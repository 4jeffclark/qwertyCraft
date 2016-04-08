package com.qwertyCraft;

public class LevelMap {	
	public Tile[][][] tile;
	
	public LevelMap () {
		tile = new Tile[256][][];
		
		for (Integer x=0;x<256;x++) {
			tile[x]= new Tile[256][];
			for (Integer y=0;y<256;y++) {
				tile[x][y] = new Tile[8];
				for (Integer z=0;z<8;z++) {
					tile[x][y][z]= new Tile();
					tile[x][y][z].name = x.toString() + " " +y.toString()+" "+z.toString();
				}
			}
		}
	}
}

