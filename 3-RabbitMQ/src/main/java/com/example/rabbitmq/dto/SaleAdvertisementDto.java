package com.example.rabbitmq.dto;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class SaleAdvertisementDto implements Serializable {

    private String title;
    private String photo;
    private String detailedMessage;
    private String userName;
    private String email;
    @Override
    public String toString() {
        return "SaleAdvertisementDto{" +
                "title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", detailedMessage='" + detailedMessage + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
