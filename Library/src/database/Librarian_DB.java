package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Librarian_DB {
	/**
	 * 
	 * @param s
	 * @param framea
	 */

public void Insert_frame(int s, gui.librarian_gui.Librarian_insert framea)
{
	database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "INSERT INTO librarian(Year,Semester_Type,Requested_Amount,total_of_salaries)      VALUES ('"+framea.year+"','"+framea.type+"','"+framea.ReqA+"','"+framea.total+"')";
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
	ResultSet rs = obj.select("SELECT * FROM `librarian`");
	

	return rs;




}
/**
 * 
 * @return
 */
public ResultSet selects()
{
	database.dbclass naveed123=new database.dbclass();//passing variable
	String ss = "Select * from librarian";
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
public void Update(int s, gui.librarian_gui.librarianupdate framea)////change
{
	
	
	
	database.dbclass naveed123=new database.dbclass();//passing variable
	System.out.println("algo started");
	//String ss = ("UPDATE `salary_budget` SET `Issue_Date`='"+framea.s+"',`Allocated`='"+framea.amount+"' WHERE `ID`='"+framea.id+"'");      

	String ss=("UPDATE `librarian` SET `Requested_Amount`='"+framea.req+"',`total_of_salaries`='"+framea.total+"' WHERE `ID`='"+framea.id+"'");
	
	System.out.println(framea.id);
	
	
	
	
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
	ResultSet rs = obj.select("SELECT * FROM `librarian` WHERE Year='"+s+"'");
	
	
	System.out.println("querycompleted");
	
	return rs;
	
	
	
	
}

}
