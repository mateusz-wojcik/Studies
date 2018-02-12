package zad2;

public class FDSCAN {
    public FDSCAN(){
    	
    }
    
    public static int AlgorytmFDSCANzSCAN(int lokacja, Proces[] Procesy, Proces2[] Procesy2, int max){
    	int suma = 0;
    	int dzialanie = 0;
    	int biezacycylinder = lokacja;
    	suma+=shortestdeadline(biezacycylinder,Procesy,Procesy2);
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
    
    public static int AlgorytmFDSCANzCSCAN(int lokacja, Proces[] Procesy, Proces2[] Procesy2, int max) {
		int suma = 0;
		int biezacycylinder = lokacja;
		suma+=shortestdeadline(biezacycylinder,Procesy,Procesy2);
		while (!alldone(Procesy)) {
			for (int i = 0; i < Procesy.length; i++) {
				if (Procesy[i].cylinder == biezacycylinder)
					Procesy[i].done = true;
			}
			biezacycylinder++;
			if (biezacycylinder == max){
				biezacycylinder = 0;
				suma+=max;
			}
			suma++;
		}

		return suma;
	}
    
    public static int shortestdeadline(int lokacja, Proces[] proc1, Proces2[] proc){
    	int wynik = 0;
    	int sumacz = 0;
    	Proces2 proces = new Proces2(1,false,1,1000,true);
    	for(int i=0; i<proc.length; i++){
    		if(proc[i].ready==true && proc[i].done==false && proc[i].deadline<proces.deadline){
    			proces = proc[i];
    		}
    	}
    	for(int i=0;i<proc1.length;i++){
    		if(proc1[i].cylinder>=lokacja && proc1[i].cylinder<=proces.cylinder){
    			proc[i].done=true;
    		}
    	}
    	proces.done = true;
    	wynik = Math.abs(proces.cylinder-lokacja)+sumacz;
    	return wynik;
    }
    
    public static boolean alldone(Proces[] proc){
    	for(int i=0; i<proc.length; i++){
    		if(proc[i].done==false) return false;
    	}
    	return true;
    }
}
