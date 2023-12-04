package com.example.busring.dto;

import javax.persistence.*;

@Entity
public class MemberDTO {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;

    private String name;

    private String id;

    private String pw;

    private String phone;

    private String type;

    @ManyToOne
    @JoinColumn(name = "businfo_num")
    private businfo businfo;

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public com.example.busring.dto.businfo getBusinfo() {
        return businfo;
    }

    public void setBusinfo(com.example.busring.dto.businfo businfo) {
        this.businfo = businfo;
    }
}
