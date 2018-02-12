package so5;

import java.util.ArrayList;
import java.util.Random;

public class Proces {
	public int udzial;
	public int czastrwania;
	public int pojawienie;
	
	public Proces(){}
	
	public Proces(int udzial, int czastrwania, int pojawienie){
		this.udzial=udzial;
		this.czastrwania=czastrwania;
		this.pojawienie=pojawienie;
	}
	
	public ArrayList<Proces> generator(int ileczasu, int czestotliwosc, int maxczastrwania, int szansa, int maxdlugosc){
		ArrayList<Proces> proc = new ArrayList();
		Random r = new Random();
		for(int i=0; i<ileczasu; i++){
			if(r.nextInt(szansa)+1==1){                  //x% szans na pojawienie sie procesu
				proc.add(new Proces(r.nextInt(maxdlugosc)+1,r.nextInt(maxczastrwania)+1,i));   
			}
		}
		return proc;
	}

}
