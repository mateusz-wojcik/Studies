package Lista;

public class Element {
	char znak;
	Element next;	
	
	public Element(){
		next = null;
	}
	
	public Element(char znak, Element next){
		this.znak = znak;
		this.next = next;	
	}
	
	public Element getnext(){
		return next;
	}
	
	public void setnext(Element element){
		next = element;
	}
	
	public char getznak(){
		return znak;
	}
	
	public void wyswietl(){
		System.out.println(znak);
	}

}
