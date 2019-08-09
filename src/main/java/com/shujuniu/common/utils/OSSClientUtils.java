package com.shujuniu.common.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.shujuniu.common.bean.OssProperties;
import com.shujuniu.common.controller.StatusCode;
import com.shujuniu.common.exception.MRPException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
@Slf4j
public class OSSClientUtils {

    private static OSSClient ossClient;
    @Autowired
    private OssProperties ossProperties;


    public OSSClient getInstance(){
        if(this.ossClient == null){
            OSSClient ossClient = new OSSClient(ossProperties.getOssAddress(),ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
            this.ossClient = ossClient;
        }
        return this.ossClient;
    }

    public String uploadFile( InputStream is , String fileName ,Integer type) throws MRPException {
        ossClient = this.getInstance();
        if(is == null){
            throw  new MRPException(StatusCode.INPUT_STREAM_EMPTY);
        }
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());
            //指定该Object被下载时的网页的缓存行为
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setHeader("Access-Control-Allow-Origin","*");
            metadata.setHeader("Access-Control-Allow-Methods","POST GET HEAD PUT DELETE");
            metadata.setHeader("Access-Control-Max-Age","3600");
            metadata.setContentType(getContentType(fileName));
            metadata.setContentDisposition("filename=" + fileName );
            PutObjectResult putResult = ossClient.putObject(ossProperties.getBucketName()
                    , (type == 1 ? ossProperties.getStorePath() : ossProperties.getFilePath())
                            + fileName, is, metadata);
            String resultStr = putResult.getETag();
            System.out.println("上传成功：" + resultStr);
            return resultStr;
        }catch (Exception e){
            e.printStackTrace();
            throw  new MRPException(StatusCode.PROGRAM_EXCEPTION);
        }
    }
    public String deleteObjectFiles(List<String> filePathList) {
        String bucketName = ossProperties.getBucketName();
        DeleteObjectsRequest objectRequests = new DeleteObjectsRequest(bucketName);// 定义参数实体（bucketName以及文件集合）
        try {
            try {
                ossClient = this.getInstance();
            } catch (Exception e) {
                log.info("连接OSS云存储服务器失败：" + e);
                return "连接OSS云存储服务器失败失败！";
            }

            if (StringUtils.isNotBlank(bucketName)) {
                objectRequests.setBucketName(bucketName);
                objectRequests.setKeys(filePathList);
                ossClient.deleteObjects(objectRequests);
                return("删除成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("OSS内部云服务器删除文件失败：" + e);
            return "删除失败";
        } finally {
            log.info("OSS删除文件结束！.");
        }
        return null;
    }

    /**
     * * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     * * @param fileName 文件名	 * @return 文件的contentType
     * */
    public static  String getContentType(String fileName){
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        	return "image/jpeg";
    }
}
