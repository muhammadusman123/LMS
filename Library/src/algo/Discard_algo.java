package algo;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Budget_database;
import database.Discard_DB;
import database.Salary_budget;
import database.dbclass;
/**
 * 
 * @author Naveed
 *
 */
public class Discard_algo {

/*	public void Discard_frame(int s, gui.Discard_Book_gui.Insert_Discard framea)
	{
	Discard_DB alg=new Discard_DB();
	alg.Delete_frame(s, framea);
	}*/
	
	/**
	 * 
	 * @param s
	 * @param framea
	 */
	public void Insert_frame(int s, gui.Discard_Book_gui.Insert_Discard framea)
	{
	
		Discard_DB budget=new Discard_DB();
		budget.Insert_frame(s, framea);		


	}
	/**
	 * 
	 * @param s
	 * @param framea
	 */
	public void update(int s, gui.Discard_Book_gui.Update_Discard framea)
	{
				

		Discard_DB budget=new Discard_DB();
		budget.update(s, framea);	

	}
	
	
	/**
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	
	public ResultSet select() throws SQLException
	{


		Discard_DB budget=new Discard_DB();
		ResultSet rs=budget.select();

		
		return rs;




	}
	/**
	 * 
	 * @return
	 */
	public ResultSet selects()
	{
		Discard_DB budget=new Discard_DB();
		ResultSet rs=budget.selects();
		return rs;			


	}
	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public ResultSet querry(String s) throws SQLException
	{
		
		
		
		Discard_DB budget=new Discard_DB();
		ResultSet rs =budget.querry(s);
		return rs;
		
		
		
		
	}
	
	
}
