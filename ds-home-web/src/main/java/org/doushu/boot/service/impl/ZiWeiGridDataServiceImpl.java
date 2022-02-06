package org.doushu.boot.service.impl;

import org.doushu.boot.common.ZiWeiCommonService;
import org.doushu.boot.entity.BirthQuery;
import org.doushu.boot.entity.GridEntity;
import org.doushu.boot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ZiWeiGridDataServiceImpl implements ZiWeiGridDataService {

    @Autowired
    private ZiWeiOwnerStarService ziWeiOwnerStarService;

    @Autowired
    private ZiWeiSixJiService ziWeiSixJiService;

    @Autowired
    private ZiWeiSixShaService ziWeiSixShaService;

    @Autowired
    private ZiWeiTaoHuaService ziWeiTaoHuaService;

    @Autowired
    private ZiWeiBingStarService ziWeiBingStarService;

    @Autowired
    private ZiWeiXiaoStarService ziWeiXiaoStarService;

    public String getGridHtmlData(BirthQuery birthQuery, int location) {

        GridEntity grid = ziWeiOwnerStarService.getOwnerStarThHtmlData(birthQuery);
        String tdHtmlData = getTdHtmlData(birthQuery, grid, location);
        return tdHtmlData;

    }

    private String getTdHtmlData(BirthQuery birthQuery, GridEntity grid, int location) {
        StringBuilder joinAppend = new StringBuilder();
        int lifeLocation = grid.getMingGongLocatio();
        int bodyLocation = grid.getShenGongLocation();
        if (lifeLocation == location) {
            joinAppend.append("<td nowrap align=center bgcolor=#ffffd0 style=\"white-space:pre;border:1px solid darkblue;width:9em;font-family:Courier\">");
        } else if (bodyLocation == location) {
            joinAppend.append("<td nowrap align=center bgcolor=#f0ffd5 style=\"white-space:pre;border:1px solid darkblue;width:9em;font-family:Courier\">");
        } else {
            joinAppend.append("<td nowrap align=center bgcolor=white style=\"white-space:pre;border:1px solid darkblue;width:9em;font-family:Courier\">");
        }

        // 第一行
        getFristRowTdHtmlData(birthQuery, grid, location, joinAppend);
        // 第二行
        getSecondRowTdHtmlData(birthQuery, location, joinAppend);
        // 第三行
        getThirdRowTdHtmlData(grid, location, joinAppend);
        // 第四行
        getFourRowTdHtmlData(grid, location, joinAppend);
        // 第五行
        getFiveRowTdHtmlData(grid, location, joinAppend);

        joinAppend.append("</td>");
        return joinAppend.toString();

    }

    private void getFiveRowTdHtmlData(GridEntity grid, int location, StringBuilder joinAppend) {
        String[] ageLocation = grid.getAggeGrid();
        String[] heavenlyAndEarthlyArray = grid.getTianGanDiZhiGrid();
        String[] lifeAndBodyLocation = grid.getShiXiangGrid();
        String shiXiangName = "<span style=\"color:#dd3333\"> 【" + lifeAndBodyLocation[location] + "】</span>";
        joinAppend.append("<code>").append(heavenlyAndEarthlyArray[location]).append(shiXiangName);
        joinAppend.append("<span style=\"color:blue\">").append(ageLocation[location]).append("</span>").append("</code>");

    }

    private void getThirdRowTdHtmlData(GridEntity grid, int location, StringBuilder joinAppend) {
        String[] ziweiXiLocation = grid.getZiWeiXiGrid();
        String[] tianfuXiLocation = grid.getTianFuXiGrid();
        joinAppend.append("<code><span style=\"color:#cc0000\" align=right>              ");
        if ("".equals(tianfuXiLocation[location]) && "".equals(ziweiXiLocation[location]) ){
            joinAppend.append("X");
        }
        if (location == 0) {
            if (ZiWeiCommonService.zeroMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.zeroMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.zeroMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.zeroMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 1) {
            if (ZiWeiCommonService.oneMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.oneMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.oneMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.oneMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 2) {
            if (ZiWeiCommonService.secondMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.secondMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.secondMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.secondMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 3) {
            if (ZiWeiCommonService.thirdMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.thirdMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.thirdMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.thirdMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 4) {
            if (ZiWeiCommonService.fourMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.fourMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.fourMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.fourMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 5) {
            if (ZiWeiCommonService.fiveMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.fiveMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.fiveMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.fiveMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 6) {
            if (ZiWeiCommonService.sixMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.sixMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.sixMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.sixMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 7) {
            if (ZiWeiCommonService.sevenMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.sevenMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.sevenMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.sevenMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 8) {
            if (ZiWeiCommonService.eightMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.eightMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.eightMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.eightMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 9) {
            if (ZiWeiCommonService.nineMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.nineMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.nineMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.nineMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 10) {
            if (ZiWeiCommonService.tenMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.tenMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.tenMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.tenMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        if (location == 11) {
            if (ZiWeiCommonService.eleMap.containsKey(tianfuXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.eleMap.get(tianfuXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
            if (ZiWeiCommonService.eleMap.containsKey(ziweiXiLocation[location])) {
                joinAppend.append(ZiWeiCommonService.eleMap.get(ziweiXiLocation[location]));
            } else {
                joinAppend.append(" ");
            }
        }

        joinAppend.append("</span></code><br>");
    }

    private void getFourRowTdHtmlData(GridEntity grid, int location, StringBuilder joinAppend) {
        int bodyLocation = grid.getShenGongLocation();  // 定身宮
        joinAppend.append("<code>");
        if (grid.getPositionGrid() != null && grid.getPositionGrid().length > 0) {
            joinAppend.append("<span style=\"font-size: small\"><b>").append(grid.getPositionGrid()[location]).append("</b></span>");
        }
        if (bodyLocation == location) {
            joinAppend.append("<span style=\"color:red;font-weight:bold\">").append(" 身宮").append("</span>");
        }
        joinAppend.append("</code></br>");
    }

    private void getSecondRowTdHtmlData(BirthQuery birthQuery, int location, StringBuilder joinAppend) {
        String[] xiaoStar = ziWeiXiaoStarService.getFourThHtmlData(birthQuery, location);
        StringBuilder firstStr = new StringBuilder("");
        StringBuilder secondWord = new StringBuilder("");
        int total = 0;
        if (xiaoStar != null && xiaoStar.length > 0) {
            total = xiaoStar.length;
            for (int index = 0; index < xiaoStar.length; index++) {
                if (xiaoStar[index] != null && !"".equals(xiaoStar[index])) {
                    firstStr.append(xiaoStar[index].substring(0, 1));
                    secondWord.append(xiaoStar[index].substring(1, 2));
                }
            }
        }
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        if (total < 13) {
            for (int index = 0; index < 13 - total; index++) {
                first.append(" ");
                second.append(" ");
            }
        }
        joinAppend.append("<code>").append(first).append(firstStr).append("</code></br><code>").append(second).append(secondWord).append("</code></br>");
    }

    /**
     * 获取主星的row
     *
     * @param birthQuery
     * @param grid
     * @param location
     * @param joinAppend
     */
    private void getFristRowTdHtmlData(BirthQuery birthQuery, GridEntity grid, int location, StringBuilder joinAppend) {
        Map<String, String> rightData = getRowOwnerFirstSecondThirdData(birthQuery, grid, location);
        Map<String, String> centerData = getRowBingStarFirstSecondThirdData(birthQuery, location);
        Map<String, String> leftData = getRowtaoShaFirstSecondThirdData(birthQuery, location, Integer.valueOf(rightData.get("total")) + Integer.valueOf(centerData.get("total")));
        joinAppend.append("<code>").append(leftData.get("first")).append(centerData.get("first")).append(rightData.get("first")).append("</code></br>");
        joinAppend.append("<code>").append(leftData.get("second")).append(centerData.get("second")).append(rightData.get("second")).append("</code></br>");
        joinAppend.append("<code>").append(leftData.get("third")).append(centerData.get("third")).append(rightData.get("third")).append("</code></br>");
    }

    private Map<String, String> getRowtaoShaFirstSecondThirdData(BirthQuery birthQuery, int location, int count) {
        String[] sixShaStar = getSixShaStarLocation(birthQuery, location);
        Map<String, String> joinMap = new HashMap<>();
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder third = new StringBuilder();
        int total = 0;
        first.append("<span style=\"color:#cc0000\" >");
        second.append("<span style=\"color:#cc0000\">");
        if (sixShaStar != null && sixShaStar.length > 0) {
            total += sixShaStar.length;
            for (int index = 0; index < sixShaStar.length; index++) {
                String currentVal = sixShaStar[index];
                first.append(currentVal.substring(0, 1));
                second.append(currentVal.substring(1, 2));
                third.append("  ");
            }
        }
        if (total + count < 13) {
            for (int index = 0; index < 13 - (total + count); index++) {
                first.append(" ");
                second.append(" ");
                third.append(" ");
            }
        }
        first.append("</span>");
        second.append("</span>");

        joinMap.put("first", first.toString());
        joinMap.put("second", second.toString());
        joinMap.put("third", third.toString());
        joinMap.put("total", total + "");
        return joinMap;
    }

    private Map<String, String> getRowBingStarFirstSecondThirdData(BirthQuery birthQuery, int location) {
        Map<String, String> joinMap = new HashMap<>();
        String[] taoHuaStar = getTaoHuaStarLocation(birthQuery, location);
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder third = new StringBuilder();
        int total = 0;
        if (taoHuaStar != null && taoHuaStar.length > 0) {
            total += taoHuaStar.length;
            first.append("<span style=\"color:magenta\" >");
            second.append("<span style=\"color:magenta\">");
            for (int index = 0; index < taoHuaStar.length; index++) {
                String currentVal = taoHuaStar[index];
                first.append(currentVal.substring(0, 1));
                second.append(currentVal.substring(1, 2));
                third.append("  ");
            }
            first.append("</span>");
            second.append("</span>");
        }

        String[] bingStar = ziWeiBingStarService.getBingStarThHtmlData(birthQuery, location);
        if (bingStar != null && bingStar.length > 0) {
            total += bingStar.length;
            for (int index = 0; index < bingStar.length; index++) {
                String currentVal = bingStar[index];
                if ("天马".equals(currentVal)) {
                    first.append("<span style=\"color:#cc0000\"> <b>").append(currentVal.substring(0, 1)).append("</b></span>");
                    second.append("<span style=\"color:#cc0000\"> <b>").append(currentVal.substring(1, 2)).append("</b></span>");
                } else {
                    first.append(currentVal.substring(0, 1));
                    second.append(currentVal.substring(1, 2));
                }

                third.append("  ");
            }
        }
        first.append("  ");
        second.append("  ");
        third.append("  ");
        total++;
        joinMap.put("first", first.toString());
        joinMap.put("second", second.toString());
        joinMap.put("third", third.toString());
        joinMap.put("total", total + "");
        return joinMap;

    }

    private Map<String, String> getRowOwnerFirstSecondThirdData(BirthQuery birthQuery, GridEntity grid, int location) {
        Map<String, String> joinMap = new HashMap<>();
        String[] ownerStar = getOwnerStarByLocation(birthQuery, grid, location);
        String[] sixJiStar = getSexJiStarByLocation(birthQuery, grid, location);
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder third = new StringBuilder();
        int total = 0;
        if (sixJiStar != null && sixJiStar.length > 0) {
            total += sixJiStar.length + 1;
            first.append("<span style=\"color:darkorchid\">");
            second.append("<span style=\"color:darkorchid\">");
            third.append("<span style=\"color:darkorchid\">");
            for (int index = 0; index < sixJiStar.length; index++) {
                String currentVal = sixJiStar[index];
                first.append(currentVal.substring(0, 1));
                second.append(currentVal.substring(1, 2));
                if (currentVal.length() == 3) {
                    third.append(currentVal.substring(2, 3));
                } else {
                    third.append("  ");
                }
            }
            first.append("  </span>");
            second.append("  </span>");
            third.append("  </span>");
        }

        if (ownerStar != null && ownerStar.length > 0) {
            total += ownerStar.length;
            first.append("<span style=\"color:blue\" align=right>");
            second.append("<span style=\"color:blue\" align=right>");
            third.append("<span style=\"color:darkorchid\" align=right>");
            for (int index = 0; index < ownerStar.length; index++) {
                String currentVal = ownerStar[index];
                first.append(currentVal.substring(0, 1));
                second.append(currentVal.substring(1, 2));
                if (currentVal.length() == 3) {
                    third.append(currentVal.substring(2, 3));
                } else {
                    third.append("  ");
                }
            }
            first.append("</span>");
            second.append("</span>");
            third.append("</span>");
        }

        joinMap.put("first", first.toString());
        joinMap.put("second", second.toString());
        joinMap.put("third", third.toString());
        joinMap.put("total", total + "");
        return joinMap;
    }

    private String[] getTaoHuaStarLocation(BirthQuery birthQuery, int location) {
        String[] taoHuaStar = ziWeiTaoHuaService.getTaohuaThHtmlData(birthQuery, location);
        return taoHuaStar;
    }

    private String[] getSixShaStarLocation(BirthQuery birthQuery, int location) {
        String[] sixShaStar = ziWeiSixShaService.getSixShaThHtmlData(birthQuery, location);
        int count = 0;
        for (int index = 0; index < sixShaStar.length; index++) {
            String currentValue = sixShaStar[index];
            if (currentValue != null && !"".equals(currentValue)) {
                count++;
            }
        }
        int realCount = 0;
        String[] realSixShaStar = new String[count];
        for (int index = 0; index < sixShaStar.length; index++) {
            String currentValue = sixShaStar[index];
            if (currentValue != null && !"".equals(currentValue)) {
                realSixShaStar[realCount] = currentValue;
                realCount++;
            }
        }
        return realSixShaStar;
    }

    private String[] getOwnerStarByLocation(BirthQuery birthQuery, GridEntity grid, int location) {
        String[] ownerStar = new String[2];
        Map<String, String> thirdMap = getSihuDataMap(birthQuery.getYear());
        int count = 0;
        String[] ziweiXiLocation = grid.getZiWeiXiGrid();
        String[] tianfuXiLocation = grid.getTianFuXiGrid();
        String ziWeiData = ziweiXiLocation[location];
        if (ziWeiData != null && !"".equals(ziWeiData)) {
            count++;
            String value = ziWeiData;
            if (thirdMap.containsKey(value)) {
                value = value + thirdMap.get(ziWeiData);
            }
            ownerStar[1] = value;
        }
        String tianFuData = tianfuXiLocation[location];
        if (tianFuData != null && !"".equals(tianFuData)) {
            count++;
            String value = tianFuData;
            if (thirdMap.containsKey(value)) {
                value = value + thirdMap.get(tianFuData);
            }
            ownerStar[0] = value;
        }

        String[] realStar = new String[count];
        int realCount = 0;
        for (int index = 0; index < ownerStar.length; index++) {
            String currentValue = ownerStar[index];
            if (currentValue != null && !"".equals(currentValue)) {
                realStar[realCount] = currentValue;
                realCount++;
            }
        }
        return realStar;
    }


    private String[] getSexJiStarByLocation(BirthQuery birthQuery, GridEntity grid, int location) {
        String[] ownerStar = new String[7];
        Map<String, String> thirdMap = getSihuDataMap(birthQuery.getYear());
        int count = 0;
        String[] sixJiLocation = ziWeiSixJiService.getSixJiThHtmlData(birthQuery, location);
        for (int index = 0; index < sixJiLocation.length; index++) {
            String currentValue = sixJiLocation[index];
            String value = currentValue;
            if (currentValue != null && !"".equals(currentValue)) {
                count++;
                if (thirdMap.containsKey(currentValue)) {
                    value = value + thirdMap.get(currentValue);
                }
                ownerStar[index] = value;
            }
        }

        String[] realStar = new String[count];
        int realCount = 0;
        for (int index = 0; index < ownerStar.length; index++) {
            String currentValue = ownerStar[index];
            if (currentValue != null && !"".equals(currentValue)) {
                realStar[realCount] = currentValue;
                realCount++;
            }
        }
        return realStar;
    }


    /**
     * 获取四化信息
     *
     * @param year
     * @return
     */
    private Map<String, String> getSihuDataMap(String year) {
        Map<String, String> sihuaMap = new HashMap<>(4);
        int endYear = Integer.valueOf(year.substring(year.length() - 1));
        if (endYear == 4) {
            sihuaMap.put("廉贞", "禄");
            sihuaMap.put("破军", "权");
            sihuaMap.put("武曲", "科");
            sihuaMap.put("太阳", "忌");
        } else if (endYear == 5) {
            sihuaMap.put("天机", "禄");
            sihuaMap.put("天梁", "权");
            sihuaMap.put("紫微", "科");
            sihuaMap.put("太阴", "忌");
        } else if (endYear == 6) {
            sihuaMap.put("天同", "禄");
            sihuaMap.put("天机", "权");
            sihuaMap.put("文昌", "科");
            sihuaMap.put("廉贞", "忌");
        } else if (endYear == 7) {
            sihuaMap.put("太阴", "禄");
            sihuaMap.put("天同", "权");
            sihuaMap.put("天机", "科");
            sihuaMap.put("巨门", "忌");
        } else if (endYear == 8) {
            sihuaMap.put("贪狼", "禄");
            sihuaMap.put("太阴", "权");
            sihuaMap.put("右弼", "科");
            sihuaMap.put("天机", "忌");
        } else if (endYear == 9) {
            sihuaMap.put("武曲", "禄");
            sihuaMap.put("贪狼", "权");
            sihuaMap.put("天梁", "科");
            sihuaMap.put("文曲", "忌");
        } else if (endYear == 0) {
            sihuaMap.put("太阳", "禄");
            sihuaMap.put("武曲", "权");
            sihuaMap.put("太阴", "科");
            sihuaMap.put("天同", "忌");
        } else if (endYear == 1) {
            sihuaMap.put("巨门", "禄");
            sihuaMap.put("太阳", "权");
            sihuaMap.put("文曲", "科");
            sihuaMap.put("文昌", "忌");
        } else if (endYear == 2) {
            sihuaMap.put("天梁", "禄");
            sihuaMap.put("紫微", "权");
            sihuaMap.put("左辅", "科");
            sihuaMap.put("武曲", "忌");
        } else if (endYear == 3) {
            sihuaMap.put("破军", "禄");
            sihuaMap.put("巨门", "权");
            sihuaMap.put("太阳", "科");
            sihuaMap.put("贪狼", "忌");
        }
        return sihuaMap;
    }
}
