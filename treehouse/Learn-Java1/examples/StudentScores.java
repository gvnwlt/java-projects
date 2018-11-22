package examples; 

import java.util.List; 

public class StudentScores
{
	public static void main (String[] args)
	{
		int i = 0; 
		int score1 = 98; 
		int score2 = 78; 
		int score3 = 87; 
		int score4 = 100; 

		int[] scoreList = {score1, score2, score3, score4}; 

		int average = (score1 + score2 + score3 + score4) / 4; 
		

		for (i = 0; i < 4; i++)
		{
			System.out.printf("Score " + (i+1) + ":\t\t" + scoreList[i] + "\n"); 
		}	
		
		System.out.printf("Test average score:\t%d\n", average); 
	}
}
