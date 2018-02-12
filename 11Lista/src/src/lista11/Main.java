package src.lista11;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		System.out.println("Wprowadz tekst do zakodowania: ");
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		HuffmanTree tree = new HuffmanTree(text);
		Node root = tree.tree();
		tree.symbols(root);
		sc.close();
	}

}
