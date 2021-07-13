package com.sunflower.project.model;

import java.util.Date;
import javax.persistence.*;

public class Recruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "create_time")
    private Date createTime;

    private String name;

    private String contact;

    @Column(name = "apply_for")
    private String applyFor;

    @Column(name = "former_company")
    private String formerCompany;

    private String gender;

    private Integer age;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * @return apply_for
     */
    public String getApplyFor() {
        return applyFor;
    }

    /**
     * @param applyFor
     */
    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    /**
     * @return former_company
     */
    public String getFormerCompany() {
        return formerCompany;
    }

    /**
     * @param formerCompany
     */
    public void setFormerCompany(String formerCompany) {
        this.formerCompany = formerCompany;
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}