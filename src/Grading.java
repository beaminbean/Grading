import java.util.Scanner;

public class Grading {

	// attribute input receives scores from the keyboard (System.in)
	// input is a Scanner type
	private Scanner input = new Scanner(System.in);

	private double[] scores = {};  // declaring the array of scores as a double array with no data
	private int students = 0;
	private double a, b, c, d, f = 0;

	// no argument Constructor
	public Grading() {
		inputScores();
		calculateGenerousGrade();
		printGenerousGrade();
	}

	// method inputScores - is a function that prompts user for the student scores
	private void inputScores() {

		// declare and initialize score attribute
		double score = 0;

		// get the number of students
		System.out.println("Please enter the number of Students\n");
		students = input.nextInt();

		// initialize the array of student scores with 0.0 data
		scores = new double[students];

		// get input for all scores for students
		for (int i = 0; i < students; i++) {

			// reset score
			score = 0;

			// get the input from the user and convert to a double and put in the score
			// attribute
			// += means add to the current score the input score, e.g. score = score + input
			// if score = 2 and input.nextDouble() = 3 then score = 5
			System.out.println("Please enter Exam #1 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Exam #2 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Exam #3 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Exam #4 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Assignment #1 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Assignment #2 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Assignment #3 Score\n");
			score += input.nextDouble();

			System.out.println("Please enter Assignment #4 Score\n");
			score += input.nextDouble();

			System.out.println("Student Total Score: " + score);

			// put the student score in the array
			scores[i] = score;

			System.out.println("Final Score for Student # " + i + " : " + getGrade(scores[i]));
		}
	}

	// print out the students grade
	private String getGrade(double score) {

		if (score >= 450) {
			return "A";
		} else if (score >= 400) {
			return "B";
		} else if (score >= 350) {
			return "C";
		} else if (score >= 300) {
			return "D";
		}

		return "F";
	}

	// prints out the generous grade
	private void printGenerousGrade() {

		for (int i = 0; i < students; i++) {
			System.out.println("Generous Score for Student # " + i + " : " + getGenerousGrade(scores[i]));
		}
	}

	// calculates the generous grade
	private String getGenerousGrade(double score) {

		if (score >= a) {
			return "A";
		} else if (score >= b) {
			return "B";
		} else if (score >= c) {
			return "C";
		} else if (score >= d) {
			return "D";
		}

		return "F";
	}

	// calculates the generous grade
	private void calculateGenerousGrade() {

		double mean = getMean();
		double standardDeviation = getStandardDeviation();

		System.out.println("mean: " + mean);
		System.out.println("standardDeviation: " + standardDeviation);

		a = mean + (2 * standardDeviation);
		b = mean + (1 * standardDeviation);
		c = mean;
		d = mean - (1 * standardDeviation);
		f = mean - (2 * standardDeviation);

		System.out.println("Generous Grades: a:" + a + " b:" + b + " c:" + c + " d:" + d + " f:" + f);
	}

	// calculates the mean
	private double getMean() {

		double mean = 0;

		for (int i = 0; i < students; i++) {
			mean += scores[i];
		}

		return mean / students;
	}

	// calculates the standard deviation
	private double getStandardDeviation() {

		double standardDeviation = 0;

		double mean = getMean();

		for (int i = 0; i < students; i++) {
			
			// Math.pow - power(all scores one at a time, subtracting the mean) to the power of 2
			// for instance:  Student Score of 480 with a mean of 400 = Power(80, 2)
			standardDeviation += Math.pow(scores[i] - mean, 2);
		}

		return Math.sqrt(standardDeviation / students);
	}
	
	// main method starts the program
	public static void main(String[] args) {
		new Grading(); // calls the Grading Constructor
	}
}