package com.example.rabbitmq.service;
import com.example.rabbitmq.dao.SaleAdvertisementRepository;
import com.example.rabbitmq.dao.UserRepository;
import com.example.rabbitmq.dto.SaleAdvertisementDto;
import com.example.rabbitmq.entity.SaleAdvertisement;
import com.example.rabbitmq.entity.Users;
import com.example.rabbitmq.rabbit.publisher.SaleAdvertisementProducer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class SaleAdvertisementServiceImp implements SaleAdvertisementService {

    private SaleAdvertisementProducer saleAdvertisementProducer;
    @Autowired
    private SaleAdvertisementRepository saleAdvertisementRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<SaleAdvertisement> gelAll() {
        return saleAdvertisementRepository.findAll();
    }

    @Override
    public boolean createSaleAdvertisement(SaleAdvertisementDto saleAdvertisementDto) {
        try {
            Users user = Users.builder()
                    .userName(saleAdvertisementDto.getUserName())
                    .email(saleAdvertisementDto.getEmail())
                    .build();
            userRepository.save(user);

            SaleAdvertisement saleAdvertisement = SaleAdvertisement.builder()
                    .title(saleAdvertisementDto.getTitle())
                    .photo(saleAdvertisementDto.getPhoto())
                    .detailedMessage(saleAdvertisementDto.getDetailedMessage())
                    .priceGraphPath("Hesaplanıyor...")
                    .build();
            saleAdvertisementRepository.save(saleAdvertisement);
            saleAdvertisementProducer.sendToQueue(saleAdvertisement);
            return true;
        } catch (Exception exception){
            return false;
        }
    }
}
