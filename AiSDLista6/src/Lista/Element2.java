package Lista;

public class Element2 {
	String znak;
	Element2 next;	
	
	public Element2(){
		next = null;
	}
	
	public Element2(String znak, Element2 next){
		this.znak = znak;
		this.next = next;	
	}
	
	public Element2 getnext(){
		return next;
	}
	
	public void setnext(Element2 element){
		next = element;
	}
	
	public String getznak(){
		return znak;
	}
	
	public void wyswietl(){
		System.out.println(znak);
	}

}
