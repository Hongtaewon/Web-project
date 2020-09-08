package web.project.backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class ConflictException extends  RuntimeException {
    private String fieldName;
    private Object fieldValue;

    public ConflictException(String fieldName, Object fieldValue) {
        super(String.format("%s field data '%s' is already exists", fieldName, fieldValue));
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
