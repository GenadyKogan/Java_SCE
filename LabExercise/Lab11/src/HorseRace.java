import java.util.Scanner;
public class HorseRace {
	Horse[] horses;
	HorseFactory horseFactory=new HorseFactory();
	int distance;
	private static HorseRace RaceInstance = null;
	private HorseRace() {
		horses = new Horse[10];
	}
	public static HorseRace getRaceInstance() {
		if (RaceInstance == null)
			RaceInstance = new HorseRace();
		return RaceInstance;

	}
	public void prepareRace() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter race distance and press ENTER to start!");
		distance = scan.nextInt();

		// initialize
		for (int i = 0; i < horses.length; i++) {
			horses[i] = horseFactory.getHorse(i%3, i, distance);
		}

		scan.close();
	}
	
	public void startRace() {
		//start
		for (int i = 0; i < horses.length; i++) {
			horses[i].start();
		}
		// loop through all and display winners
		int first, second, third;
		String firstName = "error", secondName = "error", thirdName = "error";
		boolean flag = true;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (flag) {
			first = distance;
			second = distance;
			third = distance;

			for (int i = 0; i < horses.length; i++) {
				if (horses[i].getDistance() < first) {
					third = second;
					thirdName = secondName;
					second = first;
					secondName = firstName;
					first = horses[i].getDistance();
					firstName = horses[i].getName();				
				} else if (horses[i].getDistance() < second) {
					third = second;
					thirdName = secondName;
					second = horses[i].getDistance();
					secondName = horses[i].getName();
				} else if (horses[i].getDistance() < third) {
					third = horses[i].getDistance();
					thirdName = horses[i].getName();
				}
			}

			if (first < 0)
				first = 0;
			if (second < 0)
				second = 0;
			if (third < 0)
				third = 0;
			System.out.println("\n#1: " + firstName + " | Distance Left: "
					+ first);
			System.out.println("#2: " + secondName + " | Distance Left: "
					+ second);
			System.out.println("#3: " + thirdName + " | Distance Left: "
					+ third);
			if (first < 1)
				flag = false;
			else
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
		}
		System.out.println("\n\n------------------FINISH----------------");
	}
	
	
	
}
