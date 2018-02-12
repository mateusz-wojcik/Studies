package Lista;

public class Stos {
	int size;
	Element szczyt;
	Element first;
		
	public Stos(){
		size = 0;
	}
	
	public boolean empty(){
	    return size==0;			
	}
	
	public Element push(char znak){
		if(empty()){
			szczyt = new Element(znak,null);
			first = szczyt;
		} else {
			Element obiekt = first;
			while(obiekt.getnext()!=null){
		    obiekt = obiekt.getnext();
		    }
			obiekt.setnext(new Element(znak,null));
			szczyt = obiekt.getnext();
		}
		size++;
		return szczyt;
	}
	
	public char pop(){
		char znak = szczyt.getznak();
		Element obiekt = first;
		if(obiekt.getnext()==null){
			first = null;
			szczyt = null;
		} else {
			while(obiekt.getnext().getnext()!=null){
				obiekt = obiekt.getnext();
			}
			obiekt.setnext(null);
			szczyt = obiekt;	
		}
		
		size--;
		return znak;
	}
	
	public char peek(){
	    return szczyt.getznak();
	}
	
	public void wyswietl(){
		Element obiekt = first;
		while(obiekt!=null){
			obiekt.wyswietl();
			obiekt = obiekt.getnext();
		}
	}
}
