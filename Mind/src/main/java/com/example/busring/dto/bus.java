package com.example.busring.dto;

import javax.persistence.*;

@Entity
public class bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    @Column
    private String plate;
    @Column
    private String bus_name;


    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBus_name() {
        return bus_name;
    }

    public void setBus_name(String bus_name) {
        this.bus_name = bus_name;
    }



}
