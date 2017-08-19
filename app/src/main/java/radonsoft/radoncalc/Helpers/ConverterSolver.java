package radonsoft.radoncalc.Helpers;

import java.math.BigDecimal;

import radonsoft.radoncalc.MainActivity;
import radonsoft.radoncalc.R;
import radonsoft.radoncalc.fragments.converter;


/**
 * Created by Ruska on 14.07.2016.
 */
public class ConverterSolver {
    public BigDecimal inputValue;
    public static String exportDataToConverter;
    public BigDecimal outputValue;
    public void convert(){

        switch (converter.valueIDInt){
            case 0:
                convertLength(inputValue);
                removeZerosFromFraction(outputValue);
                break;
            case 1:
                convertWeight(inputValue);
                removeZerosFromFraction(outputValue);
                break;
            case 2:
                convertSpeed(inputValue);
                removeZerosFromFraction(outputValue);
                break;
            case 3:
                convertNumSys(inputValue);
                break;
        }
        exportDataToConverter = String.valueOf(outputValue);
    }
    public void convertNumSys(BigDecimal forConvert){
        Numsys numsys = new Numsys();
        numsys.inputValue = inputValue;
        switch (converter.firstMeasureInt){
            case 0:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert;
                        break;
                    case 1:
                        numsys.convertToBinary();
                        outputValue = numsys.exportToSolver;
                }
                break;
            case 1:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert;
                        break;
                    case 1:
                        outputValue = forConvert;
                }
        }
    }

    public void convertLength(BigDecimal forConvert){
        switch (converter.firstMeasureInt){
            case 0:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert;
                        break;
                    case 1:
                        outputValue = forConvert.divide(new BigDecimal(10), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 3:
                        outputValue = forConvert.divide(new BigDecimal(1000000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 4:
                        outputValue = forConvert.multiply(new BigDecimal(0.00328084));
                        break;
                    case 5:
                        outputValue = forConvert.multiply(new BigDecimal(0.0393701));
                        break;
                }
                break;
            case 1:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(10));
                        break;
                    case 1:
                        outputValue = forConvert;
                        break;
                    case 2:
                        outputValue = forConvert.divide(new BigDecimal(100), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 3:
                        outputValue = forConvert.divide(new BigDecimal(100000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 4:
                        outputValue = forConvert.multiply(new BigDecimal(0.0328084));
                        break;
                    case 5:
                        outputValue = forConvert.multiply(new BigDecimal(0.393701));
                        break;
                }
                break;
            case 2:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(1000));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(100));
                        break;
                    case 2:
                        outputValue = forConvert;
                        break;
                    case 3:
                        outputValue = forConvert.divide(new BigDecimal(1000), 12, BigDecimal.ROUND_HALF_EVEN);
                        break;
                    case 4:
                        outputValue = forConvert.multiply(new BigDecimal(3.28084));
                        break;
                    case 5:
                        outputValue = forConvert.multiply(new BigDecimal(39.3701));
                        break;
                }
                break;
            case 3:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(1000000));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(100000));
                        break;
                    case 2:
                        outputValue = forConvert.multiply(new BigDecimal(10000));
                        break;
                    case 3:
                        outputValue = forConvert;
                        break;
                    case 4:
                        outputValue = forConvert.multiply(new BigDecimal(3280.84));
                        break;
                    case 5:
                        outputValue = forConvert.multiply(new BigDecimal(39370.1));
                        break;
                }
                break;
            case 4:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(304.8));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(30.48));
                        break;
                    case 2:
                        outputValue = forConvert.multiply(new BigDecimal(0.3048));
                        break;
                    case 3:
                        outputValue = forConvert.multiply(new BigDecimal(0.0003048));
                        break;
                    case 4:
                        outputValue = forConvert;
                        break;
                    case 5:
                        outputValue = forConvert.multiply(new BigDecimal(12));
                        break;
                }
                break;
            case 5:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(25.4));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(2.54));
                        break;
                    case 2:
                        outputValue = forConvert.multiply(new BigDecimal(0.0254));
                        break;
                    case 3:
                        outputValue = forConvert.multiply(new BigDecimal(0.0000254));
                        break;
                    case 4:
                        outputValue = forConvert.multiply(new BigDecimal(0.0833333));
                        break;
                    case 5:
                        outputValue = forConvert;
                        break;
                }
                break;
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
                    case 3:
                        outputValue = forConvert.multiply(new BigDecimal(1.94384));
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
                    case 3:
                        outputValue = forConvert.multiply(new BigDecimal(0.539957));
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
                    case 3:
                        outputValue = forConvert.multiply(new BigDecimal(0.868976));
                        break;
                }
                break;
            case 3:
                switch (converter.secondMeasureInt){
                    case 0:
                        outputValue = forConvert.multiply(new BigDecimal(0.514444));
                        break;
                    case 1:
                        outputValue = forConvert.multiply(new BigDecimal(1.852));
                        break;
                    case 2:
                        outputValue = forConvert.multiply(new BigDecimal(1.15078));
                        break;
                    case 3:
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
