package com.qwertyCraft;

import java.util.ArrayList;

public class Layer {
	ArrayList<Integer> data;
	Integer height;
	String name;
	float opacity;
	boolean visible;
	Integer width;
	Integer x;
	Integer y;
	public Tile[] mapTiles;
	
	
	public void loadTiles(ArrayList<TileSet>  tilesets) {
		this.mapTiles = new Tile [this.data.size()];
		for (int i = 0; i< this.data.size(); i++) {
			this.mapTiles[i]=new Tile();
			for (int set=0; set < tilesets.size(); set++){
				if (tilesets.get(set).qCTileProperties.containsKey(this.data.get(i)) ) {
					this.mapTiles[i].name = tilesets.get(set).qCTileProperties.get(this.data.get(i)).qCName;
					this.mapTiles[i].desc = tilesets.get(set).qCTileProperties.get(this.data.get(i)).qCDesc;
				}
					
			}
		}
	}	
	
	
	
	/**
	 * @return the data
	 */
	public ArrayList<Integer> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<Integer> data) {
		this.data = data;
	}
	/**
	 * @return the height
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the opacity
	 */
	public float getOpacity() {
		return opacity;
	}
	/**
	 * @param opacity the opacity to set
	 */
	public void setOpacity(float opacity) {
		this.opacity = opacity;
	}
	/**
	 * @return the visible
	 */
	public boolean isVisible() {
		return visible;
	}
	/**
	 * @param visible the visible to set
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	/**
	 * @return the width
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}
	
	
}
