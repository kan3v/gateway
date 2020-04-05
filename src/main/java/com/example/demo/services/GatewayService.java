package com.example.demo.services;


import com.example.demo.daos.GatewayDao;
import com.example.demo.models.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatewayService
{
    @Autowired
    GatewayDao gatewayDao;

    public List<Gateway> getAll()
    {
        return (List<Gateway>) gatewayDao.findAll();
    }

    public List<Gateway> find(Long id, String serialNumber)
    {
        return gatewayDao.find(id, serialNumber);
    }

    public ResponseEntity<Gateway> add(Gateway gateway)
    {
        Gateway gateway1 = gatewayDao.save(gateway);

        return new ResponseEntity<>(gateway1, HttpStatus.CREATED);
    }
}
