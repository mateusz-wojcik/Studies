package lista4;

public class Klient {
	String nazwaklienta;
	Zamowienie zamowienie;
	Klient nextklient;
	
	public Klient(){
		nazwaklienta = null;
		zamowienie = null;
		nextklient = null;
	}

	public Klient(String nazwaklienta, Zamowienie zamowienie, Klient next){
		this.nazwaklienta=nazwaklienta;
		this.zamowienie=zamowienie;
		this.nextklient=next;
	}
	
	public String getnazwa(){
		return nazwaklienta;
	}
	
	public Zamowienie getzamowienie(){
		return zamowienie;
	}
	
	public Klient getnext(){
		return this.nextklient;
	}
	
	public void setnext(Klient kl){
		this.nextklient = kl;
	}
	
	public void wyswietl(){
		System.out.println("Nazwa: "+nazwaklienta);
	}
}
