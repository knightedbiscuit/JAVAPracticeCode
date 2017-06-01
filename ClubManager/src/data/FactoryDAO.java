package data;

public class FactoryDAO {

	public static MemberDAO getMemberDAO()
	{
		return new data.MemberDAOImpl();
	}
	

}
