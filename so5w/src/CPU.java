import java.util.*;
public class CPU 
{
	ArrayList<Process> procesy;//tasks
	int zaladuj; //load
	int wielkosc; //size
	public CPU()
	{
		procesy = new ArrayList<Process>();
		zaladuj = 0;
		wielkosc = 0;
	}
	public void przeladuj()//updateLoad()
	{
		int wynik = 0; //sum
		if(procesy.isEmpty()!=true)
		{
			for(int i=0; i < wielkosc; i++)
			{
				wynik += procesy.get(i).waga; //weight
			}
		}
		zaladuj = wynik;
	}
}
