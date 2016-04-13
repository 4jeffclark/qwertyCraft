package com.qwertyCraft;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TileSet {
    public Integer columns;
    public Integer firstgid;
    public String image;
    public Integer imageheight;
    public Integer imagewidth;
    public Integer margin;
    public String name;
    public Integer spacing;
    public Integer tilecount;
    public Integer tileheight;
    public Map<Integer,Map<String,String>> tileproperties;
    public Map<Integer,Map<String,String>> tilepropertytypes;
    public Integer tilewidth;
    public String transparentcolor;
    public Map<Integer,TileProperties> qCTileProperties;
    
    
    public TileSet () {
    	//have to instantiate interface Map as a specific Object class of Map
    	this.qCTileProperties = new LinkedHashMap<Integer,TileProperties>();
    }
    
    
    

	/**
	 * @return the columns
	 */
	public Integer getColumns() {
		return columns;
	}
	/**
	 * @param columns the columns to set
	 */
	public void setColumns(Integer columns) {
		this.columns = columns;
	}
	/**
	 * @return the firstgid
	 */
	public Integer getFirstgid() {
		return firstgid;
	}
	/**
	 * @param firstgid the firstgid to set
	 */
	public void setFirstgid(Integer firstgid) {
		this.firstgid = firstgid;
	}
	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * @return the imageheight
	 */
	public Integer getImageheight() {
		return imageheight;
	}
	/**
	 * @param imageheight the imageheight to set
	 */
	public void setImageheight(Integer imageheight) {
		this.imageheight = imageheight;
	}
	/**
	 * @return the imagewidth
	 */
	public Integer getImagewidth() {
		return imagewidth;
	}
	/**
	 * @param imagewidth the imagewidth to set
	 */
	public void setImagewidth(Integer imagewidth) {
		this.imagewidth = imagewidth;
	}
	/**
	 * @return the margin
	 */
	public Integer getMargin() {
		return margin;
	}
	/**
	 * @param margin the margin to set
	 */
	public void setMargin(Integer margin) {
		this.margin = margin;
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
	 * @return the spacing
	 */
	public Integer getSpacing() {
		return spacing;
	}
	/**
	 * @param spacing the spacing to set
	 */
	public void setSpacing(Integer spacing) {
		this.spacing = spacing;
	}
	/**
	 * @return the tilecount
	 */
	public Integer getTilecount() {
		return tilecount;
	}
	/**
	 * @param tilecount the tilecount to set
	 */
	public void setTilecount(Integer tilecount) {
		this.tilecount = tilecount;
	}
	/**
	 * @return the tileheight
	 */
	public Integer getTileheight() {
		return tileheight;
	}
	/**
	 * @param tileheight the tileheight to set
	 */
	public void setTileheight(Integer tileheight) {
		this.tileheight = tileheight;
	}
	/**
	 * @return the tileproperties
	 */
	public Map<Integer, Map<String, String>> getTileproperties() {
		return tileproperties;
	}
	/**
	 * @param tileproperties the tileproperties to set
	 */
	public void setTileproperties(Map<Integer, Map<String, String>> tileproperties) {
		this.tileproperties = tileproperties;
	}
	/**
	 * @return the tilepropertytypes
	 */
	public Map<Integer, Map<String, String>> getTilepropertytypes() {
		return tilepropertytypes;
	}
	/**
	 * @param tilepropertytypes the tilepropertytypes to set
	 */
	public void setTilepropertytypes(Map<Integer, Map<String, String>> tilepropertytypes) {
		this.tilepropertytypes = tilepropertytypes;
	}
	/**
	 * @return the tilewidth
	 */
	public Integer getTilewidth() {
		return tilewidth;
	}
	/**
	 * @param tilewidth the tilewidth to set
	 */
	public void setTilewidth(Integer tilewidth) {
		this.tilewidth = tilewidth;
	}
	/**
	 * @return the transparentcolor
	 */
	public String getTransparentcolor() {
		return transparentcolor;
	}
	/**
	 * @param transparentcolor the transparentcolor to set
	 */
	public void setTransparentcolor(String transparentcolor) {
		this.transparentcolor = transparentcolor;
	}
	/**
	 * @return the qCTileProperties
	 */
	public Map<Integer, TileProperties> getqCTileProperties() {
		return qCTileProperties;
	}
	/**
	 * @param qCTileProperties the qCTileProperties to set
	 */
	public void setqCTileProperties(Map<Integer, TileProperties> qCTileProperties) {
		this.qCTileProperties = qCTileProperties;
	}
 
    
    
    
    
}
