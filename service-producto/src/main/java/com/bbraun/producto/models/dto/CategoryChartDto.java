package com.bbraun.producto.models.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryChartDto {

    private String nombre;
    private Long cantidad;
}
