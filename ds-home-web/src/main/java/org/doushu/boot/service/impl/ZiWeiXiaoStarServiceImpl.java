package org.doushu.boot.service.impl;

import org.doushu.boot.common.constants.CommonConstant;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.service.ZiWeiXiaoStarService;
import org.springframework.stereotype.Service;

@Service
public class ZiWeiXiaoStarServiceImpl implements ZiWeiXiaoStarService {

    public String[] getFourThHtmlData(BirthQuery birthQuery, int location) {
        String[] str = new String[16];
        for (int index = 0; index < str.length; index++) {
            str[index] = "";
        }

        // 息神
        int xiShenLocation = getXiShenLocation(birthQuery.getYear());
        if (xiShenLocation == location) {
            str[0] = "息神";
        }

        // 亡神
        int wangShenLocation = getWangShenLocation(birthQuery.getYear());
        if (wangShenLocation == location) {
            str[0] = "亡神";
        }

        // 指背
        int zhiBeiLocation = getZhiBeiLocation(birthQuery.getYear());
        if (zhiBeiLocation == location) {
            str[0] = "指背";
        }

        // 天福
        int tianFuLocation = getTianFuLocation(birthQuery.getYear());
        if (tianFuLocation == location) {
            str[1] = "天福";
        }

        // 三台
        int santaiLocation = getSantaiLocation(birthQuery);
        // 八座
        int bazuoLocation = getBazuoLocation(birthQuery);

        if (santaiLocation == location) {
            str[2] = "三台";
        }
        if (bazuoLocation == location) {
            str[3] = "八座";
        }

        // 恩光
        int enguangLocation = getEnguangLocation(birthQuery);
        // 天贵
        int tianguiLocation = getTianguiLocation(birthQuery);
        if (enguangLocation == location) {
            str[4] = "恩光";
        }
        if (tianguiLocation == location) {
            str[5] = "天贵";
        }

        // 台辅
        int taifuLocation = 4 + Integer.valueOf(birthQuery.getHour()) - 1 > 11 ? (4 + Integer.valueOf(birthQuery.getHour()) - 1) % 12 : 4 + Integer.valueOf(birthQuery.getHour()) - 1;
        if (taifuLocation == location) {
            str[6] = "台辅";
        }
        // 封诰
        int fengao = Integer.valueOf(birthQuery.getHour()) - 1;
        if (fengao == location) {
            str[7] = "封诰";
        }

        // 官府
        int longchiLocation = getGuanFuLocation(birthQuery.getYear());
        if (longchiLocation == location) {
            str[8] = "官府";
        }

        // 天哭
        int tiankuLocation = getTiankuLocation(birthQuery.getYear());
        if (tiankuLocation == location) {
            str[9] = "天哭";
        }
        // 天虚
        int tianxuLocation = getTianxuLocation(birthQuery.getYear());
        if (tianxuLocation == location) {
            str[10] = "天虚";
        }

        // 丧门
        int sangmenLocation = getSangmenLocation(birthQuery.getYear());
        if (sangmenLocation == location) {
            str[11] = "丧门";
        }

        // 白虎
        int baihuLocation = getBaihuLocation(birthQuery.getYear());
        if (baihuLocation == location) {
            str[12] = "白虎";
        }

        // 孤辰
        int guChenLocation = getGuChenLocation(birthQuery.getYear());
        if (guChenLocation == location) {
            str[13] = "孤辰";
        }

        // 寡宿
        int guasuLocation = getGuaSuLocation(birthQuery.getYear());
        if (guasuLocation == location) {
            str[14] = "寡宿";
        }

        // 天官
        int tianGuanLocation = getTianGuanLocation(birthQuery.getYear());
        if (tianGuanLocation == location) {
            str[15] = "天官";
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
     * 天官
     * (甲年在未，乙年在辰，丙年在巳，丁年在寅，戊年在卯，己年在酉，庚年在亥，辛年在酉，壬年在戍，癸年在午)
     *
     * @param year
     * @return
     */
    private int getTianGuanLocation(String year) {
        int value = (int) ((Long.valueOf(year)) % 10);
        int location = 0;
        if (value == 4) {
            location = 5;
        }
        if (value == 5) {
            location = 2;
        }
        if (value == 6) {
            location = 3;
        }
        if (value == 7) {
            location = 0;
        }
        if (value == 8) {
            location = 1;
        }
        if (value == 9) {
            location = 7;
        }
        if (value == 0) {
            location = 9;
        }
        if (value == 1) {
            location = 7;
        }
        if (value == 2) {
            location = 8;
        }
        if (value == 3) {
            location = 4;
        }
        return location;
    }

    /**
     * 天福
     * (甲年在酉，乙年在申，丙年在子，丁年在亥，戊年在卯，己年在寅，庚年在午，辛年在巳，壬年在午，癸年在巳)
     *
     * @param year
     * @return
     */
    private int getTianFuLocation(String year) {
        int value = (int) ((Long.valueOf(year)) % 10);
        int location = 0;
        if (value == 4) {
            location = 7;
        }
        if (value == 5) {
            location = 6;
        }
        if (value == 6) {
            location = 10;
        }
        if (value == 7) {
            location = 9;
        }
        if (value == 8) {
            location = 1;
        }
        if (value == 9) {
            location = 0;
        }
        if (value == 0) {
            location = 4;
        }
        if (value == 1) {
            location = 3;
        }
        if (value == 2) {
            location = 4;
        }
        if (value == 3) {
            location = 3;
        }
        return location;
    }

    private int getTianguiLocation(BirthQuery birthQuery) {
        int wenquLocation = (1 + Integer.valueOf(birthQuery.getHour())) > 11 ? (1 + Integer.valueOf(birthQuery.getHour())) % 12 : (1 + Integer.valueOf(birthQuery.getHour()));// 文曲
        return wenquLocation + Integer.valueOf(birthQuery.getDay()) - 2 > 11 ? (wenquLocation + Integer.valueOf(birthQuery.getDay()) - 2) % 12 : wenquLocation + Integer.valueOf(birthQuery.getDay()) - 2;
    }

    private int getEnguangLocation(BirthQuery birthQuery) {
        int wenchangLocation = (9 - Integer.valueOf(birthQuery.getHour())) >= 0 ? 9 - Integer.valueOf(birthQuery.getHour()) : 9 - Integer.valueOf(birthQuery.getHour()) + 12;  // 文昌
        int enguangLocation = wenchangLocation + Integer.valueOf(birthQuery.getDay()) - 2 > 11 ? (wenchangLocation + Integer.valueOf(birthQuery.getDay()) - 2) % 12 : wenchangLocation + Integer.valueOf(birthQuery.getDay()) - 2;
        return enguangLocation;
    }

    private int getBazuoLocation(BirthQuery birthQuery) {
        int youbiStr = (9 - Integer.valueOf(birthQuery.getMonth())) >= 0 ? 9 - Integer.valueOf(birthQuery.getMonth()) : 9 - Integer.valueOf(birthQuery.getMonth()) + 12; // 右弼
        int bazuoLocation = getBazuoLocation(youbiStr, Integer.valueOf(birthQuery.getDay()));
        return bazuoLocation;
    }

    private int getSantaiLocation(BirthQuery birthQuery) {
        int zuofuStar = (1 + Integer.valueOf(birthQuery.getMonth())) > 11 ? (1 + Integer.valueOf(birthQuery.getMonth())) % 12 : (1 + Integer.valueOf(birthQuery.getMonth())); // 左辅
        int santaiLocation = zuofuStar + Integer.valueOf(birthQuery.getDay()) - 1 > 11 ? (zuofuStar + Integer.valueOf(birthQuery.getDay()) - 1) % 12 : zuofuStar + Integer.valueOf(birthQuery.getDay()) - 1;
        return santaiLocation;
    }

    /**
     * 指背
     *
     * @param year 出生年
     * @return
     */
    private int getZhiBeiLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 6;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 3;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 9;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 0;
        }
        return location;
    }

    /**
     * 亡神
     *
     * @param year 出生年
     * @return
     */
    private int getWangShenLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 9;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 6;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 0;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 3;
        }
        return location;
    }

    /**
     * 息神
     *
     * @param year 出生年
     * @return
     */
    private int getXiShenLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "辰".equals(dizhi) || "申".equals(dizhi)) {
            location = 1;
        } else if ("丑".equals(dizhi) || "巳".equals(dizhi) || "酉".equals(dizhi)) {
            location = 10;
        } else if ("卯".equals(dizhi) || "未".equals(dizhi) || "亥".equals(dizhi)) {
            location = 4;
        } else if ("寅".equals(dizhi) || "午".equals(dizhi) || "戌".equals(dizhi)) {
            location = 7;
        }
        return location;
    }

    /**
     * 白虎
     *
     * @param year
     * @return
     */
    private int getBaihuLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])) {
                location = index;
                break;
            }
        }
        location = 6 + location > 11 ? (6 + location) % 12 : 6 + location;
        return location;
    }

    /**
     * 丧门
     *
     * @param year
     * @return
     */
    private int getSangmenLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])) {
                location = index;
                break;
            }
        }
        return location;
    }

    /**
     * 天虚
     *
     * @param year
     * @return
     */
    private int getTianxuLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])) {
                location = index;
                break;
            }
        }
        location = 4 + location > 11 ? (4 + location) % 12 : 4 + location;
        return location;
    }

    /**
     * 天哭
     *
     * @param year
     * @return
     */
    private int getTiankuLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])) {
                location = index;
                break;
            }
        }
        location = 4 - location < 0 ? 4 - location + 12 : 4 - location;
        return location;
    }


    /**
     * 八座
     *
     * @param youbiStr
     * @param day
     * @return
     */
    private int getBazuoLocation(int youbiStr, Integer day) {
        int location = youbiStr - day + 1;
        while (location < 0) {
            location = location + 12;
        }
        return location;
    }

    /**
     * 龙池
     *
     * @param year
     * @return
     */
    private int getGuanFuLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String earthlyStr = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (earthlyStr.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])) {
                location = index;
                break;
            }
        }
        location = location + 2 > 11 ? (location + 2) % 12 : location + 2;
        return location;
    }

    /**
     * 根据出生年获取孤辰位置
     *
     * @param year 出生年
     * @return 孤辰
     */
    private int getGuChenLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "亥".equals(dizhi) || "丑".equals(dizhi)) {
            location = 0;
        } else if ("寅".equals(dizhi) || "卯".equals(dizhi) || "辰".equals(dizhi)) {
            location = 3;
        } else if ("巳".equals(dizhi) || "未".equals(dizhi) || "午".equals(dizhi)) {
            location = 6;
        } else if ("申".equals(dizhi) || "酉".equals(dizhi) || "戌".equals(dizhi)) {
            location = 9;
        }
        return location;
    }

    /**
     * 根据出生年获取寡宿位置
     *
     * @param year 出生年
     * @return 寡宿
     */
    private int getGuaSuLocation(String year) {
        int earthlyValue = (int) ((Long.valueOf(year) + 6) % 12);
        String dizhi = CommonConstant.EARTHLY_CONSTANT[earthlyValue];
        int location = 0;
        if ("子".equals(dizhi) || "亥".equals(dizhi) || "丑".equals(dizhi)) {
            location = 8;
        } else if ("寅".equals(dizhi) || "卯".equals(dizhi) || "辰".equals(dizhi)) {
            location = 11;
        } else if ("巳".equals(dizhi) || "未".equals(dizhi) || "午".equals(dizhi)) {
            location = 2;
        } else if ("申".equals(dizhi) || "酉".equals(dizhi) || "戌".equals(dizhi)) {
            location = 5;
        }
        return location;
    }


}
