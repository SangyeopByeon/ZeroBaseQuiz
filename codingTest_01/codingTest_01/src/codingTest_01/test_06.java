package codingTest_01;

import java.util.Random;

public class test_06 {

	public static void main(String[] args) {
		Random random = new Random();

		double totalRate = 100;
		int voteCount = 10000;
		int[] voteCountOfAll = {0,0,0,0};
		String[] voteName = {"이재명", "윤석열", "심상정", "안철수"};

		int voteOne = 0;
		int lastVote = 0;
		for(int i=0; i < voteCount; i++){
			voteOne = random.nextInt(4);
			voteCountOfAll[voteOne] += 1;

			if(i == voteCount-1) lastVote = voteOne;
		}

		double voteRate1 = voteCountOfAll[0] / totalRate;
		double voteRate2 = voteCountOfAll[1] / totalRate;
		double voteRate3 = voteCountOfAll[2] / totalRate;
		double voteRate4 = voteCountOfAll[3] / totalRate;

		int maxCount = 0;
		int maxVote = 0;
		for(int i = 0; i < voteCountOfAll.length; i++){
			if(maxCount < voteCountOfAll[i]) {
				maxCount = voteCountOfAll[i];
				maxVote = i;
			}
		}

		String resultName = voteName[maxVote];

		System.out.println("[투표진행율]: " + totalRate + "%, " + voteCount + "명 투표 => " + voteName[lastVote]);
		System.out.println("[기호:1] " + voteName[0] + ": " + voteRate1 + "%, (투표수: " + voteCountOfAll[0] + ")");
		System.out.println("[기호:2] " + voteName[1] + ": " + voteRate2 + "%, (투표수: " + voteCountOfAll[1] + ")");
		System.out.println("[기호:3] " + voteName[2] + ": " + voteRate3 + "%, (투표수: " + voteCountOfAll[2] + ")");
		System.out.println("[기호:4] " + voteName[3] + ": " + voteRate4 + "%, (투표수: " + voteCountOfAll[3] + ")");
		System.out.println("[투표결과] 당선인: " + resultName);
	}
}
