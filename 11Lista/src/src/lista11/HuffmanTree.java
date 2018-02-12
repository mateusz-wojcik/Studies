package src.lista11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanTree {
	String text;
	
	public HuffmanTree(){}
	
	public HuffmanTree(String text){
		this.text = text;
	}
	
	public Node tree(){
		Comparator<Node> comparator = new NodeComparator();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(100,comparator);
		ArrayList<Character> list = listaznakow(text);
		for(int i=0; i<list.size(); i++){
			queue.add(new Node(ilewystapien(text, list.get(i)),list.get(i),null,null));
		}
	
		while(queue.size()>1){
			Node l = queue.poll();
			Node r = queue.poll();
			queue.add(new Node(l.waga+r.waga,l,r));
		}
		
		return queue.peek();
	}
	
	public void symbols(Node root){
		ArrayList<Character> list = listaznakow(text);
		for(int i=0; i<list.size(); i++){
			find(root, list.get(i), new StringBuffer());
		}
	}
	
	public void find(Node root, char c, StringBuffer code){
		if(root!=null){
			if(root.znak==c) System.out.println(root.znak+" "+root.waga+" "+code);
			else{
				code.append('0');
				find(root.left, c, code);
				code.deleteCharAt(code.length()-1);
			
				code.append('1');
				find(root.right, c, code);
				code.deleteCharAt(code.length()-1);
			}	
		}
	}
	
	public int ilewystapien(String text, char znak){
		int ile = 0;
		for(int i=0; i<text.length(); i++){
			if(text.charAt(i)==znak) ile++;
		}
		return ile;
	}
	
	public ArrayList<Character> listaznakow(String text){
		ArrayList<Character> lista = new ArrayList<Character>();
		for(int i=0; i<text.length(); i++){
			char current = text.charAt(i);
			if(!lista.contains(current)) lista.add(current);
		}
		return lista;
	}
	
}
