package codingTest_01;

public class test_06 {

	public static void main(String[] args) {
		
		double totalRate = 100;
		int voteCount = 0;
		
		double voteRate1 = 0;
		double voteRate2 = 0;
		double voteRate3 = 0;
		double voteRate4 = 0;
		
		int voteCount1 = 0;
		int voteCount2 = 0;
		int voteCount3 = 0;
		int voteCount4 = 0;
		
		String voteName1 = "이재명";
		String voteName2 = "윤석열";
		String voteName3 = "심상정";
		String voteName4 = "안철수";
		
		String newVote = voteName1;
		String resultVote = "윤석열";
		
		
		System.out.println("[투표진행율]: " + totalRate + "%, " + voteCount + "명 투표 => " + newVote);
		System.out.println("[기호:1] " + voteName1 + ": " + voteRate1 + "%, (투표수: " + voteCount1 + ")");
		System.out.println("[기호:2] " + voteName2 + ": " + voteRate2 + "%, (투표수: " + voteCount2 + ")");
		System.out.println("[기호:3] " + voteName3 + ": " + voteRate3 + "%, (투표수: " + voteCount3 + ")");
		System.out.println("[기호:4] " + voteName4 + ": " + voteRate4 + "%, (투표수: " + voteCount4 + ")");

		if(totalRate == 100) System.out.println("[투표결과] 당선인:" + resultVote);
		

	}

}
