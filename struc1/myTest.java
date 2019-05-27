package struc1;

public class myTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WAVLTree t=new WAVLTree();
System.out.println("______BUILD TREE FROM SMALLER TO LARGER____________");
for(int i=0; i<10; i++) {
	t.insert(i, "");
	System.out.println(WAVLTreePrinter.toString(t));
}
System.out.println("______FULL TREE____________");
System.out.println(WAVLTreePrinter.toString(t));


System.out.println("______DELETE ELEMENTS FROM LARGER TO SMALLER____________");
for(int i=10; i>0; i--) {
	t.delete(i);
	System.out.println(WAVLTreePrinter.toString(t));

}

		}
	}


