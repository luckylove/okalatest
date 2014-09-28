package com.marinabay.cruise.controller;

import com.marinabay.cruise.constant.ROLE;
import com.marinabay.cruise.constant.USERTYPE;
import com.marinabay.cruise.model.*;
import com.marinabay.cruise.service.UserGroupService;
import com.marinabay.cruise.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    private Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final String VIEW_TYPE = "viewType";
    @Autowired
    private UserService userService;

    @Autowired
    private UserGroupService userGroupService;


	@RequestMapping(value = {"/userGroup.html"}, method = RequestMethod.GET)
	public String userGroup(HttpServletRequest request, ModelMap model) {
        model.addAttribute(VIEW_TYPE, "userGroup");
        return "/index";
    }

    @RequestMapping(value = {"/addUserGroup.json"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JSonResult addUserGroup(HttpServletRequest request, UserGroup userGroup) {
        if (userGroup.getId() != null && userGroup.getId() > 0) {
            userGroupService.update(userGroup);
            return JSonResult.ofSuccess("Update group success");
        } else {
            if (StringUtils.isNotEmpty(userGroup.getName())) {

                if (userGroupService.findByName(userGroup.getName()) != null) {
                    return JSonResult.ofError("This name is already used");
                } else {
                    userGroupService.insert(userGroup);
                    return JSonResult.ofSuccess("Add group success");
                }
            } else {
                return JSonResult.ofError("Name of group can not empty");
            }
        }
    }

    @RequestMapping(value = {"/listUserGroup.json"}, method = RequestMethod.GET)
    @ResponseBody
    public JSonPagingResult<UserGroup> listUserGroup(HttpServletRequest request, PagingModel model) {
        return userGroupService.list(model);
    }


    @RequestMapping(value = {"/deleteUserGroup.json"}, method = RequestMethod.GET)
    @ResponseBody
    public JSonResult<String> deleteUserGroup(HttpServletRequest request, Long id) {
        try {
            userGroupService.deleteByID(id);
        } catch (Exception e) {
            LOG.error("", e);
            return JSonResult.ofError("Can not delete usergroup");
        }
        return JSonResult.ofSuccess("Delete success");
    }

    /**
     * part of user
     * @param request
     * @param model
     * @return
     */

    @RequestMapping(value = {"/userList.html"}, method = RequestMethod.GET)
    public String userList(HttpServletRequest request, ModelMap model) {
        model.addAttribute(VIEW_TYPE, "userList");
        //load all user group
        model.addAttribute("userGroup", userGroupService.listAlll(new PagingModel()));
        return "/index";
    }

    @RequestMapping(value = {"/addUser.json"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JSonResult addUser(HttpServletRequest request, User user) {
        if (user.getId() != null && user.getId() > 0) {
            userService.update(user);
            return JSonResult.ofSuccess("Update user success");
        } else {
            if (StringUtils.isNotEmpty(user.getEmail()) || StringUtils.isNotEmpty(user.getUserName())) {
                if (userService.findUserByEmail(user.getEmail()) != null) {
                    return JSonResult.ofError("This email is already used");
                } else {
                    user.setRole(ROLE.USER);
                    user.setUserType(USERTYPE.WEB);
                    userService.insert(user);
                    return JSonResult.ofSuccess("Add group success");
                }
            } else {
                return JSonResult.ofError("Some of fields can not empty");
            }
        }
    }

    @RequestMapping(value = {"/listUser.json"}, method = RequestMethod.GET)
    @ResponseBody
    public JSonPagingResult<User> listUser(HttpServletRequest request, PagingModel model) {
        return userService.list(model);
    }




}