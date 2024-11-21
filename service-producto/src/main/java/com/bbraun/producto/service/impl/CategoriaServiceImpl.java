package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.dto.CategoryChartDto;
import com.bbraun.producto.repository.CategoriaRepository;
import com.bbraun.producto.models.entity.Categoria;
import com.bbraun.producto.repository.ProductoRepository;
import com.bbraun.producto.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

    @Autowired
    private CategoriaRepository categoriaDAO;

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> findAll() {
        return (List<Categoria>) categoriaDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(String id) {
        return categoriaDAO.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public void deleteById(String id) {
        categoriaDAO.deleteById(id);
    }

    @Override
    public List<String> findAllCat() {
        return categoriaDAO.findAllCategories();
    }

    @Override
    public Categoria findByName(String nombre) {
        return categoriaDAO.findCategoriaByCategoria(nombre);
    }

    @Override
    public List<CategoryChartDto> getQuantityByCategory() {
        List<Object[]> data = categoriaDAO.getQuantityByCategory();
        List<CategoryChartDto> dtos = new ArrayList<>();
        int flag = 0;
        Long amount = 0L;
        for (Object[] o : data) {
            if( flag < 3) {
                CategoryChartDto dto = new CategoryChartDto();
                dto.setNombre((String) o[0]);
                dto.setCantidad((Long) o[1]);
                amount += (Long) o[1];
                dtos.add(dto);
            }else {
                dtos.add(CategoryChartDto.builder()
                        .nombre("Otros")
                        .cantidad((long) (productoRepository.getQuantityProduct() - amount))
                        .build());
                break;
            }

            flag++;
        }

        return dtos;
    }

    @Override
    public Integer getTotalCategorias() {
        return categoriaDAO.getTotalCategorias();
    }
}
