package org.doushu.boot.service;

import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiTaoHuaService {

    String[] getTaohuaThHtmlData(BirthQuery birthData, int location);
}
