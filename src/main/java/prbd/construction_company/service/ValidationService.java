package prbd.construction_company.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ValidationService {

    public Map<String, String> getErrorsMap(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        fieldError -> fieldError.getField() + "Error",
                        //todo придумать отлов typeMismatchException
                        fieldError -> {
                            if (Arrays.asList(fieldError.getCodes()).contains("typeMismatch"))
                                return "Please fill value";
                            else return fieldError.getDefaultMessage();
                        }
                ));
    }
}
