package com.example.busring.Controller;

import com.example.busring.Service.BusService;
import com.example.busring.dto.bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class BusController {

    @Autowired
    private BusService busService;

    @ResponseBody
    @RequestMapping("/getAll1")
    public List<bus> getAll() {return busService.getAll();}

    @RequestMapping("/busjoin")
    public String bus( ){
        return "busjoin";
    }

    @RequestMapping("/busregi")
    public String join(bus b){
        busService.insertOne(b);

        return "redirect:/busjoin";
    }

}
