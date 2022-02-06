package org.doushu.boot.service.impl;

import org.doushu.boot.common.BaseResult;
import org.doushu.boot.common.ZiWeiCommonService;
import org.doushu.boot.common.constants.CommonConstant;
import org.doushu.boot.common.eums.FiveTigersEnum;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.entity.GridEntity;
import org.doushu.boot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class ZiWeiStarServiceImpl implements ZiWeiStarService {


    @Autowired
    private ZiWeiXiaoStarService ziWeiFourLineService;

    @Autowired
    private ZiWeiOwnerStarService ziWeiOwnerStarService;

    @Autowired
    private ZiWeiGridDataService ziWeiGridDataService;

    /**
     * @param birthQuery
     * @return
     */
    public BaseResult<String> getZiWeiOutResult(BirthQuery birthQuery) {
        BaseResult baseResult = new BaseResult();
        try {
            baseResult.setResultCode(CommonConstant.RESULT_SUCCES);
            StringBuilder sb = new StringBuilder();
            sb.append("<center> <table table border=1 cellpadding=6 cellspacing=1 bgcolor=white style=\"color:#00004f;border:0px solid darkblue\">");
            GridEntity gridEntity = ziWeiOwnerStarService.getOwnerStarThHtmlData(birthQuery);
            sb.append("<tr><td style=\"border:0px\" align=center bgcolor=white colspan=4><span style=\"color:mediumblue\"><a href=\"/index.html\">").append("命盘").append("</a></span></td></tr>");

            // 最上一行
            StringBuilder top = getTopHmtlTdData(birthQuery);
            sb.append("<tr>").append(top).append("</tr>");

            // 第一行开始
            String thirdGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 3);
            String fourGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 4);
            String fiveGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 5);
            String sixGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 6);
            sb.append("<tr><td style=\"border:0px\"></td>").append(thirdGrid).append(fourGrid).append(fiveGrid).append(sixGrid).append("<td style=\"border:0px\"></td></tr>");
            // 第一行结束

            //第二行开始
            String twoGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 2);
            String centerData = getCenterHtmlContent(birthQuery, gridEntity.getWuXingJu());
            String sevenGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 7);
            sb.append("<tr>").append(getTaiShuiLeftRightLocationName(birthQuery, 2)).append(twoGrid).append(centerData).append(sevenGrid).append(getTaiShuiLeftRightLocationName(birthQuery, 7)).append("</tr>");
            // 第二行结束

            //第三行开始
            String oneGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 1);
            String eightGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 8);
            sb.append("<tr>").append(getTaiShuiLeftRightLocationName(birthQuery, 1)).append(oneGrid).append(eightGrid).append(getTaiShuiLeftRightLocationName(birthQuery, 8)).append("</tr>");
            // 第三行结束

            //第四行开始
            String zeroGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 0);
            String elevGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 11);
            String tenGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 10);
            String nineGrid = ziWeiGridDataService.getGridHtmlData(birthQuery, 9);
            sb.append("<tr><td style=\"border:0px\"></td>").append(zeroGrid).append(elevGrid).append(tenGrid).append(nineGrid).append("<td style=\"border:0px\"></td></tr>");
            // 第四行结束

            sb.append("<tr>").append(getDownHmtlTdData((birthQuery))).append("</tr>");
            sb.append("</table></center>");
            baseResult.setResultBody(sb.toString());
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return baseResult;
    }

    /**
     * 最下面行
     *
     * @param birthQuery
     * @return
     */
    private StringBuilder getDownHmtlTdData(BirthQuery birthQuery) {
        StringBuilder top = new StringBuilder();
        top.append("<td style=\"border:0px\"></td>");
        top.append(getTaiShuiLocationName(birthQuery, 0));
        top.append(getTaiShuiLocationName(birthQuery, 11));
        top.append(getTaiShuiLocationName(birthQuery, 10));
        top.append(getTaiShuiLocationName(birthQuery, 9));
        top.append("<td style=\"border:0px\"></td>");
        return top;
    }

    /**
     * 最上面行
     *
     * @param birthQuery
     * @return
     */
    private StringBuilder getTopHmtlTdData(BirthQuery birthQuery) {
        StringBuilder top = new StringBuilder();
        top.append("<td style=\"border:0px\"></td>");
        top.append(getTaiShuiLocationName(birthQuery, 3));
        top.append(getTaiShuiLocationName(birthQuery, 4));
        top.append(getTaiShuiLocationName(birthQuery, 5));
        top.append(getTaiShuiLocationName(birthQuery, 6));
        top.append("<td style=\"border:0px\"></td>");
        return top;
    }

    /**
     * 上下行
     *
     * @param birthQuery
     * @param location
     * @return
     */
    private String getTaiShuiLocationName(BirthQuery birthQuery, int location) {
        String topTd = "<td nowrap align=center bgcolor=white style=\"white-space:pre;border:1px solid darkblue;width:9em;height: 3em;font-family:Courier\">";
        StringBuilder join = new StringBuilder();
        if (birthQuery.getFatherYear() != null && !"".equals(birthQuery.getFatherYear())) {
            int fatherLocation = (int) ((Long.valueOf(birthQuery.getFatherYear()) + 6) % 12);
            if (fatherLocation == location) {
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getFatherYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getFatherYear());
                join.append("<code><span style=\"color:#dd3333\"><b>父亲: ").append(value).append("(").append(array[location]).append(")</b></span></code><br>");
            }
        }
        if (birthQuery.getMotherYear() != null && !"".equals(birthQuery.getMotherYear())) {
            int motherLocation = (int) ((Long.valueOf(birthQuery.getMotherYear()) + 6) % 12);
            if (motherLocation == location) {
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getMotherYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getMotherYear());
                join.append("<code><span style=\"color:#dd3333\"><b>母亲: ").append(value).append("(").append(array[location]).append(")</b></span></code><br>");
            }
        }
        if (birthQuery.getWifeYear() != null && !"".equals(birthQuery.getWifeYear())) {
            int wifeLocation = (int) ((Long.valueOf(birthQuery.getWifeYear()) + 6) % 12);
            if (wifeLocation == location) {
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getWifeYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getWifeYear());
                join.append("<code><span style=\"color:#dd3333\"><b>妻子: ").append(value).append("(").append(array[location]).append(")</b></span></code><br>");
            }

        }
        if (birthQuery.getFriendYear() != null && !"".equals(birthQuery.getFriendYear())) {
            int friendLocation = (int) ((Long.valueOf(birthQuery.getFriendYear()) + 6) % 12);
            if (friendLocation == location) {
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getFriendYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getFriendYear());
                join.append("<code><span style=\"color:#dd3333\"><b>朋友: ").append(value).append("(").append(array[location]).append(")</b></span></code><br>");
            }
        }
        if (join.length() == 0) {
            return "<td style=\"border:0px\"></td>";
        }
        return topTd + join.append("</td>").toString();
    }

    /**
     * 左右行
     *
     * @param birthQuery
     * @param location
     * @return
     */
    private String getTaiShuiLeftRightLocationName(BirthQuery birthQuery, int location) {
        String tdBorder = "<td nowrap align=center bgcolor=white style=\"white-space:pre;border:1px solid darkblue;width:3em;height: 9em;font-family:Courier\">";
        StringBuilder join = new StringBuilder();
        StringBuilder first = new StringBuilder("<code><span style=\"color:#dd3333\"><b>");
        StringBuilder second = new StringBuilder("<code><span style=\"color:#dd3333\"><b>");
        StringBuilder third = new StringBuilder("<code><span style=\"color:#dd3333\"><b>");
        StringBuilder four = new StringBuilder("<code><span style=\"color:#dd3333\"><b>");
        StringBuilder five = new StringBuilder("<code><span style=\"color:#dd3333\"><b>");
        StringBuilder six = new StringBuilder("<code><span style=\"color:#0F0033\"><b>");
        boolean flag = true;
        if (birthQuery.getFatherYear() != null && !"".equals(birthQuery.getFatherYear())) {
            int fatherLocation = (int) ((Long.valueOf(birthQuery.getFatherYear()) + 6) % 12);
            if (fatherLocation == location) {
                flag = false;
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getFatherYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getFatherYear());
                first.append("父 ");
                second.append("亲 ");
                third.append("︰ ");
                four.append(value.substring(0, 1)).append(" ");
                five.append(value.substring(1, 2)).append(" ");
                six.append("(").append(array[location].substring(0, 1)).append(")");
            }
        }
        if (birthQuery.getMotherYear() != null && !"".equals(birthQuery.getMotherYear())) {
            int motherLocation = (int) ((Long.valueOf(birthQuery.getMotherYear()) + 6) % 12);
            if (motherLocation == location) {
                flag = false;
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getMotherYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getMotherYear());
                first.append("母 ");
                second.append("亲 ");
                third.append("︰ ");
                four.append(value.substring(0, 1)).append(" ");
                five.append(value.substring(1, 2)).append(" ");
                six.append("(").append(array[location].substring(0, 1)).append(")");
            }
        }
        if (birthQuery.getWifeYear() != null && !"".equals(birthQuery.getWifeYear())) {
            int wifeLocation = (int) ((Long.valueOf(birthQuery.getWifeYear()) + 6) % 12);
            if (wifeLocation == location) {
                flag = false;
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getWifeYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getWifeYear());
                first.append("妻 ");
                second.append("子 ");
                third.append("︰ ");
                four.append(value.substring(0, 1)).append(" ");
                five.append(value.substring(1, 2)).append(" ");
                six.append("(").append(array[location].substring(0, 1)).append(")");
            }

        }
        if (birthQuery.getFriendYear() != null && !"".equals(birthQuery.getFriendYear())) {
            int friendLocation = (int) ((Long.valueOf(birthQuery.getFriendYear()) + 6) % 12);
            if (friendLocation == location) {
                flag = false;
                String[] array = ziWeiOwnerStarService.getheavenlyAndEarthlyList(birthQuery.getFriendYear());
                String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getFriendYear());
                first.append("朋 ");
                second.append("友 ");
                third.append("︰ ");
                four.append(value.substring(0, 1)).append(" ");
                five.append(value.substring(1, 2)).append(" ");
                six.append("(").append(array[location].substring(0, 1)).append(")");
            }
        }
        first.append("</b></span></code><br>");
        second.append("</b></span></code><br>");
        third.append("</b></span></code><br>");
        four.append("</b></span></code><br>");
        five.append("</b></span></code><br>");
        six.append("</b></span></code><br>");
        if (flag) {
            return "<td style=\"border:0px\"></td>";
        }
        return tdBorder + join.append(first).append(second).append(third).append(four).append(five).append(six).append("</td>").toString();
    }


    private String getCenterHtmlContent(BirthQuery birthQuery, String fiveGame) {
        StringBuilder sb = new StringBuilder();
        sb.append("<td align=center bgcolor=white colspan=2 rowspan=2 nowrap style=\"white-space:pre;border:1px solid darkblue;font-family:Courier\"><span style=\"color:mediumblue\"><code></code><br>");
        String yearHeavenlyAndEarthly = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getYear());
        String birthDate = getBirthYearMonthDayData(birthQuery, yearHeavenlyAndEarthly);
        sb.append(birthDate);
        sb.append("<code>　　　　　　　　　　　　　　　  </code><br>");
        sb.append("<code>　　　　　　　　　　　　　　　　</code><br>");
        if (birthQuery.getFatherYear() != null && !"".equals(birthQuery.getFatherYear())) {
            String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getFatherYear());
            sb.append("<code>父亲: ").append(value).append(" (").append(birthQuery.getFatherYear()).append(")　　　　　　　　　 </code><br>");
        } else {
            sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        }
        sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        if (birthQuery.getMotherYear() != null && !"".equals(birthQuery.getMotherYear())) {
            String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getMotherYear());
            sb.append("<code>母亲: ").append(value).append(" (").append(birthQuery.getMotherYear()).append(")　　　　　　　　　 </code><br>");
        } else {
            sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        }
        sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        if (birthQuery.getWifeYear() != null && !"".equals(birthQuery.getWifeYear())) {
            String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getWifeYear());
            sb.append("<code>妻子: ").append(value).append(" (").append(birthQuery.getWifeYear()).append(")　　　　　　　　　 </code><br>");
        } else {
            sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        }
        sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        if (birthQuery.getFriendYear() != null && !"".equals(birthQuery.getFriendYear())) {
            String value = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getFriendYear());
            sb.append("<code>朋友: ").append(value).append(" (").append(birthQuery.getFriendYear()).append(")　　　　　　　　　 </code><br>");
        } else {
            sb.append("<code>　　　　　　　　　　　　　　   </code><br>");
        }
        String[] sizhuData = getBirthSizhuData(birthQuery);
        StringBuilder firstData = new StringBuilder();
        StringBuilder secondData = new StringBuilder();
        for (int index = 0; index < sizhuData.length; index++) {
            String value = sizhuData[index];
            if (value != null && !"".equals(value)) {
                firstData.append(value.substring(0, 1)).append(" ");
                secondData.append(value.substring(1, 2)).append(" ");
            }
        }
        if (birthQuery.getDayStr() != null && !"".equals(birthQuery.getDayStr())) {
            String value = birthQuery.getDayStr().substring(0, 1);
            for (int index = 0; index < CommonConstant.HEAVENLY_CONSTANT.length; index++) {
                if (value.equals(CommonConstant.HEAVENLY_CONSTANT[index])) {
                    String array = ziWeiOwnerStarService.getheavenlyAndEarthlyListByHeader(value)[(Integer.valueOf(birthQuery.getHour() + 9)) % 12];
                    firstData.append(value).append(" ").append(array.substring(0, 1));
                    secondData.append(birthQuery.getDayStr().substring(1, 2)).append(" ").append(array.substring(1, 2));
                    break;
                }
            }
        }
        sb.append("<code>  </code><br>");
        sb.append("<code>").append(firstData).append("        </code><br>");
        sb.append("<code>").append(secondData).append("        </code><br>");
        sb.append("<code>　　　　　　　　　　　　　  ").append("<a href=\"/index.html\">").append(fiveGame).append("</a> </code><br>");
        sb.append("<code>　　　　　　　　　　　　　　　　</code><br></span>");
        sb.append("</td>");
        return sb.toString();
    }

    /**
     * 获取出生年月日天干地支
     *
     * @param birthQuery
     * @return
     */
    private String[] getBirthSizhuData(BirthQuery birthQuery) {
        String[] sizhu = new String[4];
        sizhu[0] = ZiWeiCommonService.getHeavenlyAndEarthly(birthQuery.getYear());
        String fiveTigerHeader = FiveTigersEnum.getFiveTigerValue(birthQuery.getYear());
        String mouthDizhi = CommonConstant.EARTHLY_CONSTANT[Integer.valueOf(birthQuery.getMonth()) - 1];
        sizhu[1] = fiveTigerHeader + mouthDizhi;

        return sizhu;
    }


    /**
     * 获取出生年月日
     *
     * @param yearData
     * @return
     */
    private String getBirthYearMonthDayData(BirthQuery birthQuery, String yearData) {
        StringBuilder sb = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        Long yearValue = Long.valueOf(birthQuery.getYear());
        sb.append("<code>");
        String sexName = yearValue % 2 == 0 ? "阳" : "阴";
        sb.append(sexName);
        if ("1".equals(birthQuery.getSex())) { // 1 : 男； 2：女
            sb.append("男:　");
        } else if ("2".equals(birthQuery.getSex())) {
            sb.append("女:　");
        }
        sb.append(birthQuery.getYear()).append("年").append(birthQuery.getMonth()).append("月").append(birthQuery.getDay()).append("日");
        String hourName = getHourName(birthQuery.getHour());
        sb.append(hourName).append("时 (").append(yearData).append("年)");
        sb.append("</code><br><code>  年龄： ").append(calendar.get(Calendar.YEAR) - yearValue + 1).append("岁   (流年：").append(calendar.get(Calendar.YEAR)).append("年)       </code><br>");
        return sb.toString();
    }

    /**
     * 获取时辰
     *
     * @param hour
     * @return
     */
    private String getHourName(String hour) {
        int value = Integer.valueOf(hour);
        String name = CommonConstant.FIVE_EARTHLY_CONSTANT[value - 1];
        return name;
    }


}
