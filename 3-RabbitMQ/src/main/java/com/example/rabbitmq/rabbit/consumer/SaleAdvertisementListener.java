package com.example.rabbitmq.rabbit.consumer;
import com.example.rabbitmq.entity.SaleAdvertisement;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SaleAdvertisementListener {

    @RabbitListener(queues = "queue1-queue")
    public void handleAdvertisement (SaleAdvertisement saleAdvertisement) throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("SaleAdvertisement recieved...");
        saleAdvertisement.setPriceGraphPath("PriceGraphPath");
        System.out.println(saleAdvertisement.toString());

    }

}
