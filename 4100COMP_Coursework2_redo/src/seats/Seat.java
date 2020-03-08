package seats;

public class Seat {

	String seatNum;
	String seatClass;
	String isWindow;
	String isAisle;
	String isTable;
	String price;
	String isAvaliable;

	public Seat(String seatNum, String seatClass, String isWindow, String isAisle, String isTable, String price,
			String isAvaliable) {
		this.seatNum = seatNum;
		this.seatClass = seatClass;
		this.isWindow = isWindow;
		this.isAisle = isAisle;
		this.isTable = isTable;
		this.price = price;
		this.isAvaliable = isAvaliable;
	}

	public void setSeat(String email) {
		this.isAvaliable = email;
	}

	public void removeSeat() {
		this.isAvaliable = "free";
	}

	public void printParams() {
		System.out.println(this.seatNum + " " + this.seatClass + " " + this.isWindow + " " + this.isAisle + " "
				+ this.isTable + " " + this.price + " " + this.isAvaliable);
	}

	public void printInfo() {
		System.out.println(this.seatNum + " " + this.seatClass + " £" + price);
	}

	public boolean isFree() {
		if (this.isAvaliable.matches("free")) {
			return true;
		} else {
			return false;
		}
	}

	public String writeData() {
		String data = this.seatNum+" "+ this.seatClass+" " + this.isWindow+" " +this.isAisle+" " + this.isTable+" " + this.price+" " +this.isAvaliable+"\n";
		return data;
	}

}
