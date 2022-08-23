package org.o7planning.finalproject;

public class user_score_list {
    private String user;
    private String type;
    private Integer score;

    public user_score_list(String user, String type, Integer score) {
        this.user = user;
        this.type = type;
        this.score = score;
    }

    public String getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public Integer getScore() {
        return score;
    }
}
