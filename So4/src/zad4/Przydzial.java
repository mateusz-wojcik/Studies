package zad4;

import java.util.ArrayList;

public class Przydzial {
	int ileramek;
	int ileodwolan;
	int zakres;
	
	public Przydzial(){}
	
	public Przydzial(int ileramek){
		this.ileramek=ileramek;
	}
	
	public int przydzialrowny(Proces[] proc, int ilerameksuma){
		int brakstrony = 0;
		int x = ilerameksuma/proc.length; //ilosc ramek dla kazdego procesu
		for(int i=0; i<proc.length; i++){
			proc[i].ileramek = x;
	        
			int aktualnybrak = 0;
			Ramka tab[] = new Ramka[x];
			for(int j=0; j<x; j++){
				tab[j] = new Ramka(j,0);
			}
			for(int k=0; k<proc[i].odwolania.length; k++){
				if(!check(tab,proc[i].odwolania[k])){
					tab[ktoraramka2(tab,proc[i].odwolania,k)].wartosc=proc[i].odwolania[k];
					aktualnybrak++;
				}
			}
		System.out.println("Proces numer "+proc[i].nr+" Strony: "+proc[i].ilestron+" Ramki: "+proc[i].ileramek+" Bledy stron: "+aktualnybrak);
		brakstrony+=aktualnybrak;
		}
		return brakstrony;
	}
	
	public int przydzialproporcjonalny(Proces[] proc, int ilerameksuma){
		int brakstrony = 0;
		int sumastron = 0;
		int ileramekjeszcze = ilerameksuma;
		for(int l=0; l<proc.length; l++) sumastron+=proc[l].ilestron; 
		for(int i=0; i<proc.length; i++){
			int x = (proc[i].ilestron*ilerameksuma/sumastron); //ilosc ramek dla kazdego procesu
			//if(x%2 == 0 && ileramekjeszcze>0) x+=1;
			if(x<10 && ileramekjeszcze>0) x+=1;
			
			proc[i].ileramek = x;
	        ileramekjeszcze-=x;
			
			int aktualnybrak = 0;
			Ramka tab[] = new Ramka[x];
			for(int j=0; j<x; j++){
				tab[j] = new Ramka(j,0);
			}
			for(int k=0; k<proc[i].odwolania.length; k++){
				if(!check(tab,proc[i].odwolania[k])){
					tab[ktoraramka2(tab,proc[i].odwolania,k)].wartosc=proc[i].odwolania[k];
					aktualnybrak++;
				}
			}
		System.out.println("Proces numer "+proc[i].nr+" Strony: "+proc[i].ilestron+" Ramki "+proc[i].ileramek+" Bledy stron "+aktualnybrak);
		brakstrony+=aktualnybrak;
		}
		return brakstrony;
	}
	
	public int zliczaniebledow(Proces[] proc, int ilerameksuma, int ramkipoczatkowe, int prog){ //tablica proc, ile ramek w sumie do dyspozycji, ile ramek kazdy dostaje na poczatku, prog przydzialu nowej ramki
		double licznik = 0;
		int brakstrony = 0;
		int ileramekjeszcze = ilerameksuma-ramkipoczatkowe*proc.length;
		//int sumastron = 0;
		//for(int l=0; l<proc.length; l++) sumastron+=proc[l].ilestron; 
		for(int i=0; i<proc.length; i++){
			int x = ramkipoczatkowe; //ilosc ramek dla kazdego procesu
			proc[i].ileramek = x;
	        
			int aktualnybrak = 0;
			//Ramka tab[] = new Ramka[x];
			ArrayList<Ramka> tab = new ArrayList<Ramka>();
			for(int j=0; j<x; j++){
				tab.add(new Ramka(j,0));
			}
			for(int k=0; k<proc[i].odwolania.length; k++){
				if(!check(tab,proc[i].odwolania[k])){
					tab.get(ktoraramka2(tab,proc[i].odwolania,k)).wartosc=proc[i].odwolania[k];
					aktualnybrak++;
					/*if(aktualnybrak>prog && ileramekjeszcze>0 && proc[i].ileramek<proc[i].ilestron){
						ileramekjeszcze--;
						proc[i].ileramek++;
						tab.add(new Ramka(tab.size(),0));
					}*/
				}
				if(k%10 == 0 && k>=ramkipoczatkowe){
					licznik = (double)aktualnybrak/(double)(k+1);
					if(licznik>0.4 && ileramekjeszcze>0){
						ileramekjeszcze--;
						proc[i].ileramek++;
						tab.add(new Ramka(tab.size(),0));
					}
					if(licznik<0.2 && tab.size()>proc[i].ilestron){
						ileramekjeszcze++;
						proc[i].ileramek--;
						tab.remove(tab.size()-1);
					}
				}
			}
		System.out.println("Proces numer "+proc[i].nr+" Strony: "+proc[i].ilestron+" Bledy stron: "+aktualnybrak);
		brakstrony+=aktualnybrak;
		}
		return brakstrony;
	}

	public int modelstrefowy(Proces[] proc, int ilerameksuma, int ramkipoczatkowe, int prog, int zakresmax, int I){ //tablica proc, ile ramek w sumie do dyspozycji, ile ramek kazdy dostaje na poczatku, prog przydzialu nowej ramki
		int zrsize = 0;
		int brakstrony = 0;
		//int ileramekjeszcze = ilerameksuma-ramkipoczatkowe*proc.length;
		int[] bittab = new int[zakresmax];
		//int sumastron = 0;
		//for(int l=0; l<proc.length; l++) sumastron+=proc[l].ilestron; 
		for(int i=0; i<proc.length; i++){
			zrsize = 0;
			for(int n=0; n<zakresmax; n++){
				bittab[n] = 0;
			}
			//int x = ramkipoczatkowe; //ilosc ramek dla kazdego procesu
			for(int m=0; m<I; m++){
				bittab[proc[i].odwolania[m]]=1;
			}
			for(int o=0; o<bittab.length; o++){
				if(bittab[o]!=0) zrsize++;
			}
			proc[i].ileramek = zrsize;
	        
			int aktualnybrak = 0;
			//Ramka tab[] = new Ramka[x];
			ArrayList<Ramka> tab = new ArrayList<Ramka>();
			for(int j=0; j<zrsize; j++){
				tab.add(new Ramka(j,0));
			}
			for(int k=0; k<proc[i].odwolania.length; k++){
				if(!check(tab,proc[i].odwolania[k])){
					tab.get(ktoraramka2(tab,proc[i].odwolania,k)).wartosc=proc[i].odwolania[k];
					aktualnybrak++;
				}
			}
		System.out.println("Proces numer: "+proc[i].nr+" Strony: "+proc[i].ilestron+" Bledy stron: "+aktualnybrak);
		brakstrony+=aktualnybrak;
		}
		return brakstrony;
	}
	
	public boolean check(Ramka ramki[], int odwolanie){
		boolean czy = false;
		for(int i=0; i<ramki.length; i++){
			if(ramki[i].wartosc==odwolanie){
				czy = true;
				break;
			}
		}
		return czy;
	}
	
	public boolean check(ArrayList<Ramka> ram, int odwolanie){
		boolean czy = false;
		for(int i=0; i<ram.size(); i++){
			if(ram.get(i).wartosc==odwolanie){
				czy = true;
				break;
			}
		}
		return czy;
	}
	
	public int ktoraramka(Ramka ramki[], int odwolanie[], int pozycja){
		int count[] = new int[ramki.length];
		for(int i=0; i<ramki.length; i++){
			for(int j=pozycja; j>0; j--){
				if(ramki[i].wartosc==odwolanie[j]){
					count[i] = j;
					break;
				}
			}
		}
		
		int min = 0;
		for(int i=0; i<count.length; i++){
			if(count[i]<=count[min]){
				min = i;
			}
		}
		
		return min;
	}
	
	public int ktoraramka2(Ramka ramki[], int odwolanie[], int pozycja){
		int count[] = new int[ramki.length];
		int min = 0;
		boolean czy = false;
		for(int i=0; i<ramki.length; i++){
			if(ramki[i].wartosc==0){
			    min = i;
			    czy = true;
			    break;
			}
			for(int j=pozycja; j>0; j--){
				if(ramki[i].wartosc==odwolanie[j]){
					count[i] = j;
					break;
				}
			}
		}
		
		if(czy==false){
			min = 0;
			for(int i=0; i<count.length; i++){
				if(count[i]<=count[min]){
					min = i;
				}
			}	
		}
		
		return min;
	}
	
	public int ktoraramka2(ArrayList<Ramka> ramki, int odwolanie[], int pozycja){
		int count[] = new int[ramki.size()];
		int min = 0;
		boolean czy = false;
		for(int i=0; i<ramki.size(); i++){
			if(ramki.get(i).wartosc==0){
			    min = i;
			    czy = true;
			    break;
			}
			for(int j=pozycja; j>0; j--){
				if(ramki.get(i).wartosc==odwolanie[j]){
					count[i] = j;
					break;
				}
			}
		}
		
		if(czy==false){
			min = 0;
			for(int i=0; i<count.length; i++){
				if(count[i]<=count[min]){
					min = i;
				}
			}	
		}
		
		return min;
	}

}
