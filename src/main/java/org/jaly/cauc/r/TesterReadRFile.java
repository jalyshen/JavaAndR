package org.jaly.cauc.r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TesterReadRFile {
    public static void main(String[] args) throws RserveException, REXPMismatchException {
        RConnection rcon = new RConnection();
        double first = 5;
        double second = 9;
        String rExp = "m = mean(c("+first+","+second+"))";
        System.out.println("rExp = > " + rExp);
        //rcon.eval(rExp);
        REXP rexp=rcon.eval(rExp);
        double m1 = rcon.eval("solve(m)").asDouble();
        //返回类型是一个整数类型，所以用asInteger
        System.out.println(m1);
        rcon.close();//用完记得关闭连接
    }
}
