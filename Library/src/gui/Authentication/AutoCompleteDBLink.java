package gui.Authentication;



public class AutoCompleteDBLink
{
String query = "";
AutoTextComplete ac = null;
java.sql.Connection connection = null;

public AutoCompleteDBLink(AutoTextComplete atc, String query, java.sql.Connection con) {
this.query = query;
ac = atc;
connection = con;
populate();
}
public void populate() {
try {
java.sql.Statement st = connection.createStatement();
java.sql.ResultSet rs = st.executeQuery(query);
java.util.ArrayList<String> al = new java.util.ArrayList<String>();
while(rs.next())
al.add(rs.getString(1));
ac.setItems(al);
} catch(Exception ex) {ex.printStackTrace();}
}
}
