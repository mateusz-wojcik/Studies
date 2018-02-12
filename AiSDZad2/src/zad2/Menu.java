package zad2;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
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
			ArrayList list = Lista.utworz();
			System.out.println("Lista zostala utworzona.");
			wybor = sc.nextInt();
			while (true) {
				switch (wybor) {
				case 2:
					System.out.println("Wyswietlam liste:");
					Lista.wyswietlliste(list);
					wybor = sc.nextInt();
				case 3:
					System.out.println("Liczba elementow: " + Lista.liczbaelementow(list));
					wybor = sc.nextInt();

				case 4:
					System.out.println("O jakiej wartosci wyswietlic karty?");
					int wart = sc.nextInt();
					Lista.wyswietlwartosci(list, wart);
					wybor = sc.nextInt();

				case 5:
					System.out.println("O jakim kolorze wyswietlic karty?");
					int kolo = sc.nextInt();
					Lista.wyswietlkolor(list, kolo);
					wybor = sc.nextInt();
				}
			}
		}
	}
}
