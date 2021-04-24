package org.s166.ums.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int id;
    private String name ;
    private String pass ;
    private String sex ;
    private int age;
    private Date regTime ;

}
