package com.music.player.content.test.api;

import com.alibaba.fastjson2.JSONObject;
import com.music.player.content.api.ArtistsAuditApi;
import com.music.player.content.dto.CreateArtistsAuditDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName : ArtistsAuditApiImpl<br>
 * Description : ArtistsAuditApiImpl<br>
 *
 * @author : sj
 * @date : 12/27/25
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ArtistsAuditApiImplTest {


    @Autowired
    private ArtistsAuditApi artistsAuditApi;


    @Test
    public void create() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("11", "11");
        jsonObject.put("22", "22");
        jsonObject.put("33", "33");
        jsonObject.put("44", "44");
        CreateArtistsAuditDto createArtistsAuditDto = new CreateArtistsAuditDto()
                .setUserId(111L)
                .setSubmittedData(jsonObject.toJSONString());
        artistsAuditApi.createArtists(createArtistsAuditDto);
    }
}
