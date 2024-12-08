package dev.sana.volvorecruitementtask.exceptions;

import dev.sana.volvorecruitementtask.DTO.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse<Map<String, Object>> handleCountryNotFound(CountryNotFoundException ex) {
        System.out.println("Handled exception, return " + ex.getMessage());
        return new ApiResponse<>("error", Map.of("reason", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<Map<String, Object>> handleException(Exception ex) {
        System.out.println("Unhandled exception: " + ex.getMessage() + " returned to user");
        ex.printStackTrace();
        return new ApiResponse<>("error", Map.of("reason", "Internal Server Error"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse<Map<String, Object>> handleIllegalArgumentException(IllegalArgumentException ex) {
        return new ApiResponse<>("error", Map.of("reason", ex.getMessage()));
    }
}
