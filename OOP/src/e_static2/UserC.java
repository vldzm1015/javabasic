package e_static2;

public class UserC {
	DBConnect con;

	public UserC (){
		con = DBConnect.getInstance();

	}

	public void use(){
		System.out.println("디비 작업중");
	}
}