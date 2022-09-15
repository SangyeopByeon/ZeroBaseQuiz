package codingTest_01;

import java.util.Random;
import java.util.Scanner;

public class test_07 {

	public static void main(String[] args) {

		//0. 구매 수량 입력 틀
		System.out.println("[로또 당첨 프로그램]");
		System.out.println();
		System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");

		// 1. 구매 수량입력
		Scanner scan = new Scanner(System.in);
		int scanCount = scan.nextInt();
		scan.close();

		// 2. 로또 발행 전 출력 틀 제작
		String[] lottoTitle = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		String[][] MyLotto = new String[scanCount][6];

		// 3. 로또 발행
		for (int i = 0; i < scanCount; i++) {
			// 3-(1) 로또 번호 제작
			for (int j = 1; j < 7; ) {
				Random random = new Random();
				int emSpaceInt = random.nextInt(45);
				String emSpace = String.format("%02d", emSpaceInt);
				if (emSpace.equals("0")) continue;
				MyLotto[i][j - 1] = emSpace;
				j++;
			}
			// 3-(2) 로또 순서 알파벳 출력
			System.out.print(lottoTitle[i] + "\t");
			// 3-(3) 로또 번호 출력
			for (int j = 0; j < 6; j++) {
				if (j == 5) System.out.println(MyLotto[i][j]);
				else System.out.print(MyLotto[i][j] + ",");
			}
		}

		// 4. 당첨번호 출력 틀 제작
		String[] resultLotto = new String[6];

		// 5. 당첨번호 제작
		for (int i = 0; i < 6; ) {
			Random random = new Random();
			int emSpaceInt = random.nextInt(45);
			String emSpace = String.format("%02d", emSpaceInt);
			if (emSpace.equals("0")) continue;
			resultLotto[i] = emSpace;
			i++;
		}
		// 6. 당첨번호 출력
		System.out.println();
		System.out.println("[로또 발표]");
		System.out.print("    ");
		for (int i = 0; i < 6; i++) {
			System.out.print(resultLotto[i]);
			if(i < 5) System.out.print(",");
			else break;
		}

		// 7. 당첨결과 틀 제작(일치 개수)
		int[] resultCount = new int[scanCount];
		int resultCountEnum = 0;

		// 8. 당첨번호 일치 개수 반환
		for(int i=0; i<scanCount; i++){		// <한줄 : 한줄> 확인
			resultCountEnum = 0;
			for(int j=0; j<6; j++){ 		// <한칸 : 한줄> 확인
				if(MyLotto[i][j].equals(resultLotto[j])){
					resultCountEnum += 1;
				}
			}
			resultCount[i] = resultCountEnum;
		}

		// 9. 당첨결과 출력
		System.out.println();
		System.out.println();
		System.out.println("[내 로또 결과]");
		for (int i = 0; i < scanCount; i++) {
			System.out.print(lottoTitle[i] + "   ");
			for (int j = 0; j < 6; j++) {
				if (j == 5) System.out.print(MyLotto[i][j]);
				else System.out.print(MyLotto[i][j] + ",");
			}
			System.out.println(" => " + resultCount[i] + "개 일치");
		}
	}
}