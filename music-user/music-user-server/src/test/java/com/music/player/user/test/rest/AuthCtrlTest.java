package com.music.player.user.test.rest;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.music.player.user.dto.LoginDto;
import com.music.player.user.dto.LoginGetCodeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * ClassName : AuthCtrlTest<br>
 * Description : AuthCtrlTest<br>
 *
 * @author : sj
 * @date : 10/11/25
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AuthCtrlTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void login() throws Exception {
        LoginGetCodeDto loginGetCodeDto = new LoginGetCodeDto();
        loginGetCodeDto.setPhone("17600907053");
        loginGetCodeDto.setType("3");
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/auth/getCode")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONBytes(loginGetCodeDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn();

        String content = result.getResponse().getContentAsString();
        JSONObject jsonObject = JSON.parseObject(content);
        LoginDto loginDto = new LoginDto();
        loginDto.setPhone("17600907053");
        loginDto.setCode(jsonObject.getInteger("data"));
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONBytes(loginDto))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
}
