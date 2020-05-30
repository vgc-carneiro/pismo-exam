package br.exam.pismo

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus

import java.time.LocalDateTime

class ApiError {

    HttpStatus status
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    LocalDateTime timestamp
    String message

    private ApiError() {
        timestamp = LocalDateTime.now()
    }

    ApiError(HttpStatus status) {
        this()
        this.status = status
    }

    ApiError(HttpStatus status, Throwable ex) {
        this()
        this.status = status
        this.message = "Unexpected error"
    }

    ApiError(HttpStatus status, String message, Throwable ex) {
        this()
        this.status = status
        this.message = message
    }
}
