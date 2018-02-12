package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/plaisirdb")
public class DatabaseController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public String get(ModelMap modelMap){
        return "Hello from DB";
    }
}
