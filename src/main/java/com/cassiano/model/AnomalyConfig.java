package com.cassiano.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnomalyConfig {
    private String parentPattern;
    private Double limit;
}
