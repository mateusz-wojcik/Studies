package zad1;

import java.util.concurrent.ThreadLocalRandom;

public class Proces{
	int iloscprocesow,numer,dlfazy,momentzgloszenia,czasoczekiwania;
	
	public Proces(){}
	
	public Proces(int numer, int dlfazy, int momentzgloszenia, int czasoczekiwania){
		this.numer=numer;
		this.dlfazy=dlfazy;
		this.momentzgloszenia = momentzgloszenia;
		this.czasoczekiwania=czasoczekiwania;
	}
	
	public static int[] dlprocesu(int iloscprocesow, int zakresdlugosci){
		int[] tab = new int[iloscprocesow];
		for(int i=0;i<iloscprocesow;i++){
			tab[i]=(ThreadLocalRandom.current().nextInt(zakresdlugosci))+1;
		}		
		return tab;
	}
	
	public static int[] czaszgloszenia(int iloscprocesow, int zakresdlugosci){
		int[] tabczas = new int[iloscprocesow];
		for(int i=0;i<iloscprocesow;i++){
			tabczas[i]=(ThreadLocalRandom.current().nextInt(zakresdlugosci))+1;
		}		
		return tabczas;
	}
	
	public void wyswietl(){
		String s = String.format("%-6s %-6s %-16s %-15s",numer,dlfazy,momentzgloszenia,czasoczekiwania);
		System.out.println(s);
	}

}
