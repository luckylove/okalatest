package com.marinabay.cruise.service;

import com.marinabay.cruise.dao.SchedulesDao;
import com.marinabay.cruise.model.JSonPagingResult;
import com.marinabay.cruise.model.PagingModel;
import com.marinabay.cruise.model.Schedules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: son.nguyen
 * Date: 9/23/14
 * Time: 7:15 PM
 */
@Service
public class SchedulesService extends GenericService<Schedules>{

    @Autowired
    private SchedulesDao schedulesDao;

    @Override
    public SchedulesDao getDao() {
        return schedulesDao;
    }

    public JSonPagingResult<Schedules> list(PagingModel model) {
        Long count = schedulesDao.count(model);
       /* if (StringUtils.isEmpty(model.getName())) {
            model.setName("userName");
        }
        //need translate filed to column
        if ("userName".equals(model.getName())) {
            model.setName("user_name");
        } else if ("taxiLicense".equals(model.getName())) {
            model.setName("taxi_license");
        } else if ("taxiLicense".equals(model.getName())) {
            model.setName("taxi_license");
        }*/
        return JSonPagingResult.ofSuccess(count, schedulesDao.select(model));
    }

}
