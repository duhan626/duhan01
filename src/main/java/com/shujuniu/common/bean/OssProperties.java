package com.shujuniu.common.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "ali.oss")
@Data
public class OssProperties {
    private String ossAddress;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String filePath;
    private String storePath;
}
