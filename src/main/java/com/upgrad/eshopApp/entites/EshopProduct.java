package com.upgrad.eshopApp.entites;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@Entity
@Table(name="ESHOP_PRODUCT")
public class EshopProduct {

    @Id
//    @SequenceGenerator(name="PRODUCTID_GENERATOR" )
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTID_GENERATOR")
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//            name = "Hiberante_Sequence",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="PRODUCT_ID")
    private int productId;

    @Column(name="AVAILABLE_ITEMS")
    private int availableItems;

    @Column(nullable = false)
    private String category;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;


    private String description;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    private String manufacturer;

    private String name;

    private double price;

    //bi-directional many-to-one association to EshopOrder
    @OneToMany(mappedBy="eshopProduct")
    private List<EshopOrder> eshopEshopOrders;
//
//    @Id
//    @SequenceGenerator(name="PRODUCTID_GENERATOR" )
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTID_GENERATOR")
////    @GeneratedValue(generator = "sequence-generator")
////    @GenericGenerator(
////            name = "Hiberante_Sequence",
////            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
////            parameters = {
////                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "product_sequence"),
////                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
////                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
////            }
////    )
//    @Column(name="PRODUCT_ID",nullable = false)
//    private int productId;
//
//    @Column(name="AVAILABLE_ITEM",nullable = false)
//    private int availableItem;
//
//    @Column(nullable = false)
//    private String category;
//
//    @CreationTimestamp
//    private LocalDateTime created;
//
//    @UpdateTimestamp
//    private LocalDateTime updated;
//
//    @Column(nullable = false)
//    private String description;
//
//    @Column(name="IMAGE_URL", nullable = false)
//    private String imageUrl;
//
//    @Column(nullable = false)
//    private String manufacturer;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private double price;
//
//    //bi-directional many-to-one association to EshopOrder
//    @OneToMany(mappedBy="eshopProduct")
//    private List<Order> eshopOrders;

    public EshopProduct() {
    }




}
