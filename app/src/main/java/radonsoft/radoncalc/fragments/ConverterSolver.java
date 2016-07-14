package radonsoft.radoncalc.fragments;

import java.math.BigDecimal;

import radonsoft.radoncalc.MainActivity;

/**
 * Created by Ruska on 14.07.2016.
 */
public class ConverterSolver {
    public BigDecimal inputValue;
    public String valueID;
    public String measureOneID;
    public String measureTwoID;
    public static String exportDataToConverter;
    public BigDecimal outputValue;
    public void convert(){
        switch (valueID){
            case "Length":
                convertLength(inputValue);
                removeZerosFromFraction(outputValue);
                break;
        }
        exportDataToConverter = String.valueOf(outputValue);
    }
    public void convertLength(BigDecimal forConvert){
        switch (measureOneID){
            case "Centimeter":
                switch (measureTwoID){
                    case "Centimeter":
                        outputValue = forConvert;
                        break;
                    case "Meter":
                        outputValue = forConvert.divide(new BigDecimal(100), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case "Kilometer":
                        outputValue = forConvert.divide(new BigDecimal(100000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }

                break;
        }
    }
    public void removeZerosFromFraction(BigDecimal ToRemove){
        BigDecimal toRemoveChecker = ToRemove.setScale(0, BigDecimal.ROUND_DOWN);
        if (ToRemove.equals(toRemoveChecker)){

        }
        else {
            String ZeroRemoval = String.valueOf(ToRemove);
            if (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '0') {
                do {
                    ZeroRemoval = (ZeroRemoval.substring(0, ZeroRemoval.length() - 1));
                }
                while (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '0');
                if (ZeroRemoval.charAt(ZeroRemoval.length() - 1) == '.') {
                    ZeroRemoval = (ZeroRemoval.substring(0, ZeroRemoval.length() - 1));
                }
                outputValue = new BigDecimal(String.valueOf(ZeroRemoval));
            }
        }
    }
}
