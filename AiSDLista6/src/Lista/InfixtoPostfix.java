package Lista;

public class InfixtoPostfix { 
	String postfix;
	Stos operatorstack;
	
	public InfixtoPostfix(){
		postfix = "";
	}
	
	public String convert(String infix){
	    operatorstack = new Stos();
		postfix = "";
		int index = 0;
		char znak;
		while(index<infix.length()){
			znak = infix.charAt(index);
			if(!isOperator(znak) && isnumber(znak) && index<=infix.length()-2 && isnumber(infix.charAt(index+1))){
				postfix+=znak;
				if(index==infix.length()-2){
					postfix+=infix.charAt(index+1)+" ";
					break;
				}
			} else if((!isOperator(znak) && isnumber(znak))){
				postfix+=znak+" ";
			} else if(isOperator(znak)){
				proccessOperator(znak);
			} else{
				System.out.println("Jakis blad");
				break;
			}
			index++;
		}
		
		while(!operatorstack.empty()){
		    postfix+=operatorstack.pop()+" ";	
		}
		return postfix;
	}
	
	private void proccessOperator(char op){
		if(operatorstack.empty() || op=='('){
		    operatorstack.push(op);	
		} else{
			char topOp=operatorstack.peek();
			if(precedence(op)>precedence(topOp)){
				operatorstack.push(op);
			} else{
				while(!operatorstack.empty() && precedence(op)<=precedence(topOp)){
					topOp=operatorstack.pop();
					if(topOp=='('){
						break;
					}
					postfix+=topOp+" ";
					if(!operatorstack.empty()){
						topOp=operatorstack.peek();
					}
				}
				if(op!=')'){
					operatorstack.push(op);	
				}
			}
		}
			
	}
	
	private boolean isOperator(char ch){
		return (ch=='+' || ch == '-' || ch == '*' || ch =='/' || ch=='%' || ch=='(' || ch==')');
	}
	
	private int precedence(char op){
		int priorytet = 0;
		if(op=='(' || op==')') priorytet=-1;
		if(op=='+' || op=='-') priorytet=1;
		if(op=='*' || op=='/' || op=='%') priorytet=2;
		return priorytet;
	}
	
	public String wylicz(String expression){
		Stos2 stack = new Stos2();
		boolean czyblad=false;
		String result;
		char znak;
		int a,b,c;
		String[] tab = expression.split(" ");
		for(int i=0; i<tab.length; i++){
			if(tab[i].length()>1){
				stack.push(tab[i]);
			} else{
			znak = tab[i].charAt(0);	
			if(!isOperator(znak)){
				if(!isnumber(znak)){
					czyblad=true;
					System.out.println("Wystapil blad podczas obliczen");
					break;
				}
				String znak2 = Character.toString(znak);
				stack.push(znak2);
			} else if(isOperator(znak)) {
			    b = Integer.parseInt(stack.pop());
			    if(b==0 && znak=='/'){
			    	czyblad=true;
			    	break;
			    }
			    a = Integer.parseInt(stack.pop());
			    c = operation(a,b,znak);
			    String znak3 = Integer.toString(c);
			    stack.push(znak3);
			} else{
				czyblad=true;
				break;
			}
		  }
		}
		if(czyblad==true){
			System.out.println("Wystapil blad podczas obliczen");
			result = "?";
		} else {
			result = stack.peek();	
		}
		
		return result;
	}
	
	private int operation(int a, int b, char znak){
		int result = 0;
		if(znak=='+') result=a+b;
		if(znak=='-') result=a-b;
		if(znak=='*') result=a*b;
		if(znak=='/') result=a/b;
		if(znak=='%') result=a%b;
		return result;
	}
    
	private boolean isnumber(char ch){
		return (ch=='0' || ch=='1' || ch=='2' || ch=='3' || ch=='4' || ch=='5' || ch=='6' || ch=='7' || ch=='8' || ch=='9');
	}
}
