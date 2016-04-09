package com.qwertyCraft;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;

public class LevelMap {	
	public Tile[][][] tile;
	
	public LevelMap () throws IOException {

		tile = new Tile[256][][];
        Yaml map = new Yaml();  
        try( InputStream in = Files.newInputStream( Paths.get( "data\template.yml" ) ) ) {
            Object qC_config = map.load( in );

  					System.out.println( "dump:\n" + qC_config.toString() );
        }

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

