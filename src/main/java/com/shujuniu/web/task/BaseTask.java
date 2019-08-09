package com.shujuniu.web.task;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTask {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTask.class);

    public void handlerException(Exception ex,String interfaceName){
        logger.info("接口出现异常："+ interfaceName +  "\n" + ExceptionUtils.getFullStackTrace(ex));
    }

}
