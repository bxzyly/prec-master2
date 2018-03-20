package com.goi.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"password"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "用户名不能为空！")
    private String username;//用户名

    @JsonIgnore
    @Column(nullable = false)
    @NotEmpty(message = "密码不能为空！")
    private String password;//密码

    @Column(unique = true,length = 20)
    private String nickname;//昵称

    private String  sex;//性别

    @Column(nullable = false)
    private int userType = 0;//用户类型，默认值为0为普通注册用户，1为手机直接注册用户

    private String birthday;

    private String bloodType;//血型

    private String hometown;//家乡

    private String location;//所在地

    private String school;//学校

    private String company;//公司

    @Column(nullable = false)
    @Pattern(regexp = "^[1][3,4,5,7,8][0-9]{9}$", message = "手机号不正确")
    @NotNull(message = "手机号不能为空！")
    private String telephone;//手机

    private String personalitySignature;//个性签名

    private String personalExplanation;//个人说明

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date time;//创建时间

    private int reported = 0;//被举报的数

    private int fabulous = 0;//被点赞的数

    private String followIds = "0";//关注某人的id字符串

    @ManyToMany(cascade = CascadeType.PERSIST, fetch=FetchType.LAZY)
    @JoinTable(name="user_label",joinColumns = {@JoinColumn(name = "uid")},inverseJoinColumns =  {@JoinColumn(name = "lid")})
    private List<Label> labelList;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<User_Label> user_labels;


    public User() {
    }

    public User(String username, String password, String telephone,int userType) {
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.userType = userType;
    }

    public User(String username, String password, String nickname, String sex, int userType, String birthday, String bloodType, String hometown, String location, String school, String company, String telephone, String personalitySignature, String personalExplanation, Date time, int reported, int fabulous, String followIds) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.userType = userType;
        this.birthday = birthday;
        this.bloodType = bloodType;
        this.hometown = hometown;
        this.location = location;
        this.school = school;
        this.company = company;
        this.telephone = telephone;
        this.personalitySignature = personalitySignature;
        this.personalExplanation = personalExplanation;
        this.time = time;
        this.reported = reported;
        this.fabulous = fabulous;
        this.followIds = followIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    public List<User_Label> getUser_labels() {
        return user_labels;
    }

    public void setUser_labels(List<User_Label> user_labels) {
        this.user_labels = user_labels;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", userType=" + userType +
                ", birthday='" + birthday + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", hometown='" + hometown + '\'' +
                ", location='" + location + '\'' +
                ", school='" + school + '\'' +
                ", company='" + company + '\'' +
                ", telephone='" + telephone + '\'' +
                ", personalitySignature='" + personalitySignature + '\'' +
                ", personalExplanation='" + personalExplanation + '\'' +
                ", time=" + time +
                ", reported=" + reported +
                ", fabulous=" + fabulous +
                ", followIds='" + followIds + '\'' +
                '}';
    }
}
