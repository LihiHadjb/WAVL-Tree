package struc1;

import java.util.Arrays;

/**
*
* WAVLTree
*
* An implementation of a WAVL Tree.
* (Haupler, Sen & Tarajan ‘15)
*
*/
public class WAVLTree {
	private WAVLNode external= new WAVLNode(-1, null);
	private WAVLNode root;
	private WAVLNode min;
	private WAVLNode max;

	/**
	  * public WAVLTree()
	  *initializes an empty tree
	  */
	public WAVLTree() {
		this.root = null;
		external.rank = (-1);
		external.setSubtreeSize(0);
	}
	
	
 /**
  * public boolean empty()
  *
  * returns true if and only if the tree is empty
  *
  */
 public boolean empty() { 
	 return root==null;
 }

/**
  * public String search(int k)
  *
  * returns the info of an item with key k if it exists in the tree
  * otherwise, returns null
  */
 public String search(int k)
 {
	 if (empty()) {
		 return null;
	 }
	 
	WAVLNode ret = searchWithNode(this.root ,k,0);
	if (ret.getKey()==k) {
		return ret.getValue();
	}
	else {
		return null;
	}
 }
 
 /**
  * a recursive search function. 
  * If k is a key in the tree, returns the only node with key k
  * Otherwise returns the node that should be k's parent (i.e. returns potential insertion place)
  */
 

 public WAVLNode searchWithNode(WAVLNode node ,int k, int ChangeSize) 
 {
	 				
	node.subTreeSize+=ChangeSize;	//update sizes on the way down
	 if (node.getKey()==k) { 		// k is already in the tree
		 return node;
	 }
	 
	 else if (node.getKey()<k) { 	//continue the search in right subtree 
		 if (!node.getRight().isInnerNode()) {
			 return node;
		 }
		 return searchWithNode(node.getRight() , k, ChangeSize);
	 }
	 else if (node.getKey()>k) { 	//continue the search in left subtree 
		if (!node.getLeft().isInnerNode()) {
			return node;
		}
		return searchWithNode(node.getLeft() , k, ChangeSize);
	}
	 return null;
 }
 

 /**
  * public int insert(int k, String i)
  *
  * inserts an item with key k and info i to the WAVL tree.
  * the tree must remain valid (keep its invariants).
  * returns the number of rebalancing operations, or 0 if no rebalancing operations were necessary.
  * returns -1 if an item with key k already exists in the tree.
  */
  public int insert(int k, String i) {
	  
	  if (this.getRoot()==null) {			//insert to an empty tree
		  this.root = new WAVLNode(k, i);
		  min=root;
		  max=root;
		  root.subTreeSize=1;
		  return 0;
	  }
	  WAVLNode node = this.searchWithNode(this.getRoot(), k ,0);	//find insertion place
	  
	  if (node.getKey()==k) {				//key already in tree
     	 return -1;
      }
	  
	  else if (k>node.getKey()) {			//insert as right child
		  
    	  node.setRight(new WAVLNode(k, i));
    	  this.searchWithNode(this.getRoot(), k ,1);	//increase preseccessor's sizes
    	  if(k>max.getKey()) {
    		  max=node.getRight();
    	  }
      }
	  else if (k<node.getKey()) {			//insert as left child
    	  node.setLeft(new WAVLNode(k, i));
    	  this.searchWithNode(this.getRoot(), k ,1); //increase preseccessors's sizes
    	  if(k<min.getKey()) {
    		  min=node.getLeft(); 
    	  }
      }
	  
	  return insertRebalance(node);			//start rebalancing with the node that is the parent of the new node
         
  }
  
  /**
   * public static boolean isLegal(WAVLNode node)
   *returns true iff node is a legal WAVLNode
   */
 
  public static boolean isLegal(WAVLNode node) {
	  if(is12(node)||is21(node)||is11(node)||is22(node)){
		  return true;
	  }
	  return false;
  }
  /**
   *  public static boolean nodeType(WAVLNode node, int expectedLeftDiff, int expectedRightDiff)
   *returns true iff the rank differences between node and his children are identical to expectedLeftDiff, expectedRightDiff
   */ 
  
  public static boolean nodeType(WAVLNode node, int expectedLeftDiff, int expectedRightDiff) {
	  if(node.rank-node.left.rank==expectedLeftDiff&&node.rank-node.right.rank==expectedRightDiff) {
		  return true;
	  }
	  return false;
  }
  /**
   *  public static boolean isAB(WAVLNode node)
   *returns true iff the rank differences between node and with left child is A and node with is right child is B
   */ 
  
  public static boolean is01(WAVLNode node) {
	  return nodeType(node,0,1);
  }
  
  public static boolean is10(WAVLNode node) {
	  return nodeType(node,1,0);
  }
  public static boolean is12(WAVLNode node) {
	  return nodeType(node,1,2);
  }
  public static boolean is21(WAVLNode node) {
	  return nodeType(node,2,1);
  }
  public static boolean is11(WAVLNode node) {
	  return nodeType(node,1,1);
  }
  public static boolean is22(WAVLNode node) {
	  return nodeType(node,2,2);
  }
  public static boolean is20(WAVLNode node) {
	  return nodeType(node,2,0);
  }
  public static boolean is02(WAVLNode node) {
	  return nodeType(node,0,2);
  }
  public static boolean is31(WAVLNode node) {
	  return nodeType(node,3,1);
  }
  public static boolean is13(WAVLNode node) {
	  return nodeType(node,1,3);
  }
  public static boolean is23(WAVLNode node) {
	  return nodeType(node,2,3);
  }
  public static boolean is32(WAVLNode node) {
	  return nodeType(node,3,2);
  }
  
  /**
   * public void rotateRight(WAVLNode node)
   *rotates the tree starting at node right
   */ 
  public void rotateRight(WAVLNode node) {
	  
	  node.rank--;
	  if(root==node) {					
		  root=root.getLeft();
		  root.parent=null;
		  WAVLNode temp=root.getRight();
		  root.setRight(node);
		  node.setLeft(temp);
		  temp.updateSize();
		  node.updateSize();
		  root.updateSize();
	  }
	  else {
		  node.setParentChild(node.getLeft());
		  WAVLNode temp=node.left.right;
		  node.left.setRight(node);
		  node.setLeft(temp);
		  temp.updateSize();
		  node.updateSize();
		  node.getParent().updateSize();
		  if(node.getParent().getParent()!=null) {
			  node.getParent().getParent().updateSize();
		  }
		  
	  }
  }
  /**
   * public void rotateLeft(WAVLNode node)
   *rotates the tree starting at node left
   */ 
  public void rotateLeft(WAVLNode node) {
	  
	  node.rank--;
	  if(root==node) {					
		  root=root.getRight();
		  root.parent=null;
		  WAVLNode temp=root.getLeft();
		  root.setLeft(node);
		  node.setRight(temp);
		  temp.updateSize();
		  node.updateSize();
		  root.updateSize();
	  }
	  else {
		  node.setParentChild(node.getRight());
		  WAVLNode temp=node.right.left;
		  node.right.setLeft(node);
		  node.setRight(temp);
		  temp.updateSize();
		  node.updateSize();
		  node.getParent().updateSize();
		  if(node.getParent().getParent()!=null) {
			  node.getParent().getParent().updateSize();
		  }		  
	  }
	  	 
  }
  /**
   *  public void doubleRotateRight(WAVLNode node)
   *double rotates the tree starting at node right
   */ 
  
  public void doubleRotateRight(WAVLNode node) {
	  node.left.right.rank++;	//promote
	  this.rotateLeft(node.left);
	  this.rotateRight(node);
	  
  }
  
  /**
   *  public void doubleRotateLeft(WAVLNode node)
   *double rotates the tree starting at node left
   */ 
  public void doubleRotateLeft(WAVLNode node) {
	  node.right.left.rank++;	//promote
	  rotateRight(node.right);
	  rotateLeft(node);
  }
  
  
  /**
   *  public int insertRebalance(WAVLNode node)
   *rebalances the tree after insertion of a new node
   *returns the number of rebalancing operations needed
   */ 
  
  public int insertRebalance(WAVLNode node) {
	  if (isLegal(node)) {							//rebalancing is done
		  return 0;
	  }
	  if (is01(node)||is10(node)){					//case 1 (promote)
		  node.rank++;
		  if (this.root==node) {
			  return 1;
		  }
		  else {
			  return 1 + insertRebalance(node.parent);
		  }
	  }
	  
	  if(is02(node)&&is12(node.getLeft())) {		//case 2
		  rotateRight(node);
		  return 2;
	  }
	  
	  if(is20(node)&&is21(node.getRight())) {		//case 2
		  rotateLeft(node);
		  return 2;
	  }
	  
	  if(is02(node)&&is21(node.getLeft())) {		//case 3
		  doubleRotateRight(node);
		  return 5;
	  }
	  
	  if(is20(node)&&is12(node.getRight())) {		//case 3
		  doubleRotateLeft(node);
		  return 5;
	  }
	  return 0;
  }
 
  /**
  * public int delete(int k)
  *
  * deletes an item with key k from the binary tree, if it is there;
  * the tree must remain valid (keep its invariants).
  * returns the number of rebalancing operations, or 0 if no rebalancing operations were needed.
  * returns -1 if an item with key k was not found in the tree.
  */
  public int delete(int k)
  {
	  if(empty()) {
		  return -1;
	  }

	  WAVLNode deletedNode=searchWithNode(root,k,0);// find the node to be deleted 
	  if (deletedNode.getKey()!=k) {				//key is not in the tree
     	 return -1;
      }
	  

	  if(deletedNode==root) {
		  if(!isLeaf(deletedNode)&&!isUnary(deletedNode)){
			  searchWithNode(root,findSuccessor(deletedNode).getKey(),-1);					//decrease sizes of deletedNode's predecessors
		  }
		return deleteRoot(deletedNode);
		   
	  }
	  
	  if(isLeaf(deletedNode)) {	
		  searchWithNode(root,k,-1);														//decrease sizes of deletedNode's predecessors
		  return deleteLeaf(deletedNode);
	  }
	  
	  if(isUnary(deletedNode)) {	
		  searchWithNode(root,k,-1);														//decrease sizes of deletedNode's predecessors
		  return deleteUnary(deletedNode);
	  }
	  
	  else {										//deletedNode has 2 children
		 WAVLNode succ=findSuccessor(deletedNode); 
		 searchWithNode(root,succ.getKey(),-1);
		 deletedNode.replace(succ);
		 if(isUnary(deletedNode)) {
			 return deleteUnary(deletedNode);
		 }
		 else {
			 return deleteLeaf(deletedNode);
		 }
	  }  
  }
  
  
  /**
   * public boolean isUnary(WAVLNode node)
   * Returns true iff node has exactly one child
   */
  public boolean isUnary(WAVLNode node) {
	  if ((node.getLeft()==external&&node.getRight()!=external)||(node.getRight()==external&&node.getLeft()!=external)) {
		  return true;
	  }
	  return false;
  }
  
  
  /**
   * public boolean isLeaf(WAVLNode node)
   * Returns true iff node has no children
   */
  public boolean isLeaf(WAVLNode node) {
	  if ((node.getLeft()==external&&node.getRight()==external)) {
		  return true;
	  }
	  return false;
  }
  
  /**
   * public WAVLNode findSuccessor(WAVLNode node)
   * Returns the node following the argument node is the tree
   * if there is no successor, returns null
   */
  public WAVLNode findSuccessor(WAVLNode node) {
	  
	  if(node==max) {
		  return null;
	  }
	
	  if (node.getRight()!=external) {	//node has a right sub-tree
		  WAVLNode succ=node.getRight();
		  while(succ.getLeft()!=external) {
			  succ=succ.getLeft();
		  }
		  return succ;
	  }
	  else {							//node does not have a right sub-tree
		  WAVLNode succ=node;
		  while(succ.parent.getRight()==succ) {
			  succ=succ.parent;
		  }
		  return succ.parent;
	  }
  }
    
  
  /**
   * public int deleteUnary(WAVLNode node)
   * Deletes an unary node from the tree and returns the number of rebalancing operations needed
   */
  public int deleteUnary(WAVLNode node) {
	  if (min==node) {
		  min=findSuccessor(node);
	  }
	  if (max==node) {
		  max=node.getLeft();
	  }
	  if(is11(node.parent)&&is12(node)) {		//leftmost case in presentation
		  node.setParentChild(node.getLeft());
	  }
	  else if(is11(node.parent)&&is21(node)) {	//leftmost case in presentation
		  node.setParentChild(node.getRight());
	  }
	  else if(is12(node)&&is12(node.parent)) {	//middle case in presentation
		  node.setParentChild(node.getLeft());
	  }
	  else if(is21(node)&&is21(node.parent)) {	//middle case in presentation
		  node.setParentChild(node.getRight());
	  }
	  else if(is12(node)&&(is21(node.parent))) {	//rightmost case in presentation
		  node.setParentChild(node.getLeft());
		  
	  }
	  else if(is21(node)&&is12(node.parent)) {		//rightmost case in presentation
		  node.setParentChild(node.getRight());		
	  }
	  else if(is22(node.parent)) {					//rightmost case in presentation
		  if(is12(node)) {
			  node.setParentChild(node.getLeft());
		  }
		  else if(is21(node)) {
			  node.setParentChild(node.getRight());
		  }
	  }
	  return deleteRebalance(node.getParent());
  }
  
  
  /**
   * public int deleteRoot(WAVLNode node)
   * Deletes the root from the tree and returns the number of rebalancing operations needed
   */
  
  public int deleteRoot(WAVLNode node) {
	  if (isLeaf(node)) {					//deleting the last node in the tree
		  this.root=null;
		  min=null;
		  max=null;
		  return 0;
	  }
	  else if (node.getRight()==external) { //root is max
		  this.root=node.getLeft();
		  node.getLeft().parent=null;
		  node.getLeft().rank=0;
		  max=root;
		  return 0;
	  }
	  else if (node.getLeft()==external) { //root is min
		  this.root=node.getRight();
		  node.getRight().parent=null;
		  node.getRight().rank=0;
		  min=root;
		  return 0;
	  }
	  
	  WAVLNode succ=findSuccessor(node);
	  node.replace(succ);
	  this.root = succ;
	  root.parent=null;
	  if(isUnary(node)) {
		return deleteUnary(node);
	  }
	  else {
	    return deleteLeaf(node);
	  }
}
  
  
  /**
   * public int deleteLeaf(WAVLNode node)
   * Deletes a leaf node from the tree and returns the number of rebalancing operations needed
   */
  public int deleteLeaf(WAVLNode node) {
	  WAVLNode daddy=node.getParent();
	  
	  if (node==max) {
		  max=node.parent;
	  }
	  if (node==min) {
		  min=findSuccessor(node);
	  }
	  node.setParentChild(external);
	  return deleteRebalance(daddy);
  }
  
  
  
  /**
   *  public int delteRebalance(WAVLNode node)
   *rebalances the tree after a deletion of a node
   *returns the number of rebalancing operations needed
   */ 
  public int deleteRebalance(WAVLNode node) {
	  if(isLegal(node)) {
		  if(isLeaf(node)&&node.getRank()==1) {
			  node.rank--;
			  if(node.getParent()!=null) {
				  return 1+deleteRebalance(node.getParent());
			  }
			  else {
				  return 1;
				  }
		  }
		  else if(isLeaf(node)&&node.getRank()==2) {
			  node.rank-=2;
			  if(node.getParent()!=null) {
				  return 1+deleteRebalance(node.getParent());
			  }
			  else {
				  return 1;
			  }
		  }
		  return 0;		//node is a leaf with rank 0
	  }
	  
	  else if(is32(node)||is23(node)) {		//case 1 (demote)
		  node.rank--;
		  if(node==root) {
			  return 1;
		  }
		  return 1+deleteRebalance(node.parent);
	  }
	  else if(is31(node)&&is22(node.getRight())) {	//case 2 (double demote)
		  node.rank--;
		  node.getRight().rank--;
		  if(node==root) {
			 return 2; 
		  }
		  return 2+deleteRebalance(node.parent);
	  }
	  else if(is13(node)&&is22(node.getLeft())) {	//case 2 (double demote)
		  node.rank--;
		  node.getLeft().rank--;
		  if(node==root) {
			 return 2; 
		  }
		  return 2+deleteRebalance(node.parent);
	  }
	  else if(is31(node)&&(is11(node.getRight())||is21(node.getRight()))){//case 3 (rotate)
		  node.getRight().rank++;
		  rotateLeft(node);
		  if(isLeaf(node)&&is22(node)){
			node.rank--;  
		  }
		  return 3;
	  }
	  else if(is13(node)&&(is11(node.getLeft())||is12(node.getLeft()))){//case 3 (rotate)
		  node.getLeft().rank++;
		  rotateRight(node);
		  if(isLeaf(node)&&is22(node)){
				node.rank--;  
			  }
		  return 3;
	  }
	  else if(is31(node)&&is12(node.getRight())) {		//case 4 (double rotate)
		  node.getRight().getLeft().rank++;
		  node.rank--;
		  doubleRotateLeft(node);
		  return 6;
	  }
	  else if(is13(node)&&is21(node.getLeft())) {		//case 4 (double rotate)
		  node.getLeft().getRight().rank++;
		  node.rank--;
		  doubleRotateRight(node);
		  return 6;
	  }
	  return 0;
  }
  
  /**
   * public String min()
   *
   * Returns the info of the item with the smallest key in the tree,
   * or null if the tree is empty
   */
  public String min()
  {
	  if(empty()) {
		  return null;
	  }
      return min.getValue();
  }

  /**
   * public String max()
   *
   * Returns the info of the item with the largest key in the tree,
   * or null if the tree is empty
   */
  public String max()
  {
	  if(empty()) {
		  return null;
	  }
      return max.getValue();
  }
  
  
  /**
   * public String getMin()
   *
   * Returns the node with the smallest key in the tree,
   * or null if the tree is empty
   */
  public WAVLNode getMin() {
	  if(empty()) {
		  return null;
	  }
	  return min;
  }
  
  /**
   * public String getMax()
   *
   * Returns the node with the largest key in the tree,
   * or null if the tree is empty
   */
  public WAVLNode getMax() {
	  if(empty()) {
		  return null;
	  }
	  return max;
  }

  /**
  * public int[] keysToArray()
  *
  * Returns a sorted array which contains all keys in the tree,
  * or an empty array if the tree is empty.
  */
  public int[] keysToArray()
  {
       int[] arr = new int[this.size()]; 
       WAVLNode curr=min;
       for(int i=0; i<arr.length; i++) {
    	   arr[i]=curr.getKey();
    	   curr=findSuccessor(curr);
       }
       return arr;              
  }

  /**
  * public String[] infoToArray()
  *
  * Returns an array which contains all info in the tree,
  * sorted by their respective keys,
  * or an empty array if the tree is empty.
  */
  public String[] infoToArray()
  {
	  String[] arr = new String[this.size()]; 
      WAVLNode curr=min;
      for(int i=0; i<arr.length; i++) {
   	   arr[i]=curr.getValue();
   	   curr=findSuccessor(curr);
      }
      return arr;                   
  }

  /**
   * public int size()
   * Returns the number of nodes in the tree.
   */
  public int size()
  {
	  if(empty()) {
		  return 0;
	  }
      return root.subTreeSize;
  }
  
    /**
   * public WAVLNode getRoot()
   * Returns the root WAVL node, or null if the tree is empty
   *
   */
  public WAVLNode getRoot()
  {
          return this.root;
  }


  
  /**
 * public int select(int i)
 *
 * Returns the value of the i'th smallest key (return -1 if tree is empty)
 * Example 1: select(1) returns the value of the node with minimal key 
     * Example 2: select(size()) returns the value of the node with maximal key 
     * Example 3: select(2) returns the value 2nd smallest minimal node, i.e the value of the node minimal node's successor  
 *
 */ 
  public String select(int i)
  {
	  	if(i>size()||i<=0) {
			return null;
		}	
		return selectRec(root,i-1).getValue();	  
  }  
  
  /**
 * public int selectRec(WAVLNode curr, int i)
 * Returns the node with the i'th smallest key   
 *
 */   
  public WAVLNode selectRec(WAVLNode curr, int i) {
	int r=curr.getLeft().getSubtreeSize();
	if(r>i) {
		return selectRec(curr.getLeft(),i); 
	}
	else if(r<i) {
		return selectRec(curr.getRight(),i-r-1);
	}
	return curr;
}
          
  
  


  /**
  * public class WAVLNode
  */
 public class WAVLNode{
	 private WAVLNode left;
	 private WAVLNode right;
	 private WAVLNode parent;
	 private int rank;
	 private int key;
	 private String value;
	 private int subTreeSize;
	 
	 /**
	  * public WAVLNode()
	  *initializes a new node
	  */
	 			public WAVLNode(int key, String value) {
	 				this.rank=0;
	 				this.right=external;
	 				this.left=external;
	 				this.key=key;
	 				this.value=value;
	 				this.subTreeSize=0;
	 			}
	 			
	 			
               public int getKey()
               {
                       return key; 
               }
               public String getValue()
               {
            	   
                       return value; 
               }
               public WAVLNode getLeft()
               {
                       return left; 
               }
               public WAVLNode getRight()
               {
                       return right; 
               }
               
               public WAVLNode getParent() {
            	   return parent;
               }
               public boolean isInnerNode()
               {
            	   
                   return (this!=external); 
               }

               public int getSubtreeSize()
               {
                       return subTreeSize;
               }
               
               public void setSubtreeSize(int size)
               {
                       this.subTreeSize=size;
               }
               
               public int getRank() {
            	   return rank;
               }
               
               /**
          	  * public void setRight(WAVLNode child)
          	  *sets child to be the new right child of the current node
          	  */
               
               public void setRight(WAVLNode child) {
            	   this.right=child;
            	   if(child!=external) {
            		   child.parent=this;
            	   }
            	   this.updateSize();
            	   
               }
               
               /**
            	  * public void setLeft(WAVLNode child)
            	  *sets child to be the new left child of the current node
            	  */
               public void setLeft(WAVLNode child) {
            	   this.left=child;
            	   if(child!=external) {
            		   child.parent=this;
            	   }
            	   this.updateSize();
            	   
               }
               
               /**
            	  * public void setParentChild(WAVLNode newChild)
            	  *sets newChild to be the new child of the current node's parent, instead of the current node
            	  */
               
               public void setParentChild(WAVLNode newChild) {
            	   if(parent!=null && this.parent.getLeft()==this) {
            		   this.parent.setLeft(newChild);
            	   }
            	   else {
            		   if(parent!=null)
            		   {
            			   this.parent.setRight(newChild);
            		   }
            	   }
               }
                     
               /**
          	  * public void replace(WAVLNode node2)
          	  *Switches locations of the current node with node 2. This method is violates the binary search rules until the deletion is completed
          	  * (It is only used while deleting)
          	  */
               
               public void replace(WAVLNode node2) {
            	   	int nodeRank=this.getRank();
            	   	int replacementRank=node2.getRank();
            	   	int nodeSize=this.getSubtreeSize();
            	   	int replacementSize=node2.getSubtreeSize();
            		  WAVLNode node1Replacement=new WAVLNode(-2,null);
            		  WAVLNode node2Replacement=new WAVLNode(-3,null);
            		  this.replaceAndExtract(node1Replacement);
            		  node2.replaceAndExtract(node2Replacement);
            		  node1Replacement.replaceAndExtract(node2);
            		  node2Replacement.replaceAndExtract(this);
            		  node2.rank=nodeRank;
            		  this.rank=replacementRank;
            		  this.subTreeSize=replacementSize;
            		  node2.subTreeSize=nodeSize;
            		  if(node2.parent!=null) {node2.parent.updateSize();}	  
            	}
               
               
               
               /**
            	  * public void replaceAndExtract(WAVLNode replacement)
            	  *Switches locations of the current node with replacement and cleans node's pointers to children and parent
            	  * (It is only used while deleting)
            	  */
               
               public void replaceAndExtract(WAVLNode replacement) {
            		  replacement.setLeft(this.getLeft());
            		  replacement.setRight(this.getRight());
            		  if(this.parent==null) {
            			  replacement.parent=null;
            			  root=replacement;
            		  }
            		  else {
            			 this.setParentChild(replacement);
            		  }
            		  this.setRight(external);
            		  this.setLeft(external); 
            		  this.parent=null;
               }
               
               
               /**
          	  * public void updateSize()
          	  *Updates the node's subtreeSize according to the sizes of his children
          	  */
               public void updateSize() {
            	   if(this!=external&&this!=null) {
            		   this.subTreeSize=1 + this.getRight().subTreeSize + this.getLeft().subTreeSize;
            	   }
               }         
      }
 }


