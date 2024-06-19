package june;

public class MaximumVolumeOfCuboid {
	public static void main(String[] args) {
		System.out.println(maxVolume(22, 15));
		System.out.println(maxVolume2(20, 5));
	}

	public static double maxVolume(double perimeter, double area) {
		double P = perimeter;
		double A = area;

		// Calculate the square root term
		double sqrtTerm = Math.sqrt(P * P - 24 * A);

		// Calculate dimensions
		double dimension1 = (P - sqrtTerm) / 12.0;
		double dimension2 = (P / 4.0) - 2 * dimension1;

		// Calculate volume
		double volume = Math.pow(dimension1, 2) * dimension2;

		// Round volume to 2 decimal places
		return Math.round(volume * 100.0) / 100.0;
	}

	public static double maxVolume2(double p, double a) {
		double l = (p - Math.sqrt(Math.pow(p, 2) - 24 * a)) / 12;
		double volume = ((p * Math.pow(l, 2)) - (8 * Math.pow(l, 3))) / 4;
		return Math.round(volume * 100.0) / 100.0;
	}
}
