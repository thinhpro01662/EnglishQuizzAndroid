package org.o7planning.finalproject;


import java.util.ArrayList;

public class QuestList {
    private String ques;
    private String an1;
    private String an2;
    private String an3;
    private String an4;
    private String tran;

    public QuestList(String ques, String an1, String an2, String an3, String an4, String tran) {
        this.ques = ques;
        this.an1 = an1;
        this.an2 = an2;
        this.an3 = an3;
        this.an4 = an4;
        this.tran = tran;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAn1() {
        return an1;
    }

    public void setAn1(String an1) {
        this.an1 = an1;
    }

    public String getAn2() {
        return an2;
    }

    public void setAn2(String an2) {
        this.an2 = an2;
    }

    public String getAn3() {
        return an3;
    }

    public void setAn3(String an3) {
        this.an3 = an3;
    }

    public String getAn4() {
        return an4;
    }

    public void setAn4(String an4) {
        this.an4 = an4;
    }

    public String getTran() {
        return tran;
    }

    public void setTran(String tran) {
        this.tran = tran;
    }

}
