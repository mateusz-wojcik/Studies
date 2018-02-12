package lista8;

public class Shell3 {
	 int tab[];
		
		public Shell3(){
			
		}
		
		public Shell3(int tab[]){
			this.tab = tab;
		}
		
		public long shellsortA(){
			int x;
			int n = tab.length;
			int h = ciagA();
			long start = System.currentTimeMillis();
			while(h>0){
				if(h==1){
					for(int i=0;i<tab.length; i++){
						for(int j=0;j<i; j++){
							if(tab[i]<tab[j]){
								int bufor = tab[i];
								for(int k=i; k>j; k--){
									tab[k] = tab[k-1];
								}
								tab[j]=bufor;
								break;
							}
						}
					}
					
				} else {
					for(int l=0; l<h; l++){
						for(int k=l; k<tab.length; k+=h){
							if(k+h < tab.length && tab[k]>tab[k+h]){
								x = tab[k];
								tab[k] = tab[k+h];
								tab[k+h] = x;
							}
						}	
					}
				}
				h /= 3;
			}
			long stop = System.currentTimeMillis();
			return stop - start;
		}
		
		public long shellsortB(){
			int x;
			int n = tab.length;
			int h = ciagB();
			long start = System.currentTimeMillis();
			while(h>0){
				if(h==1){
					for(int i=0;i<tab.length; i++){
						for(int j=0;j<i; j++){
							if(tab[i]<tab[j]){
								int bufor = tab[i];
								for(int k=i; k>j; k--){
									tab[k] = tab[k-1];
								}
								tab[j]=bufor;
								break;
							}
						}
					}
				} else {
					for(int l=0; l<h; l++){
						for(int k=l; k<tab.length; k+=h){
							if(k+h < tab.length && tab[k]>tab[k+h]){
								x = tab[k];
								tab[k] = tab[k+h];
								tab[k+h] = x;
							}
						}	
					}
				}
				h /= 2;
			}
			long stop = System.currentTimeMillis();
			return stop - start;
		}
		
		public long shellsortC(){
			int x;
			int n = tab.length;
			int h = ciagC();
			long start = System.currentTimeMillis();
			while(h>0){
				if(h==1){
					for(int i=0;i<tab.length; i++){
						for(int j=0;j<i; j++){
							if(tab[i]<tab[j]){
								int bufor = tab[i];
								for(int k=i; k>j; k--){
									tab[k] = tab[k-1];
								}
								tab[j]=bufor;
								break;
							}
						}
					}
				} else {
					for(int l=0; l<h; l++){
						for(int k=l; k<tab.length; k+=h){
							if(k+h < tab.length && tab[k]>tab[k+h]){
								x = tab[k];
								tab[k] = tab[k+h];
								tab[k+h] = x;
							}
						}	
					}
				}
				if(h==1) h=0; else if(h==3) h=1; else h = (h+1)/2;
			}
			long stop = System.currentTimeMillis();
			return stop - start;
		}
		
		public long shellsortD(){
			int x;
			int n = tab.length;
			int[] fib = ciagD();
			int h = fib[fib.length-4];
			int l = 4;
			long start = System.currentTimeMillis();
			while(h>0){
				if(h==1){
					for(int i=0;i<tab.length; i++){
						for(int j=0;j<i; j++){
							if(tab[i]<tab[j]){
								int bufor = tab[i];
								for(int k=i; k>j; k--){
									tab[k] = tab[k-1];
								}
								tab[j]=bufor;
								break;
							}
						}
					}
				} else {
					for(int m=0; m<h; m++){
						for(int k=m; k<tab.length; k+=h){
							if(k+h < tab.length && tab[k]>tab[k+h]){
								x = tab[k];
								tab[k] = tab[k+h];
								tab[k+h] = x;
							}
						}	
					}
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
