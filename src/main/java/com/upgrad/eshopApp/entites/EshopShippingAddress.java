package com.upgrad.eshopApp.entites;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="ESHOP_SHIPPING_ADDRESS")
public class EshopShippingAddress {
    @Id
//    @SequenceGenerator(name="ESHOP_SHIPPING_ADDRESS_ID_GENERATOR" )
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESHOP_SHIPPING_ADDRESS_ID_GENERATOR")
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//            name = "Hiberante_Sequence",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "ShippingAddress_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="CITY",nullable = false)
    private String city;

    @Column(name="LANDMARK")
    private String landmark;

    @Column(name="NAME",nullable = false)
    private String name;

    @Column(name="PHONE_NUMBER",nullable = false)
    private String phoneNumber;

    @Column(name="STATE",nullable = false)
    private String state;

    @Column(name="STREET",nullable = false)
    private String street;

    @Column(name="ZIPCODE",nullable = false)
    private String zipcode;

    //bi-directional many-to-one association to EshopOrder
    @OneToMany(mappedBy="eshopShippingAddress")
    private List<EshopOrder> eshopEshopOrders;

    //bi-directional many-to-one association to EshopUser
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private EshopUser eshopUser;

    public EshopShippingAddress() {
    }




}
