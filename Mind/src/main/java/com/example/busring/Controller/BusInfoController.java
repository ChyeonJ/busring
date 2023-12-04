package com.example.busring.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@CrossOrigin //크로스 오리진은 리엑트 같이 view 파일 사용 시 오류 충돌을 막기 위함.
public class BusInfoController {
}
