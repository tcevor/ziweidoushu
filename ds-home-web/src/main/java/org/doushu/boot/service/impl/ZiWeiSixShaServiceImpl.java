package org.doushu.boot.service.impl;

import org.doushu.boot.common.constants.CommonConstant;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.service.ZiWeiSixShaService;
import org.springframework.stereotype.Service;

@Service
public class ZiWeiSixShaServiceImpl implements ZiWeiSixShaService {

    public String[] getSixShaThHtmlData(BirthQuery birthData,int location){
        String[] str = new String[6];
        for (int index = 0; index < str.length; index++) {
            str[index] = "";
        }
        // 火星铃星
        int huoxingLocation = getHuoxingLocation(birthData.getYear(), birthData.getHour());
        int lingxingLocationg = getLingxingLocation(birthData.getYear(), birthData.getHour());

        // 地空地劫
        int dikongLocation = getDikongLocation(birthData.getHour());
        int dijieLocation = getDijieLocation(birthData.getHour());

        // 禄存，擎羊，陀罗
        int lucunLocation = getLucunLocation(birthData.getYear());
        int qingyangLocation = lucunLocation + 1;
        int tuoluoLocation = lucunLocation - 1 >= 0 ? lucunLocation - 1 : 11;

        if (huoxingLocation == location) {
            str[0] = "火星";
        }
        if (lingxingLocationg == location) {
            str[1] = "铃星";
        }

        if (qingyangLocation == location) {
            str[2] = "擎羊";
        }
        if (tuoluoLocation == location) {
            str[3] = "陀罗";
        }
        if (dikongLocation == location) {
            str[4] = "地空";
        }
        if (dijieLocation == location) {
            str[5] = "地劫";
        }

        return str;

    }

    /**
     * 根据出生时辰获取地空位置
     *
     * @param hour 时辰
     * @return 地空
     */
    private int getDikongLocation(String hour) {
        int location = 10 - Integer.valueOf(hour) < 0 ? 10 - Integer.valueOf(hour) + 12 : 10 - Integer.valueOf(hour);
        return location;
    }

    /**
     * 根据出生时辰获取地劫位置
     *
     * @param hour 时辰
     * @return 地劫
     */
    private int getDijieLocation(String hour) {
        int location = 8 + Integer.valueOf(hour) > 11 ? (8 + Integer.valueOf(hour)) % 12 : 8 + Integer.valueOf(hour);
        return location;
    }

    /**
     * 根据出生年和时辰获取火星位置
     *
     * @param year 出生年
     * @param hour 出生时辰
     * @return 火星
     */
    private int getHuoxingLocation(String year, String hour) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 0;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 1;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 7;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 11;
        }
        location = location + Integer.valueOf(hour) - 1 > 11 ? (location + Integer.valueOf(hour) - 1) % 12 : location + Integer.valueOf(hour) - 1;
        return location;
    }

    /**
     * 根据出生年和时辰获取铃星位置
     *
     * @param year 出生年
     * @param hour 时辰
     * @return 铃星
     */
    private int getLingxingLocation(String year, String hour) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 1;
        } else {
            location = 8;
        }
        location = location + Integer.valueOf(hour) - 1 > 11 ? (location + Integer.valueOf(hour) - 1) % 12 : location + Integer.valueOf(hour) - 1;
        return location;
    }

    /**
     * 获取禄存位置
     *
     * @param year 出生年
     * @return 禄存位置
     */
    private int getLucunLocation(String year) {
        int endYear = Integer.valueOf(year.substring(year.length() - 1));
        if (endYear == 4) {
            return 0;
        }
        if (endYear == 5) {
            return 1;
        }
        if (endYear == 6 || endYear == 8) {
            return 3;
        }
        if (endYear == 7 || endYear == 9) {
            return 4;
        }
        if (endYear == 0) {
            return 6;
        }
        if (endYear == 1) {
            return 7;
        }
        if (endYear == 2) {
            return 9;
        }
        if (endYear == 3) {
            return 10;
        }
        return 0;
    }
}
