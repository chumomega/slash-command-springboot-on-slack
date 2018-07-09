package com.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeAppController {
	
	@Autowired
	  private DataSource dataSource;
	
	@RequestMapping("/")
	  String index() {
	    return "index";
	  }

	  @RequestMapping("/db")
	  String db(Map<String, Object> model) {
	    try (Connection connection = dataSource.getConnection()) {
	      Statement stmt = connection.createStatement();
	      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
	      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
	      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

	      ArrayList<String> output = new ArrayList<String>();
	      while (rs.next()) {
	        output.add("Read from DB: " + rs.getTimestamp("tick"));
	      }

	      model.put("records", output);
	      return "db";
	    } catch (Exception e) {
	      model.put("message", e.getMessage());
	      return "error";
	    }
	  }
	  
	  @RequestMapping("/hello")
	  String hello() {
	      return "Hello world. This is tic tac toe";
	  }
	  
	  @RequestMapping(value="/ttt", method=RequestMethod.POST, consumes ="application/x-www-form-urlencoded")
	  @ResponseBody
	  @ResponseStatus(value = HttpStatus.OK)
	  public String ttt(HttpServletRequest request){
		  final SlackCommand slackCommand = new SlackCommand();
		  
		  
	      
		  slackCommand.setUserId(request.getParameter("user_id"));
		  slackCommand.setUserName(request.getParameter("user_name"));
		  slackCommand.setText(request.getParameter("text"));
		  slackCommand.setTriggerId(request.getParameter("trigger_id"));
		  
	      StringBuilder x=new StringBuilder();

	      x.append(slackCommand.getUserName());
	      x.append(" ");
	      x.append(slackCommand.getUserId());
	      x.append(" ");
	      
	      
	      if (!StringUtils.hasText(slackCommand.getText())){ 
	    	  return "Please include the username of the person you are challenging";
	       }
	      else {

	    	  Game game1 = new Game(request.getParameter("user_name"),request.getParameter("text").substring(1));
	    	  
	    	  x.append(slackCommand.getText());
		      return "Person who called the Tic Tac Toe App: " + x.toString() + "\n" + "\n" + game1.showGameBoard();
		      
	      }
	      
	      
	  }
	  

}
