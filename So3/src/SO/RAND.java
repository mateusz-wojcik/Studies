package SO;

import java.util.Random;

public class RAND {
	
    public RAND(){}
    
    public int rand(int odw[], int ileramek){
    	int brakstrony = 0;
		Ramka tab[] = new Ramka[ileramek];
		for(int j=0; j<ileramek; j++){
			tab[j] = new Ramka(j,0);
		}
		for(int i=0; i<odw.length; i++){
			if(i<ileramek && !check(tab,odw[i])) tab[i].wartosc=odw[i];
				if(i>=ileramek){
					if(check(tab,odw[i])){
						tab[ktoraramka(ileramek)].wartosc=odw[i];
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
    
    public int ktoraramka(int ile){
    	Random r = new Random();
    	return r.nextInt(ile);
    }
    
    

}
