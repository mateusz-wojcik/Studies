public class test 
{
	public static void main(String []args)
	{
		system s = new system(30,45);
		s.pierwszy();
		System.out.println("1. Średnie obciążenie: " + s.obciazenie()+"%");
		System.out.println("1. Ilość zapytań o obciążenie: " + s.wyni[0]);
		System.out.println("1. Przemieszczenia procesów: " + s.wyni[1]+"\n");
		s.drugi();
		System.out.println("2. Średnie obciążenie: " + s.obciazenie1()+"%");
		System.out.println("2. Ilość zapytań o obciążenie: " + s.wyni1[0]);
		System.out.println("2. Przemieszczenia procesów: " + s.wyni1[1]+"\n");
		s.trzeci();
		System.out.println("2. Średnie obciążenie: " + s.obciazenie2()+"%");
		System.out.println("2. Ilość zapytań o obciążenie: " + s.wyni2[0]);
		System.out.println("2. Przemieszczenia procesów: " + s.wyni2[1]+"\n");
	}
}
