package zad3;

import java.util.Random;

public class Lista {
	static Element pierwszy = null; // wartownik
	static int size;
	static int size2;

	public Lista() {
		pierwszy = null;
		size2 = 0;
	}

	public static boolean Pusta() {
		return size2 == 0;
	}
	
	public static void Dodaj(Karta kart, int index){
		Element el = new Element(kart);
		Element obiekt = pierwszy;
		if(index==0){
			el.setNext(pierwszy);
			pierwszy = el;
		} else{
		for(int i=0; i<index-1; i++){
			obiekt = obiekt.getnext();
		  }
		  if(obiekt != null){
			   el.setNext(obiekt.getnext());
			   obiekt.setNext(el);
		     } else{	 
				 el.setNext(null);
				 obiekt.setNext(el);
		     } 
		  }
	}

	public static void Usun(int index) {
		Element obiekt = pierwszy;

		if (index == 0) {
			pierwszy = pierwszy.getnext();
		} else {
			for (int i = 1; i < index; i++) {
				obiekt = obiekt.getnext();
			}

			obiekt.setNext(obiekt.getnext().getnext());
		}

		size2--;
	}
	
	public static Element Szukaj(int index){
		Element el = pierwszy;
		int i = 0;
		while(el!=null){
			if(i==index){
			    return el;	
			}
			i++;
			el = el.getnext();
		}
		return null;
	}

	public static void Wyswietl() {
		Element obiekt = pierwszy;
		while(obiekt != null) {
			System.out.println(obiekt.getkarta().getwartosc() + " " + obiekt.getkarta().getkolor());
			obiekt = obiekt.getnext();	
		}
	}

	public static int LiczbaElementow() {
		int ile = 0;
		Element obiekt = pierwszy; //.getnext();?
		while (obiekt != null) {
			ile++;
			obiekt = obiekt.getnext();
		}
		return ile;
	}
//---------------------------------------------------------------------------------
	public static int FindIndex(Karta kart) {
		int i = 0;
		int index = 0;
		Element element = pierwszy;
		Karta porownaj = pierwszy.getkarta();
		outerloop: while (element != null) {
			if (kart.getwartosc() < porownaj.getwartosc() && i == 0) {
				index = 0;
				break;
			}
			if (kart.getwartosc() == porownaj.getwartosc()) {
				int tab = znajdzwartosc(kart.getwartosc());
				//System.out.println(tab);
				for (int j = i; j < i + tab; j++) {
					if (kart.getkolor() <= porownaj.getkolor()) {
						index = j;
						break outerloop;
					}
					if(j == i+tab-1){
						index = i+tab;
						break outerloop;
					}
					if (kart.getkolor() == porownaj.getkolor()) {
						index = j;
						break outerloop;
					}
					if (kart.getkolor() > porownaj.getkolor() && kart.getkolor() < element.getnext().getkarta().getkolor()) {
						index = j + 1;
						break outerloop;
					}
				}
			}
			if(element.getnext()==null){
				index = i+1;
				break;
			}
			if (kart.getwartosc() > porownaj.getwartosc() && kart.getwartosc() < element.getnext().getkarta().getwartosc()) {
				index = i+1;
				break;
			}
			
			element = element.getnext();
			porownaj = element.getkarta();
			i++;
		}
		return index;
	}
	
	public static int znajdzwartosc(int wart){
		int licznik = 0;
		Element ele = pierwszy;
		IteratorLista it = new IteratorLista(size2);
	    for(it.first(); !it.isDone(); it.next()){
	    	if(ele.getkarta().getwartosc()==wart){
	    		licznik++;
	    		//System.out.println(licznik);
	    	}
	    	ele = ele.getnext();
	    }
		return licznik;
	}
	
	public static void Utworz(){
		int wart = -1;
		int kol = 0;
		Random r = new Random();
		while (wart != 0) {
			wart = r.nextInt(14);
			kol = r.nextInt(4);
			if (wart != 0) {
				if(size2==0){
					Karta kart = new Karta(wart, kol);
					//System.out.println("Karta: "+wart+" "+kol);
					Dodaj(kart,0);
					size2++;
				} else{
					Karta kart = new Karta(wart, kol);
					//System.out.println("Karta: "+wart+" "+kol+" "+FindIndex(kart));
					Dodaj(kart,FindIndex(kart));
					size2++;

				}
			}
		}
	}
	
	public static void wyswietlwartosc(int wartosc){
		Element el = pierwszy;
		while(el!=null){
			if(el.getkarta().getwartosc()==wartosc){
				el.getkarta().wyswietl();
			}
			el = el.getnext();
		}
	}
	
	public static void wyswietlkolor(int kolor){
		Element el = pierwszy;
		while(el!=null){
			if(el.getkarta().getkolor()==kolor){
				el.getkarta().wyswietl();
			}
			el = el.getnext();
		}
	}

}
