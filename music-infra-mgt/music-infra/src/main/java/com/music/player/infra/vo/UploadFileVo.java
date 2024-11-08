package com.music.player.infra.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class UploadFileVo implements Serializable {

    private String fileName;

    private String fileUrl;
}
