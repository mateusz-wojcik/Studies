package zad3;

public class Element {
	Karta kart;
	Element nastepnik;
	
	public Element(Karta kart){
		this.kart=kart;
		nastepnik = null;
	}
	
	public Element(Karta kart, Element next){
		this.kart = kart;
		this.nastepnik = next;
	}
	
	public Karta getkarta(){
		return this.kart;
	}
	
	public Element getnext(){
		return this.nastepnik;
	}
	
	public  void setKarta(Karta kart){
		this.kart = kart;
	}
	
	public void setNext(Element nastElem){
		this.nastepnik = nastElem;
	}	
}
