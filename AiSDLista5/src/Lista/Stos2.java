package Lista;

public class Stos2 {
	int size;
	Element2 szczyt;
	Element2 first;
		
	public Stos2(){
		size = 0;
	}
	
	public boolean empty(){
	    return size==0;			
	}
	
	public Element2 push(String znak){
		if(empty()){
			szczyt = new Element2(znak,null);
			first = szczyt;
		} else {
			Element2 obiekt = first;
			while(obiekt.getnext()!=null){
		    obiekt = obiekt.getnext();
		    }
			obiekt.setnext(new Element2(znak,null));
			szczyt = obiekt.getnext();
		}
		size++;
		return szczyt;
	}
	
	public String pop(){
		String znak = szczyt.getznak();
		Element2 obiekt = first;
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
	
	public String peek(){
	    return szczyt.getznak();
	}
	
	public void wyswietl(){
		Element2 obiekt = first;
		while(obiekt!=null){
			obiekt.wyswietl();
			obiekt = obiekt.getnext();
		}
	}

}
