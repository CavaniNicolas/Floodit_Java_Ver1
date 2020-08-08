
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Floodit floodit = new Floodit();
		floodit.displayTable();

		int flood = 0;

		while (!floodit.isWon() && !floodit.isLost()) {
			
			try {
				flood = sc.nextInt();
				sc.nextLine();
				floodit.setNewFlood(flood);
				
			} catch (InputMismatchException e) {
				System.out.println("Ce n'est pas un int...");
				sc.nextLine();
			}

			floodit.displayTable();
		}

		floodit.displayIsWon();
		sc.close();
	}
}