package pl.volanto.contacts.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No access to other users contacts")
public class NotUserContactException extends RuntimeException {

}
