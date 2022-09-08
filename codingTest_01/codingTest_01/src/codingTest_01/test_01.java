package codingTest_01;

public class test_01 {

	public static void main(String[] args) {
		
		System.out.println("[구구단 출력]");
		
		for(int i = 1; i < 10; i++) {
          for(int j = 1; j < 10; j++) {
        	  
             int x = j;
             int y = i;
             int mul = x * y;
             
             String X = String.format("%2d", x).replace(" ", "0");
             String Y = String.format("%2d", y).replace(" ", "0");
             String Mul = String.format("%2d", mul).replace(" ", "0");
             
             if(j == 9) {
            	 System.out.println(X + " x " + Y + " = " + Mul + "   ");	 
             }else {
            	 System.out.print(X + " x " + Y + " = " + Mul + "   ");
             }
          }
       }
	}
}
