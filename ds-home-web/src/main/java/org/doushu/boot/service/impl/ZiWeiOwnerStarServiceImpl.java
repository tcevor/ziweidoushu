package org.doushu.boot.service.impl;

import org.doushu.boot.common.ZiWeiCommonService;
import org.doushu.boot.common.constants.CommonConstant;
import org.doushu.boot.common.eums.FiveGameEnum;
import org.doushu.boot.common.eums.FiveTigersEnum;
import org.doushu.boot.common.eums.HeavenlyFiveGameEnum;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.entity.GridEntity;
import org.doushu.boot.service.ZiWeiOwnerStarService;
import org.springframework.stereotype.Service;

@Service
public class ZiWeiOwnerStarServiceImpl implements ZiWeiOwnerStarService {

    public GridEntity getOwnerStarThHtmlData(BirthQuery birthQuery) {

        GridEntity gridEntity = new GridEntity();
        gridEntity.setTianGanDiZhi(ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getYear()));
        // String fiveTigerHeader = FiveTigersEnum.getFiveTigerValue();
        String[] heavenlyAndEarthlyArray = getheavenlyAndEarthlyList(birthQuery.getYear()); // 十二天干地支
        gridEntity.setTianGanDiZhiGrid(heavenlyAndEarthlyArray);


        int lifeLocation = getLifeLocation(birthQuery.getMonth(), birthQuery.getHour()); // 定命宮
        gridEntity.setMingGongLocatio(lifeLocation);

        int bodyLocation = getBodyLocation(birthQuery.getMonth(), birthQuery.getHour()); // 定身宫
        gridEntity.setShenGongLocation(bodyLocation);

        // 十二事项宫位
        String[] lifeAndBodyLocation = getLifeAndBodyItemLocation(lifeLocation); // 十二事项宫位
        gridEntity.setShiXiangGrid(lifeAndBodyLocation);

        String fiveGame = getFiveGameValue(heavenlyAndEarthlyArray[lifeLocation]); // 五行局
        int gameValue = FiveGameEnum.getFiveGameValue(fiveGame); // 五行局
        gridEntity.setWuXingJu(fiveGame);
        gridEntity.setWuXingJuNo(gameValue);

        // 年龄区间
        String[] ageLocation = getAgeLocationList(lifeLocation, gameValue, birthQuery); // 获取年龄区间位置
        gridEntity.setAggeGrid(ageLocation);

        // 紫微系
        int ziweiLocation = getZiweiLocation(birthQuery.getDay(), gameValue);
        String[] ziweiDepartment = getZiweiDepartment(ziweiLocation);
        gridEntity.setZiWeiXiGrid(ziweiDepartment);

        // 天府系
        int tianfuLocation = getTianfuLocation(ziweiLocation);
        String[] tianfuDepartment = getTianfuDepartment(tianfuLocation);
        gridEntity.setTianFuXiGrid(tianfuDepartment);
        return gridEntity;
    }

    /**
     * 获取十二事项宫位置
     *
     * @param lifeLocation
     * @return 十二事项宫位置
     */
    private String[] getLifeAndBodyItemLocation(int lifeLocation) {
        String[] locationValue = new String[12];
        int location = lifeLocation;
        for (int index = 0; index < CommonConstant.HOUSES_POS.length; index++) {
            String value = CommonConstant.HOUSES_POS[index];
            locationValue[location] = value;
            if (location == 11) {
                location = 0;
            } else {
                location++;
            }
        }
        return locationValue;
    }

    /**
     * 定五行局
     *
     * @param fiveGameLocation 命宫天干地支
     * @return 五行局（中文）
     */
    private String getFiveGameValue(String fiveGameLocation) {
        String fiveGame = HeavenlyFiveGameEnum.getFiveGameValue(fiveGameLocation.substring(0, 1));
        String[] gameArray = new String[3];
        int seq = 0;
        for (int index = 0; index < CommonConstant.FIVE_GAME.length; index++) {
            if (fiveGame.equals(CommonConstant.FIVE_GAME[index])) {
                seq = index;
                break;
            }
        }
        gameArray[0] = CommonConstant.FIVE_GAME[seq];
        int second = (seq + 1) > 4 ? (seq + 1) % 5 : seq + 1;
        gameArray[1] = CommonConstant.FIVE_GAME[second];
        int third = (seq + 2) > 4 ? (seq + 2) % 5 : seq + 2;
        gameArray[2] = CommonConstant.FIVE_GAME[third];

        String earthlyValue = fiveGameLocation.substring(1, 2);
        int earthlyIndex = 0;
        for (int index = 0; index < CommonConstant.FIVE_EARTHLY_CONSTANT.length; index++) {
            if (earthlyValue.equals(CommonConstant.FIVE_EARTHLY_CONSTANT[index])) {
                earthlyIndex = index;
                break;
            }
        }
        int gameIndex = earthlyIndex % 2 > 0 ? (earthlyIndex - 1) / 2 : earthlyIndex / 2;
        int gameLocation = gameIndex % 3;
        return gameArray[gameLocation];
    }

    /**
     * 获取年龄区间位置
     *
     * @param lifeLocation 命宫位置
     * @param gameValue    五行局
     * @param birthQuery   1 :  顺行， 0:  逆行
     * @return 年龄区间位置
     */
    private String[] getAgeLocationList(int lifeLocation, int gameValue, BirthQuery birthQuery) {
        int modYear = (int) ((Long.valueOf(birthQuery.getYear()) + Integer.valueOf(birthQuery.getSex())) % 2); // 1 : 阳男阴女 顺行， 0: 阴男阳女 逆行
        String[] ageArray = new String[12];
        int startAge = gameValue;
        int index = 0;
        int startIndex = lifeLocation;
        while (index < 12) {
            int endAge = startAge + 9;
            ageArray[startIndex] = startAge + "-" + endAge;
            if (modYear == 1) {
                startIndex++;
            } else {
                startIndex--;
            }
            if (modYear == 1 && startIndex == 12) {
                startIndex = 0;
            }
            if (modYear == 0 && startIndex < 0) {
                startIndex = 11;
            }
            startAge += 10;
            index++;

        }
        return ageArray;

    }

    /**
     * 获取天府的位置
     *
     * @param ziweiLocation 紫微位置
     * @return 天府的位置
     */
    private int getTianfuLocation(int ziweiLocation) {
        int tianfuLocation = 0;
        if (ziweiLocation == 0) {
            tianfuLocation = 0;
        } else if (ziweiLocation == 1) {
            tianfuLocation = 11;
        } else if (ziweiLocation == 2) {
            tianfuLocation = 10;
        } else if (ziweiLocation == 3) {
            tianfuLocation = 9;
        } else if (ziweiLocation == 4) {
            tianfuLocation = 8;
        } else if (ziweiLocation == 5) {
            tianfuLocation = 7;
        } else if (ziweiLocation == 6) {
            tianfuLocation = 6;
        } else if (ziweiLocation == 7) {
            tianfuLocation = 5;
        } else if (ziweiLocation == 8) {
            tianfuLocation = 4;
        } else if (ziweiLocation == 9) {
            tianfuLocation = 3;
        } else if (ziweiLocation == 10) {
            tianfuLocation = 2;
        } else if (ziweiLocation == 11) {
            tianfuLocation = 1;
        }
        return tianfuLocation;
    }

    /**
     * 获取紫微的位置
     *
     * @param day       出生天
     * @param gameValue 五行局
     * @return 紫微的位置
     */
    private int getZiweiLocation(String day, int gameValue) {
        int dayValue = Integer.valueOf(day);
        int goValue = dayValue % gameValue == 0 ? (dayValue / gameValue) : (dayValue / gameValue) + 1;
        int inverseValue = goValue * gameValue - dayValue;
        int ziweiLocation = 0;
        if (inverseValue % 2 == 1) {
            ziweiLocation = (goValue - inverseValue - 1) >= 0 ? (goValue - inverseValue - 1) : (goValue - inverseValue - 1) + 12;
        } else {
            ziweiLocation = (goValue + inverseValue - 1) > 12 ? (goValue + inverseValue - 1) % 12 : (goValue + inverseValue - 1);
        }
        if (ziweiLocation > 12) {
            ziweiLocation = ziweiLocation % 12;
        }
        return ziweiLocation;
    }

    /**
     * 获取命宫位置 （命宮，從寅宮，順數月，逆數時）
     *
     * @param month 月
     * @param hour  時
     * @return 返回命宮位置
     */
    private int getLifeLocation(String month, String hour) {
        int monthValue = Integer.valueOf(month);
        int hourValue = Integer.valueOf(hour);
        int calculationValue = monthValue - (hourValue - 1) - 1; //
        while (calculationValue < 0) {
            calculationValue = calculationValue + 12;
        }
        return calculationValue;
    }

    /**
     * 获取身宮位置（從寅宮，順數月，順數時）
     *
     * @param month 月
     * @param hour  時
     * @return 返回身宮位置
     */
    private int getBodyLocation(String month, String hour) {
        int monthValue = Integer.valueOf(month);
        int hourValue = Integer.valueOf(hour);
        int calculationValue = monthValue + (hourValue - 1) - 1;
        if (calculationValue > 11) {
            calculationValue = calculationValue % 12;
        }
        return calculationValue;
    }

    /**
     * 起五虎遁，算出寅宮以後天干地支
     *
     * @param year 出生年
     * @return 寅宮以後天干地支
     */
    public String[] getheavenlyAndEarthlyList(String year) {
        String fiveTigerHeader = FiveTigersEnum.getFiveTigerValue(year);
        String[] strs = new String[12];
        int seq = 0;
        for (int index = 0; index < CommonConstant.HEAVENLY_CONSTANT.length; index++) {
            if (fiveTigerHeader.equals(CommonConstant.HEAVENLY_CONSTANT[index])) {
                seq = index;
                break;
            }
        }
        for (int index = 0; index < CommonConstant.EARTHLY_CONSTANT.length; index++) {
            String value = CommonConstant.HEAVENLY_CONSTANT[seq] + CommonConstant.EARTHLY_CONSTANT[index];
            seq++;
            strs[index] = value;
        }
        return strs;
    }

    /**
     * 起五虎遁，算出寅宮以後天干地支
     *
     * @param fiveTigerHeader 天干
     * @return 寅宮以後天干地支
     */
    public String[] getheavenlyAndEarthlyListByHeader(String fiveTigerHeader) {
        String fiveTiger = "";
        for (FiveTigersEnum fiveTigers : FiveTigersEnum.values()) {
            if (fiveTigers.getKey() != null && fiveTigerHeader.equals(fiveTigers.getKey())) {
                fiveTiger = fiveTigers.getValue();
            }
        }
        String[] strs = new String[12];
        int seq = 0;
        for (int index = 0; index < CommonConstant.HEAVENLY_CONSTANT.length; index++) {
            if (fiveTiger.equals(CommonConstant.HEAVENLY_CONSTANT[index])) {
                seq = index;
                break;
            }
        }
        for (int index = 0; index < CommonConstant.EARTHLY_CONSTANT.length; index++) {
            String value = CommonConstant.HEAVENLY_CONSTANT[seq] + CommonConstant.EARTHLY_CONSTANT[index];
            seq++;
            strs[index] = value;
        }
        return strs;
    }

    /**
     * 天府系
     *
     * @param tianfuLocation
     * @return
     */
    private String[] getTianfuDepartment(int tianfuLocation) {
        String[] tianfuStar = new String[12]; // 天府系
        String[] baseTianfu = CommonConstant.TIANFU_STAR;
        for (int index = 0; index < baseTianfu.length; index++) {
            int location = index + tianfuLocation;
            if (location > 11) {
                location = location % 12;
            }
            tianfuStar[location] = baseTianfu[index];
        }
        return tianfuStar;
    }

    /**
     * 紫薇系
     *
     * @param ziweiLocation
     * @return
     */
    private String[] getZiweiDepartment(int ziweiLocation) {
        String[] ziweiStar = new String[12]; // 紫薇系
        String[] baseZiwei = CommonConstant.ZIWEI_STAR;
        for (int index = 0; index < baseZiwei.length; index++) {
            int location = index + ziweiLocation + 1;
            if (location > 11) {
                location = location % 12;
            }
            ziweiStar[location] = baseZiwei[index];
        }
        return ziweiStar;
    }
}
