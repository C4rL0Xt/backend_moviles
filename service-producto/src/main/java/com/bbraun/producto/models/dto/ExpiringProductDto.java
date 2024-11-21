package com.bbraun.producto.models.dto;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpiringProductDto {

    private String productId;
    private String nombre;
    private String loteId;
    private String concentracion;
    private String fechaExpiracion;
}
