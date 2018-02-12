package zad2;

public class EDF {
    public EDF(){
    	
    }
    
    public static int AlgorytmEDF(int lokacja, Proces2[] Procesy){
    	int suma = 0;
    	int aktualnyczas = 0;
    	int biezacycylinder = lokacja;
    	while(!alldone(Procesy)){
    		checkready(Procesy,aktualnyczas);
    		Proces2 biezacy = shortestdeadline(Procesy); 
    		suma+=Math.abs(biezacy.cylinder-biezacycylinder);
    		biezacycylinder = biezacy.cylinder;
    		aktualnyczas++;
    	}
    	return suma;
    }	
    
    
    public static boolean alldone(Proces2[] proc){
      	for(int i=0; i<proc.length; i++){
        	if(proc[i].done==false) return false;
        }
        return true;
    }
    
    public static void checkready(Proces2[] proc, int obecnyczas){
    	for(int i=0; i<proc.length; i++){
        	if(proc[i].czas>=obecnyczas){
        		proc[i].ready=true;
        	}
        }
    }
    
    public static Proces2 shortestdeadline(Proces2[] proc){
    	Proces2 proces = new Proces2(1,false,1,1000,true);
    	for(int i=0; i<proc.length; i++){
    		if(proc[i].ready==true && proc[i].done==false && proc[i].deadline<proces.deadline){
    			proces = proc[i];
    		}
    	}
    	proces.done = true;
    	return proces;
    }
    
}
