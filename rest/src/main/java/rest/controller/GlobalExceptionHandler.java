package rest.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GlobalExceptionHandler {
    public static String handleConstraintViolationException(ConstraintViolationException ex) {

        StringBuilder message = new StringBuilder();
        List<ConstraintViolation> lstError = ex.getConstraintViolations().stream().collect(Collectors.toList());
        if (lstError.size() > 1){
            for (ConstraintViolation error :lstError){
                message = message.append(error.getMessage().replace("!",""));
                message = lstError.indexOf(error) == lstError.size()-1 ? message.append("") :message.append(",");
            }
        }else {
            message = message.append(lstError.get(0).getMessage());
        }
        return message.toString();
    }

}
