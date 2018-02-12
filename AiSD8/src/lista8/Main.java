package lista8;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.print("Ile liczb? ");
		int n = sc.nextInt();
		int tab1[] = new int[n];
		Random r = new Random();
		for(int i=0; i<n; i++){
			tab1[i] = r.nextInt(2000000000)+1;
		}
		int tab2[] = tab1.clone();
		int tab3[] = tab1.clone();
		int tab4[] = tab1.clone();
		int tab5[] = tab1.clone();
		int tab6[] = tab1.clone();
		int tab7[] = tab1.clone();
		int tab8[] = tab1.clone();
		int tab9[] = tab1.clone();
		int tab10[] = tab1.clone();
		int tab11[] = tab1.clone();
		int tab12[] = tab1.clone();
		
        
		System.out.println("0%------------------------------------100%");
		String s = "  ";
		
		Shell1 sh1a = new Shell1(tab1);
		//sh1a.wyswietl();
		//System.out.println("----");
		long time1a = sh1a.shellsortA();
		//sh1a.wyswietl();
		System.out.print(s+="---");
		
		Shell1 sh1b = new Shell1(tab2);
		//System.out.println("----");
		long time1b = sh1b.shellsortB();
		//sh1b.wyswietl();
		System.out.print("---");
		
		Shell1 sh1c = new Shell1(tab3);
		//System.out.println("----");
		long time1c = sh1c.shellsortC();
		//sh1c.wyswietl();
		System.out.print("---");

		Shell1 sh1d = new Shell1(tab4);
		//System.out.println("----");
		long time1d = sh1d.shellsortD();
		//sh1d.wyswietl();
		System.out.print("---");
		
		Shell2 sh2a = new Shell2(tab5);
		//System.out.println("----");
		long time2a = sh2a.shellsortA();
		//sh2a.wyswietl();
		System.out.print("---");
		
		Shell2 sh2b = new Shell2(tab6);
		//System.out.println("----");
		long time2b = sh2b.shellsortB();
		//sh2b.wyswietl();
		System.out.print("---");
		
		Shell2 sh2c = new Shell2(tab7);
		//System.out.println("----");
		long time2c = sh2c.shellsortC();
		//sh2c.wyswietl();
		System.out.print("---");
		
		Shell2 sh2d = new Shell2(tab8);
		//System.out.println("----");
		long time2d = sh2d.shellsortD();
		//sh2d.wyswietl();
		System.out.print("---");
		
		Shell3 sh3a = new Shell3(tab9);
		//System.out.println("----");
		long time3a = sh3a.shellsortA();
		//sh3a.wyswietl();
		System.out.print("---");
		
		Shell3 sh3b = new Shell3(tab10);
		//System.out.println("----");
		long time3b = sh3b.shellsortB();
		//sh3b.wyswietl();
		System.out.print("---");
		
		Shell3 sh3c = new Shell3(tab11);
		//System.out.println("----");
		long time3c = sh3c.shellsortC();
		//sh3c.wyswietl();
		System.out.print("---");
		
		Shell3 sh3d = new Shell3(tab12);
		//System.out.println("----");
		long time3d = sh3d.shellsortD();
		//sh3d.wyswietl();
	    System.out.print("---\n");
		
		System.out.printf("%-10s %14s %14s %14s \n", " ", "Insert&Insert","Insert&Bubble","Bubble&Insert");
	    System.out.printf("%-17s %-14s %-14s %-14s \n", "a) 3h+1", time1a, time2a, time3a);
	    System.out.printf("%-17s %-14s %-14s %-14s \n", "b) 2^k-1", time1b, time2b, time3b);
	    System.out.printf("%-17s %-14s %-14s %-14s \n", "c) 2^k+1", time1c, time2c, time3c);
	    System.out.printf("%-17s %-14s %-14s %-14s \n", "d) Fib", time1d, time2d, time3d);
	    
		sc.close();
	}
}
