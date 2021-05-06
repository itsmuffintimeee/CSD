package com.fc.vo;

import lombok.Data;

import java.util.List;

@Data
public class AfterVO<T> {
    private Integer code;
    private Long count;
    private String msg;
    private List<T> data;
}
