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

        //need translate filed to column
        if ("arrivalTimeStr".equals(model.getName())) {
            model.setName("arrival_time");
        } else if ("departureTimeStr".equals(model.getName())) {
            model.setName("departure_time");
        } else if ("passengers".equals(model.getName())) {
            model.setName("passengers");
        } else if ("callType".equals(model.getName())) {
            model.setName("call_type");
        }
        return JSonPagingResult.ofSuccess(count, schedulesDao.select(model));
    }

}
