package com.example.grocerydeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

// Lombok constructors og setters/getters.
// JPA skal altid bruge en tom constructor
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Vi bruger ikke GenerationType.AUTO, fordi den laver en hjælpetabel der viser, hvad det næste ID er.
    // Det gør IDENTITY ikke. Man kan self godt, men vi skal ikke bruge tabellen til noget.
    // @Column(name="productid")
    private int productId;

    private String name;
    private double price;
    private double weight;

    // En type af produkt kan tilhøre mange orders. "product" peger bare på klassen.
    @OneToMany(mappedBy = "product")
    @JsonBackReference // Gør bare at der ikke opstår en json bug, når du skriver json ud.
    private Set<ProductOrder> productOrders = new HashSet<>();



}
