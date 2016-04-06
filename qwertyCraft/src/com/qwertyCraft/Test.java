package com.qwertyCraft;

import java.io.FileNotFoundException;
import java.util.List;

import org.yaml.snakeyaml.Yaml;

import net.homeip.jeffclark.popJava.consoleio.popConsole;
import net.homeip.jeffclark.popJava.fileio.popFile;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
		List<String> list = (List<String>) yaml.load(document);
		System.out.println(list);


		//popConsole Test	    
	    String userinput = null;
	    popConsole console = new popConsole();	    
	    
	    userinput = console.prompt("You should tell me your name: ");
	    System.out.println("Hello there " + userinput + ". Hope you have a good day");
	    
	    userinput = console.prompt("Please tell me something: ");
	    System.out.println("You entered : " + userinput);
		console.prompt("Press any key to continue...");
		/////////////////////////////////////////////////////////////////
		
	    // File Tests ///////////////////////////////////////////////////
		console.getKeyStroke("File Tests..............................\nPress return to continue");

		popFile file = new popFile(System.getProperty("user.dir") + "/data/testCSV.csv");
     	
		Integer csv = -1;
	    System.out.print(file.getFilename() + " " + file.getStatus() + System.lineSeparator());

	    while (file.getStatus()=="OPEN"){
	    		csv=file.getCSVInt();
					if (csv!=null) System.out.print(csv + " ");
	    }
	    System.out.println("EOF");
	    System.out.print(file.getFilename() + " " + file.getStatus() + System.lineSeparator());
			/////////////////////////////////////////////////////////////////
			popFile testToken = new popFile(System.getProperty("user.dir") + "/data/testToken.txt");
     	
			String tok;
	    System.out.print(file.getFilename() + " " + testToken.getStatus() + System.lineSeparator());

	    while (testToken.getStatus()=="OPEN"){
	    		tok=testToken.getToken();
					if (tok!="") System.out.print(tok + " ");
	    }
	    System.out.println("EOF");
	    System.out.print(testToken.getFilename() + " " + file.getStatus() + System.lineSeparator());
	}
}
