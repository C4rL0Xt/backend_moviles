package com.bbraun.pedidos.cotizacion.util;

import com.bbraun.pedidos.cotizacion.models.Producto;
import com.bbraun.pedidos.cotizacion.models.dto.CotizacionDtoPDF;
import com.bbraun.pedidos.cotizacion.models.dto.DetalleDtoPDF;
import com.bbraun.pedidos.cotizacion.models.entity.CotizacionVenta;
import com.bbraun.pedidos.cotizacion.models.entity.DetalleCotizacionVenta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterToDto {

    public CotizacionDtoPDF convertCotizacionEntityToDto(CotizacionVenta cotizacionVenta, List<DetalleDtoPDF> detalles){
        CotizacionDtoPDF cotizacionDto = CotizacionDtoPDF.builder()
                .nombrecliente(cotizacionVenta.getNombre_cliente())
                .montoproducto(cotizacionVenta.getMonto_producto())
                .fechaemision(cotizacionVenta.getFecha_emision())
                .montoimpuesto(cotizacionVenta.getMonto_impuesto())
                .montototal(cotizacionVenta.getMonto_total())
                .dni(cotizacionVenta.getDni())
                .departamento(cotizacionVenta.getId_departamento().getNombreDepartamento())
                .detalles(detalles)
                .build();
        return cotizacionDto;
    }

    public DetalleDtoPDF converterDetallVToDto(DetalleCotizacionVenta detalleCotizacionVenta, Producto producto){
        DetalleDtoPDF detalleDto = DetalleDtoPDF.builder()
                .preciounitario(producto.getPrice())
                .producto(producto.getName())
                .subtotal(detalleCotizacionVenta.getMonto())
                .cantidad(detalleCotizacionVenta.getCantidad())
                .build();
        return detalleDto;
    }


}
