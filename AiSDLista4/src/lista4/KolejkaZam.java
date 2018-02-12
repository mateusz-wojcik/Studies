package lista4;

public class KolejkaZam {
	
    static Zamowienie firstzamowienie;
    static int sizezamowienie;
    
    public KolejkaZam(){
    	firstzamowienie = null;
    	sizezamowienie = 0;
    }
	
    public void InsertZam(Zamowienie zam){
    	Zamowienie obiekt = firstzamowienie;
	    if(isEmptyZam()){
	    	zam.setnext(firstzamowienie);
	    	firstzamowienie = zam;
	    } else {
	    	for(int i=0;i<sizezamowienie-1;i++){
	    		obiekt = obiekt.getnext();
	    	}
	    	obiekt.setnext(zam);
	    }
	    sizezamowienie++;
    }
    
    public void RemoveZam(){
    	firstzamowienie = firstzamowienie.getnext();
    	sizezamowienie--;
    }
    
    public boolean isEmptyZam(){
    	return sizezamowienie==0;
    }
    
    public boolean isFullZam(){
    	return false;
    }
    
    public int getsizezam(){
    	return sizezamowienie;
    }
}
