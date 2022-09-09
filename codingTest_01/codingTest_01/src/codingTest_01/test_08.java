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
		long taxByRate = 0;
		taxByRate = rateSection(inputIncome);
		
		//누진공제 계산에 의한 세금
		long taxByDeduction = 0;
		taxByDeduction = deductionSection(inputIncome);
		
		System.out.println();
		System.out.println("[세율에 의한 세금]:  　　　　" + String.format("%10d", taxByRate));
		System.out.println("[누진공제 계산에 의한 세금]: " + String.format("%10d", taxByDeduction));
	}

	//필드 생성 (세율과 누진공제 계산에 각각 활용하기 위한 항목)
	//연봉 구간 기준
	static long incomeSectionA = 12000000;
	static long incomeSectionB = 46000000;
	static long incomeSectionC = 88000000;
	static long incomeSectionD = 150000000;
	static long incomeSectionE = 300000000;
	static long incomeSectionF = 500000000;
	static long incomeSectionG = 1000000000;
	static long incomeSectionH = 0;

	//구간별 세율 필드
	static int taxRateA = 6;
	static int taxRateB = 15;
	static int taxRateC = 24;
	static int taxRateD = 35;
	static int taxRateE = 38;
	static int taxRateF = 40;
	static int taxRateG = 42;
	static int taxRateH = 45;
	
	//세율에 의한 세금 리턴 함수
	static long rateSection(long annualIncome) {
		
		//구간별 과세표준액
		long incomeA = incomeSectionA;
		long incomeB = incomeSectionB-incomeA;
		long incomeC = incomeSectionC-incomeA-incomeB;
		long incomeD = incomeSectionD-incomeA-incomeB-incomeC;
		long incomeE = incomeSectionE-incomeA-incomeB-incomeC-incomeD;
		long incomeF = incomeSectionF-incomeA-incomeB-incomeC-incomeD-incomeE;
		long incomeG = incomeSectionG-incomeA-incomeB-incomeC-incomeD-incomeE-incomeF;
		long incomeH = incomeSectionH;

		//구간별 최대 부과 세금
		long taxA = incomeA * taxRateA /100;
		long taxB = incomeB * taxRateB /100;
		long taxC = incomeC * taxRateC /100;
		long taxD = incomeD * taxRateD /100;
		long taxE = incomeE * taxRateE /100;
		long taxF = incomeF * taxRateF /100;
		long taxG = incomeG * taxRateG /100;
		long taxH = incomeH * taxRateH /100;
		
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
		long LastTaxA = lastIncomeA * taxRateA /100;
		long LastTaxB = lastIncomeB * taxRateB /100;
		long LastTaxC = lastIncomeC * taxRateC /100;
		long LastTaxD = lastIncomeD * taxRateD /100;
		long LastTaxE = lastIncomeE * taxRateE /100;
		long LastTaxF = lastIncomeF * taxRateF /100;
		long LastTaxG = lastIncomeG * taxRateG /100;
		long LastTaxH = lastIncomeH * taxRateH /100;
		
		//세금 총액
		long totalTax = 0;
		
		if(annualIncome <= incomeSectionA) {
			System.out.println(String.format("%10d", lastIncomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", LastTaxA));
			totalTax = LastTaxA;
		} 
		else if(annualIncome <= incomeSectionB) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", lastIncomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", LastTaxB));
			totalTax = taxA + LastTaxB;
		}
		else if(annualIncome <= incomeSectionC) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", lastIncomeC) + " * " + String.format("%2d", taxRateC) + "% = " + String.format("%10d", LastTaxC));
			totalTax = taxA + taxB + LastTaxC;
		}
		else if(annualIncome <= incomeSectionD) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateC) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", lastIncomeD) + " * " + String.format("%2d", taxRateD) + "% = " + String.format("%10d", LastTaxD));
			totalTax = taxA + taxB + taxC + LastTaxD;
		}
		else if(annualIncome <= incomeSectionE) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateC) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateD) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", lastIncomeE) + " * " + String.format("%2d", taxRateE) + "% = " + String.format("%10d", LastTaxE));
			totalTax = taxA + taxB + taxC + taxD + LastTaxE;
		}
		else if(annualIncome <= incomeSectionF) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateC) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateD) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", incomeE) + " * " + String.format("%2d", taxRateE) + "% = " + String.format("%10d", taxE));
			System.out.println(String.format("%10d", lastIncomeF) + " * " + String.format("%2d", taxRateF) + "% = " + String.format("%10d", LastTaxF));
			totalTax = taxA + taxB + taxC + taxD + + taxD +LastTaxF;
		}
		else if(annualIncome <= incomeSectionG) {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateC) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateD) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", incomeE) + " * " + String.format("%2d", taxRateE) + "% = " + String.format("%10d", taxE));
			System.out.println(String.format("%10d", incomeF) + " * " + String.format("%2d", taxRateF) + "% = " + String.format("%10d", taxF));
			System.out.println(String.format("%10d", lastIncomeG) + " * " + String.format("%2d", taxRateG) + "% = " + String.format("%10d", LastTaxG));
			totalTax = taxA + taxB + taxC + taxD + taxE + taxF + LastTaxG;
		}
		else {
			System.out.println(String.format("%10d", incomeA) + " * " + String.format("%2d", taxRateA) + "% = " + String.format("%10d", taxA));
			System.out.println(String.format("%10d", incomeB) + " * " + String.format("%2d", taxRateB) + "% = " + String.format("%10d", taxB));
			System.out.println(String.format("%10d", incomeC) + " * " + String.format("%2d", taxRateC) + "% = " + String.format("%10d", taxC));
			System.out.println(String.format("%10d", incomeD) + " * " + String.format("%2d", taxRateD) + "% = " + String.format("%10d", taxD));
			System.out.println(String.format("%10d", incomeE) + " * " + String.format("%2d", taxRateE) + "% = " + String.format("%10d", taxE));
			System.out.println(String.format("%10d", incomeF) + " * " + String.format("%2d", taxRateF) + "% = " + String.format("%10d", taxF));
			System.out.println(String.format("%10d", incomeG) + " * " + String.format("%2d", taxRateG) + "% = " + String.format("%10d", taxG));
			System.out.println(String.format("%10d", lastIncomeH) + " * " + String.format("%2d", taxRateH) + "% = " + String.format("%10d", LastTaxH));
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
		if(annualIncome <= incomeSectionA) totalTax = annualIncome * taxRateA / 100 - deductionA;
		else if(annualIncome <= incomeSectionB) totalTax = annualIncome * taxRateB / 100 - deductionB;
		else if(annualIncome <= incomeSectionC) totalTax = annualIncome * taxRateC / 100 - deductionC;
		else if(annualIncome <= incomeSectionD) totalTax = annualIncome * taxRateD / 100 - deductionD;
		else if(annualIncome <= incomeSectionE) totalTax = annualIncome * taxRateE / 100 - deductionE;
		else if(annualIncome <= incomeSectionF) totalTax = annualIncome * taxRateF / 100 - deductionF;
		else if(annualIncome <= incomeSectionG) totalTax = annualIncome * taxRateG / 100 - deductionG;
		else  totalTax = annualIncome * taxRateH / 100 - deductionH;

		//세금 총액 반환
		return totalTax;
	}
}
