package database;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.dbclass;

public class payroll_dbclass {
	
public void Insert(String emp_name,String post,String date_of_joining, float rate_per_day,float rate_per_overtime_hour)
	
	{
		
		
		 String insert_query;
		  insert_query="INSERT INTO `payroll`(`Employee_name`,`Post`,`Days`,`Overtime_hours`,`Rate_per_day`,`Rate_per_overtime_hour`,`Salary`,`Date_of_Joining`) VALUES('"+emp_name+"','"+post+"','"+0+"','"+0.0+"','"+rate_per_day+"','"+rate_per_overtime_hour+"','"+0+"','"+date_of_joining+"')";
		dbclass obj=new dbclass();
		obj.insert(insert_query);
		
		
	}

   public ResultSet update_field(int id) throws SQLException {
	String query = "SELECT * FROM `payroll` WHERE Employee_id='"
			+ id + "'";
	dbclass obj = new dbclass();
	ResultSet rs = obj.select(query);
	return rs;
   }
   
   public void Delete (int id, String name)
   {
	  String query="DELETE FROM `payroll` WHERE Employee_id='"+ id +"'";
	  dbclass obj = new dbclass();
	  obj.insert(query);
   }
   public void Update(int emp_id, String emp_name,String post, int days, float hours,float rate_per_day,float rate_per_overtime_hour,float salary,String date_of_joining) {
		
		String update_query;
		update_query = "UPDATE `payroll` SET `Employee_name`= '"
				+ emp_name + "' ,`Post`='" + post + "',`Days`='" +days
				+ "',`Overtime_hours`='" + hours + "',`Rate_per_day`='"+rate_per_day+"',`Rate_per_overtime_hour`='"+rate_per_overtime_hour+"',`Salary`='"+salary+"',`Date_of_joining`='"+date_of_joining+"' WHERE `Employee_id`='" + emp_id
				+ "'";
		System.out.println(salary);
		dbclass obj = new dbclass();
		obj.insert(update_query);
	}
   
   public ResultSet Report() throws SQLException {
		String report_query = "SELECT * FROM `payroll`";
		dbclass obj = new dbclass();
		ResultSet rs = obj.select(report_query);
		
		return rs;
	}
   
  

}
