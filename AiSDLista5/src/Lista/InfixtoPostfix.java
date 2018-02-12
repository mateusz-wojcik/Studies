package Lista;

public class InfixtoPostfix { 
	String postfix;
	Stos operatorstack;
	
	public InfixtoPostfix(){
		postfix = "";
	}
	
	public int wylicz(String expression){
		Stos2 stack = new Stos2();
		int result = 0;
		char znak;
		int a,b,c;
		for(int i=0; i<expression.length(); i++){
			znak = expression.charAt(i);
			if(!isOperator(znak)){
				String znak2 = Character.toString(znak);
				stack.push(znak2);
			} else {
			    b = Integer.parseInt(stack.pop());
			    a = Integer.parseInt(stack.pop());
			    c = operation(a,b,znak);
			    String znak3 = Integer.toString(c);
			    stack.push(znak3);
			}
		}
		result = Integer.parseInt(stack.peek());
		
		return result;
	}
	
	public String convert(String infix){
	    operatorstack = new Stos();
		postfix = "";
		int index = 0;
		char znak;
		while(index<infix.length()){
			znak = infix.charAt(index);
			if(!isOperator(znak)){
				postfix+=znak;
			} else if(isOperator(znak)){
				proccessOperator(znak);
			} else{
				System.out.println("Jakis blad");
			}
			index++;
		}
		
		while(!operatorstack.empty()){
		    postfix+=operatorstack.pop();	
		}
		return postfix;
	}
	
	private void proccessOperator(char op){
		if(operatorstack.empty()){
		    operatorstack.push(op);	
		} else{
			char topOp=operatorstack.peek();
			if(precedence(op)>precedence(topOp)){
				operatorstack.push(op);
			} else{
				while(!operatorstack.empty() && precedence(op)<=precedence(topOp)){
					topOp=operatorstack.pop();
					postfix+=topOp;
					if(!operatorstack.empty()){
						topOp=operatorstack.peek();
					}
				}
				
				operatorstack.push(op);
			}
		}
			
	}
	
	private boolean isOperator(char ch){
		return (ch=='+' || ch == '-' || ch == '*' || ch =='/');
	}
	
	private int precedence(char op){
		int priorytet = 0;
		if(op=='+' || op=='-') priorytet=1;
		if(op=='*' || op=='/') priorytet=2;
		return priorytet;
	}
	
	private int operation(int a, int b, char znak){
		int result = 0;
		if(znak=='+') result=a+b;
		if(znak=='-') result=a-b;
		if(znak=='*') result=a*b;
		if(znak=='/') result=a/b;
		return result;
	}
    
}
