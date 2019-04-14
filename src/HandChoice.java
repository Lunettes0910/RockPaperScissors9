import java.util.Random;

public class HandChoice {
	private String[] handChoices = {"Rock", "Paper", "Scissors", "Glock", "Spider-Man", "Batman", "Wizard", "Spock", "Lizard"}; // String array for provided choices
	private Random rnd; // Random number generator for computer's side
	private int choiceID, c, i, j; // choiceID is ID for chosen hand position | c, i, j for loop-counting and rule-printing

	// ----------------------------
	
	public HandChoice() { // Default constructor
		rnd = new Random();
		choiceID = 0;
	}
	
	public void rules() { // Print out the game's rules
		for (i = 1; i < handChoices.length; i += 2) {
			for (j = 0; j < handChoices.length; j++) {
				c = j + i;
				if (c >= handChoices.length)
					c -= handChoices.length;
				System.out.println("       " +handChoices[c]+ " beats " +handChoices[j]);
			}
		}
		
		System.out.println();
	}

	public void randomChoice() { // Randomly choose a hand position
		choiceID = rnd.nextInt(handChoices.length);
	}

	public boolean setChoice(String x) { // Check user's input, return true if it is a valid name
		for (i = 0 ; i < handChoices.length; i++) // Compare input with each string in the array
			if (x.toLowerCase().equals(handChoices[i].toLowerCase())) {
				choiceID = i;
				return true;
			}
		return false;
	}
	
	public String getName() { // Show the object's chosen hand position
		return handChoices[choiceID];
	}

	public void validChoiceList() { // Return a string list of valid choices
		System.out.print("Choose one of the following: ");
		for (i = 0 ; i < handChoices.length; i++) {
			System.out.print(handChoices[i]);
			if (i != (handChoices.length - 1))
				System.out.print(", ");
		}
		System.out.println();
	}

	public int compareChoices(HandChoice a, HandChoice b) { // Compare this hand position to another, return -1 the other wins, 1 if this one wins, 0 if they are the same
		int result = 0;
		int c = (a.choiceID - b.choiceID) % (handChoices.length);
		if (c < 0) // Make sure the remainder is positive (0 <= c < number of positions)
			c += handChoices.length;
		
		if ((c % 2) == 0 && c != 0)// even, non-zero remainder => a lost to b
				result = -1;
		if ((c % 2) == 1) // odd remainder => a won b
				result = 1;
		
		return result;
	}
}