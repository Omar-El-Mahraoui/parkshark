package be.dumbo.switchfully.parkshark.api.interceptors;

//copied and adapted code from order solution switchfully

import oracle.jdbc.OracleDatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice(basePackages = "be.dumbo.switchfully.parkshark.api")
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public Error IllegalStateExceptionHandler(IllegalStateException exception, HttpServletRequest request) {
        return new Error(exception, BAD_REQUEST, request);
    }

    /*//https://stackoverflow.com/questions/36555057/get-field-name-when-javax-validation-constraintviolationexception-is-thrown
    //https://stackoverflow.com/questions/45070642/springboot-doesnt-handle-javax-validation-constraintviolationexception
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Set<String>> handleConstraintViolation(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

        Set<String> messages = new HashSet<>(constraintViolations.size());
        messages.addAll(constraintViolations.stream()
                .map(constraintViolation -> String.format("%s value '%s' %s", constraintViolation.getPropertyPath(),
                        constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
                .collect(Collectors.toList()));

        return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    }*/

    //https://stackoverflow.com/questions/36555057/get-field-name-when-javax-validation-constraintviolationexception-is-thrown
    //https://stackoverflow.com/questions/45070642/springboot-doesnt-handle-javax-validation-constraintviolationexception
    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Error handleJavaxConstraintViolationException(ConstraintViolationException exception, HttpServletRequest request) {
        //https://stackoverflow.com/questions/3042060/fastest-way-to-put-contents-of-setstring-to-a-single-string-with-words-separat
        //String constraintViolations = String.join(",", (CharSequence) e.getConstraintViolations());
        return new Error(exception, BAD_REQUEST, request);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(org.hibernate.exception.ConstraintViolationException.class)
    @ResponseBody
    public Error handleHibernateConstraintViolationException(org.hibernate.exception.ConstraintViolationException exception
            , HttpServletRequest request) {
        return new Error(exception, BAD_REQUEST, request);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseBody
    public Error handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception
            , HttpServletRequest request) {
        return new Error(exception, BAD_REQUEST, request);
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(OracleDatabaseException.class)
    @ResponseBody
    public Error handleOracleDatabaseException(OracleDatabaseException exception, HttpServletRequest request) {
        return new Error(exception, BAD_REQUEST, request);
    }

    public static class Error {

        private static final Logger LOGGER = LoggerFactory.getLogger(Error.class);

        private String uniqueErrorId;
        private String message;
        private int httpStatus;

        private Error() {
        }

        private Error(Exception exception, HttpStatus httpStatus, HttpServletRequest request){
            uniqueErrorId = UUID.randomUUID().toString();
            this.message = exception.getMessage();
            this.httpStatus = httpStatus.value();
            logError(exception, request);
        }

        private void logError(Exception e, HttpServletRequest request) {
            LOGGER.error("REST call threw exception [" + uniqueErrorId + "] , request=" + fullURL(request), e);
        }

        private String fullURL(HttpServletRequest request) {
            return request.getMethod() + " " + request.getRequestURL() +
                    ((request.getQueryString() != null) ? "?" + request.getQueryString() : "");
        }

        public String getUniqueErrorId() {
            return uniqueErrorId;
        }

        public String getMessage() {
            return message;
        }

        public int getHttpStatus() {
            return httpStatus;
        }
    }

}
