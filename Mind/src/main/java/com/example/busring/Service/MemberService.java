package com.example.busring.Service;

import com.example.busring.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    public List<MemberDTO> getAll();    //전체조회

    public void insertOne(MemberDTO memberDTO);


}
