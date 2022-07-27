package com.assessment.project.advisor;

import com.assessment.project.exception.EntryDuplicateException;
import com.assessment.project.exception.NotFoundException;
import com.assessment.project.util.StandardLogger;
import com.assessment.project.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity handleNullPointerException(NullPointerException e) {
        return new ResponseEntity(new StandardResponse(404, "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e) {
        return new ResponseEntity(new StandardResponse(404, "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntryDuplicateException.class})
    public ResponseEntity duplicateExceptionHandler(EntryDuplicateException e){
        LoggerHandler.handleLogger(new StandardLogger("error", e.getMessage()));
        return new ResponseEntity(
                new StandardResponse(404, "Entries Duplicate Exception",
                        e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
