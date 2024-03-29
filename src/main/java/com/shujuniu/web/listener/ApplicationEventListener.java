package com.shujuniu.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * 项目启动监听
 **/
@Slf4j
@Component
public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 在这里可以监听到Spring Boot的生命周期
        if (event instanceof ApplicationEnvironmentPreparedEvent) { // 初始化环境变量
            log.warn("初始化环境变量");
        } else if (event instanceof ApplicationPreparedEvent) { // 初始化完成
            log.warn("初始化环境变量完成");
        } else if (event instanceof ContextRefreshedEvent) { // 应用刷新，当ApplicationContext初始化或者刷新时触发该事件。
            log.warn("应用刷新");
        } else if (event instanceof ApplicationReadyEvent) {// 应用已启动完成
            log.warn("应用已启动完成");
        } else if (event instanceof ContextStartedEvent) { // 应用启动，当容器调用ConfigurableApplicationContext的 Start()方法开始/重新开始容器时触发该事件。
            log.warn("应用启动");
        } else if (event instanceof ContextStoppedEvent) { // 应用停止，当容器调用ConfigurableApplicationContext 的Stop()方法停止容器时触发该事件。
            log.warn("应用停止");
        } else if (event instanceof ContextClosedEvent) { // 应用关闭，当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有 单例Bean都被销毁。
            log.warn("应用关闭");
        }
    }

}
