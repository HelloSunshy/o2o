package com.sunshy.o2o.controller;

import com.sunshy.o2o.entity.Area;
import com.sunshy.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-13   11:49
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @ResponseBody
    @RequestMapping("/query")
    public List<Area> queryArea(){


        List<Area> areas = areaService.queryArea();

        return areas;

    }

}
