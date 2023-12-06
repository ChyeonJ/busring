package com.example.busring.dto;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class businfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num;
    private String status;  //현재 상태 ex(출발, 도착, 대기)
    private String destination; //목적지
    @CreatedDate
    private LocalDateTime time; //출발, 도착 시간
    @ManyToOne
    @JoinColumn(name = "MemberDTO_num")
    private MemberDTO memberDTO;

    @ManyToOne
    @JoinColumn(name = "bus_num")
    private  bus b;

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public bus getB() {
        return b;
    }

    public void setB(bus b) {
        this.b = b;
    }
}
