package com.wisdom.iot_demo.controllers;

import com.wisdom.iot_demo.models.Data;
import com.wisdom.iot_demo.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataController {

    @Autowired
    private DataServices dataServices;

    @GetMapping("/home")
    public String home(Model model){
        Data data = dataServices.findById(1);
        double temp = data.getTemp();
        double hum = data.getHum();
        model.addAttribute("temperature", temp);
        model.addAttribute("humidity", hum);
        model.addAttribute("values", data);
        return "home";
    }

    @GetMapping("/index")
    public String index(Model model){
        Data data = dataServices.findById(1);
        double temp = data.getTemp();
        double hum = data.getHum();
        model.addAttribute("temperature", temp);
        model.addAttribute("humidity", hum);
        model.addAttribute("values", data);
        return "index";
    }
}
