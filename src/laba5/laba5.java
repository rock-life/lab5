package laba5;

import java.util.Scanner;


public class laba5 {
	public static void main(String[] str) 
	{
		Scanner in=null;
		int v=10;
		while(v!=0) {
			try {
		in=new Scanner(System.in);
		System.out.println("\n������� ��������:\n1 - ���������\n2 - abstract  \n0 - �����");
		v=in.nextInt();
		switch(v) {
		case 1:one();break;
		case 2:two();break;
		case 3:break;}
			}
			catch(Exception ex) {System.out.print("������� ������ ������!");};
			}
	}
	
	public static void two()
	{
		wisit w=new wisit();
		wisit.start();
		Scanner in=null;
		String v="";
		do {
			try {
		in=new Scanner(System.in);
		System.out.println("\n������� ��������:\none - ������/���������� two - ������� tree - �������� \nfour -  ������� ������� ����� � ���� �� �������� �����"
				+ "\nfive -  �� � ������������ ������� ������������ �������\nsix -  ʳ������ ���, ���� ������������ ����� �� ������� �������� ������ ��������");
		v=in.nextLine();
		switch(v) {
		case "one":w.add(); break;
		case "two":w.show(); break;
		case "tree":w.del(); break;
		case "four":w.s_k_h(); break;
		case "five":w.max();break;
		case "six": w.k_d();break;
		case "exit": break;
		default: System.out.print("Error value");
		
		}
			}
			catch(Exception ex) {System.out.print(ex.getMessage());};
		}while(!v.equals("exit"));
	}
	
	
	public static void one()
	{
		bank b=new bank();
		bank.start();
		Scanner in=null;
		String v="";
		do {
			try {
		in=new Scanner(System.in);
		System.out.println("\n������� ��������:\none - ������/���������� two - ������� tree - �������� \nfour -  ������� �� ����� � ���� ������� ��� ��� �볺��� �����, �� �� ������ \r\n"
				+ "�������� ������ ���� ����� �������� ���� ������������� ��������� ����� �� �������.");
		v=in.nextLine();
		switch(v) {
		case "one":b.add(); break;
		case "two":b.show(); break;
		case "tree":b.delete(); break;
		case "four":b.zawd(); break;
		case "exit": break;
		default: System.out.print("Error value");
		
		}
			}
			catch(Exception ex) {System.out.print(ex.getMessage());};
		}while(!v.equals("exit"));
	}
	
	
}
