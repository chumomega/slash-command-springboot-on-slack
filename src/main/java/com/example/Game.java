package com.example;

public class Game {
	private GameBoard board;
	private String user1, user2, userOfLastMove;

	public Game(String user1, String user2) {
		this.user1 = user1;
		this.user2 = user2;
		board = new GameBoard();

	}
	public String showGameBoard() {		return board.displayBoard();	}

	public void playGame() {
		// true is player1, false is player2
		boolean turnCounter = true;

		board.displayBoard();
		while (!board.checkForWin()) {
			// TODO take input for position of move
			int xMove = 0, yMove = 0;
			if (turnCounter == true) {

				System.out.println("It is " + user1 + "'s turn");
				/*
				 * xMove = input x coordinate for move yMove = input y coordinate for move
				 */
				if (board.playAmove(xMove, yMove, "X")) {
					userOfLastMove = user1;
				}

				turnCounter = false;
			} else {
				// take input for position of move
				System.out.println("It is " + user2 + "'s turn");
				/*
				 * xMove = input x coordinate for move yMove = input y coordinate for move
				 */

				if (board.playAmove(xMove, yMove, "O")) {
					userOfLastMove = user2;
				}

				turnCounter = true;
			}
		}

		System.out.println("Congratulations " + userOfLastMove + ", you have won Tic Tac Toe");

	}

}