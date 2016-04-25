package com.qwertyCraft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class LevelMap {	
	//public Tile[][][] tile;

	//TmxYaml duh;
	Integer height;
	ArrayList<Layer> layers;
	Integer  nextobjectid;
	String  orientation;
	String  renderorder;
	Integer  tileheight;
	ArrayList<TileSet>  tilesets; 


	public LevelMap (String fileName) throws IOException {

		//duh = new TmxYaml();

		this.loadFreeForm(fileName);

		
	}

	
	@SuppressWarnings("unchecked")
	private void loadFreeForm(String fileName) throws FileNotFoundException {



		// The path of your YAML file.

		Yaml yaml = new Yaml();


		InputStream ios = new FileInputStream(new File(fileName));

		Map<String,Object> ty = (Map<String, Object>) yaml.load(ios);
		
		
		//System.out.println(ty.toString());
		//System.out.println(ty.keySet());
		
		//System.out.println(ty.get("layers"));
		//System.out.println(ty.get("layers").getClass());
		//System.out.println(((ArrayList) ty.get("layers")).get(0));
		
			
		
		this.height = (int) ty.get("height");
		//System.out.println(this.height);

		//////////////////////////   Layers  ///////////////////////////////
		
		//System.out.println( ty.get("layers").getClass());
		//System.out.println( ((ArrayList) ty.get("layers")).get(0));
		//System.out.println( ((ArrayList) ty.get("layers")).get(0).getClass());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).keySet());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).get("data").getClass());

		
		this.layers = new ArrayList<Layer>();

	 	for (int layernum=0;layernum < ((ArrayList) ty.get("layers")).size();layernum++) {


	 		Layer templayer = new Layer();
			
			templayer.data = (ArrayList)(((Map) ((ArrayList) ty.get("layers")).get(layernum))).get("data");
			templayer.height = (Integer) ((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("height");
			templayer.name=(String)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("name");
			templayer.opacity=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("opacity"); 
			templayer.visible=(boolean)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("visible"); 
			templayer.width=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("width");
			templayer.x=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("x");
			templayer.y=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("y");

			this.layers.add(templayer);
			
		}
	 	
	 	this.nextobjectid = (Integer) ty.get("nextobjectid");
	 	this.orientation = (String) ty.get("orientation");	 	
	 	this.renderorder = (String) ty.get("renderorder");	 	
	 	this.tileheight = (Integer) ty.get("tileheight");	 	
		//////////////////////////   TileSets  ///////////////////////////////


		
		this.tilesets = new ArrayList<TileSet>();
		for (int tset=0;tset < ((ArrayList) ty.get("tilesets")).size();tset++) {

			TileSet tempts = new TileSet();
			
			tempts.columns = (Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("columns");
			tempts.firstgid = (Integer) (((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("firstgid");
			tempts.image= (String)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("image");
			tempts.imageheight=(Integer) (((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("imageheight");
			tempts.imagewidth=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("imagewidth");
			tempts.margin=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("margin");
			tempts.name=(String)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("name");
			tempts.spacing=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("spacing");
			tempts.tilecount=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("tilecount");
			tempts.tileheight=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("tileheight");

			tempts.tileproperties = (Map<Integer,Map<String,String>>) (  ((Map) ((ArrayList) ty.get("tilesets")).get(tset)).get("tileproperties") );
			tempts.tilepropertytypes =  (Map<Integer,Map<String,String>>) (  ((Map) ((ArrayList) ty.get("tilesets")).get(tset)).get("tilepropertytypes") );

			tempts.tilewidth=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("tilewidth");
			tempts.transparentcolor=(String)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("transparentcolor");
			
			TileProperties qctp;
			
			if (tempts.tileproperties !=null)
			for (int tileID : tempts.tileproperties.keySet()) {
				qctp = new TileProperties();

				for (String propname : tempts.tileproperties.get(tileID).keySet()) {
			
					String propval = tempts.tileproperties.get(tileID).get(propname);
					if (propname.equals("qCName")) {
						TileProperties tempqctp = new TileProperties();
						qctp.qCName = propval;
					} else
					if (propname.equals("qCDesc")) {
							TileProperties tempqctp = new TileProperties();
							qctp.qCDesc = propval;
					}

				}
				if (!qctp.qCDesc.isEmpty() || !qctp.qCName.isEmpty()) {
					qctp.localID=tileID;
					qctp.globalID=tempts.firstgid+tileID;
				}


				tempts.qCTileProperties.put(tempts.firstgid+tileID, qctp);
			}

			this.tilesets.add(tempts);
			for (int layer=0; layer < this.layers.size() ; layer++) {
				this.layers.get(layer).loadTiles(this.tilesets);
			}
			
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//@Override
	public String toString() {
	 	
		String result = null;
		
		result = result + "\nqertyCraft Map loaded from TMX.\nheight: " + this.height.toString();
		result = result + "\nMap Layers (" +this.layers.size() + "):\n";
		for (Integer layernum=0;layernum < this.layers.size();layernum++) {

			result = result + "TMXLayer "+ layernum.toString();
			Integer h = this.layers.get(layernum).height;
			Integer w = this.layers.get(layernum).width;
			result = result + "\nheight: " + this.height + "\ndata ("+w+"x"+h+"):\n";

			for (Integer row=0;row < h ;row++) {	
				for (Integer column=0;column < w;column++) {	
					result = result + "\t" + this.layers.get(layernum).data.get(row*w+column).toString();
				}
				result = result +"\n";
			}
			

			result = result +"\nNAME: "+this.layers.get(layernum).name;
			result = result +"\nOPACITY: "+this.layers.get(layernum).opacity; 
			result = result +"\nVISIBLE: "+this.layers.get(layernum).visible; 
			result = result +"\nWIDTH: "+this.layers.get(layernum).width;
			result = result +"\nX: "+this.layers.get(layernum).x;
			result = result +"\nY: "+this.layers.get(layernum).y;
			
		
		}
		result = result + "\nNEXTOBJECTID: " + this.nextobjectid;
		result = result +"\nORIENTATION: " + this.orientation;
		result = result +"\nRENDERORDER: " + this.renderorder; 
		result = result +"\nTILEHEIGHT: " + this.tileheight;
		result = result + "\nFOUND " + this.tilesets.size();
		
	 	
		for (int tset=0;tset < this.tilesets.size();tset++) {

			result = result + "\n\nTILESET " + tset +":";
			result = result + "\nCOLUMNS " + this.tilesets.get(tset).columns; 
			result = result + "\nFIRSTGID " + this.tilesets.get(tset).firstgid;
			result = result + "\nIMAGE " + this.tilesets.get(tset).image;
			result = result + "\nIMAGEHEIGHT " + this.tilesets.get(tset).imageheight;
			result = result + "\nIMAGEWIDTH " + this.tilesets.get(tset).imagewidth;
			result = result + "\nMARGIN " + this.tilesets.get(tset).margin;
			result = result + "\nNAME " + this.tilesets.get(tset).name;
			result = result + "\nSPACING " + this.tilesets.get(tset).spacing;
			result = result + "\nTILECOUNT " + this.tilesets.get(tset).tilecount;
			result = result + "\nTILEHEIGHT " + this.tilesets.get(tset).tileheight;

			result = result + "\nQCTILEPROPERTIES (" + this.tilesets.get(tset).qCTileProperties.keySet().size() +")\n";

			for (int tileID : this.tilesets.get(tset).qCTileProperties.keySet()) {
				
				result = result + "TILEID " + tileID + " - "; 
				result = result + "localID:" + this.tilesets.get(tset).qCTileProperties.get(tileID).localID + " ";
				result = result + "globalID:" + this.tilesets.get(tset).qCTileProperties.get(tileID).globalID + "\n";

			}			
			if (this.tilesets.get(tset).tileproperties!=null)
				result = result + "\nTILEPROPERTIES (" + this.tilesets.get(tset).tileproperties.keySet().size() +")\n";
			else
				result = result + "\nTILEPROPERTIES (0)\n";

			if (this.tilesets.get(tset).tileproperties!=null)
				for (int tileID : this.tilesets.get(tset).tileproperties.keySet()) {
					result = result + "TILEID: " +tileID + "\n"; 
					for (String propname : this.tilesets.get(tset).tileproperties.get(tileID).keySet()) {
						String propval = this.tilesets.get(tset).tileproperties.get(tileID).get(propname);
						result = result + propname + ": " + propval +"\n";
					}

				}
			
			
			/*System.out.println ((this.tilesets.get(tset).tileproperties).keySet());
			System.out.println ((this.tilesets.get(tset).tilepropertytypes).keySet());

			if (this.tilesets.get(tset).tileproperties.containsKey(41))
					System.out.println (this.tilesets.get(tset).tileproperties.get(41).get("qCDesc"));	
			*/

			/*
			result = result + "\nqCProperties: (" + this.tilesets.get(tset).qCProperties.size() +"(\n";
			for (Map.Entry<String, String> entry : this.tilesets.get(tset).qCProperties.entrySet()) {
				System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
			}
		
			for (int tp=0;tp < this.tilesets.size();tp++) {
				result = result +(Map) (  ((Map) ((ArrayList) ty.get("tilesets")).get(tset)).get("qCProperties") );
			tempts.tilepropertytypes =  (Map) (  ((Map) ((ArrayList) ty.get("tilesets")).get(tset)).get("tilepropertytypes") );
			tempts.tilewidth=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("tilewidth");
			tempts.transparentcolor=(String)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("transparentcolor");
*/

			
		}
		return result;
				
	}
}

