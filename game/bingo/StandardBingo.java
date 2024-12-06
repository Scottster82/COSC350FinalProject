/** This class will hold methods for a standard 75ball game of bingo
* extends Bingo class
*@author Scott Weckman
*/


import java.util.*;
import java.io.*;
import java.security.SecureRandom;

public class StandardBingo extends Bingo{

	//Hold types of bingo for each round
	public String[] firstRound = {"Single Bingo", "Diamond Inside"};
	public String[] secondRound = {"Double Bingo", "Frame Inside", "Ladder"};
	public String[] thirdRound = {"Blackout", "Turtle", "Tree"};

	//Constructor
	public StandardBingo(){
		super.setGameType(75);
		super.setCalledList(75);
	}

	//format called number
	public String formatCall(Integer call){
		String callString = call.toString(); //changes called number to string
		String f = ""; // initializes returned and formatted string
		

		//Formats based on numbers placement within Bingo columns

		if(call <16){
			f = "B:" + callString;
		}
		else if(call < 31){
			f = "I:" + callString;
		}
		else if(call < 46){
			f = "N:" + callString;
		}
		else if(call < 61){
			f = "G:" + callString;
		}
		else if(call < 76){
			f = "O:" + callString;
		}
		return f; //Returns called number
	}

	//call num
	public String call(){
		Integer call = random.nextInt(75) + 1;
		while((super.getCalledList()[call])){
			call = random.nextInt(75) + 1;
		}
		recordCall(call);
		super.setLastCall(call);
		return formatCall(call);
	}

	//To print called nums of each collumn
	public String printB(){
		String rtn = "";
		boolean[] nums = super.getCalledList();
		for(int k = 1; k < 16; k++){
			if(nums[k] == true){
				rtn = String.format("%s%s\n", rtn, formatCall(k));
			}
			else{
				rtn = String.format("%s%s\n", rtn, "");
			}
		}
		return rtn;
	}

	public String printI(){
		String rtn = "";
		boolean[] nums = super.getCalledList();
		for(int k = 16; k < 31; k++){
			if(nums[k] == true){
				rtn = String.format("%s%s\n", rtn, formatCall(k));
			}
			else{
				rtn = String.format("%s%s\n", rtn, "");
			}
		}
		return rtn;
	}

	public String printN(){
		String rtn = "";
		boolean[] nums = super.getCalledList();
		for(int k = 31; k < 46; k++){
			if(nums[k] == true){
				rtn = String.format("%s%s\n", rtn, formatCall(k));
			}
			else{
				rtn = String.format("%s%s\n", rtn, "");
			}
		}
		return rtn;
	}

	public String printG(){
		String rtn = "";
		boolean[] nums = super.getCalledList();
		for(int k = 46; k < 61; k++){
			if(nums[k] == true){
				rtn = String.format("%s%s\n", rtn, formatCall(k));
			}
			else{
				rtn = String.format("%s%s\n", rtn, "");
			}
		}
		return rtn;
	}

	public String printO(){
		String rtn = "";
		boolean[] nums = super.getCalledList();
		for(int k = 61; k < 76; k++){
			if(nums[k] == true){
				rtn = String.format("%s%s\n", rtn, formatCall(k));
			}
			else{
				rtn = String.format("%s%s\n", rtn, "");
			}
		}
		return rtn;
	}

	//read patterns for given bingo type
	public ArrayList<String[]> readPattern(String type){

		ArrayList<String[]> rtn = new ArrayList<String[]>();
			String[] lineArray = new String[1];
			String[] rows = new String[5];

		if((type.equals("Single Bingo")) | (type.equals("Double Bingo"))){
			try{
				scanner = new Scanner(new File("SinglePattern.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				String row = "";
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);

			}
		}
		else if(type.equals("Blackout")){
			try{
				scanner = new Scanner(new File("BlackoutPattern.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);
			}
		}
		else if(type.equals("Diamond Inside")){
			try{
				scanner = new Scanner(new File("Diamond_Inside.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);
			}
		}
		else if(type.equals("Frame Inside")){
			try{
				scanner = new Scanner(new File("Frame_Inside.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);
			}
		}
		else if(type.equals("Ladder")){
			try{
				scanner = new Scanner(new File("Ladder.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);
			}
		}
		else if(type.equals("Turtle")){
			try{
				scanner = new Scanner(new File("Turtle.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);
			}
		}
		else if(type.equals("Tree")){
			try{
				scanner = new Scanner(new File("Tree.txt"));
			}
			catch(IOException e){
				System.err.println("Cannot open file");
				System.exit(1);
			}

			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				lineArray[0] = line;
				rtn.add(new String[]{line});
				rows = new String[5];
				for(int k = 0; k < 5; k++){
					rows[k] = scanner.nextLine();
				}
				rtn.add(rows);
			}
		}
		else{
			String line = "ERROR";
			lineArray[0] = line;
			rtn.add(new String[]{line});
			rows = new String[5];
			for(int k = 0; k < 5; k++){
				rows[k] = "ERROR";
			}
			rtn.add(rows);
		}
		return rtn;
	}
	//makes a pattern out of reader format
	public String makePattern(String[] list){
		String rtn = "";
		for(int k = 0; k < 5; k++){
			rtn = String.format("%s%s\n", rtn, list[k]);
		}
		return rtn;
	}
	//pick round bingo types
	public String pickFirstRound(){
		return firstRound[random.nextInt(2)];
	}
	public String pickSecondRound(){
		return secondRound[random.nextInt(3)];
	}
	public String pickThirdRound(){
		return thirdRound[random.nextInt(3)];
	}

	//start new game
	public void newGame(){
		setCalledList(75);
	}
	//display help stuff
	public String displayHelp(){
		String help = "CALL\n\t-Calls a number\nScore\n\t-add player name\n\t-score points for player\nNext Round\n\t-moves to next round\nShow Pattern\n\t-Show possible bingo cards\nRefresh Scores\n\t-update scores and save to file\nLoad Scores\n\t-load previous scores from file";
		return help;
	}

	// public String readBalance(){
	// 	try (Scanner scanner = new Scanner(new File("user_data.txt"))) {
    //         while (scanner.hasNextLine()) {
    //             System.out.println(scanner.nextLine());
    //         }
    //     } catch (FileNotFoundException e) {
    //         e.printStackTrace();
    //     }

	// }
}

