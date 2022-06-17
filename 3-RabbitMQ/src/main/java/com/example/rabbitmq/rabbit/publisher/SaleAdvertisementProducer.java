package com.example.rabbitmq.rabbit.publisher;
import com.example.rabbitmq.entity.SaleAdvertisement;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SaleAdvertisementProducer {

    @Value("${spring.rabbit.routing.name}")
    private String routingName;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    public void sendToQueue (SaleAdvertisement saleAdvertisement) {

        System.out.println("SaleAdvertisement sent to queue...");
        System.out.println(saleAdvertisement.toString());
        rabbitTemplate.convertAndSend(queue.getName(),saleAdvertisement);

    }
}
