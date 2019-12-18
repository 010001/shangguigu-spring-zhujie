package com.fb01001.bean;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Tolerate;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-18 下午1:34
 */
@Builder
@Data
public class Person {
    private String id;
    private String name;
    private int age;
    @Tolerate
    public Person(){};
}
