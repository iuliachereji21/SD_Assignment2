package com.example.sd_assignment2.business.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "admin")
    private List<Restaurant> restaurants;

    public User getUser() {
        return user;
    }

    public Admin(){
        super();
    }

    public Admin(String email, User user){
        this.email=email;
        this.user=user;
    }

    public String getEmail() {
        return email;
    }


    public long getId(){
        return this.id;
    }
}
