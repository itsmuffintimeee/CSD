package com.fc.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderVO implements Serializable {
    private Integer id;

    private String uemail;

    private Double oprice;

    private String status;

    private String carType;

    private String getcity;

    private String backcity;

    private String picture;
}
