package task3;

public class Main {

	public static void main(String[] args) {

		try {
			ServiceJob.runJob("a.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
