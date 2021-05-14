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
		System.out.print("ID ������� - ");
		b.rah=in.nextInt();
		int act=1;
		for(Map.Entry<Integer ,bank> entry: list.entrySet()) {
			  int key = entry.getKey();
			  bank value = entry.getValue();
			  if(key==rah)
			  {
				  System.out.println("ID �������� ����. ����������?\n1 - ���� ���");
				  act=in.nextInt();
			  }
			  }
		if(act==1) 
		{
		System.out.println("������� - ");
		in.nextLine();
		b.owner=in.nextLine();
		System.out.print("���� �������� - ");
		int d=in.nextInt();
		System.out.print("̳���� �������� - ");
		int m=in.nextInt();
		System.out.print("г� �������� - ");
		int y=in.nextInt();
		b.date=LocalDate.of(y,m,d);
		System.out.print("���� ������������� ��������� - ");
		b.sbp=in.nextInt();
		System.out.print("���� ������������� ����������� - ");
		b.sbm=in.nextInt();
		System.out.print("���� ���������� ��������� - ");
		b.shp=in.nextInt();
		System.out.print("���� ���������� ����������� - ");
		b.shm=in.nextInt();
		System.out.print("������� �� ������� - ");
		b.sal=in.nextInt();
		list.put(b.rah,b);	
		save();}
		
	}

	@Override
	public void delete() {
		Scanner in= new Scanner(System.in);
		System.out.print("ID ������� - ");
		int i=in.nextInt();
		list.remove(i);
		save();
	}

	@Override
	public void show() {
		Scanner in=new Scanner(System.in);
		System.out.print("� ����� ������� ��������?\n1 - �� ����������  ������� �� ��������\n2 - �� ���������  ������� �� ��������\n");
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
			  	System.out.print("\n\nID ������� - "+l[g].rah );
				System.out.print("\n������� - "+l[g].owner);
				System.out.print("\n���� �������� - "+l[g].date);
				System.out.print("\n���� ������������� ��������� -"+ l[g].sbp);
				System.out.print("\n���� ������������� ����������� -"+l[g].sbm);
				System.out.print("\n���� ���������� ��������� - "+l[g].shp);
				System.out.print("\n���� ���������� ����������� - "+l[g].shm);
				System.out.print("\n������� �� ������� - "+l[g].sal);
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
			  	System.out.print("\n\nID ������� - "+l[g].rah );
				System.out.print("\n������� - "+l[g].owner);
				System.out.print("\n���� �������� - "+l[g].date);
				System.out.print("\n���� ������������� ��������� -"+ l[g].sbp);
				System.out.print("\n���� ������������� ����������� -"+l[g].sbm);
				System.out.print("\n���� ���������� ��������� - "+l[g].shp);
				System.out.print("\n���� ���������� ����������� - "+l[g].shm);
				System.out.print("\n������� �� ������� - "+l[g].sal);
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
		
		System.out.print("���� - ");
		int d=in.nextInt();
		System.out.print("����� - ");
		int m=in.nextInt();
		System.out.print("�� - ");
		int yr=in.nextInt();
		LocalDate dd=LocalDate.of(yr, m, d);
		 System.out.print("���� - ");
		 d=in.nextInt();
		 System.out.print("����� - ");
		 m=in.nextInt();
		 System.out.print("�� - ");
		 yr=in.nextInt();
		LocalDate dd2=LocalDate.of(yr, m, d);
		for(int k=0;k<l.length;k++)
		{
			if(l[k].date.isAfter(dd)&&l[k].date.isBefore(dd2))
			{
			  	System.out.print("\nID ������� - "+l[k].rah );
				System.out.print("\t������� - "+l[k].owner);
				System.out.print("\n���� ������������� ��������� -"+ l[k].sbp);

		  }
			
		}
		
	}

}
