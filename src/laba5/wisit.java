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

public class wisit extends site implements Serializable, inter_site {

	public static Map<Integer, wisit>list=new HashMap<Integer,wisit>();
	LocalDate date;
	int k_host, k_stor;
	public wisit() {};
public static void start()
	{
		try(ObjectInputStream oos=new ObjectInputStream(new FileInputStream("C:\\Users\\Admin\\Desktop\\file4.txt"))) 
		{
			list=(HashMap<Integer,wisit>)oos.readObject();
		}
		catch(Exception ex) {System.out.print(ex.getMessage());}
	}
static void save() 
	{
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\Desktop\\file4.txt"))) 
		{
		oos.writeObject(list);
	}
	catch(Exception ex) {}
	}
	@Override
	public void add() {
		Scanner in=new Scanner(System.in);
		wisit w=new wisit();
		System.out.print("ID візиту - ");
		int id=in.nextInt();
		int act=1;
		for(Map.Entry<Integer ,wisit> entry: list.entrySet()) {
			  int key = entry.getKey();
			  wisit value = entry.getValue();
			  if(key==id)
			  {
				  System.out.println("ID візиту існує. редагувати?\n1 - якщо так");
				  act=in.nextInt();
			  }
			  }
		if(act==1) 
		{
		System.out.println("Назва сайту - ");
		in.nextLine();
		w.n_site=in.nextLine();
		System.out.println("URL - ");
		w.url=in.nextLine();
		System.out.print("День візиту - ");
		int d=in.nextInt();
		System.out.print("Місяць візиту - ");
		int m=in.nextInt();
		System.out.print("Рік візиту - ");
		int y=in.nextInt();
		w.date=LocalDate.of(y,m,d);
		System.out.print("Кількість унікальних хостів - ");
		w.k_host=in.nextInt();
		System.out.print("Кількість завантажених сторінок - ");
		w.k_stor=in.nextInt();
		list.put(id,w);	
		save();}
		
	}

	@Override
	public void del() {
		Scanner in= new Scanner(System.in);
		System.out.print("ID візиту - ");
		int i=in.nextInt();
		list.remove(i);
		save();
	}

	@Override
	public void show() {
		for(Map.Entry<Integer ,wisit> entry: list.entrySet()) {
			  int key = entry.getKey();
			  wisit value = entry.getValue();
			  	System.out.print("\nID візиту - "+key);
				System.out.print("\tНазва сайту - "+value.n_site);
				System.out.print("\nURL - "+value.url);
				System.out.print("\tДень візиту - "+value.date);
				System.out.print("\nКількість унікальних хостів - "+value.k_host);
				System.out.print("\t\tКількість завантажених сторінок - "+value.k_stor);
			}
	}
	public void s_k_h() {
		Scanner in=new Scanner(System.in);
		int s_h=0, s_d=0;
		System.out.print("Bкажіть період\nдень - ");
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
		for(Map.Entry<Integer ,wisit> entry: list.entrySet()) {
			  int key = entry.getKey();
			  wisit value = entry.getValue();
			  if(value.date.isAfter(dd)&&value.date.isBefore(dd2))
				{
				  s_h=s_h+ value.k_host;
				  s_d++;
				}
				}
		if(s_d>0)
		{
			int s=s_h/s_d;
			System.out.print("Середня кількість хостів в день за вказаний період - "+s);
		}
		else
			System.out.print("За вказаний період значення відсутні");
		
	}
	
	public void max() {
		int y=0;
		Scanner in=new Scanner(System.in);
		wisit [] l=new wisit[list.size()];
		for(Map.Entry<Integer ,wisit> entry: list.entrySet()) {
			  int key = entry.getKey();
			  wisit v = entry.getValue();
			  l[y]=v;
			  y++;
			}
		for(int r = l.length-1 ; r > 0 ; r--){
	        for(int j = 0 ; j < r ; j++){
	            
	            if( l[j].k_stor < l[j+1].k_stor ){
	                wisit tmp = l[j];
	                l[j] = l[j+1];
	                l[j+1] = tmp;
	            }
	        }
	    }
		for(int k=0;k<3;k++)
		{
			System.out.print("\nДень візиту - "+l[k].date);
			System.out.print("\tКількість завантажених сторінок - "+l[k].k_stor+"\n");
		  }
			
		}
	public void k_d() {
		Scanner in= new Scanner(System.in);
		int s=0;		
		System.out.print("Введіт значення - ");
		float i=in.nextFloat();
		for(Map.Entry<Integer ,wisit> entry: list.entrySet()) {
			  int key = entry.getKey();
			  wisit v = entry.getValue();
			  double d=v.k_host;
			  double o=v.k_stor;
			  double k=d/o;
			  if(i<k)
				  s++;
			}
		System.out.print("Кількість днів, коли співвідношення хостів до сторінок перевищує задане значення - "+s);
	}
}
