package org.doushu.boot.rest;

import org.doushu.boot.common.BaseResult;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.service.ZiWeiStarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

/**
 * TODO 加点注释吧
 *
 * @author by GBJ
 * @date on 2017/11/29.
 * @Description:
 */
@RestController
@RequestMapping("ziwei")
public class ZiWeiResponseRest {

    @Autowired
    private ZiWeiStarService ziWeiStarService;

    /**
     * @param birthQuery
     * @return
     */
    @RequestMapping(value = "/response", method = {RequestMethod.GET, RequestMethod.POST})
    public String getZiWeiResponse(BirthQuery birthQuery) {
        try {
             String data = validataParms(birthQuery);
             if (data.length() > 0){
                 return data;
             }
            BaseResult<String> ret = ziWeiStarService.getZiWeiOutResult(birthQuery);
            if (ret != null && ret.getResultCode() == 200){
                return ret.getResultBody();
            }else {
                return ret.getResultMsg();
            }
        }catch (Exception ex){
            return "失败";
        }
    }

    private String validataParms(BirthQuery birthQuery) {
        StringBuilder sb = new StringBuilder();
        if (birthQuery.getYear() == null || "".equals(birthQuery.getYear().trim())){
            sb.append("<a href=\"/index.html\">年份有误</a></br>");
        }

        if (birthQuery.getDay() == null || "".equals(birthQuery.getDay().trim())){
            sb.append("<a href=\"/index.html\">生日有误</a></br>");
        }
        try {
            Long year = Long.valueOf(birthQuery.getYear());
            if (year < 0){
                sb.append("<a href=\"/index.html\">年份不在有效范围内</a></br>");
            }
            int day = Integer.valueOf(birthQuery.getDay());
            if (day > 30 && day <1){
                sb.append("<a href=\"/index.html\">生日不在有效范围内</a></br>");
            }
        }catch (Exception ex){
            sb.append("<a href=\"/index.html\">年份或生日不不是纯数字</a></br>");
        }
        return sb.toString();
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index.html";
    }

}
