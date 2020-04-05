package com.example.demo.daos;



import com.example.demo.models.Gateway;
import org.springframework.data.repository.CrudRepository;

public interface GatewayDao extends CrudRepository<Gateway, Long>,GatewayDaoImpl.GatewayI
{
}
