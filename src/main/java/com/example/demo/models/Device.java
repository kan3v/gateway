package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Device
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private Long uid;

    private String vendor;

    @DateTimeFormat
    private Date dateCreated;

    public enum Status
    {
        online,
        offline
    }

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private Gateway gateway;

    public Device()
    {
    }

    public Device(Long uid, String vendor, Date dateCreated, Status status, Gateway gateway)
    {
        this.uid = uid;
        this.vendor = vendor;
        this.dateCreated = dateCreated;
        this.status = status;
        this.gateway = gateway;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getUid()
    {
        return uid;
    }

    public void setUid(Long uid)
    {
        this.uid = uid;
    }

    public String getVendor()
    {
        return vendor;
    }

    public void setVendor(String vendor)
    {
        this.vendor = vendor;
    }

    public Date getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(Date dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public Status getStatus()
    {
        return status;
    }

    public void setStatus(Status status)
    {
        this.status = status;
    }

    @JsonIgnore
    public Gateway getGateway()
    {
        return gateway;
    }

    @JsonSetter("gateway")
    public void setGateway(Gateway gateway)
    {
        this.gateway = gateway;
    }
}
