package org.doushu.boot.service.impl;

import org.doushu.boot.common.constants.CommonConstant;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.service.ZiWeiTaoHuaService;
import org.springframework.stereotype.Service;

@Service
public class ZiWeiTaoHuaServiceImpl implements ZiWeiTaoHuaService {

    @Override
    public String[] getTaohuaThHtmlData(BirthQuery birthData, int location) {
        String[] str = new String[4];
        // 天姚
        int tianyaoLocation = 10 + Integer.valueOf(birthData.getMonth()) > 12 ? ((10 + Integer.valueOf(birthData.getMonth())) % 12) : 10 + Integer.valueOf(birthData.getMonth());
        if (tianyaoLocation == location) {
            str[0] = "天姚";
        }
        // 咸池
        int xianchiLocation = getXianchiLocation(birthData.getYear());
        if (xianchiLocation == location) {
            str[1] = "咸池";
        }

        // 红鸾
        int hongluanLocation = getHongluanLocation(birthData.getYear());
        if (hongluanLocation == location) {
            str[2] = "红鸾";
        }
        // 天喜
        int tianxiLocation = hongluanLocation + 6 > 11 ? (hongluanLocation + 6) % 12 : hongluanLocation + 6;
        if (tianxiLocation == location) {
            str[3] = "天喜";
        }

        int count = 0;
        for (int index = 0; index < str.length; index++) {
            String currentValue = str[index];
            if (currentValue != null && !"".equals(currentValue)) {
                count++;
            }
        }
        int realCount = 0;
        String[] realStar = new String[count];
        for (int index = 0; index < str.length; index++) {
            String currentValue = str[index];
            if (currentValue != null && !"".equals(currentValue)) {
                realStar[realCount] = currentValue;
                realCount++;
            }
        }
        return realStar;
    }


    /**
     * 根据出生年获取咸池位置
     *
     * @param year 出生年
     * @return 咸池
     */
    private int getXianchiLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 7;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 4;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 10;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 1;
        }
        return location;
    }

    /**
     * 根据出生年获取红鸾位置
     * @param year 出生年
     * @return 红鸾
     */
    private int getHongluanLocation(String year) {
        int earthlyLocation = 0;
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (CommonConstant.FIVE_EARTHLY_CONSTANT[index].equals(earthlyStr)) {
                earthlyLocation = index;
                break;
            }
        }
        int hongluanLocation = 1 - earthlyLocation < 0 ? 1 - earthlyLocation + 12 : 1 - earthlyLocation;
        return hongluanLocation;
    }



}
