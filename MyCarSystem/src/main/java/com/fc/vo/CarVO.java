package com.fc.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class CarVO implements Serializable {
    private Integer id;

    private String name;

    private String type;

    private Integer sitnum;

    private String cname;

    private Double price;

    private Integer number;

    private String picture;
}
