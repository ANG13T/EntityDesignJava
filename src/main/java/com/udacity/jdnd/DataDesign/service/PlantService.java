package com.udacity.jdnd.DataDesign.service;

import com.udacity.jdnd.DataDesign.entity.Plant;
import org.springframework.stereotype.Service;

@Service
public class PlantService {
    public Plant getPlantByName(String name){
        return new Plant();
    }
}
