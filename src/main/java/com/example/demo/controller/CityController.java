package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/city/add")
    public Map<String, Object> addCity(@RequestBody City city) {
        return cityService.addCity(city);
    }

    @GetMapping("/city/all")
    public Map<String, Object> getAll() {
        return cityService.getAll();
    }

    @GetMapping("/city/{id}")
    public Map<String, Object> getById(@PathVariable(value = "id") Long id) {
        return cityService.getById(id);
    }

    @PutMapping("/city/update")
    public Map<String, Object> update(@RequestBody City city) {
        return cityService.updateCity(city);
    }

    @DeleteMapping("/city/delete")
    public Map<String, Object> delete(@RequestBody Long[] listId) {
        return cityService.deleteCity(listId);
    }
}
