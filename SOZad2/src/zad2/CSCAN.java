package zad2;

public class CSCAN {

	public CSCAN() {

	}

	public static int AlgorytmCSCAN(int lokacja, Proces[] Procesy, int max) {
		int suma = 0;
		int biezacycylinder = lokacja;
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

	public static boolean alldone(Proces[] proc) {
		for (int i = 0; i < proc.length; i++) {
			if (proc[i].done == false)
				return false;
		}
		return true;
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
	
	
}
