package zad2;

public class FCFS {
	
	public FCFS(){
		
	}
	
    public static int AlgorytmFCFS(int lokacja, Proces[] Procesy){
    	int suma = 0;
    	suma+=Procesy[0].cylinder-lokacja;
    	for(int i=0; i<Procesy.length-1; i++){
    		suma+=Math.abs(Procesy[i].cylinder-Procesy[i+1].cylinder);
    	}
    	return suma;
    }
    
    public static int AlgorytmFCFSzEDF(int lokacja, Proces[] Procesy, Proces2[] Procesy2){
    	int suma = 0;
    	suma+=Procesy[0].cylinder-lokacja;
    	suma+=EDF.AlgorytmEDF(lokacja, Procesy2);
    	for(int i=0; i<Procesy.length-1; i++){
    		suma+=Math.abs(Procesy[i].cylinder-Procesy[i+1].cylinder);
    	}
    	return suma;
    }

}
