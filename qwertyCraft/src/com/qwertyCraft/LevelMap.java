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

	TmxYaml tmxyaml;



	public LevelMap (String fileName) throws IOException {

		tmxyaml = new TmxYaml();

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
		
			
		
		this.tmxyaml.height = (int) ty.get("height");
		//System.out.println(tmxyaml.height);

		//////////////////////////   Layers  ///////////////////////////////
		
		//System.out.println( ty.get("layers").getClass());
		//System.out.println( ((ArrayList) ty.get("layers")).get(0));
		//System.out.println( ((ArrayList) ty.get("layers")).get(0).getClass());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).keySet());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).get("data").getClass());

		
		this.tmxyaml.layers = new ArrayList<TmxLayer>();

	 	for (int layernum=0;layernum < ((ArrayList) ty.get("layers")).size();layernum++) {


			TmxLayer templayer = new TmxLayer();
			
			templayer.data = (ArrayList)(((Map) ((ArrayList) ty.get("layers")).get(layernum))).get("data");
			templayer.height = (Integer) ((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("height");
			templayer.name=(String)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("name");
			templayer.opacity=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("opacity"); 
			templayer.visible=(boolean)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("visible"); 
			templayer.width=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("width");
			templayer.x=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("x");
			templayer.y=(Integer)((Map) ((ArrayList) ty.get("layers")).get(layernum)).get("y");

			this.tmxyaml.layers.add(templayer);
			
		}
	 	
	 	tmxyaml.nextobjectid = (Integer) ty.get("nextobjectid");
	 	tmxyaml.orientation = (String) ty.get("orientation");	 	
	 	tmxyaml.renderorder = (String) ty.get("renderorder");	 	
	 	tmxyaml.tileheight = (Integer) ty.get("tileheight");	 	
		//////////////////////////   TileSets  ///////////////////////////////


		
		this.tmxyaml.tilesets = new ArrayList<TileSet>();
		for (int tset=0;tset < ((ArrayList) ty.get("tilesets")).size();tset++) {
		//for (int tset=0;tset < 3;tset++) {

			System.out.println(tset);
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
			
			/*
			for (int tileID : tempts.tileproperties.keySet()) {
				for (String prop : tempts.tileproperties.get(tileID).keySet()) {
					System.out.println("Item : " + prop + "Val: " + tempts.tileproperties.get(tileID).get(prop));
				}
			}
		
			*/
			
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
				//System.out.println("tempts.tp: \n" + tempts.tileproperties);
				//System.out.println("tempts.qctp: \n" + tempts.qCTileProperties);
				tempts.qCTileProperties.put(tileID, qctp);
			}

			this.tmxyaml.tilesets.add(tempts);

			
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	//@Override
	public String toString() {
	 	
		String result = null;
		
		result = result + "\nqertyCraft Map loaded from TMX.\nheight: " + tmxyaml.height.toString();
		result = result + "\nMap Layers (" +tmxyaml.layers.size() + "):\n";
		for (Integer layernum=0;layernum < tmxyaml.layers.size();layernum++) {

			result = result + "TMXLayer "+ layernum.toString();
			Integer h = tmxyaml.layers.get(layernum).height;
			Integer w = tmxyaml.layers.get(layernum).width;
			result = result + "\nheight: " + tmxyaml.height + "\ndata ("+w+"x"+h+"):\n";

			for (Integer row=0;row < h ;row++) {	
				for (Integer column=0;column < w;column++) {	
					result = result + "\t" + tmxyaml.layers.get(layernum).data.get(row*w+column).toString();
				}
				result = result +"\n";
			}
			

			result = result +"\nNAME: "+tmxyaml.layers.get(layernum).name;
			result = result +"\nOPACITY: "+tmxyaml.layers.get(layernum).opacity; 
			result = result +"\nVISIBLE: "+tmxyaml.layers.get(layernum).visible; 
			result = result +"\nWIDTH: "+tmxyaml.layers.get(layernum).width;
			result = result +"\nX: "+tmxyaml.layers.get(layernum).x;
			result = result +"\nY: "+tmxyaml.layers.get(layernum).y;
			
		
		}
		result = result + "\nNEXTOBJECTID: " + tmxyaml.nextobjectid;
		result = result +"\nORIENTATION: " + tmxyaml.orientation;
		result = result +"\nRENDERORDER: " + tmxyaml.renderorder; 
		result = result +"\nTILEHEIGHT: " + tmxyaml.tileheight;
		result = result + "\nFOUND " + tmxyaml.tilesets.size();
		
	 	
		for (int tset=0;tset < tmxyaml.tilesets.size();tset++) {

			result = result + "\n\nTILESET " + tset +":";
			result = result + "\nCOLUMNS " + tmxyaml.tilesets.get(tset).columns; 
			result = result + "\nFIRSTGID " + tmxyaml.tilesets.get(tset).firstgid;
			result = result + "\nIMAGE " + tmxyaml.tilesets.get(tset).image;
			result = result + "\nIMAGEHEIGHT " + tmxyaml.tilesets.get(tset).imageheight;
			result = result + "\nIMAGEWIDTH " + tmxyaml.tilesets.get(tset).imagewidth;
			result = result + "\nMARGIN " + tmxyaml.tilesets.get(tset).margin;
			result = result + "\nNAME " + tmxyaml.tilesets.get(tset).name;
			result = result + "\nSPACING " + tmxyaml.tilesets.get(tset).spacing;
			result = result + "\nTILECOUNT " + tmxyaml.tilesets.get(tset).tilecount;
			result = result + "\nTILEHEIGHT " + tmxyaml.tilesets.get(tset).tileheight;

			result = result + "\nQCTILEPROPERTIES (" + tmxyaml.tilesets.get(tset).qCTileProperties.keySet().size() +")\n";

			for (int tileID : tmxyaml.tilesets.get(tset).qCTileProperties.keySet()) {
				
				result = result + "TILEID " + tileID + " - "; 
				result = result + "localID:" + tmxyaml.tilesets.get(tset).qCTileProperties.get(tileID).localID + " ";
				result = result + "globalID:" + tmxyaml.tilesets.get(tset).qCTileProperties.get(tileID).globalID + "\n";

			}			
			if (tmxyaml.tilesets.get(tset).tileproperties!=null)
				result = result + "\nTILEPROPERTIES (" + tmxyaml.tilesets.get(tset).tileproperties.keySet().size() +")\n";
			else
				result = result + "\nTILEPROPERTIES (0)\n";

			if (tmxyaml.tilesets.get(tset).tileproperties!=null)
				for (int tileID : tmxyaml.tilesets.get(tset).tileproperties.keySet()) {
					result = result + "TILEID: " +tileID + "\n"; 
					for (String propname : tmxyaml.tilesets.get(tset).tileproperties.get(tileID).keySet()) {
						String propval = tmxyaml.tilesets.get(tset).tileproperties.get(tileID).get(propname);
						result = result + propname + ": " + propval +"\n";
					}

				}
			
			
			/*System.out.println ((tmxyaml.tilesets.get(tset).tileproperties).keySet());
			System.out.println ((tmxyaml.tilesets.get(tset).tilepropertytypes).keySet());

			if (tmxyaml.tilesets.get(tset).tileproperties.containsKey(41))
					System.out.println (tmxyaml.tilesets.get(tset).tileproperties.get(41).get("qCDesc"));	
			*/

			/*
			result = result + "\nqCProperties: (" + tmxyaml.tilesets.get(tset).qCProperties.size() +"(\n";
			for (Map.Entry<String, String> entry : tmxyaml.tilesets.get(tset).qCProperties.entrySet()) {
				System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
			}
		
			for (int tp=0;tp < tmxyaml.tilesets.size();tp++) {
				result = result +(Map) (  ((Map) ((ArrayList) ty.get("tilesets")).get(tset)).get("qCProperties") );
			tempts.tilepropertytypes =  (Map) (  ((Map) ((ArrayList) ty.get("tilesets")).get(tset)).get("tilepropertytypes") );
			tempts.tilewidth=(Integer)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("tilewidth");
			tempts.transparentcolor=(String)(((Map) ((ArrayList) ty.get("tilesets")).get(tset))).get("transparentcolor");
*/

			
		}
		return result;
				
	}
}

