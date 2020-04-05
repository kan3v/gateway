package com.example.demo;

import com.example.demo.daos.GatewayDao;
import com.example.demo.models.Device;
import com.example.demo.models.Gateway;
import com.example.demo.services.DeviceService;
import com.example.demo.services.GatewayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.rmi.server.UID;
import java.util.Date;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests
{


    @Autowired
    DeviceService deviceService;

    @Autowired
    GatewayService gatewayService;

    @Autowired
    GatewayDao gatewayDao;

    @Test
    @Rollback
    void testGateway()
    {
        Gateway gateway = new Gateway("test", new UID().toString(),"127.0.0.1");
        gatewayService.add(gateway);
    }

    @Test
    @Rollback
    void testDevice()
    {
        Gateway gateway = new Gateway("test", new UID().toString(),"127.0.0.1");
        gatewayDao.save(gateway);
        Device device = new Device(new Random().nextLong(),"test",new Date(), Device.Status.online, gateway);
        deviceService.add(device);
    }

}
