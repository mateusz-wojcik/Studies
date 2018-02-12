package lista4;

public class Kolejka implements Queue {
    static Klient firstklient;
    static int size;
    Kolejka kol;
    Kolejka next;
	
	public Kolejka(){
		firstklient = null;
		size = 0;
	}
	
	public Kolejka(Kolejka kol, Kolejka next){
		this.kol = kol;
		this.next = next;
	}
	
    public void Insert(Klient kl){
    	Klient obiekt = firstklient;
	    if(isEmpty()){
	    	kl.setnext(firstklient);
	    	firstklient = kl;
	    } else {
	    	for(int i=0;i<size-1;i++){
	    		obiekt = obiekt.getnext();
	    	}
	    	obiekt.setnext(kl);
	    }
	    size++;
    }
    
    public void Remove(){
    	firstklient = firstklient.getnext();
    	size--;
    }
    
    public boolean isEmpty(){
    	return size==0;
    }
    
    public boolean isFull(){
    	return false;
    }
    
    public int getsize(){
    	return size;
    }
    
    public void setnext(Kolejka kl){
    	this.next=kl;
    }
    
    public Kolejka getnext(){
    	return next;
    }
    
    
}
