package com.example.mychef.advice;

import com.example.mychef.dto.MessageDTO;
import com.example.mychef.dto.requestDTO.UserRequestDTO;
import com.example.mychef.model.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import org.modelmapper.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAdvice {

//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public MessageDTO handleNullPointerException(NullPointerException exception){
//        MessageDTO messageDTO = new MessageDTO();
//        messageDTO.setMessage("NullPointerException occurred");
//        messageDTO.setType("BAD_REQUEST");
//        return messageDTO;
//    }
//****************************************
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageDTO handleEntityNotFoundException(EntityNotFoundException exception){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage("Entity not found");
        messageDTO.setType("NOT_FOUND");
        return messageDTO;
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MessageDTO handleValidationException(ValidationException exception){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage("Validation failed");
        messageDTO.setType("UNPROCESSABLE_ENTITY");
        return messageDTO;
    }

    //500 i add id not in
    // 500 same but this time i delete paramerter


    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public MessageDTO handleGenericException(Exception exception){
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage("An unexpected error occurred");
        messageDTO.setType("INTERNAL_SERVER_ERROR");
        return messageDTO;
    }
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public MessageDTO handleNullPointerExceptionInternalServerError(NullPointerException exception){
//        MessageDTO messageDTO = new MessageDTO();
//        messageDTO.setMessage("Internal server error due to NullPointerException");
//        messageDTO.setType("INTERNAL_SERVER_ERROR");
//        return messageDTO;
//    }
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public MessageDTO handleNullPointerExceptionBadRequest(NullPointerException exception){
//        MessageDTO messageDTO = new MessageDTO();
//        messageDTO.setMessage("NullPointerException occurred");
//        messageDTO.setType("BAD_REQUEST");
//        return messageDTO;
//    }
//****************************************
    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public MessageDTO handleNullPointerException(NullPointerException exception, HttpServletResponse response, UserRequestDTO userRequest){
        MessageDTO messageDTO = new MessageDTO();

        if (isBadRequestScenario(userRequest)) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            messageDTO.setMessage("NullPointerException occurred");
            messageDTO.setType("BAD_REQUEST");
        } else {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            messageDTO.setMessage("Internal server error due to NullPointerException");
            messageDTO.setType("INTERNAL_SERVER_ERROR");
        }

        return messageDTO;
    }
    private boolean isBadRequestScenario(UserRequestDTO userRequest) {

        return userRequest != null && userRequest.getId() == null;
    }
    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
