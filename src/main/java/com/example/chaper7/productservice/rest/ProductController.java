package com.example.chaper7.productservice.rest;

import com.example.chaper7.productservice.command.CreateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final CommandGateway commandGateway;

    @Autowired
    public ProductController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel model){

        CreateProductCommand command = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .title(model.getTitle())
                .price(model.getPrice())
                .quantity(model.getQuantity())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
            System.out.println("Case 1");
        }
        catch (Exception ex){
            result = ex.getLocalizedMessage();
            System.out.println("Case 2");
        }
        return result;
    }

    @DeleteMapping
    public String deleteProduct(){
        return "Product Deleted";
    }
}
