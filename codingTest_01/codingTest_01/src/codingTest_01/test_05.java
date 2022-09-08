package codingTest_01;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class test_05 {

	private static int dayDivision;

	public static void main(String[] args) {
		System.out.println("[달력 출력 프로그램]");
		
		System.out.print("달력의 년도를 입력해 주세요.(yyyy): ");
		Scanner yearScan = new Scanner(System.in);
		int year = yearScan.nextInt();
		
		System.out.print("달력의 월을 입력해 주세요.(mm): ");
		Scanner monthScan = new Scanner(System.in);
		int month = monthScan.nextInt();
		
		String.valueOf(month);
		String Title = "[" + year + "년 " + String.format("%02d", month) + "월]";

		System.out.println();
		System.out.println();
		System.out.println(Title);
		System.out.println("일   월   화   수   목   금   토");

		int lastDate = 30;		
		int[] dateList = new int[lastDate];
		
		for(int i = 0; i < dateList.length-1; i++) {
			dateList[i] = i + 1;
		}		
		
		String yearText = String.valueOf(year);
		String monthText = String.valueOf(month).format("%02d", month);
		String daySearchText = yearText + "-" + monthText + "-" + "01";
		DayOfWeek dayOfWeek = LocalDate.parse(daySearchText).getDayOfWeek();
		
		System.out.println(dayOfWeek);
		
		System.out.println("  ");
		for(int i = 0; i < dateList.length-1; i++) {
			switch (dayOfWeek) {
			case SUNDAY:
				if(dateList[i] < 7) {
					for(int j = 0; j < 0; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 7; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				else if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
				
			case MONDAY:
				if(dateList[i] < 6) {
					for(int j = 0; j < 1; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 6; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
				
			case TUESDAY:
				if(dateList[i] < 5) {
					for(int j = 0; j < 2; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 5; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
				
			case WEDNESDAY:
				if(dateList[i] < 4) {
					for(int j = 0; j < 3; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 4; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
				
			case THURSDAY:
				if(dateList[i] < 3) {
					for(int j = 0; j < 4; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 3; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
				
			case FRIDAY:
				if(dateList[i] < 2) {
					for(int j = 0; j < 5; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 2; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
				
			case SATURDAY:
				if(dateList[i] < 1) {
					for(int j = 0; j < 6; j++) {
						System.out.print("  ");	
					}
					for(int j = 0; j < 1; j++) {
						System.out.print(dateList[j]+"  ");	
					}
				}
				if(dateList[i] % 7 == 0) {				
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.println(dateList[i]+"  ");
				}else {
					String.valueOf(dateList[i]);
					String.format("%02d", dateList[i]);
					System.out.print(dateList[i]+"  ");
				}
				break;
			}
		}	
		
		
		yearScan.close();
		monthScan.close();
		
	}
}

