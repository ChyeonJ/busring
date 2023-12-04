package com.example.busring.Controller;

import com.example.busring.Service.MemberService;
import com.example.busring.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

//    아래 코드는 getAll코드
//    @ResponseBody
//    @RequestMapping("/getAll")
//    public List<MemberDTO> getAll() {
//        return memberService.getAll();
//    }

    @RequestMapping("")
    public String main(){
        return "main";
    }

    @RequestMapping("signup")
    public String signup(Model model){
        model.addAttribute("memberList", memberService.getAll());
        return "signup";
    }

    @RequestMapping("register")
    public String join(MemberDTO memberDTO){

        memberService.insertOne(memberDTO);

        return "redirect:/signup";
    }

    @RequestMapping("/useing")
    public String uesing(Model model, long num) {
        List<MemberDTO> memberDTO = memberService.selectOne(num);

        if(!memberDTO.isEmpty()) {
            MemberDTO useOne = memberDTO.get(0);
            model.addAttribute("useOne", useOne);

            switch (useOne.getType()){
                case "학생" :
                    return "busring_cus";
                case "교수" :
                    return "busring_cus";
                case "운전사" :
                    return "busring_dri";
                case "관리자" :
                    return "busring_com";
                default:
                    return "signup";
            }
        } else {
            return "signup";
        }
        //model.addAttribute("useOne", memberService.selectOne(num).get(0));

    }

    //?num={num}
    @RequestMapping("delete")
    public String delete(long num){
        memberService.deleteOne(num);
        return "redirect:/signup";
    }

    @RequestMapping("updatepage")
    public String updatePage(long num, Model model){
      model.addAttribute("memberOne", memberService.selectOne(num).get(0));
        return "updatepage";
    }

    @RequestMapping("update")
    public String update(MemberDTO memberDTO){
        memberService.updateOne(memberDTO);
        return "redirect:/signup";
    }



}
