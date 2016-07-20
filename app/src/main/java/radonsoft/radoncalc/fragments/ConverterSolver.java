package radonsoft.radoncalc.fragments;

import java.math.BigDecimal;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;


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
            case "Speed":
                convertSpeed(inputValue);
                removeZerosFromFraction(outputValue);
                break;
        }
        exportDataToConverter = String.valueOf(outputValue);
    }

    public void convertLength(BigDecimal forConvert){
        switch (converter.firstMeasureInt){
            //centimeter
            case 0:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert;
                        break;
                    case 1:
                        outputValue = forConvert.divide(new BigDecimal(100), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(100000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case 1:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(100));
                        break;
                    case 1:
                        outputValue = forConvert;
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case 2:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(100000));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case 2:
                        outputValue = forConvert;
                        break;
                }
        }
    }

    public void convertWeight(BigDecimal forConvert){
        switch (converter.firstMeasureInt){
            case 0:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert;
                        break;
                    case 1:
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(1000000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case 1:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case 1:
                        outputValue = forConvert;
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case 2:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(1000000));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case 2:
                        outputValue = forConvert;
                        break;
                }
        }
    }

    public void convertSpeed(BigDecimal forConvert){
        switch (converter.firstMeasureInt){
            case 0:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert;
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(3.6));
                        break;
                    case 2:
                        outputValue = forConvert.multiply(new BigDecimal(2.23694));
                        break;
                }
                break;
            case 1:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.divide(new BigDecimal(3.6), 8, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 1:
                        outputValue = forConvert;
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(1.60934), 8, BigDecimal.ROUND_HALF_EVEN);
                        break;
                }
                break;
            case 2:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.divide(new BigDecimal(2.23694), 8, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(1.60934));
                        break;
                    case 2:
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
