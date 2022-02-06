package org.doushu.boot.common.eums;

/**
 * 定五行局
 */
public enum FiveGameEnum {

    GOLD("金四局", 4),
    WATER("水二局", 2),
    FIRE("火六局", 6),
    SOIL("土五局", 5),
    WOOD("木三局", 3);

    FiveGameEnum(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public static Integer getFiveGameValue(String key) {
        if (key == null || "".equals(key.trim())) {
            return null;
        }
        for (FiveGameEnum fiveGame : FiveGameEnum.values()) {
            if (fiveGame.getKey() != null && key.equals(fiveGame.getKey())) {
                return fiveGame.getValue();
            }
        }
        return null;
    }

    private String key;

    private Integer value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
