package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.dbclass;

/**
 * 
 * @author Naveed
 *
 */


public class Salary_budget {
/**
 * 
 * @param s
 * @param framea
 */
	
public void Insert_frame(int s, gui.Budget.Inset_Salary_budget framea)
{
	database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "INSERT INTO salary_budget(Year,Semester_Type,Issue_Date,Allocated,Spent,Current_Balance)      VALUES ('"+framea.yearr+"','"+framea.type+"','"+framea.sdate+"','"+framea.amount+"','"+framea.spent+"','"+framea.cur+"')";
	try {
		naveed123.insert(ss);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			


}
/**
 * 
 * @return
 * @throws SQLException
 */
public ResultSet select() throws SQLException
{


	dbclass obj=new dbclass();	
	ResultSet rs = obj.select("SELECT * FROM `salary_budget`");
	

	return rs;




}
/**
 * 
 * @return
 */
public ResultSet selects()
{
	database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "Select * from salary_budget";
	ResultSet rs=null;
	
	try {
		rs=naveed123.select(ss);
		return rs;
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;			


}
/**
 * 
 * @param s
 * @param framea
 */
public void Update(int s, gui.Budget.Update_Salary_Budget framea)////change
{
	
	
	
	database.dbclass naveed123=new database.dbclass();//passing variable
	//System.out.println("algo started");
	//String ss = ("UPDATE `salary_budget` SET `Issue_Date`='"+framea.s+"',`Allocated`='"+framea.amount+"' WHERE `ID`='"+framea.id+"'");      

	String ss=("UPDATE `salary_budget` SET `Year`='"+framea.yearr +"',`Semester_Type`='"+framea.type +"',`Issue_Date`='"+framea.sdate+"',`Allocated`='"+framea.amount+"',`Spent`='"+0+"',`Current_Balance`='"+framea.amount+"' WHERE `ID`='"+framea.id+"'");
	
	//System.out.println(framea.a);
	
	
	
	
	try {
		naveed123.insert(ss);
	//	System.out.println("algo ended");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}			



}
/**
 * 
 * @param s
 * @return
 * @throws SQLException
 */
public ResultSet querryupdatea(String s) throws SQLException
{
	
	
	
	dbclass obj=new dbclass();	
	System.out.println("query started");
	ResultSet rs = obj.select("SELECT * FROM `salary_budget` WHERE ID='"+s+"'");
	
	
	System.out.println("querycompleted");
	
	return rs;
	
	
	
	
}
}
