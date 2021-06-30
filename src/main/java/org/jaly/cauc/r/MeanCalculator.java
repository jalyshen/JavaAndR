package org.jaly.cauc.r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MeanCalculator {

    public static RConnection rcon;

    static {
        try {
            rcon = new RConnection();
        } catch (RserveException e) {
            e.printStackTrace();
        }
    }

    /**
     * first  -> 3,5,6 second -> 5,7,9 means  -> 4,6,7.5
     *
     * @param first
     * @param second
     */
    public double means(String first, String second) {
        if (rcon == null) {
            try {
                rcon = new RConnection();
            } catch (RserveException e) {
                e.printStackTrace();
            }
        }
        try{
            String rexpString = "mean(c(" + first + "," + second + "))";
            System.out.println("rexpString => " + rexpString);
            return rcon.eval(rexpString).asDouble();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
