package testData;

import data.DAOException;
import data.FactoryDAO;
import data.MemberDAO;
import model.Member;

public class testDb {

	public static void main(String[] args) {
		
		MemberDAO mDAO = FactoryDAO.getMemberDAO();
		
		Member m = new Member("sun","wukong",5);
		
		try {
			mDAO.insertMember(m);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
