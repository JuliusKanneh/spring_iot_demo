package com.wisdom.iot_demo.services;

import com.wisdom.iot_demo.models.Data;
import com.wisdom.iot_demo.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataServices {
    @Autowired
    private DataRepository dataRepository;

    public void save(Data data){
        dataRepository.save(data);
    }

    public List<Data> getAll(){
        return (ArrayList<Data>) dataRepository.findAll();
    }

    public void delete(int id){
        dataRepository.deleteById(id);
    }

    public double getTemp(double temp){
        return temp;
    }

    public Data findById(int id){
        return dataRepository.findById(id).orElse(null);
    }

}
