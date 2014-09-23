package com.marinabay.cruise.controller;

import com.marinabay.cruise.model.User;
import com.marinabay.cruise.service.UserService;
import com.marinabay.cruise.utils.RequestUtls;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class IndexController {

    private Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private UserService userService;


	@RequestMapping(value = {"/", "/index.html"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request, ModelMap model) {
        model.addAttribute("loggedUser", RequestUtls.getLoggedUser(request));
        return "/index";
    }

    @RequestMapping(value = {"/login.html"}, method = RequestMethod.GET)
	public String login() {
        return "/login";
    }

    @RequestMapping(value = {"/logout.html"}, method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        RequestUtls.clearLoggedUser(request);
        return "/login";
    }

    @RequestMapping(value = {"/loginSubmit.html"}, method = RequestMethod.POST)
	public String loginSubmit(HttpServletRequest request, ModelMap model, String email, String password) {
        if (StringUtils.isNotEmpty(email) && StringUtils.isNotEmpty(password)) {
            User userByEmail = userService.findUserByEmail(email);
            if (userByEmail != null) {
                if (userByEmail.getPassword().equals(password)) {
                    RequestUtls.logged(request, userByEmail);
                    return "redirect:index.html";
                }
            }
        }
        return "redirect:login.html?login=false";
    }

    @RequestMapping(value = {"/error.html"}, method = RequestMethod.GET)
    public String error(ModelMap model, Integer page) {
        return "/error";
    }



}