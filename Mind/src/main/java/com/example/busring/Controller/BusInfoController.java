package com.example.busring.Controller;

import com.example.busring.Service.BusInfoService;
import com.example.busring.Service.MemberService;
import com.example.busring.dto.MemberDTO;
import com.example.busring.dto.businfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
@CrossOrigin
public class BusInfoController {

    @Autowired
    private BusInfoService busInfoService;

    @Autowired
    private MemberService memberService;

    @RequestMapping("/businfo_create")
    public String join(businfo info, Model model) {
        busInfoService.insertOne(info);
        model.addAttribute("businfo", busInfoService.selectOne(info.getNum()).get(0));
        return "buscomend";
    }

    @RequestMapping("status_update")
    public String updateStatus(long num, @RequestParam("status") String status, Model model) {
        businfo infos = busInfoService.selectOne(num).get(0);

        if (infos != null) {
            switch (status) {
                case "출발":
                    infos.setStatus("출발");
                    break;
                case "대기":
                    infos.setStatus("대기");
                    break;
                case "도착":
                    infos.setStatus("도착");
                    break;
                default:
                    break;
            }
            busInfoService.insertOne(infos);
        }
        model.addAttribute("businfo",infos);
        return "buscomend";
    }

    @RequestMapping("des_update")
    public String updateDes(long num, @RequestParam("des") String des, Model model){
        businfo infos1 = busInfoService.selectOne(num).get(0);

        if (infos1 != null) {
            switch (des) {
                case "모란":
                    infos1.setDestination("모란");
                    break;
                case "남한산성":
                    infos1.setDestination("남한산성");
                    break;
                case "학교":
                    infos1.setDestination("학교");
                    break;
                default:
                    break;
            }
            busInfoService.insertOne(infos1);
        }
        model.addAttribute("businfo",infos1);
        return "buscomend";
    }

    @RequestMapping("refactor/{num}")
    public String getAll(Model model, @PathVariable Long num){
        model.addAttribute("useOne", memberService.selectOne(num).get(0));
        model.addAttribute("businfo", busInfoService.getAll());
        return "busring_cus";
    }
    @RequestMapping("status_delete")
    public String endOne(long num){
        busInfoService.deleteOne(num);
        return "redirect:/";
    }

}
