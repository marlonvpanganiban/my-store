package mycom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document("product")
@Data
public class Product {

    @Id
    private String id;
    @Field("code")
    private String skuCode;
    @Field("name")
    private String productName;


    
}
