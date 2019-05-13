package com.sunshy.o2o.service.impl;

import com.sunshy.o2o.entity.Area;
import com.sunshy.o2o.mapper.AreaDao;
import com.sunshy.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-13   11:47
 */
@Service
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {

        List<Area> areas = areaDao.queryArea();

        return areas;
    }
}
