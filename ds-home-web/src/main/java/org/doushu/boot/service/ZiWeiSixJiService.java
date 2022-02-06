package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiSixJiService {
    String[] getSixJiThHtmlData(BirthQuery birthData , int location);
}
