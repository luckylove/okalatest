package com.marinabay.cruise.controller;

import com.marinabay.cruise.model.Cruise;
import com.marinabay.cruise.model.JSonPagingResult;
import com.marinabay.cruise.model.PagingModel;
import com.marinabay.cruise.service.CruiseService;
import com.marinabay.cruise.service.UserGroupService;
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
public class NotificationController {

    private Logger LOG = LoggerFactory.getLogger(NotificationController.class);

    private final String VIEW_TYPE = "viewType";

    @Autowired
    private CruiseService cruiseService;

    @Autowired
    private UserGroupService userGroupService;

	@RequestMapping(value = {"/notification.html"}, method = RequestMethod.GET)
	public String notification(HttpServletRequest request, ModelMap model) {
        model.addAttribute(VIEW_TYPE, "notification");
        model.addAttribute("userGroup", userGroupService.listAlll(new PagingModel()));
        return "/index";
    }

    @RequestMapping(value = {"/listNotification.json"}, method = RequestMethod.GET)
    @ResponseBody
    public JSonPagingResult<Cruise> listNotification(HttpServletRequest request, PagingModel model) {
        return cruiseService.list(model);
    }


   /* @RequestMapping(value = {"/addCruise.json"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public JSonResult addCruise(HttpServletRequest request, Cruise cruise) {
        if (cruise.getId() != null && cruise.getId() > 0) {
            cruiseService.update(cruise);
            return JSonResult.ofSuccess("Update cruise success");
        } else {
            if (StringUtils.isNotEmpty(cruise.getName())) {

                if (cruiseService.findByName(cruise.getName()) != null) {
                    return JSonResult.ofError("This name is already used");
                } else {
                    cruiseService.insert(cruise);
                    return JSonResult.ofSuccess("Add cruise success");
                }
            } else {
                return JSonResult.ofError("Name of cruise can not empty");
            }
        }
    }

    @RequestMapping(value = {"/deleteCruise.json"}, method = RequestMethod.GET)
    @ResponseBody
    public JSonResult<String> deleteCruise(HttpServletRequest request, String ids) {
        if (StringUtils.isNotEmpty(ids)) {
            try {
                Iterable<String> strings = Splitter.on(",").omitEmptyStrings().split(ids);
                for (String id : strings) {
                    cruiseService.deleteByID(Long.valueOf(id));
                }
            } catch (Exception e) {
                LOG.error("", e);
                return JSonResult.ofError("Can not delete users");
            }
        }
        return JSonResult.ofSuccess("Delete success");
    }
*/




}