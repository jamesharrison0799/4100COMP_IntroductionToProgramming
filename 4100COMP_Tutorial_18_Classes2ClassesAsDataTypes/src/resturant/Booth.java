package resturant;

public class Booth {
	
	int number;
	String party;
	int capacity;
	
	public Booth(int number, String party, int capacity) {
		this.number = number;
		this.party = party;
		this.capacity = capacity;
	}
	
	public String toString() {
		String string = "Number: " + number + " Party: " + party + " Capacity: " +  capacity;
		return string;
	}
	
	public String getParty() {
		return party;
	}
	
	public void setParty(String party) {
		this.party = party;
	}
}
