package br.exam.pismo.handler

import br.exam.pismo.ApiError
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.dao.DataAccessResourceFailureException
import org.springframework.dao.DuplicateKeyException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    protected ResponseEntity<Object> handleDuplicateKeyException(DuplicateKeyException ex){
        ApiError apiError = new ApiError(HttpStatus.CONFLICT)
        apiError.message = ex.message
        return buildResponseEntity(apiError)
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    protected ResponseEntity<Object> handleMongoExecutionTimeoutException(DataAccessResourceFailureException ex){
        ApiError apiError = new ApiError(HttpStatus.SERVICE_UNAVAILABLE)
        apiError.message = ex.message
        return buildResponseEntity(apiError)
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND)
        apiError.message = ex.message
        return buildResponseEntity(apiError)
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus())
    }

    //other exception handlers below
}
