package com.marinabay.cruise.service;

import com.marinabay.cruise.dao.NotificationDao;
import com.marinabay.cruise.model.JSonPagingResult;
import com.marinabay.cruise.model.Notification;
import com.marinabay.cruise.model.PagingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: son.nguyen
 * Date: 9/23/14
 * Time: 7:15 PM
 */
@Service
public class NotificationService extends GenericService<Notification>{

    @Autowired
    private NotificationDao notificationDao;

    @Override
    public NotificationDao getDao() {
        return notificationDao;
    }

    public JSonPagingResult<Notification> list(PagingModel model) {
        Long count = notificationDao.count(model);
        List<Notification> userGroups = notificationDao.select(model);
        return JSonPagingResult.ofSuccess(count, userGroups);
    }

    public List<Notification> listAlll(PagingModel model) {
        return notificationDao.select(model);
    }



}
