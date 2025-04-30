package mycom.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mycom.dto.AddProductResponse;
import mycom.dto.ProductRequest;
import mycom.model.Product;
import mycom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public AddProductResponse addProduct(ProductRequest productRequest){

        Product product= modelMapper.map(productRequest, Product.class);
        log.info("product:"+product);
        Objects.requireNonNull(product);
        return new AddProductResponse("Product Saved",null,productRepository.save(product));
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    @Cacheable("product-case")
    public Product getProduct(String id){

        Optional<Product> product=productRepository.findById(id);
        if(!product.isPresent()){
              throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Product Not -Found");
        }

        log.info("get Product invoked");
        return product.get();
    }
}
