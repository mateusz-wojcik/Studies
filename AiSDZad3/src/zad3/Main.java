package zad3;

import java.util.Scanner;

public class Main {
		public static void main(String args[]) {
			System.out.println("Wybierz opcje z menu i nacisnij enter");
			System.out.println("1. Utworzenie listy");
			System.out.println("2. Wyswietlanie listy");
			System.out.println("3. Wyswietlanie liczby elementow listy");
			System.out.println("4. Wyswietlanie kart o podanej wartosci");
			System.out.println("5. Wyswietlanie kart o podanym kolorze");
			int wybor = 0;
			Scanner sc = new Scanner(System.in);
			wybor = sc.nextInt();
			switch (wybor) {
			case 1:
                Lista.Utworz();
				System.out.println("Lista zostala utworzona.");
				wybor = sc.nextInt();
				while (true) {
					switch (wybor) {
					case 2:
						System.out.println("Wyswietlam liste:");
						Lista.Wyswietl();
						wybor = sc.nextInt();
						break;
					case 3:
						System.out.println("Liczba elementow: " + Lista.LiczbaElementow());
						wybor = sc.nextInt();
						break;
					case 4:
						System.out.println("O jakiej wartosci wyswietlic karty?");
						int wart = sc.nextInt();
						Lista.wyswietlwartosc(wart);
						wybor = sc.nextInt();
                        break;
					case 5:
						System.out.println("O jakim kolorze wyswietlic karty?");
						int kolo = sc.nextInt();
						Lista.wyswietlkolor(kolo);
						wybor = sc.nextInt();
						break;
					/*case 6:
						System.out.println("Ktory element wyszukac?");
						int nr = sc.nextInt();
						System.out.println(Lista.Szukaj(nr).getkarta().getwartosc()+" "+Lista.Szukaj(nr).getkarta().getkolor());
						wybor = sc.nextInt();
						break;*/
					}
				}
			}
			sc.close();
		}
}
