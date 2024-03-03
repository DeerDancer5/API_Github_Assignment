package com.example.zadanie_github.error;
import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class APIErrorResponse {
    private HttpStatus status;
    private String message;

    public APIErrorResponse(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}
