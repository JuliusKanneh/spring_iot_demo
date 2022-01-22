package com.wisdom.iot_demo.controllers;

import com.wisdom.iot_demo.models.Data;
import com.wisdom.iot_demo.services.DataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DataAPIController {

    @Autowired
    private DataServices dataServices;

//    @PostMapping(value = "/push")
//    public void save(@RequestBody Data data){
//        dataServices.save(data);
//    }

    @PostMapping(value = "/push")
    public void save(@RequestParam double temp, @RequestParam double hum){
        Data data = new Data();
        data.setTemp(temp);
        data.setHum(hum);
        dataServices.save(data);
    }

    //this api is working for posting data
    @RequestMapping(value = "/push/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    public void update(@PathVariable int id, @RequestParam double temp, @RequestParam double hum){
        Data data = dataServices.findById(id);
        data.setTemp(temp);
        data.setHum(hum);
        dataServices.save(data);
    }

    @GetMapping(value = "/pull")
    public List<Data> getAll(){
        return dataServices.getAll();
    }

    @GetMapping(value = "/pull_test")
    public double getTemp(){
        return dataServices.getTemp(89.9);
    }

    @GetMapping("/data/{id}")
    public ArrayList<Double> getData(@PathVariable int id){
        Data myData = dataServices.findById(id);
        double temp = myData.getTemp();
        double hum = myData.getHum();
        ArrayList<Double> send_data = new ArrayList<>();
        send_data.add(temp);
        send_data.add(hum);
        return send_data;
    }

//    @GetMapping("/data/{id}")
//    public Double getData(@PathVariable int id){
//        Data myData = dataServices.findById(id);
//        double temp = myData.getTemp();
////        double hum = myData.getHum();
////        ArrayList<Double> send_data = new ArrayList<>();
////        send_data.add(hum);
////        send_data.add(temp);
//        return temp;
//    }
}
