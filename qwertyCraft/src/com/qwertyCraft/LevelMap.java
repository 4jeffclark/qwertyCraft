package com.qwertyCraft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class LevelMap {	
	//public Tile[][][] tile;

	TmxYaml tmxyaml;



	public LevelMap (String fileName) throws IOException {

		tmxyaml = new TmxYaml();

		this.loadFreeForm(fileName);
		
	}

	private void loadStrict(String fileName) throws FileNotFoundException {


		//Yaml yaml = new Yaml();


		//InputStream ios = new FileInputStream(new File(fileName));

		//tmxyaml = yaml.loadAs(ios, TmxYaml.class);

		//System.out.println(tmxyaml.toString());

		//System.out.println(tmxyaml.getHeight());
/*		System.out.println(tmxyaml.get("height"));

		for (String key : tmxyaml.keySet()) {
			Map<String, String> subValues = tmxyaml.get(key);
			System.out.println(key);

			for (String subValueKey : subValues.keySet()) {
				System.out.println(String.format("\t%s = %s",subValueKey, subValues.get(subValueKey)));
			}
		}
*/

	}
	
	@SuppressWarnings("unchecked")
	private void loadFreeForm(String fileName) throws FileNotFoundException {



		// The path of your YAML file.

		Yaml yaml = new Yaml();


		InputStream ios = new FileInputStream(new File(fileName));

		Map<String,Object> ty = (Map<String, Object>) yaml.load(ios);
		
		
		//System.out.println(ty.toString());
		System.out.println(ty.keySet());
		
		//System.out.println(ty.get("layers"));
		//System.out.println(ty.get("layers").getClass());
		//System.out.println(((ArrayList) ty.get("layers")).get(0));
		
			
		
		tmxyaml.height = (int) ty.get("height");
		//System.out.println(tmxyaml.height);
		
		//System.out.println( ty.get("layers").getClass());
		//System.out.println( ((ArrayList) ty.get("layers")).get(0));
		//System.out.println( ((ArrayList) ty.get("layers")).get(0).getClass());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).keySet());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).get("data").getClass());
		//System.out.println(((Map) ((ArrayList) ty.get("layers")).get(0)).get("data"));

		tmxyaml.layers = new ArrayList<TmxLayer>();
		
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

			//System.out.println("Layer "+layernum+": " + templayer.data.get(24));
			tmxyaml.layers.add(templayer);
			//System.out.println(tmxyaml.layers.get(layernum).data);
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
			/*
			System.out.println(tmxyaml.get(layernum).name);
			System.out.println(tmxyaml.opacity); 
			System.out.println(tmxyaml.visible); 
			System.out.println(tmxyaml.width);
			System.out.println(tmxyaml.x);
			System.out.println(tmxyaml.y);
			
*/		
		}
		return result;
				
	}
}

