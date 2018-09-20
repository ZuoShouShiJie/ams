package com.dzjk.ams.endpoint.action.account;

import com.aliyun.oss.OSSClient;
import com.dzjk.ams.core.common.util.OSSUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by daixiaohu on 2018/3/22.
 */
public class OSSObjectImpl {
    private static Logger logger = LoggerFactory.getLogger(OSSObjectImpl.class);
    public void putObject(File file, String key)  {
        OSSClient client = OSSUtils.getOSSClient();
        logger.info("开始上传oss...");
        client.putObject("","",file);
        logger.info("上传oss成功...");
    }
}
