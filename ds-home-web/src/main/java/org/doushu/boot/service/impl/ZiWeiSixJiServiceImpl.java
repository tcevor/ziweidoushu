package org.doushu.boot.service.impl;

import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.service.ZiWeiSixJiService;
import org.springframework.stereotype.Service;

@Service
public class ZiWeiSixJiServiceImpl implements ZiWeiSixJiService {

    public String[] getSixJiThHtmlData(BirthQuery birthData ,int location){
        String[] str = new String[7];
        for (int index = 0; index < str.length; index++) {
            str[index] = "";
        }
        // 左辅右弼
        int zuofuStar = (1 + Integer.valueOf(birthData.getMonth())) > 11 ? (1 + Integer.valueOf(birthData.getMonth())) % 12 : (1 + Integer.valueOf(birthData.getMonth())); // 左辅
        int youbiStr = (9 - Integer.valueOf(birthData.getMonth())) >= 0 ? 9 - Integer.valueOf(birthData.getMonth()) : 9 - Integer.valueOf(birthData.getMonth()) + 12; // 右弼

        // 天魁天钺
        int tiankuiLocation = getTiankuiLocation(birthData.getYear());
        int tianyueLocation = getTianyueLocation(tiankuiLocation);

        // 文曲文昌
        int wenquStar = (1 + Integer.valueOf(birthData.getHour())) > 11 ? (1 + Integer.valueOf(birthData.getHour())) % 12 : (1 + Integer.valueOf(birthData.getHour()));// 文曲
        int wenchangStr = (9 - Integer.valueOf(birthData.getHour())) >= 0 ? 9 - Integer.valueOf(birthData.getHour()) : 9 - Integer.valueOf(birthData.getHour()) + 12;  // 文昌

        int lucunLocation = getLucunLocation(birthData.getYear());

        if (wenquStar == location) {
            str[0] = "文曲";
        }
        if (wenchangStr == location) {
            str[1] = "文昌";
        }
        if (zuofuStar == location) {
            str[2] = "左辅";
        }
        if (youbiStr == location) {
            str[3] = "右弼";
        }
        if (tiankuiLocation == location) {
            str[4] = "天魁";
        }
        if (tianyueLocation == location) {
            str[5] = "天钺";
        }
        if (lucunLocation == location) {
            str[6] = "祿存";
        }

        return str;
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

    /**
     * 获取天魁位置
     *
     * @param year 年
     * @return 天魁位置
     */
    private int getTiankuiLocation(String year) {
        int endYear = Integer.valueOf(year.substring(year.length() - 1));
        int tiankuiLocation = 0;
        if (endYear == 0 || endYear == 4 || endYear == 8) {
            tiankuiLocation = 11;
        }
        if (endYear == 5 || endYear == 9) {
            tiankuiLocation = 10;
        }
        if (endYear == 6 || endYear == 7) {
            tiankuiLocation = 9;
        }
        if (endYear == 2 || endYear == 3) {
            tiankuiLocation = 1;
        }
        if (endYear == 1) {
            tiankuiLocation = 0;
        }
        return tiankuiLocation;
    }

    /**
     * 获取天钺位置
     *
     * @param tiankuiLocation 天魁位置
     * @return 天钺位置
     */
    private int getTianyueLocation(int tiankuiLocation) {
        if (tiankuiLocation == 11) {
            return 5;
        }
        if (tiankuiLocation == 10) {
            return 6;
        }
        if (tiankuiLocation == 9) {
            return 7;
        }
        if (tiankuiLocation == 1) {
            return 3;
        }
        if (tiankuiLocation == 11) {
            return 4;
        }
        return 0;
    }
}
