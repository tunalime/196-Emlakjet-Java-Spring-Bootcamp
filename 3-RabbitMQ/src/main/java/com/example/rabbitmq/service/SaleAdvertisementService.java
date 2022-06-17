package com.example.rabbitmq.service;
import com.example.rabbitmq.dto.SaleAdvertisementDto;
import com.example.rabbitmq.entity.SaleAdvertisement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SaleAdvertisementService {

    List<SaleAdvertisement> gelAll();

    boolean createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto);



}
