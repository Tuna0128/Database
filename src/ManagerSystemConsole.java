import java.sql.SQLException;
import java.util.Scanner;

public class ServerConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		Scanner inputScanner = new Scanner(System.in);
		Boolean result = true;
		try {
			//server.addMovie("Wonder Woman", "Action", 2017, 87, "DC Film", "http://www.truemovie.com/2016Poster/wonder_woman_ver2.jpg");
			System.out.println(result);
			//inputScanner.next();
			int i = server.getDownloads(0);
			//server.updateMovie(0, null, null, -1, 89, null, null);
			//inputScanner.next();
			//server.removeMovie(0);
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
