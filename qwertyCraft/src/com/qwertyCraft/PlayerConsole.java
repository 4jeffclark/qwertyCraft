package com.qwertyCraft;

import net.homeip.jeffclark.popJava.consoleio.popConsole;

public class PlayerConsole extends popConsole {
	
	//fields
	//private File file;
	private String status=null;
	//Constructor
	
	public PlayerConsole() {
	    
		super();
		this.status="Constructed";
	}
	
	
	public String getStatus() {
	    
		return(this.status);
	}

}
