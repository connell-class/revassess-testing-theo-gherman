package com.rev.config;

import java.sql.Connection;

/**
 * 
 * @author Revature
 *
 *This is a paceholder class to hold the configurations of your db connection.
 *You should change the url, username, and password. DO NOT CHANGE 
 *THE MODIFIERS OR THE NAMES OF THE VARIABLES. These are 
 *used to test your db schema. 
 */
public class ConnectionConfig {
	//add your jdbc url
	public static final String URL = "jdbc:postgresql://theos-first-test-database.cbofqckkbbrz.us-east-2.rds.amazonaws.com:5432/test_tier_3";
	//add your jdbc username
	public static final String USERNAME = "jdbc_usr";
	//add your jdbc password
	public static final String PASSWORD = "p4ssw0rd";
	//name of the created stored procedure in tier 3
	public static final String TIER_3_PROCEDURE_NAME="show_studysets";
	//name of the created sequence in tier 3
	public static final String TIER_3_SEQUENCE_NAME="myserial";
	
	//implement this method to connect to the db and return the connection object
	public static Connection connect(){
		return null;
	}

	//implement this method with a callable statement that calls the absolute value sql function
	public static long callAbsoluteValueFunction(long value){
		return value;
	}
	
	//private constructor so the class cannot be instantiated
	private ConnectionConfig(){
		super();
	}
}
