package zad2;

public class SCAN {
	
    public SCAN(){
    	
    }
    
    public static int AlgorytmSCAN(int lokacja, Proces[] Procesy, int max){
    	int suma = 0;
    	int dzialanie = 0;
    	int biezacycylinder = lokacja;
    	while(!alldone(Procesy)){
    		for(int i=0; i<Procesy.length; i++){
    			if(Procesy[i].cylinder==biezacycylinder) Procesy[i].done=true;
    		}
    		if(biezacycylinder == 0) dzialanie=1;
    		if(biezacycylinder == max) dzialanie=0;
    		if(dzialanie==0) biezacycylinder--;
    		if(dzialanie==1) biezacycylinder++;
    		suma++;
    	}
    	
    	return suma;
    }
    
    public static boolean alldone(Proces[] proc){
    	for(int i=0; i<proc.length; i++){
    		if(proc[i].done==false) return false;
    	}
    	return true;
    }
}
