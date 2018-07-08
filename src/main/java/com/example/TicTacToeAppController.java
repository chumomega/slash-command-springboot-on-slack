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
	      slackCommand.setToken(request.getParameter("token"));
	      slackCommand.setTeamId(request.getParameter("team_id"));
	      slackCommand.setTeamDomain(request.getParameter("team_domain"));
	      slackCommand.setChannelId(request.getParameter("channel_id"));
	      slackCommand.setChannelName(request.getParameter("channel_name"));
	      slackCommand.setUserId(request.getParameter("user_id"));
	      slackCommand.setUserName(request.getParameter("user_name"));
	      slackCommand.setCommand(request.getParameter("command"));
	      slackCommand.setText(request.getParameter("text"));
	      slackCommand.setResponseUrl(request.getParameter("response_url"));

	      
	      return "Hello, this should be the path for the slashcommand";
	  }
	  

}