package com.qwertyCraft;

public class Player {
    public Integer x;
    public Integer y;
    public Integer z;
    private String name;
    
    public Player (String name){
    	this.name = name;
    	this.x = 100;
    	this.y = 100;
    	this.z = 4;
    }
    
    public Player (){
    	this.x = 100;
    	this.y = 100;
    	this.z = 4;
    }
        
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public void bringInBounds() {
        if (this.x < 0) x=0;
        if (this.x > 255) x=255;
        if (this.y < 0) y=0;
        if (this.y > 255) y=255;
        if (this.z < 0) z=0;
        if (this.z > 7) z=7;
    }

}
