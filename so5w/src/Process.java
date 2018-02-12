import java.util.*;
public class Process 
{
	int waga; //weight	
	public Process()
	{
		Random r = new Random();
		waga = 1+r.nextInt(5);
	}
}