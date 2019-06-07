package com.sunshy.o2o.service.impl;

import com.sunshy.o2o.dto.HeadLineExecution;
import com.sunshy.o2o.entity.HeadLine;
import com.sunshy.o2o.enums.HeadLineStateEnum;
import com.sunshy.o2o.mapper.HeadLineDao;
import com.sunshy.o2o.service.HeadLineService;
import com.sunshy.o2o.util.FileUtil;
import com.sunshy.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Demo Class
 *
 * @author sunshy
 * @date 2019-06-07   09:57
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {


    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException {

        List<HeadLine> headLineList = null;

            headLineList = headLineDao.queryHeadLine(headLineCondition);

        return headLineList;
    }

    @Override
    @Transactional
    public HeadLineExecution addHeadLine(HeadLine headLine,
                                        MultipartFile thumbnail) {
        if (headLine != null) {
            headLine.setCreateTime(new Date());
            headLine.setLastEditTime(new Date());
            if (thumbnail != null) {
                addThumbnail(headLine, thumbnail);
            }
            try {
                int effectedNum = headLineDao.insertHeadLine(headLine);
                if (effectedNum > 0) {

                    return new HeadLineExecution(HeadLineStateEnum.SUCCESS,
                            headLine);
                } else {
                    return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("添加区域信息失败:" + e.toString());
            }
        } else {
            return new HeadLineExecution(HeadLineStateEnum.EMPTY);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public HeadLineExecution modifyHeadLine(HeadLine headLine,
                                            MultipartFile thumbnail) {
        if (headLine.getLineId() != null && headLine.getLineId() > 0) {
            headLine.setLastEditTime(new Date());
            if (thumbnail != null) {
                HeadLine tempHeadLine = headLineDao.queryHeadLineById(headLine
                        .getLineId());
                if (tempHeadLine.getLineImg() != null) {
                    FileUtil.deleteFile(tempHeadLine.getLineImg());
                }
                addThumbnail(headLine, thumbnail);
            }
            try {
                int effectedNum = headLineDao.updateHeadLine(headLine);
                if (effectedNum > 0) {

                    return new HeadLineExecution(HeadLineStateEnum.SUCCESS,
                            headLine);
                } else {
                    return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新头条信息失败:" + e.toString());
            }
        } else {
            return new HeadLineExecution(HeadLineStateEnum.EMPTY);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public HeadLineExecution removeHeadLine(long headLineId) {
        if (headLineId > 0) {
            try {
                HeadLine tempHeadLine = headLineDao
                        .queryHeadLineById(headLineId);
                if (tempHeadLine.getLineImg() != null) {
                    FileUtil.deleteFile(tempHeadLine.getLineImg());
                }
                int effectedNum = headLineDao.deleteHeadLine(headLineId);
                if (effectedNum > 0) {

                    return new HeadLineExecution(HeadLineStateEnum.SUCCESS);

                } else {
                    return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除头条信息失败:" + e.toString());
            }
        } else {
            return new HeadLineExecution(HeadLineStateEnum.EMPTY);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public HeadLineExecution removeHeadLineList(List<Long> headLineIdList) {
        if (headLineIdList != null && headLineIdList.size() > 0) {
            try {
                List<HeadLine> headLineList = headLineDao
                        .queryHeadLineByIds(headLineIdList);
                for (HeadLine headLine : headLineList) {
                    if (headLine.getLineImg() != null) {
                        FileUtil.deleteFile(headLine.getLineImg());
                    }
                }
                int effectedNum = headLineDao
                        .batchDeleteHeadLine(headLineIdList);
                if (effectedNum > 0) {

                    return new HeadLineExecution(HeadLineStateEnum.SUCCESS);
                } else {
                    return new HeadLineExecution(HeadLineStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除头条信息失败:" + e.toString());
            }
        } else {
            return new HeadLineExecution(HeadLineStateEnum.EMPTY);
        }
    }

    private void addThumbnail(HeadLine headLine, MultipartFile thumbnail) {
        String dest = FileUtil.getHeadLineImagePath();
        String thumbnailAddr = ImageUtil.generateNormalImg(thumbnail, dest);
        headLine.setLineImg(thumbnailAddr);
    }

}
