package codingTest_01;

import java.time.LocalDate;
import java.util.Scanner;

public class test_05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("[달력 출력 프로그램]");
		System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
		int year = scanner.nextInt();
		System.out.print("달력의 월을 입력해 주세요.(mm): ");
		int month = scanner.nextInt();

		String Title = "[" + year + "년 " + String.format("%02d", month) + "월]";
		String dayTitle = "일\t월\t화\t수\t목\t금\t토";

		System.out.println();
		System.out.println();
		System.out.println(Title);
		System.out.println(dayTitle);

		LocalDate date = LocalDate.of(year,month,1);
		int dayNumber = date.getDayOfWeek().getValue();

		for(int i=0; i < dayNumber; i++){
			System.out.print("\t");
		}

		for(int i = 1; i <= date.lengthOfMonth(); i++){
			String day = String.format("%02d", i);
			System.out.print(day);
			System.out.print("\t");
			dayNumber++;

			if(dayNumber % 7 == 0) {
				System.out.println();
			}
		}
	}
}

