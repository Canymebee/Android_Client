package com.common.action;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Message {
	public Message(int userID, int targetID, String type, String content, JSONArray location)
			throws NumberFormatException, JSONException{
		this.UserID = userID;
		this.TargetID = targetID;
		this.MsgType = type;
		this.Content = content;
		this.Location_La = Float.parseFloat(location.get(0).toString());
		this.Location_Long = Float.parseFloat(location.get(1).toString());
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getTargetName() {
		return TargetName;
	}
	public void setTargetName(String targetName) {
		TargetName = targetName;
	}
	public int getTargetID() {
		return TargetID;
	}
	public void setTargetID(int targetID) {
		TargetID = targetID;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public float getLocation_La() {
		return Location_La;
	}
	public void setLocation_La(float location_La) {
		Location_La = location_La;
	}
	public float getLocation_Long() {
		return Location_Long;
	}
	public void setLocation_Long(float location_Long) {
		Location_Long = location_Long;
	}
	
	public JSONObject PackUpMessage(){
		JSONObject msg = new JSONObject();
		JSONArray location = new JSONArray();
		
		try {
			msg.put("Type",MsgType);
			msg.put("SenderID", UserID);
			msg.put("ReceiverID", TargetID);
			msg.put("Content", Content);
			msg.put("SenderID", UserID);
			location.put(Location_La).put(Location_Long);
			msg.put("Location", location);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}
	
/*	public Message DecodeMessage(JSONObject message){
		//Message msg = new Message(0,0,0,0,0);
		
	}*/
	
	private String UserName;
	private int UserID;
	private String TargetName;
	private int TargetID;
	private String MsgType;
	private String Content;
	private float Location_La;
	private float Location_Long;

}
