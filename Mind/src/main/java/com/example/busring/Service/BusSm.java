package com.example.busring.Service;

import com.example.busring.Repository.BRepository;
import com.example.busring.dto.bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusSm implements BusService{

    @Autowired
    private BRepository bRepository;

    @Override
    public List<bus> getAll() {
        return bRepository.findAll();
    }

    @Override
    public void insertOne(bus b){

        bRepository.save(b);
    }


}
