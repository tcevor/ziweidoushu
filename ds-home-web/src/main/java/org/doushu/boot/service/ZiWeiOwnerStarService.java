package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.entity.GridEntity;

public interface ZiWeiOwnerStarService {

    public GridEntity getOwnerStarThHtmlData(BirthQuery birthQuery);

    /**
     * 起五虎遁，算出寅宮以後天干地支
     *
     * @param year 出生年
     * @return 寅宮以後天干地支
     */
    String[] getheavenlyAndEarthlyList(String year);

    String[] getheavenlyAndEarthlyListByHeader(String fiveTigerHeader);
}
