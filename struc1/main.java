package struc1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import struc1.WAVLTree.WAVLNode;



public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
////		WAVLTree t4=new WAVLTree();
////		int i1=t4.insert(5, "gg");
////		int i2=t4.insert(8, "g");
////		int i3=t4.insert(7, "gg");
//////		System.out.println(t4.getRoot().getKey());//7
//////		System.out.println(t4.getRoot().getRank());//1
//////		//System.out.println(t4.getRoot().getSubtreeSize());//3
////////		System.out.println(t4.getRoot().getRight().getKey());//8
//////		System.out.println(t4.getRoot().getRight().getRank());//0
//////		System.out.println(t4.getRoot().getRight().getSubtreeSize());//1
//////		System.out.println(t4.getRoot().getLeft().getKey());//5
//////		System.out.println(t4.getRoot().getLeft().getRank());//0
//////		System.out.println(t4.getRoot().getLeft().getSubtreeSize());//1
//////		System.out.println(i1);
//////		System.out.println(i2);
//////		System.out.println(i3);
//////		//System.out.println(t4.getRoot().getLeft().getParent().getKey());//7
//////		System.out.println(WAVLTreePrinter.toString(t4));
////		
//////		System.out.println("_____ff__");
////		System.out.println(t4.search(7));
////
////		
////		
////		WAVLTree t3=new WAVLTree();
////		t3.insert(5, "gg");
////		t3.insert(1, "gg");
////		t3.insert(3, "gg");
//////		System.out.println(t3.getRoot().getKey());//3
//////		System.out.println(t3.getRoot().getRank());//1
//////		System.out.println(t3.getRoot().getRight().getKey());//5
//////		System.out.println(t3.getRoot().getRight().getRank());//0
//////		System.out.println(t3.getRoot().getLeft().getKey());//1
//////		System.out.println(t3.getRoot().getLeft().getRank());//0
////		System.out.println(WAVLTreePrinter.toString(t3));
////		
////		
////		WAVLTree t2=new WAVLTree();
////		t2.insert(7, "gg");
////		t2.insert(5, "gg");
////		t2.insert(3, "gg");
////		t2.insert(2, "gg");
////		t2.insert(1, "gg");
////		
//////		System.out.println(t2.getRoot().getRight().getKey());//7
//////		System.out.println(t2.getRoot().getRight().getRank());//0
//////		System.out.println(t2.getRoot().getLeft().getKey());//2
//////		System.out.println(t2.getRoot().getLeft().getRank());//1
//////		System.out.println(t2.getRoot().getLeft().getLeft().getKey());//1
//////		System.out.println(t2.getRoot().getLeft().getLeft().getRank());//0
//////		System.out.println(t2.getRoot().getLeft().getRight().getKey());//3
//////		System.out.println(t2.getRoot().getLeft().getRight().getRank());//0
//////		System.out.println(t2.getRoot().getKey());//5
//////		System.out.println(t2.getRoot().getRank());//2
////		
////		
//		WAVLTree t=new WAVLTree();
//		t.insert(1, "a");
////		System.out.println(t.getRoot().getLeft()==null);
////		System.out.println(t.toString());
////		
//		
//		t.insert(2, "b");
////		System.out.println(t.getRoot().getRank());
////		System.out.println(t.getRoot().getRight().getRank());
////		
////		
////		t.insert(3, "g");
////		System.out.println(t.getRoot().getRight().getRight().getKey());
////		System.out.println(t.getRoot().getRank());
////		System.out.println(t.getRoot().getRight().getRank());
////		
//////		System.out.println(t.getRoot().getLeft().getRank());
////		System.out.println(t.toString());
//////		System.out.println("fgggg");
////		
////		System.out.println(t.getRoot().getRight().getKey());
////		System.out.println(t.getRoot().getLeft().getKey());
//		t.insert(5, "c");
//		t.insert(7, "d");
////		System.out.println(t.getRoot().getRight().getKey());//5
////		System.out.println(t.getRoot().getRight().getRank());//1
////		System.out.println(t.getRoot().getRight().getRight().getKey());//7
////		System.out.println(t.getRoot().getRight().getRight().getRank());//0
////		System.out.println(t.getRoot().getRight().getLeft().getKey());//3
////		System.out.println(t.getRoot().getRight().getLeft().getRank());//0
////		System.out.println(t.getRoot().getKey());//2
////		System.out.println(t.getRoot().getRank());//2
//		t.insert(9, "e");
//		t.insert(10, "f");
//		t.insert(11, "g");
//		t.insert(12, "h");
//		t.insert(13, "i");
//		System.out.println(WAVLTreePrinter.toString(t));
////		System.out.println(t.getRoot().getRank());
////		System.out.println(t.getRoot().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRank());
////		
////		System.out.println(t.getRoot().getLeft().getLeft().getRank());
////		System.out.println(t.getRoot().getLeft().getRight().getRank());
////		System.out.println(t.getRoot().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRank());
////		
////		System.out.println(t.getRoot().getRight().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRight().getRank());
//
//		System.out.println(t.getRoot().getSubtreeSize());//9
//		System.out.println(WAVLTreePrinter.toString(t));
//		System.out.println("deleting 2______________");
//		t.delete(2);
//		System.out.println(WAVLTreePrinter.toString(t));
//		System.out.println("sizes:");
//		System.out.println(t.getRoot().getSubtreeSize());//8
//		System.out.println(t.getRoot().getLeft().getSubtreeSize());//2
//		System.out.println(t.getRoot().getRight().getSubtreeSize());//5
//		
//		System.out.println(t.getRoot().getLeft().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getLeft().getRight().getSubtreeSize());//0
//		System.out.println(t.getRoot().getRight().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getRight().getRight().getSubtreeSize());//3
//		System.out.println(t.getRoot().getRight().getRight().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getRight().getRight().getRight().getSubtreeSize());//1
//		
////		System.out.println(t.getRoot().getRank());
////		System.out.println(t.getRoot().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRank());
//		
////		System.out.println(t.getRoot().getLeft().getLeft().getRank());
////		System.out.println(t.getRoot().getLeft().getRight().getRank());
////		System.out.println(t.getRoot().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRank());
////		
////		System.out.println(t.getRoot().getRight().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRight().getRank());
//		
//		System.out.println("deleting 9______________");
//		t.delete(9);
//		System.out.println(WAVLTreePrinter.toString(t));
//		
//		System.out.println("sizes:");
//		System.out.println(t.getRoot().getSubtreeSize());//7
//		System.out.println(t.getRoot().getLeft().getSubtreeSize());//2
//		System.out.println(t.getRoot().getRight().getSubtreeSize());//4
//		
//		System.out.println(t.getRoot().getLeft().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getLeft().getRight().getSubtreeSize());//0
//		System.out.println(t.getRoot().getRight().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getRight().getRight().getSubtreeSize());//3
//		System.out.println(t.getRoot().getRight().getLeft().getRight().getSubtreeSize());//1
//		System.out.println(t.getRoot().getRight().getRight().getRight().getSubtreeSize());//0
////		System.out.println(t.getRoot().getRank());
////		System.out.println(t.getRoot().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRank());
////		
////		System.out.println(t.getRoot().getLeft().getLeft().getRank());
////		System.out.println(t.getRoot().getLeft().getRight().getRank());
////		System.out.println(t.getRoot().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRank());
////		
////		System.out.println(t.getRoot().getRight().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRight().getRank());
//		
//		System.out.println("deleting root 7______________");
//		t.delete(7);
//		System.out.println(WAVLTreePrinter.toString(t));
//		
//		System.out.println("sizes:");
//		System.out.println(t.getRoot().getSubtreeSize());//7
//		System.out.println(t.getRoot().getLeft().getSubtreeSize());//2
//		System.out.println(t.getRoot().getRight().getSubtreeSize());//4
//		
//		System.out.println(t.getRoot().getLeft().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getLeft().getRight().getSubtreeSize());//0
//		System.out.println(t.getRoot().getRight().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getRight().getRight().getSubtreeSize());//3
//		//System.out.println(t.getRoot().getRight().getLeft().getRight().getSubtreeSize());//1
//		//System.out.println(t.getRoot().getRight().getRight().getRight().getSubtreeSize());//0
////		System.out.println(t.getRoot().getRank());
////		System.out.println(t.getRoot().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRank());
////		
////		System.out.println(t.getRoot().getLeft().getLeft().getRank());
////		System.out.println(t.getRoot().getLeft().getRight().getRank());
////		System.out.println(t.getRoot().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRank());
////		
////		System.out.println(t.getRoot().getRight().getRight().getLeft().getRank());
////		System.out.println(t.getRoot().getRight().getRight().getRight().getRank());
//		
//		
//		
//		System.out.println(t.getRoot().getSubtreeSize());//6
//		System.out.println(t.getRoot().getLeft().getSubtreeSize());//2
//		System.out.println(t.getRoot().getRight().getSubtreeSize());//3
//		
//		System.out.println(t.getRoot().getLeft().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getLeft().getRight().getSubtreeSize());//0
//		System.out.println(t.getRoot().getRight().getLeft().getSubtreeSize());//1
//		System.out.println(t.getRoot().getRight().getRight().getSubtreeSize());//1
//		
//		
//		
//		
//		
//		System.out.println(Arrays.toString(t.keysToArray()));
//		System.out.println(Arrays.toString(t.infoToArray()));
//		
//		
//		
//		//t.delete(13);
//		//t.delete(12);
//		//t.delete(2);
////		t.delete(2);
////		System.out.println(WAVLTreePrinter.toString(t));
////		t.delete(1);
////		System.out.println(WAVLTreePrinter.toString(t));
//////		t.delete(2);
////		System.out.println(WAVLTreePrinter.toString(t));
////		t.delete(1);
////		System.out.println(WAVLTreePrinter.toString(t));
////		t.delete(7);
////		System.out.println(WAVLTreePrinter.toString(t));
////		t.delete(9);
//		
//		
////		System.out.println(WAVLTreePrinter.toString(t));
////		System.out.println(t.getRoot().getRank());
////
////		System.out.println("5 size: "  + t.getRoot().getSubtreeSize()); //10
////		System.out.println("11 size: "  + t.getRoot().getRight().getSubtreeSize()); //6 node11
////		System.out.println("12 size: "  + t.getRoot().getRight().getRight().getSubtreeSize()); //2 node12
////		System.out.println("13 size: "  + t.getRoot().getRight().getRight().getRight().getSubtreeSize()); //1 node13
////		System.out.println("9 size: "  + t.getRoot().getRight().getLeft().getSubtreeSize()); //3 node9
////		System.out.println("7 size: "  + t.getRoot().getRight().getLeft().getLeft().getSubtreeSize()); //1 node7
////		System.out.println("10 size: "  + t.getRoot().getRight().getLeft().getRight().getSubtreeSize()); //1 node10
////		System.out.println("2 size: "  + t.getRoot().getLeft().getSubtreeSize()); //3 node2
////		System.out.println("1 size: "  + t.getRoot().getLeft().getLeft().getSubtreeSize()); //1 node1
////		System.out.println("external size: "  + t.getRoot().getLeft().getLeft().getLeft().getSubtreeSize()); //0 external
////		
////		System.out.println(t.search(2));//searchhh
////		System.out.println(t.search(900));//null
//		
////		WAVLTree t5=new WAVLTree();
////		t5.insert(1, "");
////		t5.insert(2, "");
////		t5.insert(3, "");
////		t5.insert(4, "");
////		t5.insert(5, "");
////		System.out.println(WAVLTreePrinter.toString(t5));
////		
////		t5.delete(1);
////		System.out.println(WAVLTreePrinter.toString(t5));
////		t5.delete(2);
////		System.out.println(WAVLTreePrinter.toString(t5));
//
//		t.delete(1);
//		System.out.println(t.max());
//		System.out.println(t.min());
		
		
		
		
		System.out.println("___________________t777");
		WAVLTree t7=new WAVLTree();
		t7.insert(1, "1");
		t7.insert(2, "2");
		t7.insert(5, "5");
		t7.insert(4, "4");
		t7.insert(6, "6");
		System.out.println(WAVLTreePrinter.toString(t7));
		//System.out.println(t7.getRoot().getParent().getKey());
		t7.delete(2);
		System.out.println("repppppp");
		System.out.println(WAVLTreePrinter.toString(t7));
		System.out.println("size"+t7.getRoot().getSubrtreeSize());
		System.out.println("ra"+t7.getRoot().getLeft().getRank());
		System.out.println("ra"+t7.getRoot().getRight().getRank());
		System.out.println(WAVLTreePrinter.toString(t7));
		//System.out.println("before"+t7.getRoot().getLeft().getRight().getKey());//-1
		//System.out.println("before"+t7.getRoot().getLeft().getLeft().getKey());//-1
		//t7.delete(12);
		//System.out.println("delte2");
		//System.out.println(t7.getRoot().getKey());//4
		//System.out.println(t7.getRoot().getLeft().getKey());//1
		//System.out.println(t7.getRoot().getLeft().getParent().getKey());//4
		//System.out.println(t7.getRoot().getLeft().getRight().getKey());//-1
		//System.out.println(t7.getRoot().getLeft().getLeft().getKey());//-1
		//System.out.println(t7.getRoot().getRight().getKey());//5
		//System.out.println(t7.getRoot().getRight().getRight().getKey());//6
		//System.out.println(t7.empty());
		//System.out.println(t7.max());
		//System.out.println(t7.min());
		//System.out.println(WAVLTreePrinter.toString(t7));
		
		
//		WAVLTree t8=new WAVLTree();
//		t8.insert(1, "");
//		t8.insert(2, "");
//		t8.insert(3, "");
//		t8.insert(4, "");
//		System.out.println(WAVLTreePrinter.toString(t8));
//		t8.getRoot().getRight().replace(t8.getRoot().getRight().getRight());
//		System.out.println(WAVLTreePrinter.toString(t8));
	}

}
