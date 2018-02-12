package zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lista {

	// public Lista(){}

	// public Lista()

	@SuppressWarnings("rawtypes")
	public static ArrayList utworz() {
		int wart = -1;
		int kol = 0;
		Random r = new Random();
		ArrayList<Karta> lista = new ArrayList<Karta>();
		while (wart != 0) {
			wart = r.nextInt(14);
			kol = r.nextInt(4);
			if (wart != 0) {
				lista.add(new Karta(wart, kol));
			}
		}
		return lista;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void wyswietlliste(ArrayList list) {
		Collections.sort(list, Karta.Sortowanie);
		for (Object karta : list) {
			((Karta) karta).wyswietl();
		}
	}

	@SuppressWarnings("rawtypes")
	public static int liczbaelementow(ArrayList list) {
		return (list.size());
	}

	public static void wyswietlwartosci(ArrayList list, int war) {
		for (Object karta : list) {
			if (((Karta) karta).wartosc == war) {
				((Karta) karta).wyswietl();
			}
		}
	}

	public static void wyswietlkolor(ArrayList list, int kol) {
		for (Object karta : list) {
			if (((Karta) karta).kolor == kol) {
				((Karta) karta).wyswietl();
			}
		}
	}
}
