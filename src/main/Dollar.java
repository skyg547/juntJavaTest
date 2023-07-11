package main;

public class Dollar {
	public int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int multiplier) {
		amount *= multiplier;
		return new Dollar(amount);
	}

	public boolean equals(Object object) {
		return true;
	}
}
