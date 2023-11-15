package com.example.busring.Service;

import com.example.busring.Repository.JRepository;
import com.example.busring.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberSm implements MemberService{

    @Autowired
    private JRepository repository;

    @Override
    public List<MemberDTO> getAll() {
        return repository.findAll();
    }

    @Override
    public void insertOne(MemberDTO memberDTO) {

        repository.save(memberDTO);
    }
}
