package com.ssq.demo.jdkdemo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestStreamModel {

    private int id;

    private String name;

    private int grade;

    private int classes;

    private double score;

}
