/*
 * Written by Diana Sen
 * This program will take 2 files (one by one) from user input. 
 * These files will be read and merged into third, new file named solutions type is txt
 * they will be merged line by line meaning one line from file 1 and one line from file 2 until
 * there is no more lines with text left
 * 
 * program is not infinite because thrird made file has specified name "solutions.txt" it would be unreasonable to keep overwriting same file
 * but if wanted to run it infinetly simple solution is to comment out or delete exit statement on line 102 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class merge_files {
	
	public static void welcome() {
		System.out.println("Welcome,\n this java program will ask you to for two files and will merge them together"
				+ "\n they will be merged line by line meaning one line from file 1 and one line from file 2 until "
				+ "there is no more lines with text left.\nSince program is made to name merged file solutions.txt it will quit after one time\n"
				+ "but you have option to quit at any time once typed quit \n PS make sure to put absolute path to file.\n Press enter to continue");
	}
	
	public static void welcomeLoop() {
		System.out.println("Please enter files when asked");
	}
	
	public static void printSolutions() throws IOException, FileNotFoundException {
      	System.out.println("This is output of you solutions file: ");
     	 BufferedReader br = new BufferedReader(new FileReader("solutions.txt"));
     	 String answerFile;
     	 while ((answerFile = br.readLine()) != null) {
     	   System.out.println(answerFile);
     	 }
     	 br.close();
	}
	
	public static void quitStattement() {
		System.out.println("If you want to quit please enter quit,\n if want to continue press enter");
	}
	
	public static void goodbye() {
		System.out.println("Goodbye,\nThank you for using my program, if want to do it again please start over");
	}
	
	public static void combineFiles(BufferedReader reader, BufferedReader reader2, PrintWriter newFile) throws IOException {
      	String answersFile;
      	String answersFile2;
		while ( (answersFile = reader.readLine()) != null && (answersFile2 = reader2.readLine()) != null ) {
        	newFile.println(answersFile);
          	newFile.println(answersFile2);
        }
	}
	
	public static void run() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		if (input.equals("quit")) {
			System.out.println("Goodbye, Program terminated by user");
			System.exit(0);
			}
		}

	public static void main(String[] args) throws IOException, FileNotFoundException, NoSuchElementException {
		welcome();
		
      	Scanner scanner = new Scanner(System.in);
      	String input = scanner.nextLine();
		
      	while (!input.equals("quit")) {
      		welcomeLoop();
      		quitStattement();
      		run();
      		
      		System.out.println("Enter file one: ");
		
      		String fileOne = scanner.nextLine();
      		File file = new File(fileOne);
      		BufferedReader reader = new BufferedReader(new FileReader(file));
      		
      		quitStattement();
      		run();
      		System.out.println("Enter file two: ");
      		String fileTwo = scanner.nextLine();
      		File file2 = new File(fileTwo);
      		BufferedReader reader2 = new BufferedReader(new FileReader(file2));
      
      		PrintWriter newFile = new PrintWriter("solutions.txt");   
      
      		combineFiles(reader, reader2, newFile);
		
      		newFile.close();
      	
      		printSolutions();
      		goodbye();
      		System.exit(0);
      		
      	}
      	
      	scanner.close();
      	}
	
}