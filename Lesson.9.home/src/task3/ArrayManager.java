package task3;

public class ArrayManager {

	private char symbol;
	private long count;

	public ArrayManager() {
		super();
	}

	public ArrayManager(char symbol, long count) {
		super();
		this.symbol = symbol;
		this.count = count;
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
}
