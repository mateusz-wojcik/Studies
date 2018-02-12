package zad2;

import java.util.Random;

public class Proces2 {
	int cylinder;
	boolean done;
	boolean ready;
	int czas; 
	int deadline;
	static Proces2[] tabproces;
	
    public Proces2(){
    	
    }
    
    public Proces2(int cylinder, boolean done, int czas, int deadline, boolean ready){
    	this.cylinder = cylinder;
    	this.done = done;
    	this.czas = czas;
    	this.deadline = deadline;
    	this.ready = ready;
    }
    
    public static Proces2[] CreateDisc(int ile, int max){
    	tabproces = new Proces2[ile];
    	Random r = new Random();
    	for(int i=0; i<ile; i++){
    		tabproces[i] = new Proces2(r.nextInt(max),false,r.nextInt(30),r.nextInt(20),false);
    	}
    	return tabproces;
    }
    
    public static void clear(Proces2[] proc){
    	for(int i=0; i<proc.length;i++){
    		proc[i].done=false;
    		proc[i].ready=false;
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
