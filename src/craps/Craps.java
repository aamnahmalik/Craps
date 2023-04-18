/**
 * Tess Bossdorf
 * Craps Conversion
 * @date 1/25/2023
 * @author tessbossdorf
 * Simulating playing craps
 */
package craps;

import java.util.Scanner;
public class Craps {

	public static void main(String[] args) {
		//This script simulates playing craps a large number of times.
		Scanner scan = new Scanner(System.in);
		System.out.println("How many times should we play the game?");
		int numGames = scan.nextInt();
		
		int wins = 0;
		int losses = 0;
		int i = 0;
		int numGame = 0;
				
		
		//for (i <- 1 .to(numGame)) {
		for (i = 0; i < numGames; i++) {
			boolean playerWins = playGame();
			if (playerWins) {
				wins++;
			}
			else {
				losses++;
			}
		}
		
		System.out.printf("\nThe player won %d out of %d games (%.2f%%)\n", wins, numGames, 100.0*wins/numGames);
		System.out.printf("\nThe house won %d out of %d games (%.2f%%)\n", wins, numGames, 100.0*losses/numGames);
	}
		
		/**The playGame function plays a single game of craps. It returns true
		 * if the player wins, and false if the house wins.
		 * @return 
		 */
		public static boolean playGame() {
			int roll = roll2Dice();
			if (roll == 7 || roll == 11) {
				return true;
			}
			else if (roll == 2 || roll == 3 || roll == 12){
				return false;
			}
			else {
				int point = roll;
				do {
					roll = roll2Dice();
				} 	while (roll != 7 && roll != point);
					
				return (roll == point);
			}
		}
		
		/**The roll2Dice function simulates rolling two six-sided dice and
		 * returns the sum of the rolls of those dice.
		 * @return 
		 */
		public static int roll2Dice() {
			int roll1 = (int) (6 * Math.random() + 1);
			int roll2 = (int) (6 * Math.random() + 1);	
			return roll1 + roll2;
		}
	}