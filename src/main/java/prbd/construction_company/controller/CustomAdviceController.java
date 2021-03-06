package prbd.construction_company.controller;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import prbd.construction_company.exception.NotFoundException;

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

    @ExceptionHandler(ConstraintViolationException.class)
    public String handleUniqueException(Model model) {
        model.addAttribute("message", "Error! Entry already exists!");
        return "error-page";
    }
}
