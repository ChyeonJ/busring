package com.example.busring.Controller;

import com.example.busring.Service.MemberService;
import com.example.busring.dto.MemberDTO;
import org.dom4j.rule.Mode;
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
        return "login";
    }

    @RequestMapping("signup")
    public String signup(Model model){
        model.addAttribute("memberList", memberService.getAll());
        return "signup";
    }

    @RequestMapping("register")
    public String join(MemberDTO mdto){

        memberService.insertOne(mdto);

        return "redirect:/signup";
    }

    //?num={num}
    @RequestMapping("delete")
    public String delete(long num){
        memberService.deleteOne(num);
        return "redirect:/signup";
    }

    @RequestMapping("updatepage")
    public String updatePage(long num, Model model){
        //List<MemberDTO> a = memberService.selectOne(num);
        //System.out.println(a.get(0).getNum());
      //model.addAttribute("memberOne", memberService.selectOne(num));
        //System.out.println(model.addAttribute("memberOne", memberService.selectOne(num)));
      model.addAttribute("memberOne", memberService.selectOne(num).get(0));
        return "updatepage";
    }

    @RequestMapping("update")
    public String update(MemberDTO mdto){
       // memberService.updateOne(num);
        return "signup";
    }



}
