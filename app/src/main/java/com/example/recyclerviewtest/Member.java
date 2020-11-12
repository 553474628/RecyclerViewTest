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

    public class Type {
        public static final int ONE = 1;
        public static final int TWO = 2;
        public static final int THREE = 3;
    }
}
