package src.lista11;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
	
    public int compare(Node x, Node y){
		if(x.waga<y.waga) return -1;
		if(x.waga>y.waga) return 1;
		return 1;
	}
    
}
