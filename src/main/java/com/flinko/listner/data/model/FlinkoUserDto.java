package com.flinko.listner.data.model;

import java.util.List;

public class FlinkoUserDto {

	private String name;

    private String email;

    private String phone;

    private List<Batches> batches;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setBatches(List<Batches> batches){
        this.batches = batches;
    }
    public List<Batches> getBatches(){
        return this.batches;
    }
}
