package com.music.player.infra.api.service;

import com.music.player.framework.common.base.R;
import com.music.player.infra.api.dto.DeleteSysRoleDto;
import com.music.player.infra.api.dto.QuerySysRoleDto;
import com.music.player.infra.api.dto.SaveSysRoleDto;
import com.music.player.infra.api.dto.UpdateSysRoleDto;
import com.music.player.infra.api.enmus.ApiConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * ClassName : SysRoleServiceFeign<br>
 * Description : SysRoleServiceFeign<br>
 *
 * @author : sj
 * @date : 2024/5/24
 */
@FeignClient(value = ApiConstants.NAME, path = "/music-infra")
public interface SysRoleServiceFeign {

    @PostMapping("role/saveRole")
    R<Boolean> saveRole(@RequestBody @Valid SaveSysRoleDto saveSysRoleDto);


    @PostMapping("role/querySysRole")
    R querySysRole(@RequestBody QuerySysRoleDto querySysRoleDto);

    @PostMapping("role/updateSysRole")
    R<Boolean> updateSysRole(@RequestBody @Valid UpdateSysRoleDto updateSysRoleDto);

    @PostMapping("role/deleteSysRole")
    R<Boolean> deleteSysRole(@RequestBody @Valid DeleteSysRoleDto deleteSysRoleDto);

}
