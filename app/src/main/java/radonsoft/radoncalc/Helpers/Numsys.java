package radonsoft.radoncalc.Helpers;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Ruslan on 04.10.16.
 */
public class Numsys {
    public BigDecimal inputValue;
    public BigDecimal outputValue;
    public BigDecimal exportToSolver;
    public BigDecimal bufferization;
    public BigDecimal equal;
    public String output;
    public String output_final;
    public String buffer;

    public void convertToBinary() {
        output = "";
        while(!inputValue.equals(new BigDecimal(1))){
            bufferization = inputValue.divide(new BigDecimal(2));
            equal = bufferization.setScale(0, BigDecimal.ROUND_DOWN);
            if (bufferization.equals(equal)) {
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

}