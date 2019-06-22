import java.util.Scanner;

public class Application{

      public static void main(String[] args){
        UnitConverter unitConverter = new UnitConverter();
        
        unitConverter.setUnits();
        unitConverter.readInput();
        unitConverter.convert();
        System.out.println("Target Value : "+unitConverter.getTargetValue());
        System.out.println(unitConverter);
    }
}