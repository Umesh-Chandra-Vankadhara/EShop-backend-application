package com.upgrad.eshopApp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.List;


@Data
@Entity
@Table(name="ESHOP_USER")
public class EshopUser {
//    @SequenceGenerator(name="ESHOP_USER_ID_GENERATOR" )
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESHOP_USER_ID_GENERATOR")
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
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

    @Column(name="email_id")
    private String email;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="PHONE_NUMBER")
    private String phoneNumber;

    @Column(name="ROLE")
    private String role;

    @Column(name="USER_NAME")
    private String username;

    //bi-directional many-to-one association to EshopOrder
    @OneToMany(mappedBy="eshopUser")
    private List<EshopOrder> eshopOrders;

    //bi-directional many-to-one association to EshopShippingAddress
    @OneToMany(mappedBy="eshopUser")
    private List<EshopShippingAddress> eshopShippingAddresses;

    public EshopUser() {
    }





}
