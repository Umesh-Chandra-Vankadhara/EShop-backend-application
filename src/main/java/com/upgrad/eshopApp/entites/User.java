package com.upgrad.eshopApp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Objects;


@Data
@Entity
@Table(name="ESHOP_USER")
public class User {
    @Id
    @SequenceGenerator(name="ESHOP_USER_ID_GENERATOR" )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESHOP_USER_ID_GENERATOR")
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//            name = "Hiberante_Sequence",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    private int id;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

    @Column(name="email_id")
    private String email;

    @Column(name="FIRST_NAME",nullable = false)
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="PHONE_NUMBER",nullable = false)
    private String phoneNumber;

    @Column(name="ROLE",nullable = false)
    private String role;

    @Column(name="USER_NAME",nullable = false,unique = true)
    private String username;

    //bi-directional many-to-one association to EshopOrder
    @OneToMany(mappedBy="eshopUser")
    private List<Order> Orders;

    //bi-directional many-to-one association to EshopShippingAddress
    @OneToMany(mappedBy="eshopUser")
    private List<ShippingAddress> ShippingAddresses;

    public User() {
    }





}
