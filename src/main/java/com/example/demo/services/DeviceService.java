package com.example.demo.services;

import com.example.demo.daos.DeviceDao;
import com.example.demo.models.Device;
import com.example.demo.models.Gateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeviceService
{
    @Autowired
    DeviceDao deviceDao;

    public ResponseEntity<String> add(Device device)
    {
        Gateway gateway = device.getGateway();
        Integer count = deviceDao.countAllByGateway(gateway);
        if (count < 10)
        {
            if (null == device.getDateCreated())
            {
                device.setDateCreated(new Date());
            }
            deviceDao.save(device);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        } else
        {
            return new ResponseEntity<>("This gateway has reached its device limit of 10", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> remove(Long id)
    {
        deviceDao.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.ACCEPTED);
    }
}
