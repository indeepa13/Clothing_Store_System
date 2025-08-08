package model.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String category;
    private String color;
    private String size;
    private String image;
    private Integer qty;
    private Double cost_price;
    private Double selling_price;
    private Integer supplier;
    private LocalDate added_date;
    private String description;



}
