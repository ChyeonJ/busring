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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class BusController {

    @Autowired
    private BusService busService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private BusInfoService busInfoService;

//    @ResponseBody
//    @RequestMapping("/getAll1")
//    public List<bus> getAll() {return busService.getAll();}
    @RequestMapping("adminPage")
    public String adminPage(Model model){
        List<MemberDTO> members = memberService.getAll();
        List<bus> buss = busService.getAll();
        List<businfo> infos = busInfoService.getAll();
        model.addAttribute("memberList",members);
        model.addAttribute("busList",buss);
        model.addAttribute("info",infos);
        return "adminPage";
    }

    @RequestMapping("busjoin")
    public String bus(){
        return "busjoin";
    }

    @RequestMapping("busring_dri/choice")
    public String busAll(Model model){
        model.addAttribute("busList", busService.getAll());
        return "choice";
    }

    @RequestMapping("businfo_join")
    public String businfo_join(Model model, long num){
        model.addAttribute("busList", busService.selectOne(num).get(0));
        return "businfo_join";
    }

    @RequestMapping("busregi")
    public String join(bus b){
        busService.insertOne(b);

        return "redirect:/adminPage";
    }

    @RequestMapping("busdelete")
    public String delete(long num){
        busService.deleteOne(num);
        return "redirect:http://localhost:8080/adminPage";
    }


    @RequestMapping("busupdatepage")
    public String updatepage(long num, Model model){
        model.addAttribute("busOne",busService.selectOne(num).get(0));
        return "busupdatepage";
    }


    @RequestMapping("busupdate")
    public String updateOne(bus b){
        busService.updateOne(b);
        return "redirect:/adminPage";
    }


}
