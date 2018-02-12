package so5;

import java.util.ArrayList;

public class Procesor {
	public int nr;
	public int obciazenie;
	public ArrayList<Proces> proc;
	
	public Procesor(){}
	
	public Procesor(int nr, int obciazenie, ArrayList<Proces> proc){
	    this.nr=nr;
	    this.obciazenie=obciazenie;
	    this.proc=proc;
	}
	
	public Procesor[] generator(int ile, int ileczasu, int czestotliwosc, int maxczastrwania, int szansa, int maxdlugosc){
		Procesor proc[] = new Procesor[ile];
		Proces proces = new Proces();
		for(int i=0; i<ile; i++){
			proc[i] = new Procesor(i+1,0,proces.generator(ileczasu, czestotliwosc, maxczastrwania, szansa, maxdlugosc));
		}
		return proc;
	}
	
	public Procesor[] generator(int ile, ArrayList<Proces> al){
		Procesor proc[] = new Procesor[ile];
		Proces proces = new Proces();
		for(int i=0; i<ile; i++){
			proc[i] = new Procesor(i+1,0,al);
		}
		return proc;
	}
	
	public void wyswietl(){
		System.out.println(nr+" "+obciazenie);
	}

}
