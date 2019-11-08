package com.bw.week2.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class HomeEntity {

    @Id
    private Long id;
    private String jsonResult;
    @Generated(hash = 584869693)
    public HomeEntity(Long id, String jsonResult) {
        this.id = id;
        this.jsonResult = jsonResult;
    }
    @Generated(hash = 1364639484)
    public HomeEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getJsonResult() {
        return this.jsonResult;
    }
    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }
    
}
