package prbd.construction_company.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import prbd.construction_company.exception.NotFoundException;

@ControllerAdvice
public class CustomAdviceController {

    @ExceptionHandler(NotFoundException.class)
    public String handleException(Model model, NotFoundException e) {
        model.addAttribute("message", e.getMessage());
        return "error-page";
    }
}
