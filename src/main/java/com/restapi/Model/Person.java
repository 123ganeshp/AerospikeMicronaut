package com.restapi.Model;

import com.aerospike.mapper.annotations.*;




@AerospikeRecord(namespace= "test",set="Person")
public class Person {
    @AerospikeKey

    @AerospikeBin

    private int id;
     @AerospikeBin
    private String name;
     @AerospikeBin
    private String email;
    @AerospikeBin
    private int sal;
    @AerospikeBin
    private String JoiningDate;



      @AerospikeEmbed
      @AerospikeBin
    private Categories categories;



    public Person(int id, String name, String email, int sal,String JoiningDate, Categories categories) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sal = sal;
        this.JoiningDate=JoiningDate;

        this.categories = categories;
    }

    public Person() {

    }

    public Person(String name, String email, int sal,String JoingDate, Categories categories) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSal() {
        return sal;
    }

    public String getJoiningDate() {
        return JoiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        JoiningDate = joiningDate;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }



    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sal=" + sal +
                ", JoiningDate='" + JoiningDate + '\'' +
                ", categories=" + categories +
                '}';
    }
}
