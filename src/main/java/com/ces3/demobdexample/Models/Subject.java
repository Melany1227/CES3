package com.ces3.demobdexample.Models;

import java.util.Date;
import lombok.*;

@Data
public class Subject {
    private Integer id;
    private String name;
    private String code;
    private String description;
    private Integer credit;
    private Faculty faculty;
    private Date create_at;
    private Date updated_at;
    private Date deleted_at;
}
