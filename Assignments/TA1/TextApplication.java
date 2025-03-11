/**
 *  This class adds a text user interface to our pre-existing classes, as well as a run method that brings the whole application
 *  together. 
 *  
 * 
 * @authors Doug Strueby, Nolan Ruzicki, Scott Salmon
 *
 *
 *
 */
import java.util.Scanner;  

public class TextApplication{

	private PollList polls;

	
	/**
	 * This method display the data of one poll by seats
	 * 
	 * @param aPoll A poll being displayed
	 */
	public void displayPollDataBySeat(Poll aPoll) {
		String display = aPoll.textVisualizationBySeats(18, 5);
		System.out.print(display);
	}
	
	/**
	 * This method display the data of one poll by votes
	 * 
	 * @param aPoll A poll being displayed
	 */
	public void displayPollDataByVotes(Poll aPoll) {
		String display = aPoll.textVisualizationByVotes(18, 5);
		System.out.print(display);
	}
	
	/**
	 * This method displays the party names in the poll list by seats
	 * 
	 * @param partyNames parties in the poll list
	 */
	public void displayPollsBySeat(String[] partyNames) {
		System.out.print(polls.textVisualizationBySeats());
		
		Poll ps = polls.getAggregatePoll(partyNames);
		System.out.println(ps.textVisualizationBySeats(18,5));
		
	}

	/**
	 * This method displays the party names in the poll list by votes
	 * 
	 * @param partyNames parties in the poll list
	 */
	public void displayPollsByVotes(String[] partyNames) {
		System.out.print(polls.textVisualizationByVotes());
		
		Poll ps = polls.getAggregatePoll(partyNames);
		System.out.println(ps.textVisualizationByVotes(18,5));
	}

	/**
	 * This method displays the average results of the poll list
	 * 
	 * @param partyNames parties in the poll list
	 */
	private void displayAggregateSeat(String[] partyNames) {
		Poll ps = polls.getAggregatePoll(partyNames);
		System.out.println(ps.textVisualizationBySeats(18,5));
	}
	
	/**
	 * This method safely gets a poll specified by the user
	 * Continues to prompt until a valid input is given
	 * 
	 * @return A poll
	 */
	private Poll getPoll() {
		
		for(int i = 0; i < polls.toArray().length; i++) {
			System.out.println(i + 1 + " " + polls.toArray()[i].getPollName());		
		}
		while(true) {
			
			int pollNumber = getInt("Enter the Number of Polls you want: ") - 1;
			if(pollNumber >= polls.toArray().length) {
				System.out.println("Poll: " + pollNumber + " is out of bounds.");
				continue;
			}
			return polls.toArray()[pollNumber];
		}
	}
	
	/**
	 * This method safely gets a integer specified by the user
	 * Continues to prompt until a valid input is given
	 * 
	 * @param aMessage Prompt for user
	 * @return A integer
	 */
	private static int getInt(String aMessage) {
		Scanner sc = new Scanner(System.in);
		System.out.print(aMessage);
		while(true) {
			String line = sc.nextLine();
			try {
				return Integer.parseInt(line);
			}
			catch(NumberFormatException e){
				System.out.println("Input was not a Integer. Use a full number.");
			}
		}
	}
	
	/**
	 * This method safely gets a float specified by the user
	 * Continues to prompt until a valid input is given
	 * 
	 * @param aMessage Prompt for user
	 * @return A float
	 */
	private static float getFloat(String aMessage) {
		Scanner sc = new Scanner(System.in);
		System.out.print(aMessage);
		while(true) {
			String line = sc.nextLine();
			try {
				return Float.parseFloat(line + "f");
			}
			catch(NumberFormatException e){
				System.out.println("Input was not a number.");
			}
		}
	}
	
	
	/**
	 * This method prompts for a specifications in a poll list
	 * 
	 * @param nameOfParties A array of party names inputed by the user
	 * @param numOfPolls A integer of the polls requested by the user
	 * 
	 */
	private void promptForPollList(String[] nameOfParties, int numOfPolls) {
		
		String result = null;
		Scanner scan = new Scanner(System.in);	
	
			System.out.println("Enter the Desired Name(s) for the Poll(s): ");
			
			for(int i = 0; i < numOfPolls; i++) {
				System.out.print("Name: ");
				String pollName = scan.nextLine();
				Poll p = new Poll(pollName, nameOfParties.length);
				
				for(int ind = 0; ind < nameOfParties.length; ind++) {
					System.out.println("For Party: " + nameOfParties[ind]);
					float projSeats; 
					while(true) {
						projSeats = getFloat("What is the expected number of Seats to be won? (number): ");
						if(projSeats > 0) {
							break;
						}
						System.out.println("Can't have negative seats");
					}
					float projVote;
					
					while(true) {
					
						projVote =  (float) (getInt("What is the expected Vote % won? (Use a whole number between 0-100): ") / 100.0);
						if(projVote <= 1.0) {
							break;
						}
						
						System.out.println("Can't select a percentage greater than 100%");
					}
					Party pt = new Party(nameOfParties[ind], projSeats, projVote);
					p.addParty(pt);
				}
				polls.addPoll(p);	
			}	
		
		System.out.print("Would you like Polls displayed by Seats or Votes (seats/votes): ");
		String option2 = scan.nextLine();
			if(option2.equalsIgnoreCase("votes")) {
				result = "vote";	
			}
			if(option2.equalsIgnoreCase("seats")) {
				result = "seats";			
			}
		
		System.out.print("Would you like to print with data or without? (with / without): ");
		String data = scan.nextLine();
		
		if(data.equalsIgnoreCase("with") && result.equalsIgnoreCase("vote")) {
			displayPollDataByVotes(getPoll());
		}
			
		if(data.equalsIgnoreCase("with") && result.equalsIgnoreCase("seats")) {
			displayPollDataBySeat(getPoll());
			}
				
		if(data.equalsIgnoreCase("without") && result.equalsIgnoreCase("vote")) {
			displayPollsByVotes(nameOfParties);
			}
				
		if(data.equalsIgnoreCase("without") && result.equalsIgnoreCase("seats")) {
			displayPollsBySeat(nameOfParties);
		}
		
	}
	
	/**
	 * runs the program asks for inputs and displays data
	 */
	public void run(){
		System.out.println("Welcome to the Poll Tracker!");
		Scanner scan = new Scanner(System.in);	
		int seats = getInt("How many Seats are available in the Election? ");
		Factory p = new Factory(seats);
		
		
		System.out.println("Which Parties are in the Election? (provide names, comma separated): ");
		String parties = scan.nextLine();
		String[] partyNames = parties.split(",");
		p.setPartyNames(partyNames);
		
		int numberOfPolls =  getInt("How many Polls do you want to track with this application? ");
		polls = new PollList(numberOfPolls,seats);
		
		System.out.print("Would you like me to create a random set of Polls? ");
		String question = scan.nextLine();

		if(question.equalsIgnoreCase("yes")) {
			for(int i = 0; i < numberOfPolls; i++) {
				polls = p.createRandomPollList(numberOfPolls);
			}
			
			System.out.println(polls);
		}
		
		else if(question.equalsIgnoreCase("no")) {
			promptForPollList(partyNames, numberOfPolls);
			
		}
		
		System.out.println();
		
		while(true) {
		
			System.out.println("Options: all (show result of all polls), aggregate (show aggregate result), quit(end apllication)");
			System.out.print("Choose an option: ");
			String response = scan.nextLine();
			
			if(response.equalsIgnoreCase("all")) {
				displayPollsBySeat(partyNames);
			}
			
			else if(response.equalsIgnoreCase("aggregate")) {
				displayAggregateSeat(partyNames);
			}
			
			else if(response.equalsIgnoreCase("quit")) {
				return;
				}
			}
	}
		
	
	public static void main(String[] args) {

		TextApplication t = new TextApplication();
		t.run();
	
	}
}
