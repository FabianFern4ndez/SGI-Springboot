package com.example.SGI_API.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SGI_API.Models.ItemModel;



@Repository
public interface RepositorioItem extends JpaRepository<ItemModel, Long> {
    // Aquí puedes agregar consultas personalizadas si quieres
}
