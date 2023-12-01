package com.example.busring.dto;

import javax.persistence.*;

@Entity
public class bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;
    @Column
    private String plate;
    @Column
    private String bus_name;


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
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
