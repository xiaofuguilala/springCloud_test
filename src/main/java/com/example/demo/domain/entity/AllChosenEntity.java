package com.example.demo.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AllChosenEntity {
    public AllChosenEntity(){}

    private String albackname;

    private String modelbackname;
}