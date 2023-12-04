package com.example.busring.Controller;

import com.example.busring.Service.BusService;
import com.example.busring.dto.bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class BusController {

    @Autowired
    private BusService busService;

//    @ResponseBody
//    @RequestMapping("/getAll1")
//    public List<bus> getAll() {return busService.getAll();}

    @RequestMapping("/busjoin")
    public String bus(Model model){
        model.addAttribute("busList", busService.getAll());
        return "busjoin";
    }

    @RequestMapping("/busregi")
    public String join(bus b){
        busService.insertOne(b);

        return "redirect:/busjoin";
    }

    @RequestMapping("/busdelete")
    public String delete(long num){
        busService.deleteOne(num);
        return "redirect:/busjoin";
    }

    @RequestMapping("/busupdatepage")
    public String updatepage(long num, Model model){
        model.addAttribute("busOne",busService.selectOne(num).get(0));
        return "busupdatepage";
    }

    @RequestMapping("/busupdate")
    public String updateOne(bus b){
        busService.updateOne(b);
        return "redirect:/busjoin";
    }


}
