package com.trigital.cm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Records Found")
public class NoRecordsFoundException extends RuntimeException{
	
	public NoRecordsFoundException() {
        super();
    }

    public NoRecordsFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRecordsFoundException(String message) {
        super(message);
    }

    public NoRecordsFoundException(Throwable cause) {
        super(cause);
    }
	

}
