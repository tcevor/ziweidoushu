package org.doushu.boot.entity;

public class GridEntity {

    private int mingGongLocatio;

    private int shenGongLocation;

    private String tianGanDiZhi;

    private String wuXingJu;

    private int wuXingJuNo;

    private String[] tianGanDiZhiGrid;

    private String[] aggeGrid;

    private String[] shiXiangGrid;

    private String[] ziWeiXiGrid;

    private String[] tianFuXiGrid;

    private String[] positionGrid = new String[]{"木（东北偏东）","木（东）","土（东南偏东）","火（东南偏南）","火（南）","土（西南偏南）","金（西南偏西）","金（西）","土（西北偏西）","水（西北偏北）","水（北）","土（东北偏北）"};

    public int getMingGongLocatio() {
        return mingGongLocatio;
    }

    public void setMingGongLocatio(int mingGongLocatio) {
        this.mingGongLocatio = mingGongLocatio;
    }

    public int getShenGongLocation() {
        return shenGongLocation;
    }

    public void setShenGongLocation(int shenGongLocation) {
        this.shenGongLocation = shenGongLocation;
    }

    public String getTianGanDiZhi() {
        return tianGanDiZhi;
    }

    public void setTianGanDiZhi(String tianGanDiZhi) {
        this.tianGanDiZhi = tianGanDiZhi;
    }

    public String getWuXingJu() {
        return wuXingJu;
    }

    public void setWuXingJu(String wuXingJu) {
        this.wuXingJu = wuXingJu;
    }

    public int getWuXingJuNo() {
        return wuXingJuNo;
    }

    public void setWuXingJuNo(int wuXingJuNo) {
        this.wuXingJuNo = wuXingJuNo;
    }

    public String[] getTianGanDiZhiGrid() {
        return tianGanDiZhiGrid;
    }

    public void setTianGanDiZhiGrid(String[] tianGanDiZhiGrid) {
        this.tianGanDiZhiGrid = tianGanDiZhiGrid;
    }

    public String[] getAggeGrid() {
        return aggeGrid;
    }

    public void setAggeGrid(String[] aggeGrid) {
        this.aggeGrid = aggeGrid;
    }

    public String[] getShiXiangGrid() {
        return shiXiangGrid;
    }

    public void setShiXiangGrid(String[] shiXiangGrid) {
        this.shiXiangGrid = shiXiangGrid;
    }

    public String[] getZiWeiXiGrid() {
        return ziWeiXiGrid;
    }

    public void setZiWeiXiGrid(String[] ziWeiXiGrid) {
        this.ziWeiXiGrid = ziWeiXiGrid;
    }

    public String[] getTianFuXiGrid() {
        return tianFuXiGrid;
    }

    public void setTianFuXiGrid(String[] tianFuXiGrid) {
        this.tianFuXiGrid = tianFuXiGrid;
    }

    public String[] getPositionGrid() {
        return positionGrid;
    }

    public void setPositionGrid(String[] positionGrid) {
        this.positionGrid = positionGrid;
    }
}
