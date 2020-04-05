package com.example.demo.daos;


import com.example.demo.models.Device;
import com.example.demo.models.Gateway;
import org.springframework.data.repository.CrudRepository;

public interface DeviceDao extends CrudRepository<Device, Long>
{
    Integer countAllByGateway(Gateway gateway);
}
