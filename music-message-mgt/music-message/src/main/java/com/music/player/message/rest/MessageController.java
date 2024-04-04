package com.music.player.message.rest;

import com.music.player.auth.api.dto.UserGetCodeDto;
import com.music.player.auth.api.service.UserServiceFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : MessageController<br>
 * Description : MessageController<br>
 *
 * @author : sj
 * @date : 2024/4/3
 */
@Slf4j
@RestController
@RequestMapping("/message")
public class MessageController {


    @Autowired
    private UserServiceFeign userServiceFeign;

    @PostMapping("info")
    public void aa() {
        log.info("1111");
        UserGetCodeDto userGetCodeDto = new UserGetCodeDto();
        userServiceFeign.getCode(userGetCodeDto);
    }
}
