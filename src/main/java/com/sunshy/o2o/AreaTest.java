package com.sunshy.o2o;

import com.sunshy.o2o.entity.Area;
import com.sunshy.o2o.mapper.AreaDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-05-12   20:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void testArea(){

        List<Area> areaMappers = areaDao.queryArea();

        System.out.println(areaMappers.size());

    }

}
