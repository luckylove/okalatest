package com.marinabay.cruise.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HelloController {

    private Logger LOG = LoggerFactory.getLogger(HelloController.class);




	@RequestMapping(value = {"/", "/index.html"}, method = RequestMethod.GET)
	public String home(ModelMap model, Integer page, String searchText) {
        if (page == null || page == 0) {
            page = 1;
        }
        model.addAttribute("page", page);
        return "/index";
    }

    @RequestMapping(value = {"/login.html"}, method = RequestMethod.GET)
	public String login(ModelMap model, Integer page, String searchText) {
        return "/login";
    }

    @RequestMapping(value = {"/loginSubmit.html"}, method = RequestMethod.POST)
	public String loginSubmit(ModelMap model, Integer page, String searchText) {
        return "redirect:index.html";
    }

    @RequestMapping(value = {"/error.html"}, method = RequestMethod.GET)
    public String error(ModelMap model, Integer page) {
        return "/error";
    }



}