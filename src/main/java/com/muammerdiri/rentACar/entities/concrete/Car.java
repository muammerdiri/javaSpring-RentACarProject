package com.muammerdiri.rentACar.entities.concrete;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="model_year")
    private int modelYear;

    @Column(name="daily_price")
    private double dailyPrice;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;
    @OneToOne
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    private Brand brand;
    @ManyToOne()
    @JoinColumn(name = "color_id",referencedColumnName = "id")
    private Color color;

}











//    @Column(name="brand_id")
//    private int brandId;
//
//    @Column(name="color_id")
//    private int colorId;