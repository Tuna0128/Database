import java.sql.SQLException;
import java.util.Scanner;

public class ManagerSystemConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatabaseManager manager = new DatabaseManager();
		Scanner inputScanner = new Scanner(System.in);
		Boolean result = true;
		try {
			manager.addMovie("Wonder Woman", "Action", 2017, 87, "DC Film", "http://www.truemovie.com/2016Poster/wonder_woman_ver2.jpg");
			System.out.println(result);
			//inputScanner.next();
			int i = manager.getDownloads(0);
			manager.updateMovie(0, null, null, -1, 89, null, null);
			//inputScanner.next();
			manager.removeMovie(0);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inputScanner.close();
	}

}
