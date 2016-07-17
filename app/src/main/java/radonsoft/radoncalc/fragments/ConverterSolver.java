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
            case "Weight":
                convertWeight(inputValue);
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
            case "Meter":
                switch (measureTwoID){
                    case "Centimeter":
                        outputValue = forConvert.multiply(new BigDecimal(100));
                        break;
                    case "Meter":
                        outputValue = forConvert;
                        break;
                    case "Kilometer":
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case "Kilometer":
                switch (measureTwoID){
                    case "Centimeter":
                        outputValue = forConvert.multiply(new BigDecimal(100000));
                        break;
                    case "Meter":
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case "Kilometer":
                        outputValue = forConvert;
                        break;
                }
        }
    }

    public void convertWeight(BigDecimal forConvert){
        switch (measureOneID){
            case "Gram":
                switch (measureTwoID){
                    case "Gram":
                        outputValue = forConvert;
                        break;
                    case "Kilogram":
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case "Ton":
                        outputValue = forConvert.divide(new BigDecimal(1000000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case "Kilogram":
                switch (measureTwoID){
                    case "Gram":
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case "Kilogram":
                        outputValue = forConvert;
                        break;
                    case "Ton":
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case "Ton":
                switch (measureTwoID){
                    case "Gram":
                        outputValue = forConvert.multiply(new BigDecimal(1000000));
                        break;
                    case "Kilogram":
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case "Ton":
                        outputValue = forConvert;
                        break;
                }
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
