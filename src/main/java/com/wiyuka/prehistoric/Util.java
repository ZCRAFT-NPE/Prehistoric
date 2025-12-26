package com.wiyuka.prehistoric;

import com.mojang.logging.LogUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Util {
    public static void info(String msg) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        LogUtils.getLogger().info("RenderMixin");
        Class<?> loggerUtil = Class.forName("com.mojang.logging.LogUtils");
        Class<?> loggerClass = Class.forName("org.slf4j.Logger");
        Method getLoggerMethod = loggerUtil.getMethod("getLogger");
        Object logger = getLoggerMethod.invoke(null);
        List<String> messages = new CopyOnWriteArrayList<>();
        messages.add(msg);
        for (String message : messages) {
            Method infoMethod = loggerClass.getMethod("info", String.class);
            infoMethod.invoke(logger, message);

            System.gc();
        }
    }
}
