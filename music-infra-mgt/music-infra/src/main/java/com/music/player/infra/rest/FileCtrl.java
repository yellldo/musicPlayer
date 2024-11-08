package com.music.player.infra.rest;

import com.music.player.framework.common.base.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("file")
public class FileCtrl {

    @PostMapping("uploadFile")
    public R uploadFile(@RequestParam("file") MultipartFile multipartFile) {


        return R.ok();
    }
}
