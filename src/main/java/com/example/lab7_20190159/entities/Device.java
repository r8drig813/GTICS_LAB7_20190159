package com.example.lab7_20190159.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deviceid", nullable = false)
    private Integer deviceid;

    @Column(name = "devicename")
    private String devicename;

    @Column(name = "devicetype")
    private String devicetype;

    @Column(name = "model")
    private String model;

    @Column(name = "serialnumber")
    private String serialnumber;

    @ManyToOne
    @JoinColumn(name = "siteID")
    private Site siteID;

}