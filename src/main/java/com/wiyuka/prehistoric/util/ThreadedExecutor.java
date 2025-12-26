package com.wiyuka.prehistoric.util;

import com.wiyuka.prehistoric.Util;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;

public class ThreadedExecutor implements Executor {

    private final String name;

    private ThreadedExecutor(String name) {
        this.name = name;
    }

    public static ThreadedExecutor newExecutor() {
        try {
            Class<?> clazz = Class.forName("com.wiyuka.prehistoric.util.ThreadedExecutor");
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            return (ThreadedExecutor) constructor.newInstance(Thread.currentThread().getStackTrace()[0].getClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void execute(@NotNull Runnable command) {
        String taskName = Util.ensureStringSecure(name + command);
        Thread thread = new Thread(command);
        thread.setName(taskName);
        thread.start();
    }
}
