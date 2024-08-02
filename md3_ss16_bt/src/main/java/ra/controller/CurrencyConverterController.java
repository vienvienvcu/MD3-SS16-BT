package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("currencyConverterController")
public class CurrencyConverterController {
    private static final double EXCHANGE_RATE = 23500.0; // Tỉ giá USD/VNĐ

    @GetMapping
    public String showForm(Model model) {
        return "showForm";
    }

    @PostMapping("/convert")
    public String convertCurrency(@RequestParam("usd") double usd, Model model) {
        double vnd = usd * EXCHANGE_RATE;
        model.addAttribute("usd", usd);
        model.addAttribute("vnd", vnd);
        model.addAttribute("rate", vnd);

        return "result";
    }
}
