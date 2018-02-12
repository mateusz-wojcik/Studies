import java.util.*;
public class system 
{
	public final static int THwyniHOLD = 90;
	public final static int THwyniHOLD2 = 30;
	public final static int Z_czas = 3;
	public CPU[] cpu;
	public int iloCPU;
	public int maxCzas;
	public double[] wyniki;
	public int[] wyni;
	public int[] wyni1;
	public int[] wyni2;
	public double[] wyniki1;
	public double[] wyniki2;
	public int liczbaProcesow;
	public system(int liczbaCPU, int _maxCzas)
	{
		Random r= new Random();
		cpu = new CPU[liczbaCPU];
		iloCPU = 0;
		maxCzas = _maxCzas;
		wyniki = new double[maxCzas];
		wyni = new int[2];
		wyni1 = new int[2];
		wyni2 = new int[2];
		wyniki1 = new double[maxCzas];
		wyniki2 = new double[maxCzas];
		liczbaProcesow = 1000;
		for(int i=0; i < liczbaCPU; i++)
		{
			cpu[i] = new CPU();
			iloCPU++;
		}
	}
	public void pierwszy()
	{
		int zalPyt = 0;
		int migracjaProcesow = 0;
		for(int i=1; i <= maxCzas; i++)
		{
			Random rand= new Random();
			//int liczbaProcesow = 1+rand.nextInt(500);
			for(int j=0; j < liczbaProcesow; j++)
			{
				int rCPU = rand.nextInt(cpu.length);
				Process nowyProces = new Process();
				int wybierzCPU = rand.nextInt(cpu.length);
				int z_czas = 1;
				while(wybierzCPU == rCPU || cpu[wybierzCPU].zaladuj > THwyniHOLD )
				{
					wybierzCPU = rand.nextInt(cpu.length);
					z_czas++;
					zalPyt++;
					if(z_czas == (Z_czas+1))
					{
						break;
					}
				}
				if(cpu[wybierzCPU].zaladuj > THwyniHOLD)
				{
					if(cpu[rCPU].zaladuj + nowyProces.waga <= 100)
					{
						cpu[rCPU].procesy.add(nowyProces);
						cpu[rCPU].wielkosc++;
						cpu[rCPU].przeladuj();
					}
					zalPyt++;
				}
				else{
					if(cpu[wybierzCPU].zaladuj + nowyProces.waga <= 100)
					{
						cpu[wybierzCPU].procesy.add(nowyProces);
						cpu[wybierzCPU].wielkosc++;
						cpu[wybierzCPU].przeladuj();
					}
					migracjaProcesow++;
					zalPyt++;
				}
			}
			int obciazenie = 0;
			for(int k=0; k < cpu.length; k++)
			{
				obciazenie += cpu[k].zaladuj;
			}
			wyniki[i-1] = obciazenie/cpu.length;
			for(int k=0; k < cpu.length; k++)
			{
				cpu[k].procesy.clear();
				cpu[k].wielkosc = 0;
				cpu[k].przeladuj();
			}
			wyni[0] = zalPyt;
			wyni[1] = migracjaProcesow;
		}
	}
	public void drugi()
	{
		int zalPyt = 0;
		int migracjaProcesow = 0;
		for(int i=1; i <= maxCzas; i++)
		{
			Random rand= new Random();
			//int liczbaProcesow = 1+rand.nextInt(500);
			for(int j=0; j < liczbaProcesow; j++)
			{
				int rCPU = rand.nextInt(cpu.length);
				Process nowyProces = new Process();
				int wybierzCPU = rand.nextInt(cpu.length);
				int z_czas = 1;
				if(cpu[rCPU].zaladuj < THwyniHOLD)
				{
					if(cpu[rCPU].zaladuj + nowyProces.waga <= 100)
					{
						cpu[rCPU].procesy.add(nowyProces);
						cpu[rCPU].wielkosc++;
						cpu[rCPU].przeladuj();
					}
					zalPyt++;
				}
				else{
					while(wybierzCPU == rCPU || cpu[wybierzCPU].zaladuj > THwyniHOLD )
					{
						wybierzCPU = rand.nextInt(cpu.length);
						z_czas++;
						zalPyt++;
						if(z_czas == (Z_czas+100))
						{
							break;
						}
					}
					if(cpu[wybierzCPU].zaladuj + nowyProces.waga <= 100)
					{
						cpu[wybierzCPU].procesy.add(nowyProces);
						cpu[wybierzCPU].wielkosc++;
						cpu[wybierzCPU].przeladuj();
						migracjaProcesow++;
					}
				}
			}
			int obciazenie = 0;
			for(int k=0; k < cpu.length; k++)
			{
				obciazenie += cpu[k].zaladuj;
			}
			wyniki1[i-1] = obciazenie/cpu.length;
			for(int k=0; k < cpu.length; k++){
				cpu[k].procesy.clear();
				cpu[k].wielkosc = 0;
				cpu[k].przeladuj();
			}
		}
		wyni1[0] = zalPyt;
		wyni1[1] = migracjaProcesow;
	}
	public void trzeci()
	{
		int zalPyt = 0;
		int migracjaProcesow = 0;
		for(int i=1; i <= maxCzas; i++)
		{
			Random rand= new Random();
			//int liczbaProcesow = 1+rand.nextInt(500);
			for(int j=0; j < liczbaProcesow; j++)
			{
				int rCPU = rand.nextInt(cpu.length);
				Process nowyProces = new Process();
				int wybierzCPU = rand.nextInt(cpu.length);
				int z_czas = 1;
				if(cpu[rCPU].zaladuj < THwyniHOLD)
				{
					if(cpu[rCPU].zaladuj + nowyProces.waga <= 100)
					{
						cpu[rCPU].procesy.add(nowyProces);
						cpu[rCPU].wielkosc++;
						cpu[rCPU].przeladuj();
						zalPyt++;
					}
					if(cpu[rCPU].zaladuj < THwyniHOLD2)
					{
						while(cpu[wybierzCPU].zaladuj < THwyniHOLD)
						{
							wybierzCPU = rand.nextInt(cpu.length);
							z_czas++;
							if(z_czas == (Z_czas+10)){
								break;
							}
							zalPyt++;
						}
						if(cpu[wybierzCPU].zaladuj > THwyniHOLD)
						{
							int division = cpu[wybierzCPU].procesy.size()/2;
							for(int k=0; k < division; k++){
								cpu[rCPU].procesy.add(cpu[wybierzCPU].procesy.get(0));
								cpu[wybierzCPU].procesy.remove(0);
								cpu[rCPU].wielkosc++;
								cpu[wybierzCPU].wielkosc--;
								cpu[rCPU].przeladuj();
								cpu[wybierzCPU].przeladuj();
								migracjaProcesow += division;
							}
						}
					}
				}
				else{
					while(wybierzCPU == rCPU || cpu[wybierzCPU].zaladuj > THwyniHOLD )
					{
						wybierzCPU = rand.nextInt(cpu.length);
						z_czas++;
						if(z_czas == (Z_czas+20)){
							break;
						}
						zalPyt++;
					}
					if(cpu[wybierzCPU].zaladuj + nowyProces.waga <= 100)
					{
						cpu[wybierzCPU].procesy.add(nowyProces);
						cpu[wybierzCPU].wielkosc++;
						cpu[wybierzCPU].przeladuj();
						migracjaProcesow++;
					}
				}
			}
			if(i%3 == 0){
				for(int k=0; k < cpu.length; k++)
				{
					cpu[k].procesy.remove(0);
					cpu[k].wielkosc--;
					cpu[k].przeladuj();
				}
			}
			int obciazenie = 0;
			for(int k=0; k < cpu.length; k++)
			{
				obciazenie += cpu[k].zaladuj;
			}
			wyniki2[i-1] = obciazenie/cpu.length;
		}
		wyni2[0] = zalPyt;
		wyni2[1] = migracjaProcesow*100;
	}
	public double obciazenie()
	{
		double obciazenie = 0;
		for(int i=0; i < wyniki.length; i++)
		{
			obciazenie += wyniki[i];
		}
		return obciazenie/wyniki.length;
	}
	public double obciazenie1()
	{
		double obciazenie = 0;
		for(int i=0; i < wyniki1.length; i++)
		{
			obciazenie += wyniki1[i];
		}
		return obciazenie/wyniki1.length;
	}
	public double obciazenie2()
	{
		double obciazenie = 0;
		for(int i=0; i < wyniki2.length; i++)
		{
			obciazenie += wyniki2[i];
		}
		return obciazenie/wyniki2.length;
	}
}
