package com.example.sd_assignment2.business.model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public Customer(){
        super();
    }

    public Customer(String phone, User user){
        this.phone=phone;
        this.user=user;
    }

    public String getPhone() {
        return phone;
    }


    public long getId(){
        return this.id;
    }
}
