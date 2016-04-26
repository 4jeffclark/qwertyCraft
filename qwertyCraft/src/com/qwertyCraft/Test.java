package com.qwertyCraft;

import static java.lang.String.format;

import java.io.*;
import org.yaml.snakeyaml.Yaml;

import net.homeip.jeffclark.popJava.consoleio.popConsole;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Main class for testing qwertyCraft with example content.
 * @author Jeff
 *
 */
public class Test {
	public static void main(String[] args) throws FileNotFoundException,IOException {

        if( args.length != 1 ) {
            System.out.println( "Usage: <Configuration_Filename.yml>" );
            return;
        }
		// Yaml object for reading qcConfig. Plan to bury in Configuration class.
        Yaml configyaml = new Yaml();  
		
		// Instantiate qwertyCraft Configuration object
        Configuration myConfiguration = new Configuration();
		
        // Parse and load configuration. Plan to bury in Configuration class.
		try( InputStream in = Files.newInputStream( Paths.get(args[0]) )) {
			myConfiguration =  configyaml.loadAs( in, Configuration.class );
        }
		
		//Confirm Configuration
		System.out.println( "Configuration loaded from " + args[0] );
  		System.out.println( myConfiguration.toString() );

		//console vars
	    popConsole console = new popConsole(); //Instantiate console.    
	    String playerinput = new String(); //to hold user console input
	    
	    //Create player
	    playerinput = console.prompt("Please tell me your name: "); //get player's name
	    Player testPlayer = new Player(playerinput); //Instantiate a new player
	    System.out.println("Hello there " + testPlayer.getName() + ". Welcome to the qwertyCraft test world.");
		console.prompt("Press Return to continue...");
		
		
		// Instantiate qwertyCraft LevelMap object from data file in loaded configuration
		LevelMap tempmap = new LevelMap(myConfiguration.getMapFiles().get(0));
	    testPlayer.map=tempmap;
		System.out.println(testPlayer.map.toString()); 

		
	    Integer turn = 0;	//game loop turn counter.	

		// Game Loop
		while (true) {
			
			StringBuilder hud = new StringBuilder()
	            //.append( format( "[%d,%d,%d] ", testPlayer.mapx,testPlayer.mapy,testPlayer.mapz ) )
				.append( format( "\n%s\n", testPlayer.getTile("Terrain").name ) )
	            .append( format( "%s\n", testPlayer.getTile("Terrain").desc ) );

			System.out.print (hud);
			playerinput=console.prompt("> ");
			turn++;

			if (playerinput.equals("exit"))
				break;
			
			else { 
				testPlayer.moveByUserCommand(playerinput);
				testPlayer.bringInBounds();
			}
		}
		
	}
}
