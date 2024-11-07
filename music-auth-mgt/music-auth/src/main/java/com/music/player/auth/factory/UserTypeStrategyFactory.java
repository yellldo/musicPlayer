package com.music.player.auth.factory;

import com.music.player.auth.bo.UserTypeBaseBo;
import com.music.player.auth.service.UserTypeStrategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


/**
 * ClassName : UserTypeStrategy<br>
 * Description : the factory that user type implements.<br>
 *
 * @author : sj
 * @date : 2024/11/7
 */
@Component
public class UserTypeStrategyFactory implements InitializingBean, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final Map<String, UserTypeStrategy> userTypeStrategyMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, UserTypeStrategy> beansOfType = applicationContext.getBeansOfType(UserTypeStrategy.class);
        beansOfType.values().forEach(userTypeStrategy -> userTypeStrategyMap.put(userTypeStrategy.userType(), userTypeStrategy));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * get user info by userType and userId
     *
     * @param userType
     * @param userId
     * @return
     */
    public UserTypeBaseBo fetchUserInfo(String userType, Long userId) {
        UserTypeStrategy userTypeStrategy = userTypeStrategyMap.get(userType);
        return userTypeStrategy.getUserInfo(userId);
    }
}
