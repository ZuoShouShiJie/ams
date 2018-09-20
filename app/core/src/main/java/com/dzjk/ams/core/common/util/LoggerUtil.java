package com.dzjk.ams.core.common.util;

import org.slf4j.Logger;

/**
 * Created by daixiaohu on 2018/3/1.
 */
public final class LoggerUtil {

    private static final char THREAD_RIGHT_TAG = ']';
    private static final char THREAD_LEFT_TAG = '[';
    public static final char ENTERSTR = '\n';
    public static final char COMMA = ',';

    private LoggerUtil() {
    }

    public static void debug(Logger logger, Object... obj) {
        if(logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }

    }

    public static void info(Logger logger, Object... obj) {
        if(logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }

    }

    public static void warn(Logger logger, Object... obj) {
        logger.warn(getLogString(obj));
    }

    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append('[').append(Thread.currentThread().getId()).append(']');
        Object[] arr$ = obj;
        int len$ = obj.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            Object o = arr$[i$];
            log.append(o);
        }

        return log.toString();
    }
}
