package com.qwertyCraft;
import static java.lang.String.format;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public final class Configuration { 
    private String version;
    private Date released;
    private String mapFile;
    private YamlClassExample classExample;
    private List< String > listExample;
    private Map< String, String > mapExample; 

	public Configuration (String filename) {

    Yaml configyaml = new Yaml();  

/*
        try( InputStream in = Files.newInputStream( Paths.get(filename) )) {
            this.class = configyaml.loadAs( in, Configuration.class );
*/
        }




	
	
	
    @Override
    public String toString() {
        return new StringBuilder()
            .append( format( "Version: %s\n", version ) )
            .append( format( "Released: %s\n", released ) )
            .append( format( "Map File: %s\n", mapFile ) )
            .append( format( "Class Example: %s\n", classExample ) )
            .append( format( "List example: %s\n", listExample ) )
            .append( format( "Map example: %s\n", mapExample ) )
            .toString();
    }

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the released
	 */
	public Date getReleased() {
		return released;
	}

	/**
	 * @param released the released to set
	 */
	public void setReleased(Date released) {
		this.released = released;
	}

	/**
	 * @return the mapFile
	 */
	public String getMapFile() {
		return mapFile;
	}

	/**
	 * @param mapFile the mapFile to set
	 */
	public void setMapFile(String mapFile) {
		this.mapFile = mapFile;
	}

	/**
	 * @return the classExample
	 */
	public YamlClassExample getClassExample() {
		return classExample;
	}

	/**
	 * @param classExample the classExample to set
	 */
	public void setClassExample(YamlClassExample classExample) {
		this.classExample = classExample;
	}

	/**
	 * @return the listExample
	 */
	public List<String> getListExample() {
		return listExample;
	}

	/**
	 * @param listExample the listExample to set
	 */
	public void setListExample(List<String> listExample) {
		this.listExample = listExample;
	}

	/**
	 * @return the mapExample
	 */
	public Map<String, String> getMapExample() {
		return mapExample;
	}

	/**
	 * @param mapExample the mapExample to set
	 */
	public void setMapExample(Map<String, String> mapExample) {
		this.mapExample = mapExample;
	}
}