package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnersController {

    @RequestMapping({"/owners", "/owners/index", "owners/index.html"})
    String listOwners(){
        return "owners/index";
    }
}

