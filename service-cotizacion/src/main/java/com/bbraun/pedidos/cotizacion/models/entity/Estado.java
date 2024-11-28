package com.bbraun.pedidos.cotizacion.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "estados")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Estado {

    @Id
    @Column(name = "id_estado")
    private Integer idestado;
    private String estado;
}
