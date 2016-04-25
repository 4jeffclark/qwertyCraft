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

public class Test {
	public static void main(String[] args) throws FileNotFoundException,IOException {

        if( args.length != 1 ) {
            System.out.println( "Usage: <Configuration_Filename.yml>" );
            return;
        }
		Yaml configyaml = new Yaml();  
		
		Configuration myConfiguration = new Configuration();
		
		try( InputStream in = Files.newInputStream( Paths.get(args[0]) )) {
			myConfiguration =  configyaml.loadAs( in, Configuration.class );
        }
		
		
		System.out.println( "Configuration loaded from " + args[0] );
  		System.out.println( myConfiguration.toString() );
		
	    Integer tick = 0;		
	    String userinput = null;
	    popConsole console = new popConsole();	    

		LevelMap mymap = new LevelMap(myConfiguration.getMapFiles().get(0));
		System.out.println(mymap.toString()); 

	    String playerinput = new String();
	    userinput = console.prompt("Please tell me your name: ");
	    Player testPlayer = new Player(userinput);
	    testPlayer.map=mymap;

	    System.out.println("Hello there " + testPlayer.getName() + ". Welcome to the qwertyCraft test world.");
		console.prompt("Press any key to continue...");
		
			
		while (true) {
			tick++;
			
			StringBuilder hud = new StringBuilder()
	            .append( format( "[%d,%d,%d] ", testPlayer.mapx,testPlayer.mapy,testPlayer.mapz ) )
	            .append( format( "%s\n", testPlayer.getTile("Terrain").name ) )
	            .append( format( "%s\n", testPlayer.getTile("Terrain").desc ) );

			System.out.println (hud);
			userinput=console.prompt("> ");
			if (userinput.equals("exit"))
				break;
			
			else { 
				testPlayer.moveByUserCommand(userinput);
				testPlayer.bringInBounds();
			}
		}
		
	}
}
