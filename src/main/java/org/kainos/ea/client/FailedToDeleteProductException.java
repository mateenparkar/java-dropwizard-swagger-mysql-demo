package org.kainos.ea.client;

public class FailedToDeleteProductException extends  Throwable {
    public String getMessage(){
        return "Failed to delete product from database";
    }

}
