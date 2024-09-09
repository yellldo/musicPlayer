package com.music.player.auth.controller;

import com.alibaba.fastjson2.JSON;
import com.music.player.auth.dto.UserRegisterDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * ClassName : SysUserCtrlTest<br>
 * Description : SysUserCtrlTest<br>
 *
 * @author : sj
 * @date : 2024/8/30
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysUserCtrlTest {

    private MockMvc mvc;


    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void register() throws Exception {
        UserRegisterDto userRegisterDto = new UserRegisterDto();
        mvc.perform(MockMvcRequestBuilders.post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(JSON.toJSONString(userRegisterDto)))
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

}
