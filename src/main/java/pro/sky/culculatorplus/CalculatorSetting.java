package pro.sky.culculatorplus;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorSetting {
    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

}
