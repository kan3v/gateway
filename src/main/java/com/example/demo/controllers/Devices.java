package com.example.demo.controllers;


import com.example.demo.models.Device;
import com.example.demo.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("device/*")
public class Devices
{

    @Autowired
    DeviceService deviceService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> saveDevice(@Valid @RequestBody Device device)
    {
        return deviceService.add(device);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteDevice(@PathVariable Long id)
    {
       return deviceService.remove(id);
    }

}
