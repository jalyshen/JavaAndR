package org.jaly.cauc.api;

import org.jaly.cauc.api.dto.MeansRequest;
import org.jaly.cauc.api.dto.MeansResponse;
import org.jaly.cauc.core.MeansCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 计算均值的API接口
 */
@RestController
@CrossOrigin
public class CalculateMeansController {

    @Autowired
    private MeansCalculatorService meanService;

    @PostMapping(path = "/calculateMeans")
    public MeansResponse calcuateMeans(@RequestBody MeansRequest request) {
        MeansResponse means = new MeansResponse();
        String[] firstStr = request. firstGroupData.split(",");
        String[] secondStr = request.secondGroupData.split(",");
        // 二者长度需要一致，否则提示错误
        if (firstStr.length != secondStr.length) {
            // 需要返回，并给出错误代码
            means.errCode = 501; //数据不对齐
            means.errMsg = "两组数据个数必须一致";
            means.meansReuslt = new ArrayList<>();
            return means;
        }
        means.meansReuslt = meanService.means(firstStr, secondStr);
        means.highTemp = Arrays.stream(firstStr)
                               .map(num -> Double.parseDouble(num))
                               .collect(Collectors.toList());
        means.lowTemp = Arrays.stream(secondStr)
                               .map(num -> Double.parseDouble(num))
                               .collect(Collectors.toList());
        return means;
    }
}
