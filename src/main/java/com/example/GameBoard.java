package com.example;

public class GameBoard {
	private String[][] board=new String[3][3];
	private String user1, user2;
	
	public GameBoard( String user1, String user2) {
		this.user1=user1;
		this.user2=user2;
	}
	
	public void playAmove(int row, int col, String userName) {
		if(userName==user1 && board[row][col]!="X" && board[row][col]!="O") {
			board[row][col]="X";
		}
		else if(userName==user2 && board[row][col]!="X" && board[row][col]!="O") {
			board[row][col]="O";
		}
		else {
			System.out.println("Bad move");
		}		
	}
	
	public String[][] displayBoard() {
		
		return board;
	}
	
	public boolean checkForWin() {
		
		//TODO: make sure you do some checking for null values
		if(board[0][0]==board[0][1]&&board[0][1]==board[0][2]) {
			return true;			
		}
		else if(board[1][0]==board[1][1]&&board[1][1]==board[1][2]) {
			return true;			
		}
		else if(board[2][0]==board[2][1]&&board[2][1]==board[2][2]) {
			return true;			
		}
		else if(board[0][0]==board[1][0]&&board[1][0]==board[2][0]) {
			return true;			
		}
		else if(board[0][1]==board[1][1]&&board[2][1]==board[2][1]) {
			return true;			
		}
		else if(board[0][2]==board[1][2]&&board[2][1]==board[2][2]) {
			return true;			
		}
		else if(board[0][0]==board[1][1]&&board[1][1]==board[2][2]) {
			return true;			
		}
		else if(board[0][2]==board[1][1]&&board[1][1]==board[2][0]) {
			return true;			
		}
		else {
			return false;
		}
		
	}
	

}
