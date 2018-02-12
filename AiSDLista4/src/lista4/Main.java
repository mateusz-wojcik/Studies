package lista4;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
    	KolejkaMagazynow kolmag = new KolejkaMagazynow();
    	outerloop3:
    	while(true){
    	Kolejka kol = new Kolejka();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("<Proces magazyn>");
    	System.out.println("1. Dodaj klienta");
    	System.out.println("2. Dodaj zamowienie");
    	System.out.println("3. Zakoncz tworzenie klienta");
        System.out.println("4. Zakoncz proces magazyn");
        System.out.println("5. Dodaj magazyn");
    	int wybor = sc.nextInt();
    	outerloop2:
    	while(true){
    		switch(wybor){
        	case 1: 
        		System.out.println("-----------------------------------------");
        		System.out.println("Nazwa klienta:");
        		String nazwa = sc.next();
        		System.out.println("Zamowienie - nazwa towaru:");
                String nazwatow = sc.next();
                System.out.println("Zamowienie - ile sztuk?");
                int ileszt = sc.nextInt();
                Zamowienie zm = new Zamowienie(nazwatow,ileszt,null);
                KolejkaZam kolzam = new KolejkaZam();
                kolzam.InsertZam(zm);
                Klient kl = new Klient(nazwa,zm,null);
                kol.Insert(kl);
                wybor = sc.nextInt();
                outerloop:
                while(true){
                	switch(wybor){
                	case 2:
                		System.out.println("Zamowienie - nazwa towaru:");
                		nazwatow = sc.next();
                        System.out.println("Zamowienie - ile sztuk?");
                        ileszt = sc.nextInt();
                        Zamowienie newzam = new Zamowienie(nazwatow,ileszt,null);
                        kolzam.InsertZam(newzam);
                        wybor = sc.nextInt();
                        break;
                	case 3:
                		break outerloop;
                	case 4:
                		kolmag.Insert(kol);
                		break outerloop2;
                	}
                }
                wybor = sc.nextInt();
        	case 4:
        		kolmag.Insert(kol);
        		break;
        	}     	
    	}	
    	
    	System.out.println("Koniec tworzenia magazynu");
    	System.out.println(kol.getsize());
    	
    	for(int i=0; i<kol.getsize(); i++){
    		int suma = 0;
    		if(i==0){
    			Klient klient = kol.firstklient;
    			Zamowienie zamowienie = klient.getzamowienie();
    			while(zamowienie!=null){
    			    suma += zamowienie.getile();
    				zamowienie = zamowienie.getnext();
    			}
    			System.out.println(klient.getnazwa()+": zlecenie zrealizowane "+suma);
    		} else {
    			Klient klient = kol.firstklient;
    			for(int j=0; j<i; j++){
    				klient = klient.getnext();
    			}
        			Zamowienie zamowienie = klient.getzamowienie();
        			while(zamowienie!=null){
        			    suma += zamowienie.getile();
        				zamowienie = zamowienie.getnext();
        			}
        			System.out.println(klient.getnazwa()+": zlecenie zrealizowane "+suma);	
    			
    		}
    		
    	}
    	
    	switch(wybor){
    	case 5: break outerloop3;
    	}
    	
    	sc.close();  	
     }
    }
}
