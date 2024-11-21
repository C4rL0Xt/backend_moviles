package com.bbraun.producto.models.dto;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LowerStockProductDto {

    private String productoId;
    private String nombre;
    private String concentracion;
    private Integer stock;

}
