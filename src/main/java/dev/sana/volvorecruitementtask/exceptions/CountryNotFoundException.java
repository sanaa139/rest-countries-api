package dev.sana.volvorecruitementtask.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(String message){
        super(message);
    }
}
