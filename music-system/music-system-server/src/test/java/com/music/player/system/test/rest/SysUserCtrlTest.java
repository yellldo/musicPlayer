package com.music.player.system.test.rest;

import com.alibaba.fastjson2.JSON;
import com.music.player.system.dto.CreateSysUserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * ClassName : SysUserCtrlTest<br>
 * Description : SysUserCtrlTest<br>
 *
 * @author : sj
 * @date : 10/11/25
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SysUserCtrlTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create() throws Exception {
        CreateSysUserDto createSysUserDto = new CreateSysUserDto();
        createSysUserDto.setLoginName("shenjia1");
        createSysUserDto.setRemark("test");
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/sysUser/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONBytes(createSysUserDto))
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(print());
    }

}
