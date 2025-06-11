package com.ces3.demobdexample.Models;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id_user;
    private String name;
    private String lastname;
    private Date birthdate;
    private String email;
    private String password;
    private Boolean is_active;
    private String phone;
    private Gender gender;
    private Date created_at;
    private Date updated_at;
    private Date deleted_at;
}
