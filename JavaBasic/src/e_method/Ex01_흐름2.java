package e_method;

public class Ex01_흐름2 {
    public static void main(String[] args) {
        System.out.println("메인 시작");
        Ex01_흐름2 ex = new Ex01_흐름2();   // 여기서 메소드를 잡아주고 시작하면 메소드 앞에 static을 빼도 된다!?
        ex.method();
        System.out.println("메인 끝");
    }

    void method() {
        System.out.println("method 시작");
    }
}