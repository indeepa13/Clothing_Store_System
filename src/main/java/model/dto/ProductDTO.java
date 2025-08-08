package model.dto;


import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProductDTO {
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


    public void setPrice(String price) {
    }}
