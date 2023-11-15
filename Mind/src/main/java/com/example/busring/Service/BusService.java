package com.example.busring.Service;

import com.example.busring.dto.MemberDTO;
import com.example.busring.dto.bus;

import java.util.List;

public interface BusService {

    public List<bus> getAll();

    public void insertOne(bus b);

}
