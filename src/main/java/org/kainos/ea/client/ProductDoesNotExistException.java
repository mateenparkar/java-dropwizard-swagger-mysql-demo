package org.kainos.ea.client;

public class ProductDoesNotExistException extends Throwable {
    public String getMessage(){
        return "Product doesn't exist";
    }

}
