package com.nbp.afrp.Login;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id 
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "num")
//    private Long num;
    @Column(name = "id")
    private String id;
    @Column(name = "pw")
    private String password;

//    public Long getNum() {
//        return num;
//    }
//
//    public void setNum(Long Num) {
//        this.num = Num;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}