package codingTest_01;

import java.util.Scanner;

public class test_03 {

	public static void main(String[] args) {
		
		System.out.println("[입장권 계산]");
		
		System.out.print("나이를 입력해 주세요.(숫자): ");
		Scanner ageScan = new Scanner(System.in);
		int age = ageScan.nextInt();
		
		System.out.print("입장시간을 입력해 주세요.(숫자입력): ");
		Scanner timeScan = new Scanner(System.in);
		int time = timeScan.nextInt();
		
		System.out.print("국가유공자 여부를 입력해 주세요.(y/n) ");
		Scanner patriotScan = new Scanner(System.in);
		String patriot = patriotScan.next();
		
		System.out.print("복지카드 여부를 입력해 주세요.(y/n) ");
		Scanner welfareScan = new Scanner(System.in);
		String welfare = welfareScan.next();
		
		//기본 입장료
		double fee = 10000;
		
		//무료 할인율
		double freeRate = 1;
		//특별 할인율
		double specialRate = 0.6;
		//일반 할인율
		double normalRate = 0.2;
		
		//무료입장료
		double freeFee = fee - (fee * freeRate);
		//특별할인 입장료
		double specialFee = fee - (fee * specialRate);
		//일반할인 입장료
		double normalFee = fee - (fee * normalRate);

		//할인 조건
		if(age < 3) fee = freeFee;
		else if(time > 17) fee = specialFee;
		else if(age < 13) fee = specialFee;
		else if(patriot.equals("y")) fee = normalFee;
		else if(welfare.equals("y")) fee = normalFee;
		
		System.out.println("입장료: " + (int)fee);
		
		ageScan.close();
		timeScan.close();
		patriotScan.close();
		welfareScan.close();
	}
}
