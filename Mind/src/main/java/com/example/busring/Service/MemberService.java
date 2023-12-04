package com.example.busring.Service;

import com.example.busring.dto.MemberDTO;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    public List<MemberDTO> getAll();    //전체조회

    public void insertOne(MemberDTO memberDTO);

    void deleteOne(long num);

    public List<MemberDTO> selectOne(long num);

    void updateOne(MemberDTO memberDTO);


    //public void deleteOne(MemberDTO num);


}
