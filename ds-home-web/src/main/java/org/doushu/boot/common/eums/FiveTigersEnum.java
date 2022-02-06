package org.doushu.boot.common.eums;

import org.doushu.boot.common.constants.CommonConstant;

public enum FiveTigersEnum {

    NAIL("甲", "丙"),
    SECOND("乙", "戊"),
    THIRD("丙", "庚"),
    FOURTH("丁", "壬"),
    FIVE("戊", "甲"),
    SIX("已", "丙"),
    SEVEN("庚", "戊"),
    EIGHT("辛", "庚"),
    NINE("壬", "壬"),
    TEN("癸", "甲");

    FiveTigersEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    /**
     * 计算寅宫天干
     * @param year 出生年
     * @return
     */
    public static String getFiveTigerValue(String year) {
        if (year == null || "".equals(year.trim())) {
            return null;
        }
        int heavenlyValue = (int) ((Long.valueOf(year) + 6) % 10);
        String tianGan = CommonConstant.HEAVENLY_CONSTANT[heavenlyValue];
        for (FiveTigersEnum fiveTigers : FiveTigersEnum.values()) {
            if (fiveTigers.getKey() != null && tianGan.equals(fiveTigers.getKey())) {
                return fiveTigers.getValue();
            }
        }
        return null;
    }

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
