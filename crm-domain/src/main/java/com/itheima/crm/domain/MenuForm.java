package com.itheima.crm.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 13718 on 2017/9/13.
 */
@Entity
public class MenuForm {

    private String id;
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
