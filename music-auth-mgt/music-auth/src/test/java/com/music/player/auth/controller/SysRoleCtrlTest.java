package com.music.player.auth.controller;

import com.alibaba.fastjson2.JSON;
import com.music.player.auth.dto.SaveRoleDto;
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
 * ClassName : SysRoleCtrlTest<br>
 * Description : SysRoleCtrlTest<br>
 *
 * @author : sj
 * @date : 2024/9/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysRoleCtrlTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void before() {
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    public void saveRole() throws Exception {
        SaveRoleDto saveRoleDto = new SaveRoleDto();
        saveRoleDto.setRoleName("测试");
        mvc.perform(MockMvcRequestBuilders.post("sysRole/saveRole")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(JSON.toJSONString(saveRoleDto)))
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }
}
