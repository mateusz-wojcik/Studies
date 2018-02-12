
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RedBlackTree {

    private final int RED = 0;
    private final int BLACK = 1;

    private class Node {
        String key = "root";
        int color = BLACK;
        Node left = nil, right = nil, parent = nil;
        ArrayList<Integer> wiersze = new ArrayList<Integer>();
        Node(String key) {
            this.key = key;
        } 
    }
    
    private void showlist(Node n){
    	for(int i=0; i<n.wiersze.size(); i++){
    		System.out.print(" "+n.wiersze.get(i));
    	}
    	System.out.println();
    }

    private final Node nil = new Node("root"); 
    private Node root = nil;

    public void showTree(Node node){
        if (node == nil) {
            return;
        }
        showTree(node.left);
        System.out.print(((node.color==RED)?"Czerwony - ":"Czarny: -  ")+"Wartosc: "+node.key+" - Rodzic: "+node.parent.key+"\n");
        showTree(node.right);
    }

    private Node findNode(Node findNode, Node node) {
        if (root == nil) {
            return null;
        }

        if (findNode.key.compareTo(node.key) < 0) {
            if (node.left != nil) {
                return findNode(findNode, node.left);
            }
        } else if (findNode.key.compareTo(node.key) > 0) {
            if (node.right != nil) {
                return findNode(findNode, node.right);
            }
        } else if (findNode.key.compareTo(node.key) == 0) {
            return node;
        }
        return null;
    }
    
    private void insert(Node node, int wiersz) {
        Node temp = root;
        boolean czy = true;
        if (root == nil) {
            root = node;
            node.color = BLACK;
            node.parent = nil;
        } else {
            node.color = RED;
            while (true) {
                if (node.key.compareTo(temp.key) < 0) {
                    if (temp.left == nil) {
                        temp.left = node;
                        node.parent = temp;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else if (node.key.compareTo(temp.key) > 0) {
                    if (temp.right == nil) {
                        temp.right = node;
                        node.parent = temp;                       
                        break;
                    } else {
                        temp = temp.right;
                    }
                } else if(node.key.compareTo(temp.key)==0) {
                	temp.wiersze.add(wiersz);
                	czy = false;
                	break;
                }
            }
           if(czy) naprawdrzewo(node);
        }
        node.wiersze.add(wiersz);
    }

    private void naprawdrzewo(Node node) {
        while (node.parent.color == RED) {
            Node uncle = nil;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                } 
                if (node == node.parent.right) {
                    node = node.parent;
                    lewarotacja(node);
                } 
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                prawarotacja(node.parent.parent);
            } else {
                uncle = node.parent.parent.left;
                 if (uncle != nil && uncle.color == RED) {
                    node.parent.color = BLACK;
                    uncle.color = BLACK;
                    node.parent.parent.color = RED;
                    node = node.parent.parent;
                    continue;
                }
                if (node == node.parent.left) {
                    node = node.parent;
                    prawarotacja(node);
                }
                node.parent.color = BLACK;
                node.parent.parent.color = RED;
                lewarotacja(node.parent.parent);
            }
        }
        root.color = BLACK;
    }

    void lewarotacja(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != nil) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = nil;
            root = right;
        }
    }

    void prawarotacja(Node node) {
        if (node.parent != nil) {
            if (node == node.parent.left) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }

            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != nil) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = nil;
            root = left;
        }
    }
    
    void transplant(Node target, Node with){ 
          if(target.parent == nil){
              root = with;
          }else if(target == target.parent.left){
              target.parent.left = with;
          }else
              target.parent.right = with;
          with.parent = target.parent;
    }
    
    boolean delete(String value){
    	Node z = new Node(value);
        if((z = findNode(z, root))==null){
        	System.out.println("nie znaleziono");
        	return false;
        }
        Node x;
        Node y = z; 
        int y_original_color = y.color;
        
        if(z.left == nil){
            x = z.right;  
            transplant(z, z.right);  
        }else if(z.right == nil){
            x = z.left;
            transplant(z, z.left); 
        }else{
            y = treeMinimum(z.right);
            y_original_color = y.color;
            x = y.right;
            if(y.parent == z)
                x.parent = y;
            else{
                transplant(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            transplant(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color; 
        }
        if(y_original_color==BLACK)
            napraw(x);  
        return true;
    }
    
    void napraw(Node x){
        while(x!=root && x.color == BLACK){ 
            if(x == x.parent.left){
                Node w = x.parent.right;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    lewarotacja(x.parent);
                    w = x.parent.right;
                }
                if(w.left.color == BLACK && w.right.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.right.color == BLACK){
                    w.left.color = BLACK;
                    w.color = RED;
                    prawarotacja(w);
                    w = x.parent.right;
                }
                if(w.right.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.right.color = BLACK;
                    lewarotacja(x.parent);
                    x = root;
                }
            }else{
                Node w = x.parent.left;
                if(w.color == RED){
                    w.color = BLACK;
                    x.parent.color = RED;
                    prawarotacja(x.parent);
                    w = x.parent.left;
                }
                if(w.right.color == BLACK && w.left.color == BLACK){
                    w.color = RED;
                    x = x.parent;
                    continue;
                }
                else if(w.left.color == BLACK){
                    w.right.color = BLACK;
                    w.color = RED;
                    lewarotacja(w);
                    w = x.parent.left;
                }
                if(w.left.color == RED){
                    w.color = x.parent.color;
                    x.parent.color = BLACK;
                    w.left.color = BLACK;
                    prawarotacja(x.parent);
                    x = root;
                }
            }
        }
        x.color = BLACK; 
    }
    
    Node treeMinimum(Node subTreeRoot){
        while(subTreeRoot.left!=nil){
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }
    
    
    public void inorder(Node root){
    	if(root!=null){
    		inorder(root.left);
    		if(root.key!="root"){
    			System.out.format("%-15s", root.key);
    			showlist(root);
    		}
    		inorder(root.right);
    	}
    }
    
    public void levelorder(Node root){
    	System.out.println("Przejscie poziomami:");
    	Queue queue=new LinkedList();
    	  queue.add(root);
    	  while(!queue.isEmpty()){
    	   Node tempNode=(Node) queue.poll();
    	   if(tempNode.key!="root") System.out.print(tempNode.key+" ");
    	   if(tempNode.left!=null)  queue.add(tempNode.left);
    	   if(tempNode.right!=null) queue.add(tempNode.right);
    	  }
    }
    
    public void createtree() throws FileNotFoundException{
   	    int wiersz = 0;
   	    String s;
   	    Node node;
   	    FileReader fr = new FileReader("text.txt");
   	    Scanner scan = new Scanner(fr);
   	    while(scan.hasNextLine()){
   		    wiersz++;
   	        s = scan.nextLine();
   	        StringTokenizer st = new StringTokenizer(s);
   	        while(st.hasMoreTokens()){
   	    	    s = st.nextToken();
   	    	    for(int i=0; i<s.length(); i++){
       	    	    if((s.charAt(i)==',' || s.charAt(i)=='.' || s.charAt(i)=='-') && s.length()!=1) s = s.substring(0, s.length()-1);
       	        }
       	        node = new Node(s);
                insert(node, wiersz);
       	    // System.out.println(s);  
   	        }
   	    }
   	    //delete("w");
   	    //printTree(root);
   	    inorder(root);
   	    levelorder(root);
   	 
   }
  
}
