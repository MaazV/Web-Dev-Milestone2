package CS231_Project;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private String name;
	private Location location;
	private List<String> items;
	private int score;
	private List<String> visitedLocations;
	
	public User(String name) {
		this.name = name;
		this.location = new Location("Outside");
		items = new ArrayList<String>();
		this.visitedLocations = new ArrayList<String>();
	}
	
	public void move(String direction) {
		location.handleMove(direction);
		getItem();
	}
	
	private void getItem() {
		ScoreableItems scoreableitems = new ScoreableItems();
		String newItem = location.getItem();
		boolean flag = true;
		if(location.getCurrentPosition()!="Living ") {
			for(String item:items) {
				if(item==newItem) {
					flag=false;
				}
			}
			if(flag) {
				items.add(newItem);
				score+=scoreableitems.getItem(newItem);
			}
		}
	}

	public String getName() {
		return name;
	}
	
	public void print() {
		if(location.printItems) {
			System.out.println("Items: "+items);
			System.out.println("Score: "+score+"\n");
			System.out.println("Enter direction:\n");
			location.printItems=false;
		}
		else {
			location.printCurrentOptions();
			if(!visitedLocations.contains(location.getCurrentPosition())) {
				location.printItem();
			}		
			location.printDirections();
			visitedLocations.add(location.getCurrentPosition());
		}
	}
}
