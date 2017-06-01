package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import java.sql.Statement;

import model.Member;

public class MemberDAOImpl implements MemberDAO {

	private static final String SQL = "SELECT * FROM " + dbConstants.DB_NAME + "." + dbConstants.TABLE_MEMBER;
	private static final String INSERT_MEMBER = "INSERT INTO "+dbConstants.DB_NAME + "." + dbConstants.TABLE_MEMBER+" "
	+"(MemberID, Surname, FirstName, SecondName)"+" "+ "Values(?,?,?,?)";

	public Connection ConnectAttempt() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found.");
			e.printStackTrace();
		}

		// If Connection is first declared in try block, you
		// will be able to use the variable outside the block.
		Connection con = null;

		try {
			con = DriverManager.getConnection(dbConstants.DB_URL, dbConstants.USER_NAME, dbConstants.PASSWORD);
		} catch (SQLException e1) {
			System.out.println("Establish db connection failed.");
			e1.printStackTrace();
		}

		return con;
	}

	public ArrayList<Member> listAllMember() throws DAOException {

		ArrayList<Member> mList = new ArrayList<Member>();
		
		Connection conn = ConnectAttempt();
		
		try {

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(SQL);

			while (rs.next()) {
				Member m = new Member();
				m.setMemberNumber(rs.getInt("MemberID"));
				m.setSurname(rs.getString("Surname"));
				m.setFirstname(rs.getString("FirstName"));
				m.setSecondname(rs.getString("SecondName"));
				mList.add(m);
			}

			rs.close();
			statement.close();

		} catch (SQLException e) {
			System.out.println("Data retrieval failed.");
			e.printStackTrace();
		} finally {
			try {
				System.out.println("Closing connection.");
				conn.close();
			} catch (SQLException e) {
				throw new DAOException("Closing connections fails.");
			}

		}

		return mList;
	}

	public String listMember(int membID) throws DAOException {
		return null;
	}

	public void createMember(Member m) throws DAOException {
		Connection conn = ConnectAttempt();
		
		try {
			PreparedStatement ps = conn.prepareStatement(INSERT_MEMBER);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateMember(Member m) throws DAOException {

		
		

	}

	public void removeMember(Member m) throws DAOException {

	}

}
