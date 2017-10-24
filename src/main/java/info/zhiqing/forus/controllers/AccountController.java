package info.zhiqing.forus.controllers;

import info.zhiqing.forus.exceptions.TokenNotMatchException;
import info.zhiqing.forus.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/active/{username}/{token}", method = RequestMethod.GET)
    public String active(@PathVariable String username, @PathVariable String token, ModelMap model) {

        try {
            accountService.activeUser(username, token);
            model.addAttribute("ok", true);
        } catch (TokenNotMatchException e) {
            e.printStackTrace();
            model.addAttribute("ok", false);
        }

        return "active";
    }
}
