package so5;

import java.util.Random;

public class Strategia_1 {
	Procesor[] procesor;
	
	public Strategia_1(Procesor[] proc){
		this.procesor = proc;
	}
	
	public void str1(int czas, int z, int p){ //z - ile procesorw pytamy p-prog obciazenia
		Random r = new Random(); 
		int srednieobciazenie = 0;
		int suma = 0;
		int index = 0;
		int ilosczapytan = 0;
		int migracje = 0;
		int obciazenie[] = new int[czas/10];
		for(int i=0; i<czas; i++){                                         //czas
			if(i>=czas/2 && i%11==0) {
				for(int q=0; q<procesor.length; q++){
					procesor[q].obciazenie-=(procesor[q].obciazenie/10);
				}
			}
			if(i!=0 && i%10==0){                                           //obliczamy srednie obiazenie
				for(int m=0; m<procesor.length; m++){
					suma+=procesor[m].obciazenie;
				}
				obciazenie[index]=(suma/procesor.length);
				suma=0;
				index++;
			}
			for(int j=0; j<procesor.length; j++){                     //sprawdzamy kazdy procesor
				
				//procesor[j].wyswietl();
				
				for(int k=0; k<procesor[j].proc.size(); k++){         //sprawdzamy zgloszenia (ktore trwaja)
				    
					if(procesor[j].proc.get(k).pojawienie+procesor[j].proc.get(k).czastrwania<=i){
				    	procesor[j].obciazenie-=procesor[j].proc.get(k).udzial;  //proces skonczony, odejmujemy obiazenie - udzial skonczonego procesu
						procesor[j].proc.remove(k);
				    }
					
					if(k<procesor[j].proc.size() && procesor[j].proc.get(k).pojawienie==i){        //sprawdzamy czy pojawil sie nowy proces
				    	boolean czy = false;                          //czy przeniesiono proces
				    	for(int l=0; l<z; l++){                       //pytamy Z razy o obiazenie innych procesorow
				    		int bound = r.nextInt(procesor.length);
				    		ilosczapytan++;
				    		if(procesor[bound].obciazenie<p){
				    			//System.out.println(bound);
				    			procesor[bound].obciazenie+=procesor[j].proc.get(k).udzial; //dodajemy obciazenie do y
				    			procesor[bound].proc.add(procesor[j].proc.get(k));          //proces przenosimy na y
				    			//procesor[j].obciazenie-=procesor[j].proc.get(k).udzial; //UWAGA
				    			procesor[j].proc.remove(k);
				    			migracje++;
				    			czy = true;
				    			if(czy) break;
				    		}
				    		if(!czy && procesor[j].obciazenie+procesor[j].proc.get(k).udzial<100){
				    			procesor[j].obciazenie+=procesor[j].proc.get(k).udzial;     //proces wykonuje sie na x
				    		}
				    	}
				    }
					
				}
				//procesor[j].wyswietl();
			}
		}
		for(int m=0; m<obciazenie.length; m++){
			suma+=obciazenie[m];
		}
		srednieobciazenie = suma/obciazenie.length;
		suma=0;
		for(int n = 0; n<obciazenie.length; n++){
			suma+=Math.abs(srednieobciazenie-obciazenie[n]);
			//System.out.println("obc "+obciazenie[n]);
		}
		int srednieodchylenie = suma/obciazenie.length;
		System.out.println("1.");
		System.out.println("Srednie obciazenie procesorow: "+srednieobciazenie+"%");
		System.out.println("Srednie odchylenie : "+srednieodchylenie+"%");
		System.out.println("Ilosc zapytan  : "+ilosczapytan);
		System.out.println("Ilosc migracji : "+migracje);
	}

}
