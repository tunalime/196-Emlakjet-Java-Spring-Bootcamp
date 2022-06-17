package com.example.rabbitmq.controller;
import com.example.rabbitmq.dto.SaleAdvertisementDto;
import com.example.rabbitmq.entity.SaleAdvertisement;
import com.example.rabbitmq.service.SaleAdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/advertisements")
public class SaleAdvertisementController {

    @Autowired
    private SaleAdvertisementService saleAdvertisementService;

    @GetMapping
    public ResponseEntity<List<SaleAdvertisement>> getAll(){
        return new ResponseEntity<>(saleAdvertisementService.gelAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/create-advertisement")
    public ResponseEntity<SaleAdvertisement> createSaleAdvertisement(@RequestBody SaleAdvertisementDto saleAdvertisementDto){
        if (saleAdvertisementService.createSaleAdvertisement(saleAdvertisementDto)){
            return new ResponseEntity("Created", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Not Created", HttpStatus.BAD_REQUEST);
        }

    }
}
