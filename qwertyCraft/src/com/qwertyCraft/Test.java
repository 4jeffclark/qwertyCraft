package com.qwertyCraft;

import java.io.FileNotFoundException;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;

import net.homeip.jeffclark.popJava.consoleio.popConsole;
import net.homeip.jeffclark.popJava.fileio.popFile;


public class Test {
	public static void main(String[] args) throws FileNotFoundException,IOException {

        if( args.length != 1 ) {
            System.out.println( "Usage: <Configuration_Filename.yml>" );
            return;
        }
  
        Yaml configyaml = new Yaml();  
        try( InputStream in = Files.newInputStream( Paths.get( args[ 0 ] ) ) ) {
            Configuration qC_config = configyaml.loadAs( in, Configuration.class );
  					System.out.println( "qwertyCraft v" + qC_config.getVersion() );
						System.out.println( "Configuration loaded from " + args[0] );
  					System.out.println( "dump:\n" + qC_config.toString() );
        }

			
			
		
	    String userinput = null;
	    popConsole console = new popConsole();	    
	    Player testPlayer = new Player();
   
	    testPlayer.setName(console.prompt("Please tell me your name: "));
	    System.out.println("Hello there " + testPlayer.getName() + ". Welcome to the qwertyCraft test world.");
			console.prompt("Press any key to continue...");
		
	}
}
