package com.qwertyCraft;

import java.util.Map;

public class TileProperties {
	Integer localID;
	Integer globalID;
	String qCName;
	String qCDesc;
	Map<String,String> allProperties;
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
	/**
	 * @return the allProperties
	 */
	public Map<String, String> getAllProperties() {
		return allProperties;
	}
	/**
	 * @param allProperties the allProperties to set
	 */
	public void setAllProperties(Map<String, String> allProperties) {
		this.allProperties = allProperties;
	}
}
