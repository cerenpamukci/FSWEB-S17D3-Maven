package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    public KoalaController() {
        koalas = new HashMap<>();
        koalas.put(1, new Koala(1, "Koala 1", 10.0, 30.0, "Female"));
        koalas.put(2, new Koala(2, "Koala 2", 12.0, 28.0, "Male"));
    }

    @GetMapping
    public ResponseEntity<Collection<Koala>> getAllKoalas() {
        return ResponseEntity.ok(koalas.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Koala> getKoalaById(@PathVariable int id) {
        Koala koala = koalas.get(id);
        if (koala == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(koala);
    }

    @PostMapping
    public ResponseEntity<Koala> addKoala(@RequestBody Koala koala) {
        int id = koalas.size() + 1;
        koala.setId(id);
        koalas.put(id, koala);
        return ResponseEntity.status(HttpStatus.OK).body(koala);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Koala> updateKoala(@PathVariable int id, @RequestBody Koala koala) {
        Koala existingKoala = koalas.get(id);
        if (existingKoala == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        koala.setId(id);
        koalas.put(id, koala);
        return ResponseEntity.ok(koala);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKoala(@PathVariable int id) {
        Koala existingKoala = koalas.get(id);
        if (existingKoala == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        koalas.remove(id);
        return ResponseEntity.ok().build();
    }
}