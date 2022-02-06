package org.doushu.boot.service;

import org.doushu.boot.common.BaseResult;
import org.doushu.boot.entity.BirthQuery;

public interface ZiWeiStarService {

    public BaseResult<String> getZiWeiOutResult(BirthQuery birthQuery);
}

