package com.example.busring.Controller;

import com.example.busring.Service.MemberService;
import com.example.busring.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;


    @ResponseBody
    @RequestMapping("/getAll")
    public List<MemberDTO> getAll() {return memberService.getAll();}

    @RequestMapping("")
    public String main( ){
        return "login";
    }

    @RequestMapping("signup")
    public String signup( ){
        return "signup";
    }

    @RequestMapping("register")
    public String join(MemberDTO mdto){

        memberService.insertOne(mdto);

        return "redirect:/login";
    }



}
