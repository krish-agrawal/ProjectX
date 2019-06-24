import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter{

    private Map<String,IUnit> avaliableUnits;
    private Scanner scanner;
    private IUnit sourceUnit;
    private IUnit targetUnit;
    private double sourceValue;
    private double targetValue;

    private void initalizeUnitList(){
        this.avaliableUnits.put("Miligrams", new Miligrams());
        this.avaliableUnits.put("Kilograms", new Kilograms());
    }

    private IUnit selectUnit(){
            int i = 0;
            ArrayList<IUnit> values = new ArrayList<IUnit>(this.avaliableUnits.values());

            for(Map.Entry<String, IUnit> entry : avaliableUnits.entrySet()) {
                i+=1;
                String  key   = entry.getKey();
                IUnit value = entry.getValue();
                System.out.println(i+" "+key);
            }
            int selected = this.scanner.nextInt();
            if(selected <= values.size()){
                return values.get(selected - 1);
            }else{
                System.out.println("Invalid Option");
                System.exit(0);
                return null;
            }
    }

    public UnitConverter(){
        this.avaliableUnits = new LinkedHashMap<String,IUnit>();
        this.scanner = new Scanner(System.in);
        this.initalizeUnitList();
    }

    public void setUnits(){
        System.out.println("Select Source Unit");
        this.sourceUnit = this.selectUnit();
        
        System.out.println("Select Target Unit");
        this.targetUnit = this.selectUnit();
    }

    public void readInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Source Weight");
        this.sourceValue = this.scanner.nextDouble();
    }
    
    public void convert(){
        double weightInGrams = this.sourceUnit.toGrams(this.sourceValue);
        this.targetValue = this.targetUnit.fromGrams(weightInGrams);
    }

    public double getTargetValue(){
        return this.targetValue;
    }
    public double getSourceValue(){
        return this.sourceValue;
    }
    public String toString(){
        String text;

        text = "---------------------------------\n";
        text += "Source Unit : "+this.sourceUnit+"\n";
        text += "Target Unit : "+this.targetUnit+"\n";
        text += "Source Value : "+this.sourceValue+"\n";
        text += "Target Value : "+this.targetValue+"\n";
        text += "---------------------------------\n";
        return text;
    
    }
    

    
}

