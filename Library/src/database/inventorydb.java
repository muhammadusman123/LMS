package database;
import java.sql.ResultSet;
public class inventorydb {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public ResultSet report() {
		dbclass obj = new dbclass();
		ResultSet rs = obj.select("SELECT * FROM `bookinventory`");
		return rs;
	}
}
