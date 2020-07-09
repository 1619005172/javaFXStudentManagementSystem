package com.wyh.ui;

public class Data {
    private String id;
    private String name;
    private String age;
    private String address;
    private String su_id;

    public Data(String id, String name, String age, String address, String su_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.su_id = su_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSu_id() {
        return su_id;
    }

    public void setSu_id(String su_id) {
        this.su_id = su_id;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", su_id='" + su_id + '\'' +
                '}';
    }
}
