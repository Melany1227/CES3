package com.ces3.demobdexample.Models;
import java.util.Date;
import lombok.Data;

@Data
public class Enrollement {
    private Integer id_user;
    private Integer id_subject;
    private Date date_enrollement;
    private State state;
    private String term;
    private Date create_at;
    private Date updated_at;
    private Date deleted_at;
}
