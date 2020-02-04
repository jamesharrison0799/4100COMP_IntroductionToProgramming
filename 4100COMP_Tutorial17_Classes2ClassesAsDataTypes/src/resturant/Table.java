package resturant;

public class Table {

	int number;
	String party;
	
	public Table(int number, String party) {
		this.number = number;
		this.party = party;
	}
	
	public String toString() {
		String string = "Number: " + number + " Party: " + party;
		return string;
	}
	
	public String getParty() {
		return party;
	}
	
	public void setParty(String party) {
		this.party = party;
	}
}
