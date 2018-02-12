package SO;

public class LRUapr {
	
	public LRUapr(){}
	
	public int lruapr(int odw[], int ileramek){
		int brakstrony = 0;
		Ramkabit tab[] = new Ramkabit[ileramek];
		Ramkabit kolejka[] = new Ramkabit[ileramek];
		for(int j=0; j<ileramek; j++){
			tab[j] = new Ramkabit(j,0,1);
		}
		for(int i=0; i<odw.length; i++){
			if(i<ileramek && !check(tab,odw[i])){
				tab[i].wartosc=odw[i];
				kolejka[i]=new Ramkabit(i,odw[i],1);
			}
			if(i<ileramek && check(tab,odw[i])){
				kolejka[i]=new Ramkabit(i,odw[i],1);
			}
				if(i>=ileramek){
					if(check(tab,odw[i])){
						tab[ktoraramka(kolejka,odw[i])].wartosc=odw[i];
						brakstrony++;
					}

				}
		}
		return brakstrony;
	}
	
	public boolean check(Ramkabit ramki[], int odwolanie){
		boolean czy = false;
		for(int i=0; i<ramki.length; i++){
			if(ramki[i].wartosc==odwolanie){
				czy = true;
				break;
			}
		}
		return czy;
	}
	
	public int ktoraramka(Ramkabit kolejka[], int odwolanie){
		int numer = 0;
		boolean done = false;
		int licznik = 0;
		while(!done){
			if(kolejka[licznik].bit==0){
				numer = kolejka[0].numer;
				Ramkabit bufor = kolejka[0];
				for(int i=0; i<kolejka.length-1; i++) kolejka[i] = kolejka[i+1];
				kolejka[kolejka.length-1] = bufor;
				kolejka[kolejka.length-1].wartosc = odwolanie;
				kolejka[kolejka.length-1].bit = 1;
				done = true;
			} else if(kolejka[licznik].bit==1){
				Ramkabit bufor = kolejka[0];
				for(int i=0; i<kolejka.length-1; i++) kolejka[i] = kolejka[i+1];
				kolejka[kolejka.length-1] = bufor;
				kolejka[kolejka.length-1].bit = 0;
			}
		}
		
		return numer;
	}


}
