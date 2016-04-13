package com.qwertyCraft;

import java.util.Map;

public class TileProperties {
	int localID;
	int globalID;
	String qCName;
	String qCDesc;

	public TileProperties () {
		int localID = -1;
		int globalID = -1;
		qCName = new String();
		qCDesc = new String();
	}
	
	/**
	 * @return the localID
	 */
		public Integer getLocalID() {
		return localID;
	}
	/**
	 * @param localID the localID to set
	 */
	public void setLocalID(Integer localID) {
		this.localID = localID;
	}
	/**
	 * @return the globalID
	 */
	public Integer getGlobalID() {
		return globalID;
	}
	/**
	 * @param globalID the globalID to set
	 */
	public void setGlobalID(Integer globalID) {
		this.globalID = globalID;
	}
	/**
	 * @return the qCName
	 */
	public String getqCName() {
		return qCName;
	}
	/**
	 * @param qCName the qCName to set
	 */
	public void setqCName(String qCName) {
		this.qCName = qCName;
	}
	/**
	 * @return the qCDesc
	 */
	public String getqCDesc() {
		return qCDesc;
	}
	/**
	 * @param qCDesc the qCDesc to set
	 */
	public void setqCDesc(String qCDesc) {
		this.qCDesc = qCDesc;
	}

}
