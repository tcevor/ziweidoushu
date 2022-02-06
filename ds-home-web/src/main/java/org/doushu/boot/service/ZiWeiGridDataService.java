package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiGridDataService {

    String getGridHtmlData(BirthQuery birthQuery,int location);
}
