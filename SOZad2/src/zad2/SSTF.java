package zad2;

public class SSTF {
	
	public SSTF(){
		
	}

	public static int AlgorytmSSTF(int lokacja, Proces[] Procesy){
		int suma = 0;
		int biezacycylinder = lokacja;
		while(!alldone(Procesy)){
			Proces aktualnyproces = FindNearest(biezacycylinder, Procesy);
			suma+=Math.abs(aktualnyproces.cylinder-biezacycylinder);
			biezacycylinder = aktualnyproces.cylinder;
		}
		
		return suma;
	}
	
	public static int AlgorytmSSTFzEDF(int lokacja, Proces[] Procesy, Proces2[] Procesy2){
		int suma = 0;
		int biezacycylinder = lokacja;
		suma+=EDF.AlgorytmEDF(lokacja, Procesy2);
		while(!alldone(Procesy)){
			Proces aktualnyproces = FindNearest(biezacycylinder, Procesy);
			suma+=Math.abs(aktualnyproces.cylinder-biezacycylinder);
			biezacycylinder = aktualnyproces.cylinder;
		}
		
		return suma;
	}

	public static Proces FindNearest(int biezacycylinder, Proces[] proc){
		Proces min = new Proces(10000,false);
		for(int i=0; i<proc.length; i++){
			if(Math.abs(proc[i].cylinder-biezacycylinder)<Math.abs(min.cylinder-biezacycylinder) && proc[i].done==false){
				min = proc[i];
			}
		}
		
		min.done=true;
		return min;
	}
	
	public static boolean alldone(Proces[] proc){
    	for(int i=0; i<proc.length; i++){
    		if(proc[i].done==false) return false;
    	}
    	return true;
    }
	
	
}
