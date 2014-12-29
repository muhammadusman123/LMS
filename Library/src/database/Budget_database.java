package database;

import gui.Budget.budgetinsertion;
import gui.Budget.budgetupdate2;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author Naveed
 *
 */


public class Budget_database {

	/**
	 * 
	 * @param s
	 * @param framea
	 */
public void Insert_frame(int s, gui.Budget.budgetinsertion framea)
{
	database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "INSERT INTO budget(Year,Issue_Date,Aspected_Amount,Requested_Amount,Issued_Amount,Semester_Type,CS,EE,BBA,HR,FurnitureEquipment,Bill)      VALUES ('"+framea.year+"','"+framea.sdate+"','"+framea.asp+"','"+framea.req+"','"+framea.issue+"','"+framea.type+"','"+framea.CS+"','"+framea.EE+"','"+framea.BBA+"','"+framea.HR+"','"+framea.equip+"','"+framea.bill+"')";
	//String ss = "DELETE FROM `budget` WHERE ID = 2";
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
	ResultSet rs = obj.select("SELECT * FROM `budget`");
	

	return rs;




}
/**
 * 
 * @return
 */
public ResultSet selects()
{
	database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "Select * from budget";
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
public void Update(int s, gui.Budget.budgetupdate2 framea)
{
	
	
	
	database.dbclass naveed123=new database.dbclass();//passing variable
	//System.out.println("algo started");
	String ss = ("UPDATE `budget` SET `FurnitureEquipment`='"+framea.equip+"',`Bill`='"+framea.bill+"',`Year`='"+framea.year+"',`Issue_Date`='"+framea.sdate+"',`Aspected_Amount`='"+framea.asp+"',`Requested_Amount`='"+framea.req+"',`Issued_Amount`='"+framea.issue_amount+"',`Semester_Type`='"+framea.type+"',`CS`='"+framea.CS+"',`EE`='"+framea.EE+"',`BBA`='"+framea.BBA+"',`HR`='"+framea.HR+"' WHERE `ID`='"+framea.id+"'");      
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
	ResultSet rs = obj.select("SELECT * FROM `budget` WHERE ID='"+s+"'");
	
	
	System.out.println("querycompleted");
	
	return rs;
	
	
	
	
}
/**
 * 
 * @return
 * @throws SQLException
 */
public ResultSet get_year1() throws SQLException
{
	
	
	
	dbclass obj=new dbclass();	
	System.out.println("query started");
	ResultSet rs = obj.select("SELECT Issued_Amount FROM `budget` WHERE Year=(SELECT MAX(Year) From `budget`)");
	
	
	System.out.println("querycompleted");
	
	return rs;
	
	
	
	
}
/**
 * 
 * @return
 * @throws SQLException
 */
public ResultSet get_year2() throws SQLException
{
	
	
	
	dbclass obj=new dbclass();	
	System.out.println("query started");
	ResultSet rs = obj.select("SELECT Issued_Amount FROM `budget` WHERE Year=(SELECT (MAX(Year)-1) From `budget`)");
	
	
	System.out.println("querycompleted");
	
	return rs;
	
	
	
	
}
/**
 * 
 * @return
 * @throws SQLException
 */
public ResultSet get_year3() throws SQLException
{
	
	
	
	dbclass obj=new dbclass();	
	System.out.println("query started");
	ResultSet rs = obj.select("SELECT Issued_Amount FROM `budget` WHERE Year=(SELECT (MAX(Year)-2) From `budget`)");
	
	
	System.out.println("querycompleted");
	
	return rs;
	
	
	
	
}
}
