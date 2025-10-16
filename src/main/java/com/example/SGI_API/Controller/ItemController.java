package com.example.SGI_API.Controller;
import com.example.SGI_API.Repositories.RepositorioItem;
import com.example.SGI_API.Models.ItemModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private RepositorioItem repositorioItem;
     // Crear un item
    @PostMapping
    public ItemModel crearItem(@RequestBody ItemModel item) {
        return repositorioItem.save(item);
    }
/*
Ejemplo json
{
  "name": "amborguesa",
  "description": "con queso",
  "quantity": 2,
  "category": "maxideli"
}
 */
    // Obtener todos los items
    @GetMapping
    public List<ItemModel> obtenerItems() {
        return repositorioItem.findAll();
    }

    // Obtener item por id
    @GetMapping("/{id}")
    public ResponseEntity<ItemModel> obtenerItemPorId(@PathVariable UUID id) {
        Optional<ItemModel> itemOpt = repositorioItem.findById(id);
        if (itemOpt.isPresent()) {
            return ResponseEntity.ok(itemOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar item
    @PutMapping("/{id}")
    public ResponseEntity<ItemModel> actualizarItem(@PathVariable UUID id, @RequestBody ItemModel itemActualizado) {
        Optional<ItemModel> itemOpt = repositorioItem.findById(id);
        if (itemOpt.isPresent()) {
            ItemModel item = itemOpt.get();
            item.setName(itemActualizado.getName());
            item.setDescription(itemActualizado.getDescription());
            item.setQuantity(itemActualizado.getQuantity());
            item.setCategory(itemActualizado.getCategory());
            repositorioItem.save(item);
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable UUID id) {
        if (repositorioItem.existsById(id)) {
            repositorioItem.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}
