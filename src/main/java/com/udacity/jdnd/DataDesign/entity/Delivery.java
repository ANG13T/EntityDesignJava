package com.udacity.jdnd.DataDesign.entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NamedQuery(name = "Delivery.findByName",
        query = "select d from Delivery d where d.name = :name")

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    Long id;

    @Nationalized
    private String name;
    @Column(name = "address_full", length = 500)
    private String address;
    private LocalDateTime deliveryTime;
    private Date time;
    @Type(type = "yes_no")
    private boolean completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.REMOVE)
    private List<Plant> plants;

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime){
        this.deliveryTime = deliveryTime;
    }

    public void setTime(Date time){
        this.time = time;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public Long getId(){
        return id;
    }

    public List<Plant> getPlants(){
        return this.plants;
    }


}
