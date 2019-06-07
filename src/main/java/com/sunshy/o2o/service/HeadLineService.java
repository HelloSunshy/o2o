package com.sunshy.o2o.service;

import com.sunshy.o2o.dto.HeadLineExecution;
import com.sunshy.o2o.entity.HeadLine;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-07   09:52
 */
public interface HeadLineService {

    /**
     *
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition)
            throws IOException;

    /**
     *
     * @param headLine
     * @param thumbnail
     * @return
     */
    HeadLineExecution addHeadLine(HeadLine headLine,
                                  MultipartFile thumbnail);

    /**
     *
     * @param headLine
     * @param thumbnail
     * @return
     */
    HeadLineExecution modifyHeadLine(HeadLine headLine,
                                     MultipartFile thumbnail);

    /**
     *
     * @param headLineId
     * @return
     */
    HeadLineExecution removeHeadLine(long headLineId);

    /**
     *
     * @param headLineIdList
     * @return
     */
    HeadLineExecution removeHeadLineList(List<Long> headLineIdList);


}
