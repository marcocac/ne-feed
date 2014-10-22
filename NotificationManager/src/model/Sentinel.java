package model;

import java.util.ArrayList;

public class Sentinel {

	private String user; // FIXME crea oggetto user
	private String type;
	private String description;
	private Sentinel child; //FIXME i child possono essere piu di uno ??
	private ArrayList<ConditionBase> conditions;
	private Notification notification;

	public Sentinel(){
		
	}
	
	public Sentinel(String user, Integer amount, String type,
			String description, Sentinel child,
			ArrayList<ConditionBase> conditions) {
		this.user = user;
		this.type = type;
		this.description = description;
		this.child = child;
		this.conditions = conditions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Sentinel getChild() {
		return child;
	}

	public void setChild(Sentinel child) {
		this.child = child;
	}

	public ArrayList<ConditionBase> getConditions() {
		return conditions;
	}

	public void setConditions(ArrayList<ConditionBase> conditions) {
		this.conditions = conditions;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Sentinel [user=" + user + ", type=" + type + ", description="
				+ description + ", child=" + child + ", conditions="
				+ conditions.toString() + "]";
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
}
