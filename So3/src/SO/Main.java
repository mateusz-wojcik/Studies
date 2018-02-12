package SO;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Zakres stron:");
		int strony = sc.nextInt();
		System.out.println("Ile ramek?");
		int ramki = sc.nextInt();
		System.out.println("Ile odwolan?");
		int odwolania = sc.nextInt();
		int odw[] = new int[odwolania];
		Random r = new Random();
		int bufor = 0;
		for(int i=0; i<odwolania; i++){
			if(i==0) odw[i]=r.nextInt(strony)+1; else{
				if((r.nextInt(10)+1)<10){
					if((r.nextInt(10)+1)<6){
						odw[i] = odw[i-1]+r.nextInt(strony/5);
					} else{
						odw[i] = odw[i-1]-r.nextInt(strony/5);
					}
				} else odw[i] = r.nextInt(strony)+1;	
			}
			//System.out.println(odw[i]);
		}
		
		System.out.println("Ilosc bledow stron:");
		
		FCFS fc = new FCFS();
		System.out.println("FCFS: "+fc.fcfs(odw,ramki));
		
		LRU lru = new LRU();
		System.out.println("LRU : "+lru.lru(odw,ramki));
		
		RAND rand = new RAND();
		System.out.println("RAND: "+rand.rand(odw, ramki));
		
		OPT opt = new OPT();
		System.out.println("OPT : "+opt.opt(odw, ramki));
		
		LRUapr lruapr = new LRUapr();
		System.out.println("LRUa: "+lruapr.lruapr(odw, ramki));
	}

}
