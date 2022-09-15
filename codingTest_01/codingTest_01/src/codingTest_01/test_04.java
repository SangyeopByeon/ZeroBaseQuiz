package codingTest_01;

import java.util.Random;
import java.util.Scanner;

public class test_04 {

	public static void main(String[] args) {

		//정보 입력
		System.out.println("[주민등록번호 계산]");
		
		System.out.print("출생년도를 입력해 주세요.(yyyy): ");
		Scanner yearScan = new Scanner(System.in);
		int year = yearScan.nextInt();
		
		System.out.print("출생월을 입력해 주세요.(mm): ");
		Scanner monthScan = new Scanner(System.in);
		int month = monthScan.nextInt();

		System.out.print("출생일을 입력해 주세요.(dd): ");
		Scanner dayScan = new Scanner(System.in);
		int day = dayScan.nextInt();
		
		System.out.print("성별을 입력해 주세요.(m/f): ");
		Scanner genderScan = new Scanner(System.in);
		String gender = genderScan.next();
		
		//앞자리 문자열 정의
		String yearNumber = String.valueOf(year).substring(2);
		String monthNumber = String.format("%02d", month);
		String dayNumber = String.format("%02d", day);
		
		//뒷자리 문자열 정의
		String genderNumber = "0";
		if(gender.equals("m"))
			if(year < 2020) genderNumber = "1";
			else  genderNumber = "3";
		if(gender.equals("f"))
			if(year < 2020) genderNumber = "2";
			else  genderNumber = "4";
		
		Random random = new Random();
		int lastNumber = random.nextInt(999999);
		String last = String.format("%06d",lastNumber);

		// 앞자리, 뒷자리 각각 합치기
		String frontNumber = yearNumber + monthNumber + dayNumber;
		String backNumber = genderNumber + lastNumber;
		
		// 주민등록번호 형식 완성
		String residentRegistrationNumber = frontNumber + "-" + backNumber;
		
		//출력
		System.out.println(residentRegistrationNumber);
	}
}