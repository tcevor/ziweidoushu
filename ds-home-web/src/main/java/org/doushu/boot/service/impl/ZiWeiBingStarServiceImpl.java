package org.doushu.boot.service.impl;

import org.doushu.boot.common.constants.CommonConstant;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.service.ZiWeiBingStarService;
import org.springframework.stereotype.Service;

@Service
public class ZiWeiBingStarServiceImpl implements ZiWeiBingStarService {

    public String[] getBingStarThHtmlData(BirthQuery birthQuery, int location){
        String[] bingStar = new String[7];
        for (int index = 0; index < bingStar.length; index++) {
            bingStar[index] = "";
        }

        // 大耗
        int daHaoLocation = getDaHaoLocation(birthQuery.getYear());
        if (daHaoLocation == location) {
            bingStar[0] = "大耗";
        }
        // 天刑
        int tianxingLocation = getTianxingLocation(birthQuery.getMonth());
        if (tianxingLocation == location) {
            bingStar[1] = "天刑";
        }

        // 天马
        int tianmaLocation = getTianmaLocation(birthQuery.getYear());
        if (tianmaLocation == location) {
            bingStar[2] = "天马";
        }

        // 龙池
        int longchiLocation = getLongchiLocation(birthQuery.getYear());
        if (longchiLocation == location) {
            bingStar[3] = "龙池";
        }
        // 凤阁
        int fenggeLocation = getFenggeLocation(birthQuery.getYear());
        if (fenggeLocation == location) {
            bingStar[4] = "凤阁";
        }

        // 华蓋
        int huaGaiLocation = getHuaGaiLocation(birthQuery.getYear());
        if (huaGaiLocation == location){
            bingStar[5] = "华蓋";
        }

        // 劫杀
        int jieShaLocation = getJieShaLocation(birthQuery.getYear());
        if (jieShaLocation == location){
            bingStar[5] = "劫杀";
        }

        // 阴煞
        int yinShaLocation = getYinShaLocation(birthQuery.getMonth());
        if (yinShaLocation == location){
            bingStar[6] = "阴煞";
        }

        int count = 0;
        for (int index = 0; index < bingStar.length; index++) {
            String currentValue = bingStar[index];
            if (currentValue != null && !"".equals(currentValue)) {
                count++;
            }
        }
        int realCount = 0;
        String[] realStar = new String[count];
        for (int index = 0; index < bingStar.length; index++){
            String currentValue = bingStar[index];
            if (currentValue != null && !"".equals(currentValue)) {
                realStar[realCount] = currentValue;
                realCount++;
            }
        }
        return realStar;

    }

    /**
     * 阴煞
     * @param month 出生月
     * @return
     */
    private int getYinShaLocation(String month) {
        int value = Integer.valueOf(month);
        int location = 0;
        if (value == 1 || value == 7){
            location = 0;
        }

        if (value == 2 || value == 8){
            location = 10;
        }

        if (value == 3 || value == 9){
            location = 8;
        }

        if (value == 4 || value == 10){
            location = 6;
        }

        if (value == 5 || value == 11){
            location = 4;
        }

        if (value == 6 || value == 12){
            location = 2;
        }
        return location;
    }

    /**
     * 劫杀
     * @param year 出生年
     * @return
     */
    private int getJieShaLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 3;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 0;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 6;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 9;
        }
        return location;
    }

    /**
     * 华蓋
     * @param year 出生年
     * @return
     */
    private int getHuaGaiLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 2;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 11;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 5;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 8;
        }
        return location;
    }

    /**
     * 根据出生月获取天刑位置
     * @param month 出生月
     * @return 天刑
     */
    private int getTianxingLocation(String month) {
        int tianxingLocation = ((Integer.valueOf(month) + 6) > 12 ? (Integer.valueOf(month) + 6) % 12 : Integer.valueOf(month) + 6);
        return tianxingLocation;
    }

    /**
     * 根据出生年获取大耗位置
     * @param year 出生年
     * @return 大耗
     */
    private int getDaHaoLocation(String year){
        int location = (int) ((Long.valueOf(year) + 6) % 12);
        if (location % 2 == 0){
            location =  location -5 < 0 ? location -5 + 12 : location -5;
        } else {
            location = location + 5 > 11 ? (location + 5) % 12 : location + 5;
        }
        return location;
    }

    /**
     * 根据出生年获取天马位置
     *
     * @param year 出生年
     * @return 天马
     */
    private int getTianmaLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 0;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 9;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 3;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 6;
        }
        return location;
    }

    /**
     * 龙池
     * @param year 出生年
     * @return
     */
    private int getLongchiLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0;index< CommonConstant.FIVE_EARTHLY_CONSTANT.length; index ++){
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])){
                location = index;
                break;
            }
        }
        location = location + 2 > 11 ? (location + 2) % 12 : location + 2;
        return location;
    }

    /**
     * 凤阁
     * @param year 出生年
     * @return
     */
    private int getFenggeLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0;index< CommonConstant.FIVE_EARTHLY_CONSTANT.length; index ++){
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])){
                location = index;
                break;
            }
        }
        location = 8 - location < 0 ? 8 - location + 12 : 8 - location;
        return location;
    }
}
