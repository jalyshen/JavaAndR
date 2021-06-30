package org.jaly.cauc.r;

import org.rosuda.REngine.Rserve.RConnection;

public class Tester {

    public static void main(String[] args) {
        RConnection rcon = null;
        try {
            // 建立与 Rserve 的连接
            rcon = new RConnection();

            // eval() 函数用于令 R 执行 R 语句
            // 此处制造了一个 m1 矩阵
            rcon.eval("m1 = matrix(c(1, 2, 3, 4), 2, 2, byrow=TRUE)");

            // solve() 函数在 R 中求 m1 矩阵的逆矩阵
            // 并将结果返回，asDoubleMatrix 函数可以将数据转换成
            // Java 中的 double 二维数组以表示矩阵
            double[][] m1 = rcon.eval("solve(m1)").asDoubleMatrix();

            // 输出矩阵的内容
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    System.out.print(m1[i][j] + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rcon != null) {
                rcon.close();
            }
        }
    }
}
