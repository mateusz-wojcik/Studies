package zad4;

import java.util.Random;

public class Proces {
	int nr;
	int ilestron;
	int ileramek;
	int[] odwolania;
	int bit;
	
	public Proces(){}
	
	public Proces(int nr, int ilestron, int ileramek, int[] odwolania){
		this.nr=nr;
		this.ilestron=ilestron;
		this.ileramek=ileramek;
		this.odwolania=odwolania;
	}
	
	public Proces(int nr, int ilestron, int ileramek, int[] odwolania, int bit){
		this.nr=nr;
		this.ilestron=ilestron;
		this.ileramek=ileramek;
		this.odwolania=odwolania;
		this.bit=bit;
	}
	
	public Proces[] generator(int ile, int max, int min, int ileodwolan){
		Random r = new Random();
		Proces[] p = new Proces[ile];
		for(int i=0; i<ile; i++){
			int strony = r.nextInt(max)+min; //ile stron max
			int[] odw = new int[ileodwolan];
			for(int j=0; j<ileodwolan; j++){
				odw[j] = r.nextInt(strony)+1; //odowlanie z zakresu 1 - iloscstron
			}
			p[i] = new Proces(i+1,strony,0,odw);
		}
		return p;
	}
	

	public Proces[] generator2(int ile, int max, int min, int ileodwolan){
		Random r = new Random();
		Proces[] p = new Proces[ile];
		for(int i=0; i<ile; i++){
			int strony = r.nextInt(max)+min; //ile stron max
			int[] odw = new int[ileodwolan];
			for(int j=0; j<ileodwolan; j++){
				if(j==0) odw[j] = r.nextInt(strony)+1;
				else{
					odw[j] = r.nextInt(strony)-4;
					if(odw[j]==0) odw[j]+=odw[j-1];
					if(odw[j]<0) odw[j]=Math.abs(odw[j-1]);
				}
				//System.out.println(odw[j]);
				
			}
			p[i] = new Proces(i+1,strony,0,odw,0);
		}
		return p;
	}

}
