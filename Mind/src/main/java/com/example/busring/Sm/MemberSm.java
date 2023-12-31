package com.example.busring.Sm;

import com.example.busring.Repository.JRepository;
import com.example.busring.Service.MemberService;
import com.example.busring.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberSm implements MemberService {

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
    @Override
    public void deleteOne(long num){
        repository.deleteById(num);
    }
    @Override
    public List<MemberDTO> selectOne(long num) {
        return repository.selectOne(num);
    }

    @Override
    public void updateOne(MemberDTO memberDTO){
        repository.save(memberDTO);
    }

}
