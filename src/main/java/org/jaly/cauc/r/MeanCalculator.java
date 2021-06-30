package org.jaly.cauc.r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 */
@Service
public class MeanCalculator {

    private static Logger LOGGER = LogManager.getLogManager().getLogger(MeanCalculator.class.getName());

    public static RConnection rcon;

    static {
        try {
            rcon = new RConnection("81.68.116.150");
        } catch (RserveException e) {
            LOGGER.log(Level.SEVERE, "Connect RServe fail: " + e.getMessage());
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
                rcon = new RConnection("81.68.116.150");
            } catch (RserveException e) {
                LOGGER.log(Level.SEVERE, "Connect RServe fail: " + e.getMessage());
                e.printStackTrace();
            }
        }
        try{
            String rexpString = "mean(c(" + first + "," + second + "))";
            System.out.println("rexpString => " + rexpString);
            return rcon.eval(rexpString).asDouble();
        }catch (RserveException | REXPMismatchException e) {
            LOGGER.log(Level.SEVERE, "Execute R statement fail: " + e.getMessage());
        }
        return 0;
    }

}
