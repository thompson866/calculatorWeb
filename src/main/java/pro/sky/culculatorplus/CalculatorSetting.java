package pro.sky.culculatorplus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorSetting {
    private final CalculatorService service;

    public CalculatorSetting(CalculatorService service) {
        this.service = service;

    }

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите все числа";
        }
        return num1 + " + " + num2 + " = " + service.sum(Integer.parseInt(num1), Integer.parseInt(num2));
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите все числа";
        }
        return num1 + " - " + num2 + " = " + service.sum(Integer.parseInt(num1), Integer.parseInt(num2));
    }


    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите все числа";
        }
        return num1 + " * " + num2 + " = " + service.sum(Integer.parseInt(num1), Integer.parseInt(num2));
    }


    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) String num1, @RequestParam(required = false) String num2) {
        if (num1 == null || num2 == null || num1.isEmpty() || num2.isEmpty()) {
            return "Введите все числа";
        }
        if (num2.equals("0")){
            return "на ноль делить нельзя";
        }
        return num1 + " / " + num2 + " = " + service.sum(Integer.parseInt(num1), Integer.parseInt(num2));
    }
}



