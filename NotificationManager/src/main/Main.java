package main;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import utils.Constants;
import model.ConditionBase;
import model.Sentinel;

public class Main {

	private static ArrayList<Sentinel> sentinels = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createSentinel();
		evalSentinel();
	}

	private static void evalSentinel() {
		//FIXME Filter by user or type??
		ArrayList<Sentinel> usersSentinels = filterSentinelByUser("test");
		//Scorro le sentinelle
		for(Sentinel tmp : usersSentinels){
			boolean sendNotification = true;
			//Scorro le condizioni della sentinella
			for(ConditionBase tmpCond : tmp.getConditions()){
				
				if(!evaluateCondition(tmpCond)){
					//Se una delle condizioni non è vera stop
					sendNotification = false;
					break;
				}
			}
			if(sendNotification){
				//FIXME vedi come gestire inoltro notifiche
				sendNotification(tmp);
			}
		}
		
	}


	private static void sendNotification(Sentinel tmp) {
		// TODO implementare logica notifiche
		System.out.println("Sending Notification for sentinel" + tmp.toString());
		if(tmp.getChild()!=null){
			Sentinel child = tmp.getChild();
			System.out.println("Sending Notification TO CHILD" + child.toString());
		}
		
	}

	private static ArrayList<Sentinel> filterSentinelByUser(String string) {
		
		Iterable<Sentinel> filtered = Iterables.filter(sentinels, new Predicate<Sentinel>() {
		    @Override
		    public boolean apply(Sentinel p) {
		        return sentinels.contains(p.getUser());
		    }
		});
		ArrayList<Sentinel> filteredCopy = Lists.newArrayList(filtered);
		return filteredCopy;
	}

	private static boolean evaluateCondition(ConditionBase tmpCond) {
		boolean result = false;
		//TODO
		return result;
	}

	private static void createSentinel() {
		sentinels = new ArrayList<Sentinel>();
		for (int i = 0; i < 50; i++) {
			Sentinel tmp = new Sentinel();
			tmp.setUser("test");
			tmp.setConditions(getFakeConditions());
			sentinels.add(tmp);
		}

		Sentinel tmp = new Sentinel();
		tmp.setUser("test");
		ConditionBase tmpCond = new ConditionBase();
		tmpCond.setConditionType(Constants.ConditionType.MAGGIORE);
		tmpCond.setConditionVar(Constants.ConditionVar.AMOUNT);
		tmpCond.setValue(100);
		tmp.setConditions(get1MoreCondition());
		
		for (int i = 0; i < 50; i++) {
			tmp = new Sentinel();
			tmp.setUser("test1");
			tmp.setConditions(getFakeConditions());
			sentinels.add(tmp);
		}
//		System.out.println(sentinels.toString());
	}

	private static ArrayList<ConditionBase> getFakeConditions() {
		ArrayList<ConditionBase> tmp = new ArrayList<ConditionBase>();
		for (int k = 0; k < 3; k++) {
			ConditionBase tmpCond = new ConditionBase();
			tmpCond.setConditionType(Constants.ConditionType.MAGGIORE);
			tmpCond.setConditionVar(Constants.ConditionVar.AMOUNT);
			tmpCond.setValue(100);
			tmp.add(tmpCond);
		}
		return tmp;
	}

	private static ArrayList<ConditionBase> get1MoreCondition() {
		ArrayList<ConditionBase> tmp = new ArrayList<ConditionBase>();
		ConditionBase tmpCond = new ConditionBase();
		tmpCond.setConditionType(Constants.ConditionType.MAGGIORE);
		tmpCond.setConditionVar(Constants.ConditionVar.AMOUNT);
		tmpCond.setValue(100);
		tmp.add(tmpCond);
		return tmp;
	}
}
