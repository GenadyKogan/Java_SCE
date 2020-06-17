public class HorseFactory {

	public static final int MUSTANG = 0;
	public static final int WHITE = 1;
	public static final int PONY = 2;

	
	public Horse getHorse(int horseType, int horseNumber, int distance) {

		if (horseType == 0) {
			return new Mustang(horseNumber,distance);

		} else if (horseType == 1) {
			return new White(horseNumber,distance);

		} else if (horseType == 2) {
			return new Pony(horseNumber,distance);
		}

		return null;
	}
}