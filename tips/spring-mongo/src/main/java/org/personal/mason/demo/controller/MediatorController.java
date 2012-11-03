package org.personal.mason.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: masonmei
 * Date: 11/3/12
 * Time: 1:30 AM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/")
public class MediatorController {
    @RequestMapping
    public String getHomePage(){
        return "redirect:/users";
    }
}
