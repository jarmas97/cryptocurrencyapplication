package github.com.cryptocurrencyapplication;

import github.com.cryptocurrencyapplication.markets.MarketDTO;
import github.com.cryptocurrencyapplication.markets.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private MarketService marketService = new MarketService();

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<MarketDTO> marketList = marketService.getMarketList();
        model.addAttribute("marketList", marketList);
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String getRegister() {
        return "register";
    }

}
