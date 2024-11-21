package com.bbraun.producto.repository;

import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.models.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto,String> {


    List<Producto> findAll();

    List<Producto> findByIdCategoria(Categoria categoria);

    @Query("select u from Producto u where u.nombre= ?1")
    List<Producto> findByNombre(String nombre);

    @Query("SELECT p.idProducto from Producto p order by p.idProducto desc")
    List<String> getLastCodeProducto();

    Producto findByNombreAndAndConcentracion(String nombre, String concentracion);


    @Query(value = "SELECT p.id_producto, p.nombre, SUM(l.stock), p.concentracion from productos p"
            +" JOIN lotes l "+
            "ON l.idproducto = p.id_producto " +
            "GROUP BY p.id_producto "+
            " ORDER BY SUM(l.stock) "+
            " LIMIT 3;", nativeQuery = true)
    List<Object[]> getLowerStockProduct();


    @Query(value = "SELECT p.id_producto, p.nombre, p.concentracion, l.idlote, l.fechavencimiento from productos p " +
                     "JOIN lotes l "+
            "ON l.idproducto = p.id_producto " +
                    " ORDER BY l.fechavencimiento " +
                    "LIMIT 3;", nativeQuery = true)
    List<Object[]> getExpiringProduct();

    @Query(value = " SELECT COUNT(*) from productos; ", nativeQuery = true)
    Integer getQuantityProduct();

}
