package prbd.construction_company.controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import prbd.construction_company.dto.ApartmentDto;
import prbd.construction_company.exception.NotFoundException;

import javax.validation.Valid;

@ControllerAdvice
public class CustomAdviceController {

    @ExceptionHandler(NotFoundException.class)
    public String handleException(Model model, NotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "error-page";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleException(Model model) {
        model.addAttribute("message", "Error! Incorrect request");
        return "error-page";
    }

}
