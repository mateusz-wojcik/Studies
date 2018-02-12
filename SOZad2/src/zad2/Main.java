package zad2;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Wielkosc dysku: ");
        int size = sc.nextInt();
        System.out.println("Ile procesow?");
        int ile = sc.nextInt();
        System.out.println("Lokacja poczatkowa cylindra: ");
        int lokacja = sc.nextInt();
       // Proces[] tp = new Proces[ile];
       // tp = Proces.CreateDisc(ile, size);
        Proces[] tp = {new Proces(98,false),new Proces(183,false),new Proces(37,false),new Proces(122,false),new Proces(14,false),new Proces(124,false),new Proces(65,false),new Proces(67,false) };
        System.out.println("FCFS:           "+FCFS.AlgorytmFCFS(lokacja,tp));
        System.out.println("SSTF:           "+SSTF.AlgorytmSSTF(lokacja,tp));
        Proces.clear(tp);
        System.out.println("SCAN:           "+SCAN.AlgorytmSCAN(lokacja,tp,size));
        Proces.clear(tp);
        System.out.println("C-SCAN:         "+CSCAN.AlgorytmCSCAN(lokacja,tp,size));
        Proces.clear(tp);
        Proces2[] p2 = new Proces2[ile];
        p2 = Proces2.CreateDisc(ile, size);
        System.out.println("Aplikacje z czasem rzeczywistym:");
        System.out.println("FCFS z EDF:     "+FCFS.AlgorytmFCFSzEDF(lokacja, tp, p2));
        Proces.clear(tp);
        Proces2.clear(p2);
        System.out.println("SSTF z EDF:     "+SSTF.AlgorytmSSTFzEDF(lokacja, tp, p2));
        Proces.clear(tp);
        Proces2.clear(p2);
        System.out.println("SCAN z FD-SCAN: "+FDSCAN.AlgorytmFDSCANzSCAN(lokacja, tp, p2, size));
        Proces.clear(tp);
        Proces2.clear(p2);
        System.out.println("SCAN z C-SCAN:  "+FDSCAN.AlgorytmFDSCANzCSCAN(lokacja, tp, p2, size));
    }
}
