package radonsoft.radoncalc.Helpers;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Ruslan on 04.10.16.
 */
public class Numsys {
    public BigDecimal inputValue;
    public BigInteger inputValueInt;
    public BigInteger bufferIntRem;
    public BigDecimal exportToSolver;
    public BigDecimal buffer;
    public BigDecimal equal;
    public String output;
    public String inputToStr;

    public void convertToBinary() {
        output = "";
        while(!inputValue.equals(new BigDecimal(1))){
            buffer = inputValue.divide(new BigDecimal(2));
            equal = buffer.setScale(0, BigDecimal.ROUND_DOWN);
            if (buffer.equals(equal)) {
                output = "0" + output;
            }
            else {
                output = "1" + output;
            }
            inputValue = equal;
        }
        output = "1" + output;
        exportToSolver = new BigDecimal(String.valueOf(output));
    }

    public void convertToNumsys(String getNumSys){
        output = "";
        inputValueInt = inputValue.toBigInteger();
        int res = inputValueInt.compareTo(new BigInteger(getNumSys));
        while(res == 1 || res == 0) {
            bufferIntRem = inputValueInt.remainder(new BigInteger(getNumSys));
            output = bufferIntRem.toString() + output;
            inputValueInt = inputValueInt.divide(new BigInteger(getNumSys));
            res = inputValueInt.compareTo(new BigInteger(getNumSys));
        }
        output = inputValueInt.toString() + output;
        exportToSolver = new BigDecimal(String.valueOf(output));
    }

    public void convertToDecimal(String getNumSys) {
        inputToStr = inputValue.toString();
        BigInteger localbuff = new BigInteger("0");
        BigInteger localbuffone;
        BigInteger localbuffthree = new BigInteger(getNumSys);
        if (inputToStr.length() == 1) {
            exportToSolver = inputValue;
        }
        else {
            int localcount = 0;
            while (inputToStr.length()>0){
                char localchar = inputToStr.charAt(inputToStr.length()-1);
                localbuffone = new BigInteger((String.valueOf(localchar)));
                localbuff = localbuff.add(localbuffone.multiply(localbuffthree.pow(localcount)));
                localcount++;
                inputToStr = inputToStr.substring(0, inputToStr.length() - 1);
            }
            exportToSolver = new BigDecimal(localbuff);
        }
    }
}