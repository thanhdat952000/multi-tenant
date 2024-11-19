package com.example.demo.service;

import com.example.demo.domain.City;

import java.util.Map;

public interface CityService {
    Map<String, Object> getAll();

    Map<String, Object> addCity(City city);

    Map<String, Object> updateCity(City city);

    Map<String, Object> getById(Long id);

    Map<String, Object> deleteCity(Long[] listId);
}
