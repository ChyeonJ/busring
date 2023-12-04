package com.example.busring.dto;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class businfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    private String driver;  //운전자
    private String busname; //버스 이름 신구 1호
    private String plate; //번호판
    private String status;  //현재 상태 ex(출발, 도착)
    private String destination; //목적지
    @CreatedDate
    private LocalDateTime starttime; //출발 시간
    @CreatedDate
    private LocalDateTime stoptime; //도착 시간



    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getBusname() {
        return busname;
    }

    public void setBusname(String busname) {
        this.busname = busname;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getStoptime() {
        return stoptime;
    }

    public void setStoptime(LocalDateTime stoptime) {
        this.stoptime = stoptime;
    }
}
