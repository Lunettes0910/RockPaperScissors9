import java.util.Scanner;

public class Game {
	private int computerWins; // Number of round won by computer
	private int userWins; // Number of round won by user
	private int gameBreaker = 5; // Points needed to win
	private boolean userQuits; // Did the user quit?
	private HandChoice computer; // Current computer's choice
	private HandChoice user; // Current user's choice
	private Scanner input; // Global scanner

	private String hand; // User's initial input
	// ----------------------------

	public Game() { // Default constructor
		computer = new HandChoice();
		user = new HandChoice();
		input = new Scanner(System.in);
		hand = "";
		computerWins = 0;
		userWins = 0;
		userQuits = false;
	}

	public void intro() { // Show the game's rules, regardless of number of hand positions
		System.out.println("Let's play the 9-variation of the Rock-Paper-Scissor!");
		computer.rules();
	}
	
	public boolean isDone() { // Is the game done?
		if ((hand.toLowerCase().equals("quit")) || (computerWins == 5) || (userWins == 5))
			userQuits = true;

		return userQuits;
	}

	public void makeChoice() { // Computer makes a random choice
		computer.randomChoice();
	}

	public void getChoiceFromUser() { // User player makes a choice
		System.out.print("What is your choice? ");
		hand = input.nextLine();
		user.setChoice(hand);

		// The "while" loop conditions: valid input and not "quit"
		while (!(user.setChoice(hand) || isDone())) {
			user.validChoiceList();
			System.out.print("What is your choice? ");
			hand = input.nextLine();
			user.setChoice(hand);
		}
	}

	public void displayRoundResult() { // Display results of a round
		switch (computer.compareChoices(user, computer)) {
		case -1:
			System.out.println("You lose: " + computer.getName() + " beats " + user.getName());
			System.out.println();
			computerWins++;
			break;

		case 0:
			System.out.println("Tie: both choose " + computer.getName());
			System.out.println();
			break;

		case 1:
			System.out.println("You win: " + user.getName() + " beats " + computer.getName());
			System.out.println();
			userWins++;
			break;
		}
	}

	public void displayGameResult() { // Display the results of the entire game
		if (userWins != gameBreaker && computerWins != gameBreaker) // Go down one line if previous round results not shown (for format purpose)
			System.out.println();
		if (userWins == computerWins)
			System.out.print("It is a tie game, " + computerWins + " all");
		if (userWins > computerWins)
			System.out.print("You win the game, " + userWins + " to " + computerWins);
		if (userWins < computerWins)
			System.out.print("You lose the game, " + computerWins + " to " + userWins);
	}
}