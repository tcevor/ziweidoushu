package org.doushu.boot.entity;

import org.springframework.web.bind.annotation.RequestParam;

public class BirthQuery {

    private String year;
    private String month;
    private String day;
    private String hour;
    private String dayStr;

    /**
     * sex   1 : 男； 2：女
     */
    private String sex;

    private String fatherYear;

    private String motherYear;

    private String friendYear;

    private String wifeYear;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFatherYear() {
        return fatherYear;
    }

    public void setFatherYear(String fatherYear) {
        this.fatherYear = fatherYear;
    }

    public String getMotherYear() {
        return motherYear;
    }

    public void setMotherYear(String motherYear) {
        this.motherYear = motherYear;
    }

    public String getFriendYear() {
        return friendYear;
    }

    public void setFriendYear(String friendYear) {
        this.friendYear = friendYear;
    }

    public String getWifeYear() {
        return wifeYear;
    }

    public void setWifeYear(String wifeYear) {
        this.wifeYear = wifeYear;
    }

    public String getDayStr() {
        return dayStr;
    }

    public void setDayStr(String dayStr) {
        this.dayStr = dayStr;
    }

    @Override
    public String toString() {
        return "BirthQuery{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
