package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserBasicDAO {

	public List<User> findUser(int userId) throws SQLException{
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user_basic where UserBasic_id = '" 
				+ userId + "'";
		Connection conn = DBUtil.getConnection();
		Statement st = conn.createStatement();
		ResultSet rss = st.executeQuery(sql);
		while(rss.next()){
			User user = new User();
			user.setUserName(rss.getString(2));
			user.setPassword(rss.getString(3));
			userList.add(user);
		}
		DBUtil.closeConnection(conn, st, rss);
		return userList;
	}
}
