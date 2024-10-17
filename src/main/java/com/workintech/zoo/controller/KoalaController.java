package com.workintech.zoo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/koalas")
public class KoalaController {

    private Map<Integer, String> koalas;

    public KoalaController() {
        koalas = new HashMap<>();
        // Örnek koala verisi
        koalas.put(1, "Koala 1");
        koalas.put(2, "Koala 2");
    }

    // Tüm koala'ları listele
    @GetMapping
    public Map<Integer, String> getAllKoalas() {
        return koalas;
    }

    // Belirli bir ID'deki koala'yı getir
    @GetMapping("/{id}")
    public String getKoalaById(@PathVariable int id) {
        return koalas.get(id);
    }

    // Yeni bir koala ekle
    @PostMapping
    public String addKoala(@RequestParam String name) {
        int id = koalas.size() + 1;
        koalas.put(id, name);
        return "Koala added with ID: " + id;
    }

    // Belirli bir ID'deki koala'yı güncelle
    @PutMapping("/{id}")
    public String updateKoala(@PathVariable int id, @RequestParam String name) {
        if (koalas.containsKey(id)) {
            koalas.put(id, name);
            return "Koala updated with ID: " + id;
        } else {
            return "Koala not found with ID: " + id;
        }
    }

    // Belirli bir ID'deki koala'yı sil
    @DeleteMapping("/{id}")
    public String deleteKoala(@PathVariable int id) {
        if (koalas.containsKey(id)) {
            koalas.remove(id);
            return "Koala deleted with ID: " + id;
        } else {
            return "Koala not found with ID: " + id;
        }
    }
}
