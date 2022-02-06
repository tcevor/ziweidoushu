package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiXiaoStarService {

    String[] getFourThHtmlData(BirthQuery birthQuery, int location);
}
