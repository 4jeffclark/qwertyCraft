package com.qwertyCraft;
import static java.lang.String.format;

import java.util.Date;
import java.util.List;
import java.util.Map;

public final class Configuration { 
    private String version;
    private Date released;
    private String mapFile;
    private YamlClassExample classExample;
    private List< String > listExample;
    private Map< String, String > mapExample; 

    public String getVersion() {
        return version;
    }
 
    public void setVersion(String version) {
        this.version = version;
    }
 
    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }
    
    public String getmapFile() {
        return mapFile;
    }
 
    public void setmapFile(String mapFile) {
        this.mapFile = mapFile;
    }
 
    public YamlClassExample getClassExample() {
        return classExample;
    }
 
    public void setClassExample(YamlClassExample classExample) {
        this.classExample = classExample;
    }
 
    public List< String > getListExample() {
        return listExample;
    }

    public void setListExample(List< String > listExample) {
        this.listExample = listExample;
    }
 
    public Map< String, String > getMapExample() {
        return mapExample;
    }
 
    public void setMapExample(Map< String, String > mapExample) {
        this.mapExample = mapExample;
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
}