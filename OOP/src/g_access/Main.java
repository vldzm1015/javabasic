package g_access;

import g_access.sub.Access;

public class Main {
	public static void main(String[] args) {
		Access me = new Access();
		//me.a = "프라이빗변경";
		me.b = "퍼블릭변경";
		//me.c = "디폴트변경";
		//me.d = "프로택티드 변경";
		me.output();

	}
}

