package codingTest_01;

import java.util.Scanner;

public class test_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

	//필드 생성 (세율과 누진공제 계산에 각각 활용하기 위한 항목)
	//구간별 연봉 최대값 배열
	static long[] incomeSectionArray = {12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};
	//구간별 세율 배열
	static int[] taxRateArray = {6, 15, 24, 35, 38, 40, 42,45};
	
	//세율에 의한 세금 리턴 함수
	static long rateSection(long annualIncome) {
		
		//구간별 과세표준액 최대값
		long incomeA = incomeSectionArray[0];
		long incomeB = incomeSectionArray[1]-incomeA;
		long incomeC = incomeSectionArray[2]-incomeA-incomeB;
		long incomeD = incomeSectionArray[3]-incomeA-incomeB-incomeC;
		long incomeE = incomeSectionArray[4]-incomeA-incomeB-incomeC-incomeD;
		long incomeF = incomeSectionArray[5]-incomeA-incomeB-incomeC-incomeD-incomeE;
		long incomeG = incomeSectionArray[6]-incomeA-incomeB-incomeC-incomeD-incomeE-incomeF;

		//구간별 세금 최대값
		long taxA = incomeA * taxRateArray[0] /100;
		long taxB = incomeB * taxRateArray[1] /100;
		long taxC = incomeC * taxRateArray[2] /100;
		long taxD = incomeD * taxRateArray[3] /100;
		long taxE = incomeE * taxRateArray[4] /100;
		long taxF = incomeF * taxRateArray[5] /100;
		long taxG = incomeG * taxRateArray[6] /100;
		
		//구간별 최고세율 잔액
		long lastIncomeA = annualIncome;
		long lastIncomeB = annualIncome-incomeA;
		long lastIncomeC = annualIncome-incomeA-incomeB;
		long lastIncomeD = annualIncome-incomeA-incomeB-incomeC;
		long lastIncomeE = annualIncome-incomeA-incomeB-incomeC-incomeD;
		long lastIncomeF = annualIncome-incomeA-incomeB-incomeC-incomeD-incomeE;
		long lastIncomeG = annualIncome-incomeA-incomeB-incomeC-incomeD-incomeE-incomeF;
		long lastIncomeH = annualIncome-incomeA-incomeB-incomeC-incomeD-incomeE-incomeF-incomeG;
		
		//구간별 최고세율 잔액에 대한 세금
		long LastTaxA = lastIncomeA * taxRateArray[0] /100;
		long LastTaxB = lastIncomeB * taxRateArray[1] /100;
		long LastTaxC = lastIncomeC * taxRateArray[2] /100;
		long LastTaxD = lastIncomeD * taxRateArray[3] /100;
		long LastTaxE = lastIncomeE * taxRateArray[4] /100;
		long LastTaxF = lastIncomeF * taxRateArray[5] /100;
		long LastTaxG = lastIncomeG * taxRateArray[6] /100;
		long LastTaxH = lastIncomeH * taxRateArray[7] /100;
		
		//세금 총액
		long totalTax = 0;
		
		if(annualIncome <= incomeSectionArray[0]) {
			System.out.println(String.format("%10d", lastIncomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", LastTaxA));
			totalTax = LastTaxA;
		} 
		else if(annualIncome <= incomeSectionArray[1]) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", lastIncomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", LastTaxB));
			totalTax = taxA + LastTaxB;
		}
		else if(annualIncome <= incomeSectionArray[2]) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", lastIncomeC) + " * " + String.format("%2d", taxRateArray[2]) + "% = " + String.format("%10d", LastTaxC));
			totalTax = taxA + taxB + LastTaxC;
		}
		else if(annualIncome <= incomeSectionArray[3]) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateArray[2]) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", lastIncomeD) + " * " + String.format("%2d", taxRateArray[3]) + "% = " + String.format("%10d", LastTaxD));
			totalTax = taxA + taxB + taxC + LastTaxD;
		}
		else if(annualIncome <= incomeSectionArray[4]) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateArray[2]) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateArray[3]) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", lastIncomeE) + " * " + String.format("%2d", taxRateArray[4]) + "% = " + String.format("%10d", LastTaxE));
			totalTax = taxA + taxB + taxC + taxD + LastTaxE;
		}
		else if(annualIncome <= incomeSectionArray[5]) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateArray[2]) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateArray[3]) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", incomeE) + " * " + String.format("%2d", taxRateArray[4]) + "% = " + String.format("%10d", taxE));
			System.out.println(String.format("%10d", lastIncomeF) + " * " + String.format("%2d", taxRateArray[5]) + "% = " + String.format("%10d", LastTaxF));
			totalTax = taxA + taxB + taxC + taxD + taxD + LastTaxF;
		}
		else if(annualIncome <= incomeSectionArray[6]) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateArray[2]) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateArray[3]) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", incomeE) + " * " + String.format("%2d", taxRateArray[4]) + "% = " + String.format("%10d", taxE));
			System.out.println(String.format("%10d", incomeF) + " * " + String.format("%2d", taxRateArray[5]) + "% = " + String.format("%10d", taxF));
			System.out.println(String.format("%10d", lastIncomeG) + " * " + String.format("%2d", taxRateArray[6]) + "% = " + String.format("%10d", LastTaxG));
			totalTax = taxA + taxB + taxC + taxD + taxE + taxF + LastTaxG;
		}
		else {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateArray[0]) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateArray[1]) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateArray[2]) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateArray[3]) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", incomeE) + " * " + String.format("%2d", taxRateArray[4]) + "% = " + String.format("%10d", taxE));
			System.out.println(String.format("%10d", incomeF) + " * " + String.format("%2d", taxRateArray[5]) + "% = " + String.format("%10d", taxF));
			System.out.println(String.format("%10d", incomeG) + " * " + String.format("%2d", taxRateArray[6]) + "% = " + String.format("%10d", taxG));
			System.out.println(String.format("%10d", lastIncomeH) + " * " + String.format("%2d", taxRateArray[7]) + "% = " + String.format("%10d", LastTaxH));
			totalTax = taxA + taxB + taxC + taxD + taxE + taxF + taxG + LastTaxH;
		}
		
		//세금 총액
		return totalTax;
	}
	
	//누진공제 계산에 의한 세금 리턴 함수
	static long deductionSection(long annualIncome) {

		//구간별 누진공제액
		long deductionA = 0;
		long deductionB = 1080000;
		long deductionC = 5220000;
		long deductionD = 14900000;
		long deductionE = 19400000;
		long deductionF = 25400000;
		long deductionG = 35400000;
		long deductionH = 65400000;

		//세금 총액 선언
		long totalTax = 0;

		//구간별 누진공제 세금 총액
		if(annualIncome <= incomeSectionArray[0]) totalTax = annualIncome * taxRateArray[0] / 100 - deductionA;
		else if(annualIncome <= incomeSectionArray[1]) totalTax = annualIncome * taxRateArray[1] / 100 - deductionB;
		else if(annualIncome <= incomeSectionArray[2]) totalTax = annualIncome * taxRateArray[2] / 100 - deductionC;
		else if(annualIncome <= incomeSectionArray[3]) totalTax = annualIncome * taxRateArray[3] / 100 - deductionD;
		else if(annualIncome <= incomeSectionArray[4]) totalTax = annualIncome * taxRateArray[4] / 100 - deductionE;
		else if(annualIncome <= incomeSectionArray[5]) totalTax = annualIncome * taxRateArray[5] / 100 - deductionF;
		else if(annualIncome <= incomeSectionArray[6]) totalTax = annualIncome * taxRateArray[6] / 100 - deductionG;
		else  totalTax = annualIncome * taxRateArray[7] / 100 - deductionH;

		//세금 총액 반환
		return totalTax;
	}
}
