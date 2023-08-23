package org.kainos.ea.core;

import org.kainos.ea.cli.ProductRequest;

public class ProductValidator {
    public String isValidProduct(ProductRequest productRequest){
        if(productRequest.getName().length() > 50){
            return "Name greater than 50 characters";
        }

        if(productRequest.getDescription().length() > 500){
            return "Description greater than 500 characters";
        }
        if(productRequest.getPrice() < 10){
            return "Price less than £10";
        }

        return null;
    }
}
