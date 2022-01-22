package com.wisdom.iot_demo.repositories;

import com.wisdom.iot_demo.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {
//    public void deleteByName(String name);
}
