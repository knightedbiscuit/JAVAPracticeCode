package data;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Member;

public interface MemberDAO {

	public void insertMember(Member m) throws DAOException;
	
	public void updateMember(Member m) throws DAOException;
	
	public void removeMember(Member m) throws DAOException;
	
	public String listMember(int membID) throws DAOException;
	
	public ArrayList<Member> listAllMember() throws DAOException;
	
	
}
