package lista8;

public class Shell1 {
	int tab[];
	
	public Shell1(){
		
	}
	
	public Shell1(int tab[]){
		this.tab = tab;
	}
	
	public long shellsortA(){
		int x,i;
		int n = tab.length;
		int h = ciagA();
		long start = System.currentTimeMillis();
		while(h>0){
			for(int j=n-h-1; j>=0; j--){
				x = tab[j];
				i = j+h;
				while(i<n && x>tab[i]){
					tab[i-h] = tab[i];
					i+=h;
				}
				tab[i-h]=x;
			}
			h /= 3;
		}
		long stop = System.currentTimeMillis();
		return stop - start;
	}
	
	public long shellsortB(){
		int x,i;
		int n = tab.length;
		int h = ciagB();
		long start = System.currentTimeMillis();
		while(h>0){
			for(int j=n-h-1; j>=0; j--){
				x = tab[j];
				i = j+h;
				while(i<n && x>tab[i]){
					tab[i-h] = tab[i];
					i+=h;
				}
				tab[i-h]=x;
			}
			h /= 2;
		}
		long stop = System.currentTimeMillis();
		return stop - start;
	}
	
	public long shellsortC(){
		int x,i;
		int n = tab.length;
		int h = ciagC();
		long start = System.currentTimeMillis();
		while(h>0){
			for(int j=n-h-1; j>=0; j--){
				x = tab[j];
				i = j+h;
				while(i<n && x>tab[i]){
					tab[i-h] = tab[i];
					i+=h;
				}
				tab[i-h]=x;
			}
			if(h==1) h=0; else if(h==3) h=1; else h = (h+1)/2;
		}
		long stop = System.currentTimeMillis();
		return stop - start;
	}
	
	public long shellsortD(){
		int x,i;
		int n = tab.length;
		int[] fib = ciagD();
		int h = fib[fib.length-4];
		int l = 4;
		long start = System.currentTimeMillis();
		while(h>0){
			for(int j=n-h-1; j>=0; j--){
				x = tab[j];
				i = j+h;
				while(i<n && x>tab[i]){
					tab[i-h] = tab[i];
					i+=h;
				}
				tab[i-h]=x;
			}
			l++;
			if(h==1) h=0; else h = fib[fib.length-l];
		}
		long stop = System.currentTimeMillis();
		return stop - start;
	}
	
	public int ciagA(){
		int n = tab.length;
		int h;
		for(h=1;h<n;h=3*h+1);
		h/=9;
		if(h==0) h=1;
		return h;
	}
	
	public int ciagB(){
		int n = tab.length;
		int h;
		int k = 1;
		for(h=1;h<n;h=(int) (Math.pow(2, k)-1)) k++;
		h/=8;
		if(h==0) h=1;
		return h;
	}
	
	public int ciagC(){
		int n = tab.length;
		int h;
		int k = 1;
		for(h=1;h<n;h=(int) (Math.pow(2, k)+1)) k++;
		h = (h+1)/8 +1;
		if(h==0) h=1;
		return h;
	}
	
	public int[] ciagD(){
		int n = tab.length;
		int h;
		int k = 0;
		int fib[] = new int[n];
		fib[0] = 1;
		fib[1] = 1;
		for(h=2;k<n;h++){
			fib[h] = fib[h-1] + fib[h-2];
			k = fib[h];
		}
		int result[] = new int[h];
		for(int i=0;i<h;i++){
			result[i] = fib[i];
		}
		
		return result;
	}
	
	public void wyswietl(){
		for(int i=0; i<tab.length; i++){
			System.out.println(tab[i]);
		}
	}
}
