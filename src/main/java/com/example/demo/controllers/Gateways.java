package com.example.demo.controllers;


import com.example.demo.models.Gateway;
import com.example.demo.services.GatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("gateway/*")
public class Gateways
{

    @Autowired
    GatewayService gatewayService;

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public List<Gateway> gateway(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "serialNumber", required = false) String serialNumber)
    {
        return gatewayService.find(id, serialNumber);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public List<Gateway> gatewayList()
    {
        return gatewayService.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> gatewaySave(@Valid @RequestBody Gateway gateway)
    {
        return gatewayService.add(gateway);
    }

}
