package com.qwertyCraft;
import static java.lang.String.format;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public final class Configuration { 
    private String version;
    private Date released;
    private String startMapFile;
    private YamlClassExample classExample;
    private List< String > mapFiles;
    private Map< String, String > mapExample; 

	public Configuration () throws IOException {


	}


    @Override
    public String toString() {
        return new StringBuilder()
            .append( format( "Version: %s\n", version ) )
            .append( format( "Released: %s\n", released ) )
            .append( format( "Map File: %s\n", startMapFile))
            .append( format( "Class Example: %s\n", classExample ) )
            .append( format( "List example: %s\n", mapFiles ) )
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
	public String getStartMapFile() {
		return this.startMapFile;
	}

	/**
	 * @param mapFile the mapFile to set
	 */
	public void setStartMapFile(String mapFile) {
		this.startMapFile = mapFile;
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
	public List<String> getMapFiles() {
		return this.mapFiles;
	}

	/**
	 * @param listExample the listExample to set
	 */
	public void setMapFiles(List<String> mapFiles) {
		this.mapFiles = mapFiles;
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