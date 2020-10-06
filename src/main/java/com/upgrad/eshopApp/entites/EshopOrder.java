package com.upgrad.eshopApp.entites;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name="ESHOP_ORDER")
public class EshopOrder {
    @Id
//    @SequenceGenerator(name="ESHOP_ORDER_ID_GENERATOR" )
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ESHOP_ORDER_ID_GENERATOR")
//    @GeneratedValue(generator = "sequence-generator")
//    @GenericGenerator(
//            name = "Hiberante_Sequence",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "order_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "32"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
//            }
//    )
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private double amount;

    @Temporal(TemporalType.DATE)
    @Column(name="ORDER_DATE")
    private Date orderDate;

    //bi-directional many-to-one association to EshopProduct
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private EshopProduct eshopProduct;

    //bi-directional many-to-one association to EshopShippingAddress
    @ManyToOne
    @JoinColumn(name="SHIPPING_ADDRESS_ID")
    private EshopShippingAddress eshopShippingAddress;

    //bi-directional many-to-one association to EshopUser
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private EshopUser eshopUser;

    public EshopOrder() {
    }





}
