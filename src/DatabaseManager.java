import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Server {
	
	Connection db;
	Statement state;
	PreparedStatement pState;
	
	Server(){
		init();
	}
	
	private void init(){
		try {
			db = DriverManager.getConnection("jdbc:mariadb://140.127.74.210/410477013","410477013","e853w");
			state = db.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addMovie(String title, String genres, int year, int price, String company, String url) throws SQLException {
		int mv_id = 0;
		pState = db.prepareStatement("INSERT INTO `movie` "
				+ "(`mv_id`, `title`, `genres`, `released_year`, `price`, `company`, `url`) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)");
		pState.setInt(1, mv_id);
		pState.setString(2, title);
		pState.setString(3, genres);
		pState.setInt(4, year);
		pState.setInt(5, price);
		pState.setString(6, company);
		pState.setString(7, url);
		pState.execute();
	}
	
	public void updateMovie(int mv_id, String title, String genres, int year, int price, String company, String url) throws SQLException {
		ResultSet result = state.executeQuery("SELECT * FROM `movie` WHERE `mv_id` = 0 ");
		result.next();
		if (mv_id == -1)
			mv_id = result.getInt("mv_id");
		if (title == null)
			title = result.getString("title");
		if (genres == null)
			genres = result.getString("genres");
		if (year == -1)
			year = result.getInt("released_year");
		if (price == -1)
			price = result.getInt("price");
		if (company == null)
			company = result.getString("company");
		if (url == null)
			url = result.getString("url");
			
		pState = db.prepareStatement("UPDATE `movie` "
				+ "SET `title` = ?, `genres` = ?, `released_year` = ?, `price` = ?, `company` = ?, `url` = ? "
				+ "WHERE `movie`.`mv_id` = ? ");
		pState.setString(1, title);
		pState.setString(2, genres);
		pState.setInt(3, year);
		pState.setInt(4, price);
		pState.setString(5, company);
		pState.setString(6, url);
		pState.setInt(7, mv_id);
		pState.execute();
	}
	
	public void removeMovie(int mv_id) throws SQLException {
		pState = db.prepareStatement("DELETE FROM `movie` "
				+ "WHERE mv_id = ?");
		pState.setInt(1, mv_id);
		pState.execute();
	}
	
	public int getDownloads(int mv_id) throws SQLException {
		pState = db.prepareStatement("SELECT COUNT(`b_id`) "
				+ "FROM `bill` natural join `movie` "
				+ "WHERE `mv_id` = ? ");
		pState.setInt(1, mv_id);
		ResultSet result = pState.executeQuery();
		result.next();
		int i = result.getInt(1);
		return i;
	}
	
	
}
