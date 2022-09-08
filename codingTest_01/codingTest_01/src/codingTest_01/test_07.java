package codingTest_01;

import java.util.Random;
import java.util.Scanner;

public class test_07 {

	public static void main(String[] args) {
		
		System.out.println("[로또 당첨 프로그램]");
		System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
		
		//로또 구매
		Scanner scan = new Scanner(System.in);
		int scanCount = scan.nextInt();
		scan.close();
		
		//로또 생성
		for(int j = 0; j < scanCount; j++) {
			String[] lottoArray = new String[6];
			for(int i = 0; i < 6;) {
				Random random = new Random();
				int block = random.nextInt(45);
				if(block == 0) continue;
				String blockNumber = String.format("%02d", block); 
				lottoArray[i] = blockNumber;
				i++;
			}
			System.out.print("A" + "   ");
			for(int i = 0; i < 6; i++) {
				if(i == 5) System.out.println(lottoArray[i]);
				else System.out.print(lottoArray[i] + ",");
			}
		}
		
		
		//로또 발표
		System.out.println();
		System.out.println("[로또 발표]");
		String[] lottoResult = new String[6];
		for(int i = 0; i < 6;) {
			Random random = new Random();
			int blockResult = random.nextInt(45);
			if(blockResult == 0) continue;
			String blockResultNumber = String.format("%02d", blockResult); 
			lottoResult[i] = blockResultNumber;
			i++;
		}
		System.out.print(" " + "   ");
		for(int i = 0; i < 6; i++) {
			if(i == 5) System.out.println(lottoResult[i]);
			else System.out.print(lottoResult[i] + ",");
			
		}
		
		//일치 여부 확인
		
		

		
		
		
		//내 로또 결과
		System.out.println();
		System.out.println("[내 로또 결과]");
		for(int j = 0; j < scanCount; j++) {
			String[] lottoArray = new String[6];
			for(int i = 0; i < 6;) {
				Random random = new Random();
				int block = random.nextInt(45);
				if(block == 0) continue;
				String blockNumber = String.format("%02d", block); 
				lottoArray[i] = blockNumber;
				i++;
			}
			System.out.print("A" + "   ");
			for(int i = 0; i < 6; i++) {
				String matchCount = null;
				if(i < 5) System.out.print(lottoArray[i] + ",");
				else if(i == 5) System.out.println(lottoArray[i] + " => " + matchCount + "개 일치");
				else System.out.print(lottoArray[i] + ",");
			}
		}
		
		

	}

}
