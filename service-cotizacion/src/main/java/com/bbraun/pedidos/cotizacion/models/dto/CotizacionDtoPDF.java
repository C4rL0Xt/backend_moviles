package com.bbraun.pedidos.cotizacion.models.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CotizacionDtoPDF {
    private String nombrecliente;
    private Float montoproducto;
    private Date fechaemision;
    private String dni;
    private Float montoimpuesto;
    private Float montototal;
    private String departamento;
    private List<DetalleDtoPDF> detalles;
}
