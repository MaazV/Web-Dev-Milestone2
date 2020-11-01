package CS231_Project;

public class Location {
	
	private String currentPosition;
	private String optionNorth;
	private String optionSouth;
	private String optionEast;
	private String optionWest;
	private String item;
	public boolean printItems;
	
	public Location(String initialPosition) {
		this.currentPosition = initialPosition;
		optionNorth = "";
		optionEast = "";
		optionSouth = "";
		optionWest = "";
		this.item = "";
		this.printItems=false;
	}
	
	public void handleMove(String direction) {
		if (getCurrentPosition().equals("Outside")) {
			handleOutsideMove(direction);
		} else if (getCurrentPosition().equals("Living Room")) {
			handleLivingRoomMove(direction);
		} else if (getCurrentPosition().equals("Kitchen")) {
			handleKitchenMove(direction);
		} else if (getCurrentPosition().equals("Bedroom")) {
			handleBedroomMove(direction);
		} else if (getCurrentPosition().equals("Studio")) {
			handleStudioMove(direction);
		}

	}
	
	private String handleOutsideMove(String direction) {
		if(direction.equals("items")) {
			this.printItems=true;
			setOutsideOptions();
		}
		else if (direction.equals("get in") || direction.equals("east") || direction.equals("e")) {
			setLivingRoomOptions();
		} else {
			System.out.println("Sorry. I don't understand your command.");
		}
		return "";
	}
	
	private void handleLivingRoomMove(String direction) {
		if(direction.equals("items")) {
			this.printItems=true;
			setLivingRoomOptions();
		}
		else if (direction.equals("north") || direction.equals("n")) {
			setKitchenOptions();
		} else if (direction.equals("east") || direction.equals("e")) {
			setStudioOptions();
		} else if (direction.equals("south") || direction.equals("s")) {
			setBedroomOptions();
		} else if (direction.equals("west") || direction.equals("w")) {
			setOutsideOptions();
		} else {
			System.out.println("Sorry. I don't understand your command.");
		}
	}

	private void handleKitchenMove(String direction) {
		if(direction.equals("items")) {
			this.printItems=true;
			setKitchenOptions();
		}
		else if (direction.equals("south") || direction.equals("s")) {
			setLivingRoomOptions();
		} else if (direction.equals("north") || direction.equals("n") || direction.equals("east") || direction.equals("e") || direction.equals("west") || direction.equals("w")) {
			System.out.println("Oops. Nothing in that direction.");
		} else {
			System.out.println("Sorry. I don't understand your command.");
		}
		
	}
	
	private void handleStudioMove(String direction) {
		if(direction.equals("items")) {
			this.printItems=true;
			setStudioOptions();
		}
		else if (direction.equals("west") || direction.equals("w")) {
			setLivingRoomOptions();
		} else if (direction.equals("north") || direction.equals("n") || direction.equals("east") || direction.equals("e") || direction.equals("south") || direction.equals("s")) {
			System.out.println("Oops. Nothing in that direction.");
		} else {
			System.out.println("Sorry. I don't understand your command.");
		}
	}
	
	private void handleBedroomMove(String direction) {
		if(direction.equals("items")) {
			this.printItems=true;
			setBedroomOptions();
		}
		else if (direction.equals("north") || direction.equals("n")) {
			setLivingRoomOptions();
		} else if (direction.equals("east") || direction.equals("e") || direction.equals("south") || direction.equals("s") || direction.equals("west") || direction.equals("w")) {
			System.out.println("Oops. Nothing in that direction.");
		} else {
			System.out.println("Sorry. I don't understand your command.");
		}
	}
	
	private void setLivingRoomOptions() {
		currentPosition = "Living Room";
		optionNorth = "Kitchen";
		optionEast = "Studio";
		optionSouth = "Bedroom";
		optionWest = "Outside";
		item="item1";
	}
	
	private void setKitchenOptions() {
		currentPosition = "Kitchen";
		optionNorth = "";
		optionEast = "";
		optionSouth = "Living Room";
		optionWest = "";
		item="item2";
	}
	
	private void setStudioOptions() {
		currentPosition = "Studio";
		optionNorth = "";
		optionEast = "";
		optionSouth = "";
		optionWest = "Living Room";
		item="item3";
	}
	
	private void setBedroomOptions() {
		currentPosition = "Bedroom";
		optionNorth = "Living Room";
		optionEast = "";
		optionSouth = "";
		optionWest = "";
		item="item4";
	}
	
	private void setOutsideOptions() {
		currentPosition = "Outside";
		optionNorth = "";
		optionEast = "Living Room";
		optionSouth = "";
		optionWest = "";
		item="item5";
	}
	
	public void printCurrentOptions() {
		System.out.format("You are currently at %s.\nEnter \"items\" to view your items and score\n\n", getCurrentPosition());
	}
	
	
	public void printItem() {
		System.out.format("You see a %s on the ground and pick it up.\n\n",item);
	}
	
	public void printDirections() {
		System.out.format("Your north: %s\nYour east: %s\nYour south: %s\nYour west: %s\nType some direction to get going!\n",optionNorth, optionEast, optionSouth, optionWest);
	}
	

	
	public String getCurrentPosition() {
		return this.currentPosition;
	}
	
	public String getItem() {
		return this.item;
	}
}
