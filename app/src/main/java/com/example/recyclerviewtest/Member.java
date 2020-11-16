package com.example.recyclerviewtest;

/**
 * @author chenbin
 * @date 2020/11/6
 */
public class Member {

    int type;
    int level;
    String name;
    String phone;
    boolean hide;

    public Member(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public Member(int type, String name, String phone) {
        this.type = type;
        this.name = name;
        this.phone = phone;
    }

    public Member(int type, int level, String name, String phone) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.phone = phone;
    }

    public Member(int type, int level, String name, String phone, boolean hide) {
        this.type = type;
        this.level = level;
        this.name = name;
        this.phone = phone;
        this.hide = hide;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public class Type {
        public static final int ONE = 1;
        public static final int TWO = 2;
        public static final int THREE = 3;
        public static final int FOUR = 4;
    }
}
