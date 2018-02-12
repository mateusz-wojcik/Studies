package zad3;

public class IteratorLista implements Iterator{
	Element elem;
	int pierwszy;
	int ostatni;
	int biezacy=-1;
	
    public IteratorLista(int size){
    	biezacy = 0;
		pierwszy = biezacy;
		ostatni = size-1;
	}
	
	public void first(){
		biezacy = pierwszy;
	}
	
	public void last(){
		biezacy = ostatni;
	}
	
	public void next(){
		++biezacy;
	}
	
	public void previous(){
	    --biezacy;
    }
	
	public boolean isDone(){
		return biezacy < pierwszy || biezacy > ostatni;
	}
	
	public Element current(){
		return elem.getnext();
	}
}
