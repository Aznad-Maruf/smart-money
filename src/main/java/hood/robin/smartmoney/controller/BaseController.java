package hood.robin.smartmoney.controller;

import hood.robin.smartmoney.entity.BaseEntity;
import hood.robin.smartmoney.service.BaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public abstract class BaseController<T extends BaseEntity> {

    private final BaseService<T> baseService;

    @GetMapping("{uuid}")
    public ResponseEntity<T> get(@PathVariable UUID uuid) {
        T entity = baseService.find(uuid);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(entity);
    }

    @GetMapping
    public ResponseEntity<List<T>> getAll(){
        // TODO Add pagination
        List<T> entities = baseService.findAll();

        return ResponseEntity.ok(entities);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid T entity, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        T savedEntity = baseService.save(entity);

        return ResponseEntity.ok(savedEntity);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid T entity,
                                    BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        T updatedEntity = baseService.update(entity);

        return ResponseEntity.ok(updatedEntity);
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<?> delete(@PathVariable UUID uuid) {
        T entity = baseService.find(uuid);

        if (entity == null) {
            return ResponseEntity.notFound().build();
        }

        T deletedEntity = baseService.delete(entity);

        return ResponseEntity.ok(deletedEntity);
    }
}