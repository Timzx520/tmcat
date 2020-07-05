package com.tmcat.utils;

import org.apache.log4j.Logger;

/**
 * @Author Tim
 * @Date 2020/7/3 16:27
 * @Version 1.0
 * 日志输出工具类
 */
public class LogUtil {

    public static void logprint(String type,String msg,Class classname){
        final Logger logger = Logger.getLogger(classname);
        //final Logger logger = Logger.getLogger(DBUtil.class);
        final Logger saveUserLog = Logger.getLogger("saveUserLog");
        if (logger.isDebugEnabled()) {
            logger.debug("debug");
        }

        if (type.equals("INFO")){
            logger.info(msg);
        }else if(type.equals("ERROR")){
            logger.error(msg);
        }else {
            saveUserLog.info(msg);
        }


    }
}
