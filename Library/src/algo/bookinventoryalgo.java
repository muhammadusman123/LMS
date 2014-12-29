package algo;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.dbclass;
import database.bookinventory;
import database.bookinventory;
public class bookinventoryalgo {
	String a;
	String s;
	public bookinventoryalgo() {
	}
	public ResultSet queryrep() {
		bookinventory obj = new bookinventory();
		ResultSet rs = obj.queryrep();
		return rs;
	}
	public ResultSet querryupdatea(String s) throws SQLException {
		bookinventory obj = new bookinventory();
		ResultSet rs = obj.querryupdatea(s);
		return rs;
	}
	public void querryupdateb(String upc, int total, int issued, int returned,
			int remaining, int discarded) {
		bookinventory obj = new bookinventory();
		obj.querryupdateb(upc, total, issued, returned, remaining, discarded);
	}
	public void querygen(String upc, int total, int issued, int returned,
			int remaining, int discarded) {
		bookinventory dbclassobj = new bookinventory();
		dbclassobj.querygen(upc, total, issued, returned, remaining, discarded);
	}
}
