package org.jaly.cauc.core;

import org.jaly.cauc.r.MeanCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 调用R的类库，计算数组的均值
 */
@Service
public class MeansCalculatorService {

    @Autowired
    private MeanCalculator meanCalculator;
    /**
     *
     * @param firstGroupData
     * @param secondGroupData
     * @return
     */
    public List<Double> means(String[] firstGroupData, String[] secondGroupData) {
        List<Double> result = new ArrayList<>();
        int amount = firstGroupData.length;
        for(int i=0;i<amount;i++) {
            result.add(meanCalculator.means(firstGroupData[i], secondGroupData[i]));
        }
        return result;
    }
}
