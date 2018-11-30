package solutions;

public class StudentScores {

    public static void main(String[] args) {
        int score1;
        int score2;
        int score3;
        int score4;
        float average;

        score1 = 97;
        score2 = 85;
        score3 = 88;
        score4 = 91;

        average = (score1 + score2 + score3 + score4) / 4;

        System.out.println("Score 1 was: " + score1);
        System.out.println("Score 2 was: " + score2);
        System.out.println("Score 3 was: " + score3);
        System.out.println("Score 4 was: " + score4);

        System.out.print("The average of the student's test scores was: ");
        System.out.println(average);
    }
}
