package e_static답안;


import java.util.*;

public class GradeTest {

public static void main(String[] args) {

// 사용자가 처리하고 싶은 점수의 개수 입력
Scanner input = new Scanner (System.in);
System.out.println("처리할 점수의 개수를 입력하세요");
int gnum = input.nextInt();
int[] score = new int [gnum];

// 점수 입력하여 score배열에 저장
for (int i=0; i<gnum; i++) {
System.out.println("점수를 입력하세요");
score[i]= input.nextInt();
}

// score 배열을 GradeExpr 클래스로 보낸다
GradeExpr result = new GradeExpr(score);


// [PRINT]
System.out.print("입력한 점수: ");
// 향상된 for문은 추출할때 속도가 더욱 빠르다
// 집합을 응용하고 싶을시 적합하다
for (int arr:score) {
System.out.print(arr+"/");
}
System.out.println();
System.out.println("총점: "+result.calTotal());
System.out.println("평균: "+result.calAverage());
System.out.println("죄고 점수: "+result.getGoodScore());
System.out.println("죄저 점수: "+result.getBadScore());
}
}
