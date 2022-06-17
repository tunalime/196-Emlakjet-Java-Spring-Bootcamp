package com.example.rabbitmq.entity;
import lombok.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SaleAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String photo;

    @Column(nullable = false)
    private String detailedMessage;

    @Column
    private String priceGraphPath;

    @Override
    public String toString() {
        return "SaleAdvertisement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", detailedMessage='" + detailedMessage + '\'' +
                ", priceGraphPath='" + priceGraphPath + '\'' +
                '}';
    }
}
