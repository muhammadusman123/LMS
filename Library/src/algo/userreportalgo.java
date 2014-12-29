package algo;

import gui.Payroll.Display;
import gui.UserReport.userreportupdate2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import database.dbclass;
import database.payroll_dbclass;
import database.userreport_dbclass;

public class userreportalgo {

	public boolean Insert(String st_name,String rollno,String section,String membership_date) throws SQLException
	
	{
		ResultSet rs;
		String msg;
		boolean flag,flag2 = false;
		int irollno;
		if(st_name.isEmpty())
		{
			msg="Student name field is empty.";
			Display d_obj = new Display(msg,0);
			d_obj.setVisible(true);
			return false;
		}
		else if(rollno.isEmpty())
		{
			msg="University id field is empty.";
			Display d_obj = new Display(msg,0);
			d_obj.setVisible(true);
			return false;
		}
		
		else if(membership_date.isEmpty())
		{
			msg="Membership date field is empty.";
			Display d_obj = new Display(msg,0);
			d_obj.setVisible(true);
			return false;
		}
		else
		{
			flag=isInteger(rollno);
			if(flag)
			{
				irollno=Integer.parseInt(rollno);
				
				userreport_dbclass obj=new userreport_dbclass();
				rs=obj.Report2();
				while(rs.next())
				{
					if(irollno==rs.getInt("studentid"))
					{
						flag2=true;
						break;
					}
					else
					{
						flag2=false;
					}
				}
				
			    if(flag2)
			    {
				obj.Insert(st_name, irollno, section, membership_date);
				msg="Student has been added succesfully.";
				Display d_obj = new Display(msg,1);
				d_obj.setVisible(true);
				return true;
			    }
			    else
			    {
			    	msg="Student is not enrolled in University.";
					Display d_obj = new Display(msg,0);
					d_obj.setVisible(true);
					return false;
			    }
			}
			
			else
			{
				msg="University id entered must be integer.";
				Display d_obj = new Display(msg,0);
				d_obj.setVisible(true);
				return false;
			}
		}
		
	}

	public boolean Update(int st_id, String st_name, int irollno, String section,String membership_date) 
	{
		String msg;
		if(st_name.isEmpty())
		{
			msg="Student name field is empty.";
			Display d_obj = new Display(msg,0);
			d_obj.setVisible(true);
			return false;
		}
		else
		{	
			
			
		userreport_dbclass obj=new userreport_dbclass();
		obj.Update(st_id, st_name, irollno, section,membership_date);
		msg="Student data updated successfully"; ////////////////
			Display d_obj = new Display(msg,1);
			d_obj.setVisible(true);
			return true;
		}
	}

	public ResultSet Report() throws SQLException {
		userreport_dbclass obj=new userreport_dbclass();
		ResultSet rs=obj.Report();
		return rs;
	}

	public ResultSet update_field(int id) throws SQLException {
		userreport_dbclass obj=new userreport_dbclass();
		ResultSet rs=obj.update_field(id);
		return rs;
	}
	
	public void set_textfields_1 (userreportupdate2 obj,int id) throws SQLException //for user report updation
	{
		String c;
		ResultSet rs;
		userreportalgo alg=new userreportalgo();
		rs=alg.update_field(id);
		while(rs.next())
		{
		obj.textField.setText(rs.getString("Student_name"));
		obj.rollno=rs.getInt("Roll_No");
		//obj.textField_2.setText(rs.getString("Section"));
		obj.textField_4.setText(rs.getString("Membership_date"));
		}
	}
	
	public boolean Delete (String s_id, String name) throws SQLException
	   {
		   int id;
		   boolean flag,flag2,flag3=false ;
		   String msg;
		   if(s_id.isEmpty())
			{
				msg="Student id field is empty";
				Display d_obj = new Display(msg,0);
				d_obj.setVisible(true);
				return false;
			}
			else if(name.isEmpty())
			{
				msg="Student name field is empty";
				Display d_obj = new Display(msg,0);
				d_obj.setVisible(true);
				return false;
			}
		   
			else
			{
				flag3=isInteger(s_id);
				if(flag3)
				{
				id=Integer.parseInt(s_id);
			    flag=Search(id);
			   if(flag==true)
			   {
				  flag2=Search_name(id,name);
				  if(flag2==true)
				  {
				    msg="Student has been successfully deleted";
				    Display d_obj = new Display(msg,1);
				    d_obj.setVisible(true);
				    userreport_dbclass obj=new userreport_dbclass();
				    obj.Delete(id,name);
				    return true;
				  }
				  else
				  {
					  msg="Student id and name mismatched";
						Display d_obj = new Display(msg,0);
						d_obj.setVisible(true);
						return false;
				  }
			  }
			  else
			  {
				    msg="Student id not found ";
				 	Display d_obj = new Display(msg,0);
					d_obj.setVisible(true);
					return false;
			  }
				}
				else
				{
					    msg="Student id entered must be numerical  ";
					 	Display d_obj = new Display(msg,0);
						d_obj.setVisible(true);
						return false;
				}
	   }
	   }
	
	public Locale getLocale(String loc)
	{
		if(loc!=null && loc.length()>0)
		{
			return new Locale(loc);
		
		}
		else
		{
			return Locale.US;
		}
	}
	
	 public boolean Search (int id) throws SQLException 
	   {
		   int id2;
		   boolean flag=false;
		   ResultSet rs=Report();
		   while(rs.next())
		   {
			  id2 = rs.getInt("Student_id");
			  
			   if (id==id2)
			   {
				   flag=true;
				   break;
				   
			   }
			   else
			   {
				   flag=false;
			   }
		   }
		   return flag;
	   }
	 
	 public boolean Search_name (int id,String name) throws SQLException
	 {
		 int id2;
		 String name2;
		   boolean flag=false;
		   ResultSet rs=Report();
		   while(rs.next())
		   {
			  id2 = rs.getInt("Student_id");
			  
			   if (id==id2)
			   {
				   break;
			   }
			   else
			   {
				   
			   }
			   
		   }
		   name2=rs.getString("Student_name");
		   if(name.matches(name2))
		   {
			   flag=true;
		   }
		   else
		   {
			   flag=false;
		   }
		   return flag;
	 }
	 public  boolean [] is_id_field_empty(String s_id,boolean [] flag) throws SQLException
	   {
		  
		   int id;
		   if(s_id.isEmpty())
		   {
			   flag[0]=true;
		   }
		   else
		   {
			   flag[2]=isInteger(s_id);
			   if(flag[2])
			   {
			   flag[0]=false;
			   id=Integer.parseInt(s_id);
			   flag[1]=Search(id);
			   }
			   else
			   {
				   flag[2]=false;
			   }
		   }
		   return flag;
	   }
	 
	 public static boolean isInteger(String str) {
		    try {
		        Integer.parseInt(str);
		        return true;
		    } catch (NumberFormatException nfe) {
		        return false;
		    }
	}
}
