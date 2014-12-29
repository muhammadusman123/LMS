package algo;
import java.sql.ResultSet;
import database.inventorydb;
public class inventoryalgo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public ResultSet report() {
		inventorydb obj = new inventorydb();
		// obj.setVisible(true);
		ResultSet rs = obj.report();
		return rs;
	}
}
