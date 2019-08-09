package com.shujuniu.common.utils;

import com.shujuniu.common.Constant;
import com.shujuniu.common.controller.StatusCode;
import com.shujuniu.common.exception.MRPException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by haiwei on 2018/8/31.
 */
public class ImageUploadUtil {


    /**
     * 图片上传
     *
     * @param file
     * @param configPath
     * @param fileRelativePath
     * @return
     * @throws Exception
     */
    public static String doUploadImage(MultipartFile file, String configPath, String fileRelativePath) throws Exception {

        if (file == null || file.getBytes() == null || file.getBytes().length <= 0) {
            throw new MRPException(StatusCode.PARAMETER_INVALID, "图片为空");
        }

        //文件原始名称
        String originalFileName = file.getOriginalFilename();

        //图片类型
        String imageType = originalFileName.indexOf(".") < 0 ? null :
                originalFileName.substring(originalFileName.lastIndexOf(".") + 1, originalFileName.length());

        if (imageType == null) {
            throw new MRPException(StatusCode.PARAMETER_INVALID, "无法识别的图片类型");
        }

        boolean isRightType = "GIF".equals(imageType.toUpperCase()) || "PNG".equals(imageType.toUpperCase()) || "JPG".equals(imageType.toUpperCase());
        if (isRightType == false) {
            throw new MRPException(StatusCode.PARAMETER_INVALID, "请上传png,gif,jpg格式的图片");
        }

        //判断目录存不存在，不存在则创建
        String absDirect = configPath + fileRelativePath;
        File directory = new File(absDirect);
        if (directory.exists() == false) {
            directory.mkdirs();
        }

        // 自定义的文件名称
        String curTime = new SimpleDateFormat("yyMMddHHmmssSSS").format(new Date());
        String uploadFileName = curTime + "." + imageType;

        //相对路径
        String relativePath = fileRelativePath + "/" + uploadFileName;

        // 设置存放图片文件的路径
        String absPath = configPath + relativePath;
        // System.out.println("存放图片文件的路径:"+path);
        // 转存文件到指定的路径
        file.transferTo(new File(absPath));

        return "/" + Constant.UPLOAD_IMAGE_PRE_PATH + relativePath; //返回相对路径
    }
}
