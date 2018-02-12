package zad1;

import java.util.*;

public class Main {
   // static int czas = 0;
	public static void main(String args[]){
		double sumafcfs=0;
		double sumasjf=0;
		double sumarr=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Ile ciagow testowych?");
		int ileciagow = sc.nextInt();
		System.out.println("Ile procesow w ciagu?");
		int ileproc = sc.nextInt();
		System.out.println("Jaka dlugosc? (od 1 do ...?)");
		int dl = sc.nextInt();
		System.out.println("Jaki kwant czasu?");
		int kwantcz = sc.nextInt();
	    
		for(int i=0; i<ileciagow;i++){
			int tablica[] = Proces.dlprocesu(ileproc,dl);
			int tablica2[] = Proces.czaszgloszenia(ileproc,dl);
			sumafcfs+=(Algorytmy.FCFS(ileproc,tablica,tablica2));
			sumasjf+=(Algorytmy.SJF(ileproc,tablica,tablica2,dl));
			sumarr+=(Algorytmy.RR(ileproc, tablica, tablica2, kwantcz));
			//System.out.println(Algorytmy.SRTF(ileproc,tablica,tablica2,dl)+"\n");	
		}
		
		
			System.out.printf("%s %.2f%n","Sredni czas dla algorytmu FCFS: ", sumafcfs/ileciagow);
			System.out.printf("%s %.2f%n","Sredni czas dla algorytmu SJF:  ", sumasjf/ileciagow);
			System.out.printf("%s %.2f%n","Sredni czas dla algorytmu RR:   ", sumarr/ileciagow);
		
		
		sc.close();
	}
}
