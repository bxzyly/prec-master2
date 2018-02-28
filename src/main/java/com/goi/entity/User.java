package com.goi.entity;


import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;//用户名

    private String password;//密码

    @Column(unique = true,nullable = false,length = 20)
    private String name;//昵称

    @Column(nullable = false)
    private String  sex;//性别

    @Column(nullable = false)
    private int userType = 0;//用户类型，默认值为0为普通用户

    private String birthday;

    private String bloodType;//血型

    private String hometown;//家乡

    private String location;//所在地

    private String school;//学校

    private String company;//公司

    @Column(nullable = false)
    private String telephone;//手机

    @Column(nullable = false)
    private String email;//邮件

    private String personalitySignature;//个性签名

    private String personalExplanation;//个人说明

    @Column(nullable = false)
    private String lableIds;//userModel中用户基本类型id

    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;//创建时间

    private int reported = 0;//被举报的数

    private int fabulous = 0;//被点赞的数

    private String followIds = "0";//关注某人的id字符串

    public User() {
    }

    public User(String name,String password ,String sex, String telephone, String email) {
        this.name = name;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.password = password;
    }

    public User(String username, String password, String name, String sex, int userType, String birthday, String bloodType, String hometown, String location, String school, String company, String telephone, String email, String personalitySignature, String personalExplanation, String lableIds, Date time, int reported, int fabulous, String followIds) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.userType = userType;
        this.birthday = birthday;
        this.bloodType = bloodType;
        this.hometown = hometown;
        this.location = location;
        this.school = school;
        this.company = company;
        this.telephone = telephone;
        this.email = email;
        this.personalitySignature = personalitySignature;
        this.personalExplanation = personalExplanation;
        this.lableIds = lableIds;
        this.time = time;
        this.reported = reported;
        this.fabulous = fabulous;
        this.followIds = followIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonalitySignature() {
        return personalitySignature;
    }

    public void setPersonalitySignature(String personalitySignature) {
        this.personalitySignature = personalitySignature;
    }

    public String getPersonalExplanation() {
        return personalExplanation;
    }

    public void setPersonalExplanation(String personalExplanation) {
        this.personalExplanation = personalExplanation;
    }

    public String getLableIds() {
        return lableIds;
    }

    public void setLableIds(String lableIds) {
        this.lableIds = lableIds;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getReported() {
        return reported;
    }

    public void setReported(int reported) {
        this.reported = reported;
    }

    public int getFabulous() {
        return fabulous;
    }

    public void setFabulous(int fabulous) {
        this.fabulous = fabulous;
    }

    public String getFollowIds() {
        return followIds;
    }

    public void setFollowIds(String followIds) {
        this.followIds = followIds;
    }
}
