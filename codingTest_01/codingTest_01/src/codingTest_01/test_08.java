package codingTest_01;

import java.util.Scanner;

public class test_08 {

	//필드 생성 (세율과 누진공제 계산에 각각 활용하기 위한 항목)
	//구간별 연봉 최대값 배열
	static long[] incomeSectionArray = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
	//구간별 세율 배열
	static int[] taxRateArray = {6, 15, 24, 35, 38, 40, 42,45};
	//구간별 누진공제액 배열
	static long[] deductionArray = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000,65400000};

	public static void main(String[] args) {
		System.out.println("[과세금액 계산 프로그램]");
		System.out.print("연소득을 입력해 주세요.:");
		Scanner scan = new Scanner(System.in);
		//연소득
		long inputIncome = scan.nextLong();
		scan.close();
		//세율에 의한 세금
		long taxByRate;
		taxByRate = rateSection(inputIncome);
		//누진공제 계산에 의한 세금
		long taxByDeduction;
		taxByDeduction = deductionSection(inputIncome);
		System.out.println();
		System.out.println("[세율에 의한 세금]:  　　　　" + String.format("%10d", taxByRate));
		System.out.println("[누진공제 계산에 의한 세금]: " + String.format("%10d", taxByDeduction));
	}

	//세율에 의한 세금 리턴 함수
	static long rateSection(long annualIncome) {
		//구간별 과세표준액 최대값 배열
		long[] sectionStandard = new long[incomeSectionArray.length];
		for(int i=0; i<incomeSectionArray.length; i++){
			sectionStandard[i] = incomeSectionArray[i];
			if (i>0) sectionStandard[i] = incomeSectionArray[i] - incomeSectionArray[i-1];
		}
		//구간별 세금 최대값 배열
		long[] taxMaxArray = new long[incomeSectionArray.length];
		for(int i=0; i<incomeSectionArray.length; i++){
			taxMaxArray[i] = sectionStandard[i] * taxRateArray[i] /100;
		}
		//구간별 최고세율 잔액 배열
		long[] lastIncomeArray = new long[incomeSectionArray.length + 1];
		for(int i=0; i<incomeSectionArray.length + 1; i++){
			lastIncomeArray[i] = annualIncome;
			if (i>0) lastIncomeArray[i] = annualIncome - incomeSectionArray[i-1];
		}
		//구간별 최고세율 잔액에 대한 세금 배열
		long[] LastTaxArray = new long[taxRateArray.length];
		for(int i=0; i<taxRateArray.length; i++){
			LastTaxArray[i] = lastIncomeArray[i] * taxRateArray[i] /100;
		}
		//세금 총액
		long totalTax = 0;
		//구간별 세율 계산
		for(int i=0; i<incomeSectionArray.length + 1; i++){
			if(annualIncome <= incomeSectionArray[i]){
				for(int j=0; j<i; j++) {
					System.out.println(String.format("%10d", sectionStandard[j]) + " * " + String.format("%2d", taxRateArray[j]) + "% = " + String.format("%10d", taxMaxArray[j]));
				}
				System.out.println(String.format("%10d", lastIncomeArray[i]) + " * " + String.format("%2d", taxRateArray[i]) + "% = " + String.format("%10d", LastTaxArray[i]));
				for(int k=1; k<i+1; k++) {
					totalTax += taxMaxArray[k-1];
				}
				totalTax += LastTaxArray[i];
				break;
			}
		}
		//세금 총액
		return totalTax;
	}

	//누진공제 계산에 의한 세금 리턴 함수
	static long deductionSection(long annualIncome) {
		//세금 총액 선언
		long totalTax = 0;
		for(int i=0; i<incomeSectionArray.length + 1; i++){
			if(annualIncome <= incomeSectionArray[i]) {
				totalTax = annualIncome * taxRateArray[i] / 100 - deductionArray[i];
				break;
			}
		}
		//세금 총액 반환
		return totalTax;
	}
}
