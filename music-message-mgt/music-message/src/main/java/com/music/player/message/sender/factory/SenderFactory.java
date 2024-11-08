package com.music.player.message.sender.factory;

import com.music.player.message.sender.Sender;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SenderFactory implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<String, Sender> senderMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, Sender> beansOfType = applicationContext.getBeansOfType(Sender.class);
        beansOfType.values().forEach(sender -> senderMap.put(sender.type(), sender));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Sender getSender(String type) {
        return senderMap.get(type);
    }
}
