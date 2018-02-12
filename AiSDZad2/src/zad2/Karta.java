package zad2;

import java.util.Comparator;

public class Karta {
	int wartosc;
	int kolor;

	public Karta() {
		wartosc = 0;
		kolor = 0;
	}

	public Karta(int wartosc, int kolor) {
		this.wartosc = wartosc;
		this.kolor = kolor;
	}

	public int getwartosc() {
		return wartosc;
	}

	public int getkolor() {
		return kolor;
	}

	public void wyswietl() {
		System.out.println(wartosc + " " + kolor);
	}

	public static Comparator<Karta> Sortowanie = new Comparator<Karta>() {
		public int compare(Karta k1, Karta k2) {
			int w1 = k1.getwartosc();
			int w2 = k2.getwartosc();
			if (w1 - w2 == 0) {
				w1 = k1.getkolor();
				w2 = k2.getkolor();
				return w1 - w2;
			} else {
				return w1 - w2;
			}
		}
	};

}
