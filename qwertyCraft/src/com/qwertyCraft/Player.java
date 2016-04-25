package com.qwertyCraft;

public class Player {
	public LevelMap map;
    public Integer mapx;
    public Integer mapy;
    public Integer mapz;
    private String name;
    
    public Player (String name){
    	this.name = name;
    	this.mapx = 5;
    	this.mapy = 5;
    	this.mapz = 4;
    }
    
    public Player (){
    	this.mapx = 5;
    	this.mapy = 5;
    	this.mapz = 4;
    }
        
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public LevelMap getMap() {
        return this.map;
    }
 
    public void setMap(LevelMap map) {
        this.map = map;
    }
    
    public void moveByUserCommand (String userinput){
    	
    	
    	if (userinput.equals("n")){
    		this.mapy--;
    	} else if (userinput.equals("s")){
    		this.mapy++;
    	} else if (userinput.equals("e")){
    		this.mapx++;
    	} else if (userinput.equals("w")){
    		this.mapx--;
    	} else if (userinput.equals("nw")){
    		this.mapx--;
    		this.mapy--;
    	} else if (userinput.equals("ne")){
    		this.mapx++;
    		this.mapy--;
    	} else if (userinput.equals("se")){
    		this.mapx++;
    		this.mapy++;
    	} else if (userinput.equals("sw")){
    		this.mapx--;
    		this.mapy++;
    	} else if (userinput.equals("u")){
    		this.mapz++;
    	} else if (userinput.equals("d")){
    		this.mapz--;
    	} 
    	
    	this.bringInBounds();
    }
	
    
    public void bringInBounds() {
        if (this.mapx < 0) mapx=0;
        if (this.mapx > this.map.height) this.mapx=this.map.height;
        if (this.mapy < 0) this.mapy=0;
        if (this.mapy > this.map.height) this.mapy=this.map.height;
        if (this.mapz < 0) this.mapz=0;
        if (this.mapz > 7) this.mapz=7;
    }
    
    public Tile getTile(String layername) {
        
    	int index = (this.mapy*this.map.height)+ this.mapx;
    	for (int layer=0; layer<this.map.layers.size();layer++){ //for each layer
    		if (this.map.layers.get(layer).name.equals(layername)) { //if layername matches
    			return this.map.layers.get(layer).mapTiles[index];   //return the tile at index
    		}
    		

    	}
    	return null;
    }

}
