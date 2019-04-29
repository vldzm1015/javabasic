package e_static2;

public class UserB {
	DBConnect con;

	public UserB (){
		con = DBConnect.getInstance();
	}

	public void use(){
		System.out.println("디비 작업중");
	}
}