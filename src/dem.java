import java.sql.*;
public class dem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//140.127.74.210
		//140.127.74.226
		try {
			Connection db = DriverManager.getConnection("jdbc:mariadb://140.127.74.210/410477013","410477013","e853w");
			Statement state = db.createStatement();
			PreparedStatement pState = db.prepareStatement(null);
			//  = db.prepareStatement(null);
			int i = state.executeUpdate("create table actor"
					+ "(p_id int(11),"
					+ "name varchar(255),"
					+ "birthday date,"
					+ "mv_id int(11),"
					+ "primary key (p_id))");
			System.out.println("i="+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
