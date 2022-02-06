package org.doushu.boot.common;

import org.doushu.boot.common.constants.CommonConstant;

import java.util.HashMap;
import java.util.Map;

public class ZiWeiCommonService {

    /**
     * 获取出生年天干地支
     *
     * @param year 出生年
     * @return 天干地支
     */
    public static String getHeavenlyAndEarthly(String year) {
        int heavenlyValue = (int) ((Long.valueOf(year) + 6) % 10);
        String heavenlyStr = CommonConstant.HEAVENLY_CONSTANT[heavenlyValue];
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        // 出生年天干地支
        String yearHeavenlyAndEarthly = heavenlyStr + earthlyStr;
        return yearHeavenlyAndEarthly;
    }

    public static Map<String,String> zeroMap = new HashMap<>();
    public static Map<String,String> oneMap = new HashMap<>();
    public static Map<String,String> secondMap = new HashMap<>();
    public static Map<String,String> thirdMap = new HashMap<>();
    public static Map<String,String> fourMap = new HashMap<>();
    public static Map<String,String> fiveMap = new HashMap<>();
    public static Map<String,String> sixMap = new HashMap<>();
    public static Map<String,String> sevenMap = new HashMap<>();
    public static Map<String,String> eightMap = new HashMap<>();
    public static Map<String,String> nineMap = new HashMap<>();
    public static Map<String,String> tenMap = new HashMap<>();
    public static Map<String,String> eleMap = new HashMap<>();

    static {
        zeroMap.put("巨门","●");
        zeroMap.put("太阳","●");
        zeroMap.put("贪狼","●");
        zeroMap.put("天机","▲");
        zeroMap.put("太阴","▲");
        zeroMap.put("紫微","●");
        zeroMap.put("天府","●");
        zeroMap.put("破军","▲");
        zeroMap.put("廉贞","●");
        zeroMap.put("七杀","●");
        zeroMap.put("天同","●");
        zeroMap.put("天梁","●");
        zeroMap.put("武曲","●");
        zeroMap.put("天相","●");

        oneMap.put("天相","▲");
        oneMap.put("巨门","●");
        oneMap.put("天机","●");
        oneMap.put("紫微","●");
        oneMap.put("贪狼","●");
        oneMap.put("太阴","X");
        oneMap.put("天府","▲");
        oneMap.put("廉贞","▲");
        oneMap.put("破军","▲");
        oneMap.put("天同","▲");
        oneMap.put("武曲","●");
        oneMap.put("七杀","●");
        oneMap.put("太阳","●");
        oneMap.put("天梁","●");


        secondMap.put("天相","▲");
        secondMap.put("巨门","X");
        secondMap.put("天机","●");
        secondMap.put("紫微","▲");
        secondMap.put("贪狼","●");
        secondMap.put("太阴","X");
        secondMap.put("天府","●");
        secondMap.put("廉贞","●");
        secondMap.put("破军","▲");
        secondMap.put("天同","▲");
        secondMap.put("武曲","●");
        secondMap.put("七杀","▲");
        secondMap.put("太阳","●");
        secondMap.put("天梁","●");

        thirdMap.put("天相","▲");
        thirdMap.put("巨门","X");
        thirdMap.put("天机","▲");
        thirdMap.put("紫微","●");
        thirdMap.put("贪狼","X");
        thirdMap.put("太阴","X");
        thirdMap.put("天府","●");
        thirdMap.put("廉贞","X");
        thirdMap.put("破军","●");
        thirdMap.put("天同","▲");
        thirdMap.put("武曲","●");
        thirdMap.put("七杀","●");
        thirdMap.put("太阳","●");
        thirdMap.put("天梁","X");

        fourMap.put("天相","●");
        fourMap.put("巨门","●");
        fourMap.put("天机","●");
        fourMap.put("紫微","●");
        fourMap.put("贪狼","●");
        fourMap.put("太阴","X");
        fourMap.put("天府","●");
        fourMap.put("廉贞","●");
        fourMap.put("破军","●");
        fourMap.put("天同","X");
        fourMap.put("武曲","●");
        fourMap.put("七杀","●");
        fourMap.put("太阳","●");
        fourMap.put("天梁","●");

        fiveMap.put("天相","▲");
        fiveMap.put("巨门","X");
        fiveMap.put("天机","▲");
        fiveMap.put("紫微","●");
        fiveMap.put("贪狼","●");
        fiveMap.put("太阴","▲");
        fiveMap.put("天府","●");
        fiveMap.put("廉贞","●");
        fiveMap.put("破军","●");
        fiveMap.put("天同","X");
        fiveMap.put("武曲","●");
        fiveMap.put("七杀","●");
        fiveMap.put("太阳","▲");
        fiveMap.put("天梁","●");

        sixMap.put("天相","▲");
        sixMap.put("巨门","▲");
        sixMap.put("天机","▲");
        sixMap.put("紫微","●");
        sixMap.put("贪狼","●");
        sixMap.put("太阴","▲");
        sixMap.put("天府","●");
        sixMap.put("廉贞","●");
        sixMap.put("破军","▲");
        sixMap.put("天同","●");
        sixMap.put("武曲","▲");
        sixMap.put("七杀","●");
        sixMap.put("太阳","▲");
        sixMap.put("天梁","●");

        sevenMap.put("天相","▲");
        sevenMap.put("巨门","▲");
        sevenMap.put("天机","▲");
        sevenMap.put("紫微","●");
        sevenMap.put("贪狼","●");
        sevenMap.put("太阴","●");
        sevenMap.put("天府","●");
        sevenMap.put("廉贞","X");
        sevenMap.put("破军","X");
        sevenMap.put("天同","▲");
        sevenMap.put("武曲","●");
        sevenMap.put("七杀","●");
        sevenMap.put("太阳","▲");
        sevenMap.put("天梁","▲");

        eightMap.put("天相","▲");
        eightMap.put("巨门","X");
        eightMap.put("天机","●");
        eightMap.put("紫微","▲");
        eightMap.put("贪狼","●");
        eightMap.put("太阴","●");
        eightMap.put("天府","●");
        eightMap.put("廉贞","●");
        eightMap.put("破军","▲");
        eightMap.put("天同","▲");
        eightMap.put("武曲","●");
        eightMap.put("七杀","●");
        eightMap.put("太阳","X");
        eightMap.put("天梁","●");

        nineMap.put("天相","●");
        nineMap.put("巨门","●");
        nineMap.put("天机","▲");
        nineMap.put("紫微","●");
        nineMap.put("贪狼","●");
        nineMap.put("太阴","●");
        nineMap.put("天府","▲");
        nineMap.put("廉贞","●");
        nineMap.put("破军","▲");
        nineMap.put("天同","X");
        nineMap.put("武曲","●");
        nineMap.put("七杀","●");
        nineMap.put("太阳","X");
        nineMap.put("天梁","X");

        tenMap.put("天相","●");
        tenMap.put("巨门","●");
        tenMap.put("天机","●");
        tenMap.put("紫微","●");
        tenMap.put("贪狼","●");
        tenMap.put("太阴","●");
        tenMap.put("天府","●");
        tenMap.put("廉贞","●");
        tenMap.put("破军","●");
        tenMap.put("天同","●");
        tenMap.put("武曲","●");
        tenMap.put("七杀","●");
        tenMap.put("太阳","X");
        tenMap.put("天梁","●");

        eleMap.put("天相","▲");
        eleMap.put("巨门","X");
        eleMap.put("天机","▲");
        eleMap.put("紫微","●");
        eleMap.put("贪狼","●");
        eleMap.put("太阴","▲");
        eleMap.put("天府","●");
        eleMap.put("廉贞","X");
        eleMap.put("破军","●");
        eleMap.put("天同","X");
        eleMap.put("武曲","●");
        eleMap.put("七杀","X");
        eleMap.put("太阳","▲");
        eleMap.put("天梁","▲");

    }
}
