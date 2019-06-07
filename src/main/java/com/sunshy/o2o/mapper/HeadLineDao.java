package com.sunshy.o2o.mapper;

import com.sunshy.o2o.entity.HeadLine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-07   10:00
 */
public interface HeadLineDao {
    /**
     *按条件查询
     * @return
     */
    List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);

    /**
     *根据Id查询
     * @param lineId
     * @return
     */
    HeadLine queryHeadLineById(long lineId);

    /**
     *查询列表
     * @param lineIdList
     * @return
     */
    List<HeadLine> queryHeadLineByIds(List<Long> lineIdList);

    /**
     *添加头条
     * @param headLine
     * @return
     */
    int insertHeadLine(HeadLine headLine);

    /**
     *更新头条
     * @param headLine
     * @return
     */
    int updateHeadLine(HeadLine headLine);

    /**
     *根据Id删除头条
     * @param headLineId
     * @return
     */
    int deleteHeadLine(long headLineId);

    /**
     *批量删除头条
     * @param lineIdList
     * @return
     */
    int batchDeleteHeadLine(List<Long> lineIdList);
}
