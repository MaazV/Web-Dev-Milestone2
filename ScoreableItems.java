package CS231_Project;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ScoreableItems {
	private Map<String, Integer> itemScores= new HashMap<>();
	
	public ScoreableItems() {
		itemScores.put("item1",1);
		itemScores.put("item2",2);
		itemScores.put("item3",3);
		itemScores.put("item4",4);
		itemScores.put("item5",5);
		itemScores.put("item6",6);
		itemScores.put("item7",7);
		itemScores.put("item8",8);
		itemScores.put("item9",9);
		itemScores.put("item10",10);
		itemScores.put("item11",11);
		itemScores.put("item12",12);
	}
	
	public void displayCurrentItems() {
		Set<String> keys = itemScores.keySet();
		Iterator<String> iter = keys.iterator();
		
		System.out.println("Current items available:\n");
		while(iter.hasNext()) {
			String key = iter.next();
			System.out.println(key+" = "+itemScores.get(key)+" points");
		}
	}
	
	public int getItem(String key) {
		int score = itemScores.get(key);
		itemScores.remove(key);
		return score;
	}
}
