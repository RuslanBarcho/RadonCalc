package radonsoft.radoncalc.Helpers;

import java.math.BigDecimal;

/**
 * Created by Ruslan on 04.10.16.
 */
public class Nymsystem {
    public BigDecimal inputValue;
    public BigDecimal outputValue;
    private String buffer;
    public String output;

    public void convertToBinary()
    {
        while(!inputValue.equals(0)){
            buffer = inputValue.divide(new BigDecimal(2), 50, BigDecimal.ROUND_CEILING).toString();
            if (buffer.contains(".")){
                output = "1" + output;
            }
        }
    }

}
