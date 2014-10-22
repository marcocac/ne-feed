package model;

import java.util.HashMap;

public class Event {

	private String user; // FIXME usa oggetto user
	private String dataOperazione; // FIXME vedi che tipo definire
	private HashMap<String, String> eventData;// FIXME Definisci le key
												// predefinite della mappa

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDataOperazione() {
		return dataOperazione;
	}

	public void setDataOperazione(String dataOperazione) {
		this.dataOperazione = dataOperazione;
	}

	public HashMap<String, String> getEventData() {
		return eventData;
	}

	public void setEventData(HashMap<String, String> eventData) {
		this.eventData = eventData;
	}

}
