package Lista;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
        System.out.println("Podaj wyrazenie: ");
        String wyrazenie = sc.nextLine();
        InfixtoPostfix itp = new InfixtoPostfix();
        String onp = itp.convert(wyrazenie);
        //System.out.println(onp);
        System.out.println(wyrazenie+" = "+itp.wylicz(onp));
        
        sc.close();
    }
}
