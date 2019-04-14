public class RPS9Game {
	public static void main(String arg[]) {
		Game play = new Game();
		play.intro(); // Print out the game's rules
		
		// Loop until user quits or one side has won a certain times
		while (!play.isDone()) {
			play.getChoiceFromUser();
			if (play.isDone()) // Check if the user quits, end the game if true
				break;
			play.makeChoice();
			play.displayRoundResult();
		}

		play.displayGameResult();
	}
}