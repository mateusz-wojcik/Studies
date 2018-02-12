package zad2;

import java.util.Random;

public class Proces {
	int cylinder;
	boolean done;
	static Proces[] tabproces;
	
    public Proces(){
    	
    }
    
    public Proces(int cylinder, boolean done){
    	this.cylinder = cylinder;
    	this.done = done;
    }
    
    public static Proces[] CreateDisc(int ile, int max){
    	tabproces = new Proces[ile];
    	Random r = new Random();
    	for(int i=0; i<ile; i++){
    		tabproces[i] = new Proces(r.nextInt(max),false);
    	}
    	return tabproces;
    }
    
    public static void clear(Proces[] proc){
    	for(int i=0; i<proc.length;i++){
    		proc[i].done=false;
    	}
    }
    
    public int getcylinder(){
    	return cylinder;
    }
    
    public static boolean alldone(Proces[] proc){
    	for(int i=0; i<proc.length; i++){
    		if(proc[i].done==false) return false;
    	}
    	return true;
    }
    
    public boolean checkdone(){
    	return done;
    }
    
    public void wyswietl(){
    	System.out.println("Cylinder: "+cylinder);
    }
}
