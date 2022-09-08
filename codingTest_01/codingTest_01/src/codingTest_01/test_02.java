package codingTest_01;

import java.util.Scanner;

public class test_02 {

	public static void main(String[] args) {
		
		System.out.println("[캐시백 계산]");
		System.out.print("결제 금액을 입력해 주세요.(금액): ");
		Scanner scan = new Scanner(System.in);
		
		//결제금액 입력
		int pay = scan.nextInt();
		
		//결제 금액 10% 적립
		double rate = 0.1;
	
		//예상 캐시백 금액
		int cashback = (int)(pay * rate);
	
		//백원 단위 캐시백 반환
		cashback = cashback / 100;
		cashback = (int)Math.floor(cashback);
		cashback = cashback * 100;
		
		//캐시백 300원 넘을 수 없다
		if(cashback > 300) cashback = 300;
		
		System.out.println("결제 금액은 " + pay + "이고, 캐시백은 " + cashback +"원 입니다.");
		
		scan.close();
	}
}
