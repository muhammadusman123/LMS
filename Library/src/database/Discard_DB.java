package database;

import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Naveed
 *
 */
public class Discard_DB {
	
	/*public void Delete_frame(int s, gui.Discard_Book_gui.Insert_Discard framea)
	{
		database.dbclass naveed123=new database.dbclass();//passing variable
		String ss = "DELETE FROM `book1` WHERE ISBN = '"+framea.ISBN+"'";
		try {
			naveed123.insert(ss);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/**
	 * 
	 * @param s
	 * @param framea
	 */
	public void Insert_frame(int s, gui.Discard_Book_gui.Insert_Discard framea)
	{
		database.dbclass naveed123=new database.dbclass();//passing variable
		String ss = "INSERT INTO discard_book(IISBN,Discard_Date,Author_Name,Book_Title,Edition,Price,Purchase_Date,Reason)      VALUES ('"+framea.ISBN+"','"+framea.Discard_datee+"','"+framea.name+"','"+framea.book+"','"+framea.edit+"','"+framea.price+"','"+framea.purchase_date+"','"+framea.reason+"')";
		try {
			naveed123.insert(ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			


	}
	/**
	 * 
	 * @param s
	 * @param framea
	 */
	public void update(int s, gui.Discard_Book_gui.Update_Discard framea)
	{
		database.dbclass naveed123=new database.dbclass();//passing variable
		String ss = "DELETE FROM `discard_book` WHERE ID = '"+framea.id+"'";
		try {
			naveed123.insert(ss);
		} 
		catch (Exception e) {
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
		ResultSet rs = obj.select("SELECT * FROM `discard_book`");
		

		return rs;




	}
	/**
	 * 
	 * @return
	 */
	public ResultSet selects()
	{
		database.dbclass naveed123=new database.dbclass();//passing variable
		String ss = "Select * from discard_book";
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
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querry(String s) throws SQLException
	{
		
		
		
		dbclass obj=new dbclass();	
		System.out.println("query started");
		ResultSet rs = obj.select("SELECT * FROM `discard_book` WHERE ID='"+s+"'");
		System.out.println("helo");
		//System.out.println(rs.getString("Price"));
		
		
		System.out.println("querycompleted");
		
		return rs;
		
		
		
		
	}

	}
	
