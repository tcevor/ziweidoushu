package org.doushu.boot.common.eums;

/**
 * 定五行局
 */
public enum HeavenlyFiveGameEnum {

    NAIL("甲", "金四局"),
    SECOND("乙", "金四局"),
    THIRD("丙", "水二局"),
    FOURTH("丁", "水二局"),
    FIVE("戊", "火六局"),
    SIX("己", "火六局"),
    SEVEN("庚", "土五局"),
    EIGHT("辛", "土五局"),
    NINE("壬", "木三局"),
    TEN("癸", "木三局");

    HeavenlyFiveGameEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getFiveGameValue(String key) {
        if (key == null || "".equals(key.trim())) {
            return null;
        }
        for (HeavenlyFiveGameEnum fiveGame : HeavenlyFiveGameEnum.values()) {
            if (fiveGame.getKey() != null && key.equals(fiveGame.getKey())) {
                return fiveGame.getValue();
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
