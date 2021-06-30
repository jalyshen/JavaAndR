package org.jaly.cauc.r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class TestRLib {

    public static void main(String[] args) throws RserveException, REXPMismatchException {
        RConnection rc = new RConnection();
        //调用myFunc函数
        rc.eval("install.packages(\"/usr/jaly/lib/Testing_0.1.0.tgz\", repos = NULL)");
        rc.eval("library(Testing)");
        REXP rexp=rc.eval("plusTwo(2)");
        System.out.println(rexp.asInteger());
//        double d[] = rc.eval("rnorm(10)").asDoubles();

        rc.close();//用完记得关闭连接
    }

}
