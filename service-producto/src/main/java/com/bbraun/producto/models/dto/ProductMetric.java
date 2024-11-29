package com.bbraun.producto.models.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductMetric {
    private String name;
    private int unitsSold;
    private double revenue;
}
