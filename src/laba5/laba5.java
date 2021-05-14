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
		System.out.println("\nВиберіть завдання:\n1 - інтерфейс\n2 - abstract  \n0 - Вихід");
		v=in.nextInt();
		switch(v) {
		case 1:one();break;
		case 2:two();break;
		case 3:break;}
			}
			catch(Exception ex) {System.out.print("Невірний формат данних!");};
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
		System.out.println("\nВиберіть завдання:\none - додати/редагувати two - вивести tree - видалити \nfour -  Середня кількість хостів в день за вказаний період"
				+ "\nfive -  Дні з максимальною кількістю завантажених сторінок\nsix -  Кількість днів, коли співвідношення хостів до сторінок перевищує задане значення");
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
		System.out.println("\nВиберіть завдання:\none - додати/редагувати two - вивести tree - видалити \nfour -  Вивести на екран у формі таблиці дані про клієнтів банку, які на протязі \r\n"
				+ "заданого періоду часу мають найбільшу суму безготівкового отримання коштів на рахунок.");
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
