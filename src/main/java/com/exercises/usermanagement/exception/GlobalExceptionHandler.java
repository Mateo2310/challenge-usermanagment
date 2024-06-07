package com.exercises.usermanagement.exception;

import com.exercises.usermanagement.dto.response.ResponseErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // handle specific exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseErrorDTO> handleResourceNotFoundException(ResourceNotFoundException exception,
                                                                            WebRequest webRequest){
        ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO(exception.getMessage());
        return new ResponseEntity<>(responseErrorDTO, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(BlogAPIException.class)
//    public ResponseEntity<ErrorDetails> handleBlogAPIException(BlogAPIException exception,
//                                                               WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
//                webRequest.getDescription(false));
//        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
//    }
    // global exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseErrorDTO> handleGlobalException(Exception exception,
                                                              WebRequest webRequest){
        ResponseErrorDTO errorDetails = new ResponseErrorDTO(exception.getMessage());
        System.err.println(webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
