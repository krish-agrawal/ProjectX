public class Kilograms implements IUnit{

	@Override
	public double toGrams(double kilograms){
		double grams;
		grams=kilograms*1000;
		return grams;
	}
	@Override
	public double fromGrams(double grams){
		return -1;
	}
	
}