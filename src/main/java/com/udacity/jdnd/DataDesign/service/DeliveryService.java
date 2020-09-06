package com.udacity.jdnd.DataDesign.service;

import com.udacity.jdnd.DataDesign.entity.Delivery;
import com.udacity.jdnd.DataDesign.entity.RecipientAndPrice;
import com.udacity.jdnd.DataDesign.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    DeliveryRepository deliveryRepository;

    public Long save(Delivery delivery){
        delivery.getPlants().forEach(plant -> plant.setDelivery(delivery));
        deliveryRepository.persist(delivery);
        return delivery.getId();
    }

    public RecipientAndPrice getBill(Long deliveryId){
        return deliveryRepository.getBill(deliveryId);
    }

}
