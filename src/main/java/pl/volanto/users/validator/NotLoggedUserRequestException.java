package pl.volanto.users.validator;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No access to other users data")
public class NotLoggedUserRequestException extends RuntimeException {
}
