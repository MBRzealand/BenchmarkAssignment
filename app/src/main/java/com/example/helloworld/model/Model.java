package com.example.helloworld.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable {

    private String data;

    private String reversedData;

    private ArrayList<String> dataList;

    private ArrayList<String> reversedDataList;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public String getReversedData() {
        return reversedData;
    }

    public void setReversedData(String reversedData) {
        this.reversedData = reversedData;
    }


    public ArrayList<String> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<String> dataList) {
        this.dataList = dataList;
    }


    public ArrayList<String> getReversedDataList() {
        return reversedDataList;
    }

    public void setReversedDataList(ArrayList<String> reversedDataList) {
        this.reversedDataList = reversedDataList;
    }


    public String reverseString(String data){

        return new StringBuilder(data).reverse().toString();
    }

}
