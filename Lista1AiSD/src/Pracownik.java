
public class Pracownik{
	String nazwisko, imie;
	long pesel;
	int staz;
	double pensja;
	
	Pracownik(){
		nazwisko = null;
		imie = null;
		pesel=0;
		staz=0;
		pensja=0;
	}
	
	Pracownik(String nazwisko, String imie, long pesel, int staz, double pensja){
		this.nazwisko=nazwisko;
		this.imie=imie;
		this.pesel=pesel;
		this.staz=staz;
		this.pensja=pensja;
	}
    
	public void wyswietl(){
		System.out.printf("%-15s %-10s %-10s %-10s %-5s",nazwisko,imie,pesel,staz,pensja);
	}
	
	public String toString(){
		String s = String.format("%-15s %-10s %-10s %-10s %-5s","nazwisko","imie","pesel","staz","pensja"); 
		return(s);
	}
}
