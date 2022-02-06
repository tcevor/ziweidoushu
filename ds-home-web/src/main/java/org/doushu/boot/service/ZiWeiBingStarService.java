package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiBingStarService {

    String[] getBingStarThHtmlData(BirthQuery birthQuery, int location);
}
