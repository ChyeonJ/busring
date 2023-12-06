package com.example.busring.Controller;

import com.example.busring.Service.BusInfoService;
import com.example.busring.Service.BusService;
import com.example.busring.Service.MemberService;
import com.example.busring.dto.MemberDTO;
import com.example.busring.dto.bus;
import com.example.busring.dto.businfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BusService busService;

    @Autowired
    private BusInfoService busInfoService;

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
    public String signup(){
        return "signup";
    }

    @RequestMapping("register")
    public String join(MemberDTO memberDTO){

        memberService.insertOne(memberDTO);

        return "redirect:/";
    }


    //?num={num}
    @RequestMapping("delete")
    public String delete(long num){
        memberService.deleteOne(num);
        return "redirect:/adminPage";
    }

    @RequestMapping("updatepage")
    public String updatePage(long num, Model model){
      model.addAttribute("memberOne", memberService.selectOne(num).get(0));
        return "updatepage";
    }

    @RequestMapping("update")
    public String update(MemberDTO memberDTO){
        memberService.updateOne(memberDTO);
        return "redirect:/adminPage";
    }

    @RequestMapping("login")
    public String login(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model, HttpSession session) {
        List<MemberDTO> members = memberService.getAll();
        List<bus> buss = busService.getAll();
        List<businfo> infos = busInfoService.getAll();
        for (MemberDTO member : members) {
            if (member.getId().equals(id) && member.getPw().equals(pw)) {
                // 로그인 성공
                session.setAttribute("useOne", member); // 세션에 사용자 정보 저장
                    switch (member.getType()) {
                        case "학생":
                        case "교수":
                            model.addAttribute("useOne",member);
                            return "busring_cus";
                        case "운전사":
                            model.addAttribute("useOne",member);
                            return "busring_dri";
                        case "관리자":
                            model.addAttribute("memberList",members);
                            model.addAttribute("busList",buss);
                            model.addAttribute("info",infos);
                            return "adminPage";
                        default:
                            return "signup";
                    }
                }
            }

            // 로그인 실패
            model.addAttribute("error", "아이디 또는 비밀번호가 올바르지 않습니다.");
            return "redirect:/main";
        }
    }





