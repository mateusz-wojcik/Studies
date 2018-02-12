package SO;

public class OPT {
	
	public OPT(){}
	
	public int opt(int odw[], int ileramek){
		int brakstrony = 0;
		Ramka tab[] = new Ramka[ileramek];
		for(int j=0; j<ileramek; j++){
			tab[j] = new Ramka(j,0);
		}
		for(int i=0; i<odw.length; i++){
			if(i<ileramek && !check(tab,odw[i])) tab[i].wartosc=odw[i];
				if(i>=ileramek){
					if(check(tab,odw[i])){
						tab[ktoraramka(tab,odw,i)].wartosc=odw[i];
						brakstrony++;
					}

				}
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
	
	public int ktoraramka(Ramka ramki[], int odwolanie[], int pozycja){
		int count[] = new int[ramki.length];
		for(int i=0; i<ramki.length; i++){
			for(int j=pozycja; j<odwolanie.length; j++){
				if(ramki[i].wartosc==odwolanie[j]){
					count[i] = j;
					break;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<count.length; i++){
			if(count[i]>=count[max]){
				max = i;
			}
		}
		
		return max;
	}

}
