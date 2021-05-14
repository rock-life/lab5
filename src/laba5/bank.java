package laba5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class bank implements account, Serializable {
public static Map<Integer,bank>list=new HashMap<Integer,bank>();
private int rah;
private String owner;
private LocalDate date;
private int shp;
private int shm;
private int sbp;
private int sbm;
private int sal;
public bank() 
{}
static void save() 
{
	try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Desktop\\file3.txt"))) 
	{
	oos.writeObject(list);
}
catch(Exception ex) {}
}
public static void start()
{
	try(ObjectInputStream oos=new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Desktop\\file3.txt"))) 
	{
		list=(HashMap<Integer,bank>)oos.readObject();
	}
	catch(Exception ex) {System.out.print(ex.getMessage());}
}
	@Override
	public void add() {
		Scanner in=new Scanner(System.in);
		bank b=new bank();
		System.out.print("ID рахунку - ");
		b.rah=in.nextInt();
		int act=1;
		for(Map.Entry<Integer ,bank> entry: list.entrySet()) {
			  int key = entry.getKey();
			  bank value = entry.getValue();
			  if(key==rah)
			  {
				  System.out.println("ID рахункуу існує. редагувати?\n1 - якщо так");
				  act=in.nextInt();
			  }
			  }
		if(act==1) 
		{
		System.out.println("Власник - ");
		in.nextLine();
		b.owner=in.nextLine();
		System.out.print("День операції - ");
		int d=in.nextInt();
		System.out.print("Місяць операції - ");
		int m=in.nextInt();
		System.out.print("Рік операції - ");
		int y=in.nextInt();
		b.date=LocalDate.of(y,m,d);
		System.out.print("сума безготівкового отримання - ");
		b.sbp=in.nextInt();
		System.out.print("сума безготівкового відправлення - ");
		b.sbm=in.nextInt();
		System.out.print("сума готівкового отримання - ");
		b.shp=in.nextInt();
		System.out.print("сума готівкового відправлення - ");
		b.shm=in.nextInt();
		System.out.print("залишок на рахунку - ");
		b.sal=in.nextInt();
		list.put(b.rah,b);	
		save();}
		
	}

	@Override
	public void delete() {
		Scanner in= new Scanner(System.in);
		System.out.print("ID рахунку - ");
		int i=in.nextInt();
		list.remove(i);
		save();
	}

	@Override
	public void show() {
		Scanner in=new Scanner(System.in);
		System.out.print("В якому порядку виводити?\n1 - за зростанням  залишку на рахунках\n2 - за спаданням  залишку на рахунках\n");
		int i=in.nextInt();
		int y=0;
		bank [] l=new bank[list.size()];
		if(i==1)
		{
			for(Map.Entry<Integer ,bank> entry: list.entrySet()) {
				  int key = entry.getKey();
				  bank value = entry.getValue();
				  l[y]=value;
				  y++;
				}
			for(int r = l.length-1 ; r > 0 ; r--){
		        for(int j = 0 ; j < r ; j++){
		            
		            if( l[j].sal > l[j+1].sal ){
		                bank tmp = l[j];
		                l[j] = l[j+1];
		                l[j+1] = tmp;
		            }
		        }
		    }
			for(int g=0;g<l.length;g++)
			{
			  	System.out.print("\n\nID рахунку - "+l[g].rah );
				System.out.print("\nВласник - "+l[g].owner);
				System.out.print("\nДата операції - "+l[g].date);
				System.out.print("\nсума безготівкового отримання -"+ l[g].sbp);
				System.out.print("\nсума безготівкового відправлення -"+l[g].sbm);
				System.out.print("\nсума готівкового отримання - "+l[g].shp);
				System.out.print("\nсума готівкового відправлення - "+l[g].shm);
				System.out.print("\nзалишок на рахунку - "+l[g].sal);
		  }
		}
		if(i==2)
		{
			y=0;
			for(Map.Entry<Integer ,bank> entry: list.entrySet()) {
				  int key = entry.getKey();
				  bank value = entry.getValue();
				  l[y]=value;
				  y++;
				}
			for(int r = l.length-1 ; r > 0 ; r--){
		        for(int j = 0 ; j < r ; j++){
		            
		            if( l[j].sal < l[j+1].sal ){
		                bank tmp = l[j];
		                l[j] = l[j+1];
		                l[j+1] = tmp;
		            }
		        }
		    }
			for(int g=0;g<l.length;g++)
			{
			  	System.out.print("\n\nID рахунку - "+l[g].rah );
				System.out.print("\nВласник - "+l[g].owner);
				System.out.print("\nДата операції - "+l[g].date);
				System.out.print("\nсума безготівкового отримання -"+ l[g].sbp);
				System.out.print("\nсума безготівкового відправлення -"+l[g].sbm);
				System.out.print("\nсума готівкового отримання - "+l[g].shp);
				System.out.print("\nсума готівкового відправлення - "+l[g].shm);
				System.out.print("\nзалишок на рахунку - "+l[g].sal);
		  }
		}
	}

	@Override
	public void zawd() {
		int y=0;
		Scanner in=new Scanner(System.in);
		bank [] l=new bank[list.size()];
		for(Map.Entry<Integer ,bank> entry: list.entrySet()) {
			  int key = entry.getKey();
			  bank value = entry.getValue();
			  l[y]=value;
			  y++;
			}
		for(int r = l.length-1 ; r > 0 ; r--){
	        for(int j = 0 ; j < r ; j++){
	            
	            if( l[j].sbp < l[j+1].sbp ){
	                bank tmp = l[j];
	                l[j] = l[j+1];
	                l[j+1] = tmp;
	            }
	        }
	    }
		
		System.out.print("день - ");
		int d=in.nextInt();
		System.out.print("місяць - ");
		int m=in.nextInt();
		System.out.print("рік - ");
		int yr=in.nextInt();
		LocalDate dd=LocalDate.of(yr, m, d);
		 System.out.print("день - ");
		 d=in.nextInt();
		 System.out.print("місяць - ");
		 m=in.nextInt();
		 System.out.print("рік - ");
		 yr=in.nextInt();
		LocalDate dd2=LocalDate.of(yr, m, d);
		for(int k=0;k<l.length;k++)
		{
			if(l[k].date.isAfter(dd)&&l[k].date.isBefore(dd2))
			{
			  	System.out.print("\nID рахунку - "+l[k].rah );
				System.out.print("\tВласник - "+l[k].owner);
				System.out.print("\nсума безготівкового отримання -"+ l[k].sbp);

		  }
			
		}
		
	}

}
