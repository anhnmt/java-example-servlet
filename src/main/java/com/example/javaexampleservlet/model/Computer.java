package com.example.javaexampleservlet.model;

import java.time.LocalDate;

public class Computer {
    private Integer ComId;
    private String ComName;
    private String Producer;
    private String Description;
    private LocalDate YearMaking;
    private Float Price;

    public Computer() {
    }

    public Computer(Integer comId, String comName, String producer, String description, LocalDate yearMaking, Float price) {
        ComId = comId;
        ComName = comName;
        Producer = producer;
        Description = description;
        YearMaking = yearMaking;
        Price = price;
    }

    public Computer(String comName, String producer, String description, LocalDate yearMaking, Float price) {
        ComName = comName;
        Producer = producer;
        Description = description;
        YearMaking = yearMaking;
        Price = price;
    }

    public Integer getComId() {
        return ComId;
    }

    public void setComId(Integer comId) {
        ComId = comId;
    }

    public String getComName() {
        return ComName;
    }

    public void setComName(String comName) {
        ComName = comName;
    }

    public String getProducer() {
        return Producer;
    }

    public void setProducer(String producer) {
        Producer = producer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LocalDate getYearMaking() {
        return YearMaking;
    }

    public void setYearMaking(LocalDate yearMaking) {
        YearMaking = yearMaking;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }
}
