package so5;

import java.util.ArrayList;

public class Main {
	static int N = 10;       //liczba procesorow
	static int p = 90;       //prog
	static int p1 = 90;       //prog
	static int p2 = 90;       //prog
	static int pm = 30;       //prog minimalny
	static int z = 5;        //ileprocesow pytac
	static int czas = 1000;   //czas trwania
	static int f = 20;       //czestotliwosc pojawiania sie zadan
	static int maxtime = 3;  //maksymalna dlugosc trwania zadania (jednostki czasu)
	static int szansa = 8;   //szansa w % na pojawienie sie procesu 1/szansa = prawdopodobienstwo
	static int udzial = 20;   //maksymalny udzial w mocy obliczeniowej
	
	public static void main(String args[]){
		Proces proces = new Proces();
		ArrayList<Proces> al = proces.generator(czas, f, maxtime, szansa, udzial);
		ArrayList<Proces> al1 = (ArrayList<Proces>) al.clone();
		ArrayList<Proces> al2 = (ArrayList<Proces>) al.clone();
		ArrayList<Proces> al3 = (ArrayList<Proces>) al.clone();
		
		Procesor procesor = new Procesor();
		Procesor[] proc = new Procesor[N];
		Procesor[] proc1 = new Procesor[N];
		Procesor[] proc2 = new Procesor[N];
		Procesor[] proc3 = new Procesor[N];
		proc = procesor.generator(N, al);
		proc1 = procesor.generator(N, al1);
		proc2 = procesor.generator(N, al2);
		proc3 = procesor.generator(N, al3);
				
		Strategia_1 s1 = new Strategia_1(proc);
		s1.str1(czas, z, p);
		Strategia_2 s2 = new Strategia_2(proc1);
		s2.str2(czas, z, p1);
		Strategia_3 s3 = new Strategia_3(proc2);
		s3.str3(czas, z, p1, pm);
	}

}
