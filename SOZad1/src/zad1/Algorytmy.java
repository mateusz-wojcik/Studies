package zad1;

public class Algorytmy {

	// w FCFS numer procesu jest jednoczsnie jego momentem zgloszenia sie
	public static double FCFS(int ileproc, int tabwartosci[], int tabwartosciczaszgl[]) {
		int czas = 0;
		double wynik = 0;
		Proces pr[] = new Proces[ileproc];
		//System.out.println("Algorytm FCFS:");
		//System.out.println("NRProc DlProc Moment zgloszenia Czas oczekiwania");
		for (int i = 0; i < ileproc; i++) {
			Proces proc = new Proces(i + 1, tabwartosci[i], tabwartosciczaszgl[i], czas);
			pr[i] = proc;
		}
		for (int i = 0; i < ileproc - 1; i++) { // sortowanie babelkowe po
												// momencie zgloszenia
			for (int j = 0; j < ileproc - 1; j++) {
				if (pr[j].momentzgloszenia > pr[j + 1].momentzgloszenia) {
					Proces x = pr[j];
					pr[j] = pr[j + 1];
					pr[j + 1] = x;
				}
			}
		}
		for (int i = 0; i < ileproc; i++) {
			pr[i].czasoczekiwania = czas;
			czas += pr[i].dlfazy;
			wynik += czas;
			//pr[i].wyswietl();
		}
		// System.out.println(wynik);
		return (wynik / ileproc);
	}

	public static double SJF(int ileproc, int tabwartosci[], int tabwartosciczaszgl[], int dlug) {
		int czasktoryuplynal = 0; // poczatkowa wartosc czasu oczekiwania = 0
		int momentrozpoczecia = 0; // czas przybycia pierwszego + jego dlugosc,
									// a nastepnie po prostu czas, ktory minal
		double wynik = 0;
		int licznik = 0; // liczy ile elementow zostalo sprawdzonych
		int indeks = 0; // numer elementu od ktorego rozpoczynamy
		boolean czy = true;
		boolean czypowt[] = new boolean[ileproc];
		Proces pr[] = new Proces[ileproc];
		//System.out.println("Algorytm SJF:");
		//System.out.println("NR Proc DLProc Moment zgloszenia Czas oczekiwania");
		for (int i = 0; i < ileproc; i++) {
			Proces proc = new Proces(i + 1, tabwartosci[i], tabwartosciczaszgl[i], czasktoryuplynal);
			pr[i] = proc;
			czypowt[i] = false;
		}
		for (int i = 0; i < ileproc - 1; i++) { // sortowanie babelkowe po
												// dlugosci fazy
			for (int j = 0; j < ileproc - 1; j++) {
				if (pr[j].dlfazy > pr[j + 1].dlfazy) {
					Proces x = pr[j];
					pr[j] = pr[j + 1];
					pr[j + 1] = x;
				}
			}
		}

		int min = dlug + 1; // element minimalny = maksymalny element dlugosci
							// procesu + 1
		for (int i = 0; i < ileproc; i++) {// szukamy procesu ktory przybyl
											// najwczesniej
			if (pr[i].momentzgloszenia < min) {
				min = pr[i].momentzgloszenia;
				indeks = i;
			}
		}
		czypowt[indeks] = true;
		czasktoryuplynal = pr[indeks].dlfazy + pr[indeks].momentzgloszenia;
		pr[indeks].czasoczekiwania = 0;
		licznik++;

		while (czy == true) {
			if (licznik == ileproc) {
				czy = false;
				break;
			}
			for (int i = 0; i < ileproc; i++) {
				if (czasktoryuplynal >= pr[i].momentzgloszenia && czypowt[i] == false) {
					czypowt[i] = true;
					pr[i].czasoczekiwania = czasktoryuplynal - pr[i].momentzgloszenia;
					czasktoryuplynal += pr[i].dlfazy;
					wynik += czasktoryuplynal;
					licznik++;
					break;
				}
			}
		}

		for (int i = 0; i < ileproc; i++) {
			//pr[i].wyswietl();
		}

		return (wynik / ileproc);
	}

	public static double RR(int ileproc, int tabwartosci[], int tabwartosciczaszgl[], int kwantczasu) {
		int czas = 0; // caly czas ktory uplynal na wszystkich procesach
		int kontekst = 0; // liczba przelaczen kontekstu
		int kont = 0; // roznica miedzy kwantem czasu a dlugoscia fazy krotszej
						// od niego
		int kwant = kwantczasu; // kwant czasu dla przelaczenia
		int proceswykonany = 0; // liczba wykonanych procesow
		int czascalk[] = new int[ileproc]; // calkowity czas wszystkich procesow
											// do tej pory - calkowity czas tego
											// procesu w sumie
		boolean czy = true;
		double wynik = 0;
		int sumaczas[] = new int[ileproc];// calkowity czas trwania tego
											// procesu
		Proces pr[] = new Proces[ileproc];
		//System.out.println("Algorytm RR dla kwantu czasu " + kwant + ":");
		//System.out.println("NRProc DlProc MomentZgloszenia CzasOczekiwania");
		for (int i = 0; i < ileproc; i++) {
			Proces proc = new Proces(i + 1, tabwartosci[i], tabwartosciczaszgl[i], czas);
			pr[i] = proc;
		}
		for (int i = 0; i < ileproc - 1; i++) { // sortowanie babelkowe po
												// momencie zgloszenia
			for (int j = 0; j < ileproc - 1; j++) {
				if (pr[j].momentzgloszenia > pr[j + 1].momentzgloszenia) {
					Proces x = pr[j];
					pr[j] = pr[j + 1];
					pr[j + 1] = x;
				}
			}
		}
		
		while (czy == true) {
			for (int i = 0; i < ileproc; i++) {
				if (pr[i].dlfazy >= kwant /*&& czas>=pr[i].momentzgloszenia*/) {
					pr[i].dlfazy -= kwant;
					kontekst++;
					czas += kwant;
					sumaczas[i] += kwant;
					czascalk[i] = czas - sumaczas[i];
					pr[i].czasoczekiwania = czascalk[i];
					if(pr[i].dlfazy==0){
						proceswykonany++;
					}
				} else if (pr[i].dlfazy > 0 /*&& czas>=pr[i].momentzgloszenia*/ ) {
						kont = kwant - pr[i].dlfazy;
						czas += pr[i].dlfazy;
						sumaczas[i] += pr[i].dlfazy;
						czascalk[i] = czas - sumaczas[i];
						pr[i].czasoczekiwania = czascalk[i];
						pr[i].dlfazy = 0;
						kontekst++;
						proceswykonany++;
				}
				if (proceswykonany == ileproc) {
					czy = false;
				}
			}
		}
		for (int i = 0; i < ileproc; i++) {
			wynik += czascalk[i];
			//pr[i].wyswietl();
		}
		//System.out.println("Liczba przelaczen kontekstu: " + kontekst);
		return (wynik / ileproc);
	}

	public static double SRTF(int ileproc, int tabwartosci[], int tabwartosciczaszgl[], int dlug){
		int czasktoryuplynal = 0; // poczatkowa wartosc czasu oczekiwania = 0
		int momentrozpoczecia = 0; // czas przybycia pierwszego + jego dlugosc,
									// a nastepnie po prostu czas, ktory minal
		double wynik = 0;
		int z = -1;
		int element = 0;
		int pozostalyczas[] = new int[ileproc];
		int licznik = 0; // liczy ile elementow zostalo sprawdzonych
		int indeks = 0; // numer elementu od ktorego rozpoczynamy
		boolean czy = true;
		boolean czykoniec[] = new boolean[ileproc];
		Proces pr[] = new Proces[ileproc];
		//System.out.println("Algorytm SRTF:");
		//System.out.println("NR Proc DLProc Moment zgloszenia Czas oczekiwania");
		for (int i = 0; i < ileproc; i++) {
			Proces proc = new Proces(i + 1, tabwartosci[i], tabwartosciczaszgl[i], czasktoryuplynal);
			pr[i] = proc;
			czykoniec[i] = false;
			pozostalyczas[i]=pr[i].dlfazy;
		}
		for (int i = 0; i < ileproc - 1; i++) { // sortowanie babelkowe po
												// dlugosci fazy
			for (int j = 0; j < ileproc - 1; j++) {
				if (pr[j].dlfazy > pr[j + 1].dlfazy) {
					Proces x = pr[j];
					pr[j] = pr[j + 1];
					pr[j + 1] = x;
				}
			}
		}

		int min = dlug + 1; // element minimalny = maksymalny element dlugosci
							// procesu + 1
		for (int i = 0; i < ileproc; i++) {// szukamy procesu ktory przybyl
											// najwczesniej
			if (pr[i].momentzgloszenia < min) {
				min = pr[i].momentzgloszenia;
				indeks = i;
			}
		}
		int i1 = 0;
		//czypowt[indeks] = true;
		czasktoryuplynal = pr[indeks].momentzgloszenia;
		pr[indeks].czasoczekiwania = 0;
		//--------------------------------------------------------------------------------
		while (czy == true) {
			if (licznik == ileproc) {
				czy = false;
				break;
			}
			if(czasktoryuplynal==pr[indeks].momentzgloszenia){
				i1 = indeks;
			}
			else {i1 = 0;}
			outerLoop:
			for (int i = i1; i < ileproc; i++) {
				if(czasktoryuplynal==z){
					i = element;	
				}
				pr[i].wyswietl();
				System.out.println(pozostalyczas[i]);
				System.out.println(czasktoryuplynal);
				System.out.println(licznik);
				outerloop:
				if (czasktoryuplynal >= pr[i].momentzgloszenia && czykoniec[i] == false) {
					pr[i].czasoczekiwania = czasktoryuplynal - pr[i].momentzgloszenia - pr[i].dlfazy + pozostalyczas[i];
					
					for(int j=0;j<pr[i].dlfazy;j++){
						pozostalyczas[i]--;
						czasktoryuplynal++;
						if(pozostalyczas[i]==0){
							czykoniec[i] = true;
							licznik++;
							break outerLoop;
						}
						for(int k=0; k<ileproc; k++){
							if(czasktoryuplynal >= pr[i].momentzgloszenia && pr[k].dlfazy<pozostalyczas[i] && czykoniec[k]==false){
								z = czasktoryuplynal;
								element = k;
								break outerloop;
							}
						}
					}
				}
			}
			czasktoryuplynal++;
		}
		//System.out.println("Algorytm SRTF:");
		//System.out.println("NRProc DlProc MomentZgloszenia CzasOczekiwania");
		for (int i = 0; i < ileproc; i++) {
			//pr[i].wyswietl();
			wynik+=pr[i].czasoczekiwania;
		}

		return (wynik / ileproc);
	}
}
