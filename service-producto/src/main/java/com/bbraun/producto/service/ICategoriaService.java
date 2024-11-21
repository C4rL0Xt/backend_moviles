package com.bbraun.producto.service;

import com.bbraun.producto.models.dto.CategoryChartDto;
import com.bbraun.producto.models.entity.Categoria;

import java.util.List;

public interface ICategoriaService {

    public List<Categoria> findAll();

    public Categoria findById(String id);

    public Categoria save(Categoria categoria);

    public void deleteById(String id);

    public List<String> findAllCat();

    Categoria findByName(String nombre);

    List<CategoryChartDto> getQuantityByCategory();

    Integer getTotalCategorias();
}
