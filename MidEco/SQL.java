package MidEco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {

	String host = "jdbc:jtds:sqlserver://127.0.0.1:1521";
	String username = "michael";
	String password = "Labinnah1";

	public boolean connect() {
		boolean reachable = false;
		try {
			Connection con = DriverManager.getConnection(host, username, password);
			reachable = con.isValid(10);
			System.out.println("Connection: Yay!");
		} catch (SQLException err) {
			System.out.println(err.getMessage());
		}

		return reachable;
	}

}
