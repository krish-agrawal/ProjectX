public class Milligrams implements IUnit {
	public double fromGrams(double source) {
		source *= 1000;
		
		return source;
	}
}