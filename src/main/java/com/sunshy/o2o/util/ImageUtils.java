package com.sunshy.o2o.util;

import com.sun.javafx.scene.shape.PathUtils;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * 图片处理
 *
 * @author sunshy
 * @date 2019-05-15   16:26
 */
public class ImageUtils {


    /**获取相对路径**/
    private static String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();


    /**
     *
     *
     * 图片加水印
     * @param cmf ：文件
     * @param targeAddr ：图片的路径
     * @return
     *
     *
     */
    public static String getThumbnail(MultipartFile cmf, String targeAddr){

        String fileName = PathUtil.getRandFileName();

        String fileExtension = getFileExtension(cmf);

        int i = targeAddr.lastIndexOf("/");

        String substring = targeAddr.substring(24, i);

        mkdirFilePath(substring);

        String relativeAddr = targeAddr + fileName + fileExtension;

        File file = new File(relativeAddr);

        try {

            Thumbnails.of(cmf.getInputStream()).size(200,200).watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(path+"/watermark.jpg")),0.25f)

            .outputQuality(0.8f).toFile(file);

        } catch (IOException e) {

            throw new RuntimeException("创建略缩图失败");

        }

        return relativeAddr;
    }


    /***
     *
     * 创建文件
     *
     * @param targeAddr
     */
    private static void mkdirFilePath(String targeAddr) {


        String imagePath = PathUtil.getImagePath(targeAddr);

        File file = new File(imagePath);

        if (!file.exists()){

            file.mkdirs();

        }


    }


    /***
     *
     * 获取文件的后缀名
     *
     * @param cmf : 文件
     *
     * @return
     */
    private static String getFileExtension(MultipartFile cmf) {

        String originalFilename = cmf.getOriginalFilename();

        return originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
    }


    /***
     * 删除原有的图片
     * filePath 是文件路径则删除该文件
     * filePath 是目录路径则删除该目录下全部文件
     * @param filePath
     */
    public static void deleteFileOrPath(String filePath){

        File fileOrPath  = new File(filePath);

        if (fileOrPath.exists()){

            if (fileOrPath.isDirectory()){

                File[] files = fileOrPath.listFiles();

                for (File file :files){

                    file.delete();
                }

            }

                fileOrPath.delete();

        }

    }

}
