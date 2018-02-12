package so5;

import java.util.Random;

public class Strategia_3 {
	Procesor[] procesor;
	
	public Strategia_3(Procesor[] proc){
		this.procesor = proc;
	}
	
	public void str3(int czas, int z, int p, int progR){ //z - ile procesorw pytamy p-prog obciazenia
		Random r = new Random(); 
		int srednieobciazenie = 0;
		int licznik = 0;
		int suma = 0;
		int index = 0;
		int ilosczapytan = 0;
		int migracje = 0;
		int obciazenie[] = new int[czas/10];
		for(int i=0; i<czas; i++){ //czas
			if(i>=czas/2 && i%11==0) {
				for(int q=0; q<procesor.length; q++){
					procesor[q].obciazenie-=(procesor[q].obciazenie/8);
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
						ilosczapytan++;
						if(procesor[j].obciazenie>p){
				    		boolean czy = false;
				    		licznik = 0;
				    		while(!czy){
				    			licznik++;
				    			if(licznik==2*procesor.length) czy = true;
				    			int bound = r.nextInt(procesor.length);
					    		ilosczapytan++;
					    		//czy = false;
					    		if(procesor[bound].obciazenie<p){
					    			//System.out.println(bound);
					    			procesor[bound].obciazenie+=procesor[j].proc.get(k).udzial; //dodajemy obciazenie do y
					    			procesor[bound].proc.add(procesor[j].proc.get(k));          //proces przenosimy na y
					    			procesor[j].obciazenie-=procesor[j].proc.get(k).udzial; //UWAGA
					    			procesor[j].proc.remove(k);
					    			int aktualnyproces = bound;                                 //zapamietujemy proces
					    			migracje++;
					    			for(int o=0; o<z; o++){
					    				bound = r.nextInt(procesor.length);
							    		ilosczapytan++;
							    		if(procesor[bound].obciazenie>p){
							    			//System.out.println(bound);
							    			procesor[aktualnyproces].obciazenie+=(procesor[bound].obciazenie)/5; //procesor x przejmuje 20% obciazenia zapytanego
							    			procesor[bound].obciazenie-=(procesor[bound].obciazenie)/10;
							    			procesor[bound].proc.add(procesor[j].proc.get(k));          //proces przenosimy na y
							    			//procesor[j].proc.remove(k);
							    			migracje++;
							    			czy = true;
							    			if(czy) break;
							    		}
					    			}
					    			czy = true;
				    		    }
				    	    }
				    	} else {
				    		if(procesor[j].obciazenie+procesor[j].proc.get(k).udzial<100){
				    			procesor[j].obciazenie+=procesor[j].proc.get(k).udzial;     //proces wykonuje sie na x
				    		}
				    	}
						for(int o=0; o<procesor.length; o++){
							ilosczapytan++;
							if(procesor[j].obciazenie<progR){
								int bound = r.nextInt(procesor.length);
								ilosczapytan++;
								if(procesor[bound].obciazenie>p){
									migracje++;
									procesor[bound].obciazenie-=(procesor[bound].obciazenie/5);
									procesor[j].obciazenie+=(procesor[bound].obciazenie/5);
								}
								
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
		System.out.println("3.");
		System.out.println("Srednie obciazenie procesorow: "+srednieobciazenie+"%");
		System.out.println("Srednie odchylenie : "+srednieodchylenie+"%");
		System.out.println("Ilosc zapytan  : "+ilosczapytan);
		System.out.println("Ilosc migracji : "+migracje);
	}

}
