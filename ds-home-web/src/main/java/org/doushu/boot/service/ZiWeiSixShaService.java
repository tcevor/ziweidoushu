package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiSixShaService {

    String[] getSixShaThHtmlData(BirthQuery birthData,int location);
}
