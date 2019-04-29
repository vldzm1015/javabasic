package e_static2;

public class DBConnect {

	static DBConnect db;

	private DBConnect(){
		System.out.println("실제로 디비에 연결을 얻어옴");
	}

	public static DBConnect getInstance() {

		if(db==null)db = new DBConnect();
		return db;
	}
}

//public class DBConnect {
//
//	private DBConnect(){
//		System.out.println("실제로 디비에 연결을 얻어옴");
//	}
//
//} 