package com.restapi.Model;

import com.aerospike.mapper.annotations.AerospikeBin;
import com.aerospike.mapper.annotations.AerospikeKey;
import com.aerospike.mapper.annotations.AerospikeRecord;

//@AerospikeRecord (namespace= "test",set="Categories")
@AerospikeRecord
public class Categories {


    private int categoriesId;

    private String nature;


    public Categories() {
    }

    public Categories(int categoriesId,String nature) {
        this.categoriesId = categoriesId;
        this.nature = nature;
    }

    public int getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(int categoriesId) {
        this.categoriesId = categoriesId;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "categoriesId=" + categoriesId +
                ", nature='" + nature + '\'' +
                '}';
    }
}
