package algo;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Budget_database;
import database.dbclass;




/**
 * 
 * @author Naveed
 *
 */


public class budgetalgo {
	public static double y11;
	public static double y12;
	public static double y13;
	//public static void main(String[] args) {
	
	
		//Exponential_smoothing();
	
	
	//}
	
/**
 * 
 * @param s
 * @param framea
 */
	
public void Insert_frame(int s, gui.Budget.budgetinsertion framea)
{
	
	Budget_database budget=new Budget_database();
	
	
	int total2;
	String total=framea.issue;
	total2=	Integer.parseInt(total);
	
	double cs;
	double bba;
	double hr;
	double ee;
	double equip;
	double bill;
	cs=(total2)  * 0.20;
	bba=(total2) * 0.17;
	hr=(total2)  * 0.15;
	ee=(total2)  * 0.18;
	equip=(total2)  * 0.25;
	bill=(total2)  * 0.05;
framea.CS=Double.toString(cs);	
framea.BBA=Double.toString(bba);
framea.HR=Double.toString(hr);
framea.EE=Double.toString(ee);
framea.equip=Double.toString(equip);
framea.bill=Double.toString(bill);






	budget.Insert_frame(s, framea);

}
/**
 * 
 * @param year1=last year budget
 * @param year2=second last year budget
 * @param year3=third last year budget
 * @return
 */
public double exp_algo(int year1,int year2,int year3)
{
	int y1=100;
	int y2=200;
	int y3=300;
	double F1=100;
	double F2;
	double F3;

double F=0;
double alpha=0.3;

F2=F1+alpha*(y1-F1);
System.out.println(F2);



return F;
}
/**
 * 
 * @return
 * @throws SQLException
 */
public ResultSet select() throws SQLException
{

/*
	dbclass obj=new dbclass();	
	ResultSet rs = obj.select("SELECT * FROM `budget`");
	

	return rs;
*/
	Budget_database budget=new Budget_database();
	ResultSet rs=budget.select();

	
	return rs;


}
/**
 * 
 * @return
 */
public ResultSet selects()
{
	/*database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "Select * from budget";
	ResultSet rs=null;
	
	try {
		rs=naveed123.select(ss);
		return rs;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	
	Budget_database budget=new Budget_database();
	ResultSet rs=budget.selects();
	return rs;			


}
/**
 * 
 * @param s
 * @param framea
 */
public void Update(int s, gui.Budget.budgetupdate2 framea)
{
	
	


	Budget_database budget=new Budget_database();
	
	
	int total2;
	String total=framea.issue_amount;
	total2=	Integer.parseInt(total);
	
	double cs;
	double bba;
	double hr;
	double ee;
	double equip;
	double bill;
	cs=(total2)  * 0.20;
	bba=(total2) * 0.17;
	hr=(total2)  * 0.15;
	ee=(total2)  * 0.18;
	equip=(total2)  * 0.25;
	bill=(total2)  * 0.05;
framea.CS=Double.toString(cs);	
framea.BBA=Double.toString(bba);
framea.HR=Double.toString(hr);
framea.EE=Double.toString(ee);
framea.equip=Double.toString(equip);
framea.bill=Double.toString(bill);
	
	
	
	budget.Update(s, framea);
	
	
}

/**
 * 
 * @param s
 * @return
 * @throws SQLException
 */
public ResultSet querryupdatea(String s) throws SQLException
{
	
	
	/*
	dbclass obj=new dbclass();	
	System.out.println("query started");
	ResultSet rs = obj.select("SELECT * FROM `budget` WHERE ID='"+s+"'");
	
	
	System.out.println("querycompleted");
	
	
	*/
	

	Budget_database budget=new Budget_database();
	ResultSet rs =budget.querryupdatea(s);
	return rs;
	
	
	
	
}
/**
 * 
 * @return
 */


public static double Exponential_smoothing()
{
	

	String y1;
	String y2;
	String y3;
	
	
	ResultSet rs=null;
	database.Budget_database alg=new database.Budget_database();
	try {
		System.out.println(rs=alg.get_year1());
	//	
		
	
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		while(rs.next())
		{
			
			y3=rs.getString("Issued_Amount");
			System.out.println(y3);
			y13=Integer.parseInt(y3);
		
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	ResultSet rs2=null;
	database.Budget_database algo=new database.Budget_database();
	try {
		System.out.println(rs2=algo.get_year2());
	//	
		
	
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		while(rs2.next())
		{
			
			y2=rs2.getString("Issued_Amount");
			System.out.println(y2);
			y12=Integer.parseInt(y2);
		
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	ResultSet rs3=null;
	database.Budget_database algoo=new database.Budget_database();
	try {
		System.out.println(rs3=algoo.get_year3());
	//	
		
	
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		while(rs3.next())
		{
			
			y1=rs3.getString("Issued_Amount");
			System.out.println(y1);
			 y11=Integer.parseInt(y1);
		
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	
	
	
//	try {
	//	y1=rs.getString("Issued_Amount");
		//System.out.println(rs.getString("Issued_Amount"));
	//} catch (SQLException e) {
		// TODO Auto-generated catch block
	//	e.printStackTrace();
	//}
	
	
	
	
	System.out.println(y11);
double F=0;
double F1=y11;
double F2=0;
double F3;
double F4;
double alpha=0;

if(y11-y12>5000 && y11-y12<10000)
 {alpha=0.48;}
else if(y11-y12>10000)
{
	alpha=0.92;	
}
else
{
	alpha=0.38;
}

F2=F1+alpha*(y11-F1);
System.out.println(F2);

F3=F2+alpha*(y12-F2);
System.out.println(F3);

F4=F3+alpha*(y13-F3);
System.out.println(F4);

return F4;
	
	
}
}