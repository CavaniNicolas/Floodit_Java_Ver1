
public class Floodit {

	private final int size;
	private int[][] table;

	private int nbTries = 0;
	private final int nbTriesMax;
	
	private final int numValues;
	

	public Floodit() {
		this(12, 6, 24);
	}


	public Floodit(int size, int numValues, int nbTriesMax) {
		this.size = size;
		this.numValues = numValues;
		this.nbTriesMax = nbTriesMax;

		this.table = new int[this.size][this.size];

		for (int j=0; j<this.size; j++) {
			for (int i=0; i<this.size; i++) {
				this.table[j][i] = (int)(Math.random() * numValues + 1);
			}
		}
	}


	public void setNewFlood(int flood) {
		int first = this.table[0][0];
		if (flood != first && flood >= 1 && flood <= this.numValues) {
			this.nbTries ++;
			floodTable(first, flood, 0, 0);
		}
	}


	private void floodTable(int first, int flood, int j, int i) {
		if (j >= 0 && j < this.table.length && i >= 0 && i < this.table[j].length) {
			if (first == this.table[j][i]) {
				this.table[j][i] = flood;
				floodTable(first, flood, j + 1, i);
				floodTable(first, flood, j - 1, i);
				floodTable(first, flood, j, i + 1);
				floodTable(first, flood, j, i - 1);
			}
		}
	}


	public void displayTable() {
		
		String color = "\u001B[00m";
		System.out.print(color);
		System.out.println("\n Floodit   tries : " + this.nbTries + "/" + this.nbTriesMax + "\n");

		for (int[] j : this.table) {
			System.out.print(" ");
			for (int i : j) {
				color = "\u001B[3" + i + "m";
				System.out.print(color + i + " ");
			}
			System.out.println();
		}

		color = "\u001B[00m";
		System.out.println(color);
	}


	public boolean isWon() {
		boolean isWon = true;

		int j = 0;
		int i = 0;
		int first = this.table[0][0];

		while (isWon == true && j < this.table.length) {
			i = 0;
			while (isWon == true && i < this.table[j].length) {
				if (this.table[j][i] != first) {
					isWon = false;
				}
				i++;
			}
			j++;
		}

		return isWon;
	}


	public boolean isLost() {
		return this.nbTries >= nbTriesMax;
	}


	public void displayIsWon() {

		if (isLost()) {
			System.out.println("Perdu...");
		}
		if (isWon()) {
			System.out.println("Gagne !!");
		}

	}
}