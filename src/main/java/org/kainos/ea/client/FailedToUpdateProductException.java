package org.kainos.ea.client;

public class FailedToUpdateProductException extends Throwable{
    public String getMessage(){
        return "Failed to update product in database";
    }
}
