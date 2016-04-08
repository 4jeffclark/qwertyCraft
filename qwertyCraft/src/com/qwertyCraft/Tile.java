package com.qwertyCraft;

public class Tile {

	public String name;
	public String shortDesc;
	public String Desc;
	public Portal n;
	public Portal s;
	public Portal e;
	public Portal w;
	public Portal ne;
	public Portal se;
	public Portal sw;
	public Portal nw;
	public Portal u;
	public Portal d;
	
	public Tile () {
		n = new Portal();
		name = new String();
	}
}
