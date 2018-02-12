package lista4;

public class KolejkaMagazynow {
	Kolejka firstmagazyn;
	int sizemagazyn = 0;
    Kolejka kol;
    Kolejka next;
	
	public KolejkaMagazynow(){
		firstmagazyn = null;
		sizemagazyn = 0;
	}
	
	public KolejkaMagazynow(Kolejka kol, Kolejka next){
		this.kol=kol;
		this.next=next;
	}
	
	public void Insert(Kolejka kl){
    	Kolejka obiekt = firstmagazyn;
	    if(isEmpty()){
	    	setnext(firstmagazyn);
	    	firstmagazyn = kl;
	    } else {
	    	for(int i=0;i<sizemagazyn-1;i++){
	    		obiekt = obiekt.getnext();
	    	}
	    	setnext(kl);
	    }
	    sizemagazyn++;
    }
	
	 public void setnext(Kolejka kl){
	     next = kl;
	 }
	    
	 public Kolejka getnext(){
	     return next;
	 }
	    
    
    public void Remove(){
    	firstmagazyn = firstmagazyn.getnext();
    	sizemagazyn--;
    }
    
    public boolean isEmpty(){
    	return sizemagazyn==0;
    }
    
    public boolean isFull(){
    	return false;
    }
    
    public int getsize(){
    	return sizemagazyn;
    }

}
