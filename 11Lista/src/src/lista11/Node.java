package src.lista11;

public class Node {
	int waga;
	char znak;
	Node left;
	Node right;
	
	public Node(){}
	
	public Node(int waga, char znak, Node left, Node right){
		this.waga=waga;
		this.znak=znak;
		this.left=left;
		this.right=right;
	}
	
	public Node(int waga, Node left, Node right){
		this.waga=waga;
		this.left=left;
		this.right=right;
	}
	
}
