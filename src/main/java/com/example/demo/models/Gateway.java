package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
public class Gateway
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(unique = true)
    private String serialNumber;

    @NotNull(message = "Enter IPv4")
    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$",message = "Enter Valid IPv4")
    private String ipv4;


    @OneToMany(mappedBy = "gateway", cascade = CascadeType.REMOVE)
    @Fetch(FetchMode.JOIN)
    private Set<Device> devices;

    public Gateway()
    {
    }

    public Gateway(String name, String serialNumber, String ipv4)
    {
        this.name = name;
        this.serialNumber = serialNumber;
        this.ipv4 = ipv4;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSerialNumber()
    {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public String getIpv4()
    {
        return ipv4;
    }

    public void setIpv4(String ipv4)
    {
        this.ipv4 = ipv4;
    }

   @JsonGetter("devices")
    public Set<Device> getDevices()
    {
        return devices;
    }

    @JsonIgnore
    public void setDevices(Set<Device> devices)
    {
        this.devices = devices;
    }
}
