package model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor

@AllArgsConstructor
@Setter
@Getter
public class SupplierDTO {
    private Integer id;

    private String name;

    private String company;
    private String email;
    private String contact;
}
