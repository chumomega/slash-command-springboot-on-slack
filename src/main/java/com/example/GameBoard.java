package com.example;

public class GameBoard {
	private String[][] board=new String[3][3];
	
	public GameBoard() {
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j]="_";
			}
		}
	}
	
	//returns true or false if successful
	public boolean playAmove(int row, int col, String marker) {
		if(board[row][col]!="_") {
			board[row][col]=marker;
			return true;
		}
		else {
			return false;
		}		
	}
	
	public String displayBoard() {
		StringBuilder stringBoard = new StringBuilder();
		
		stringBoard.append("This is the current Tic Tac Toe Gameboard" + "\n" + "\n");
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				stringBoard.append(board[i][j]);
			}
			stringBoard.append("\n");
		}
		
		return stringBoard.toString();
	}
	
	public boolean checkForWin() {
		
		//TODO: make sure you do some checking for null values
		if(board[0][0]==board[0][1]&&board[0][1]==board[0][2]&&board[0][2]!="_") {
			return true;			
		}
		else if(board[1][0]==board[1][1]&&board[1][1]==board[1][2]&&board[1][2]!="_") {
			return true;			
		}
		else if(board[2][0]==board[2][1]&&board[2][1]==board[2][2]&&board[2][2]!="_") {
			return true;			
		}
		else if(board[0][0]==board[1][0]&&board[1][0]==board[2][0]&&board[2][0]!="_") {
			return true;			
		}
		else if(board[0][1]==board[1][1]&&board[2][1]==board[2][1]&&board[2][1]!="_") {
			return true;			
		}
		else if(board[0][2]==board[1][2]&&board[2][1]==board[2][2]&&board[2][2]!="_") {
			return true;			
		}
		else if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]&&board[2][2]!="_") {
			return true;			
		}
		else if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]&&board[2][0]!="_") {
			return true;			
		}
		else {
			return false;
		}
		
	}
	

}
