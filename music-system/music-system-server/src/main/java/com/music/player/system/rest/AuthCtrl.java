package com.music.player.system.rest;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import com.music.player.framework.common.base.R;
import com.music.player.framework.redis.domain.RedisOps;
import com.music.player.framework.web.annotation.LogPrint;
import com.music.player.framework.web.constant.LogOperationConstant;
import com.music.player.system.biz.AuthBiz;
import com.music.player.system.constants.RedisConstants;
import com.music.player.system.dto.LoginDto;
import com.music.player.system.vo.LoginVo;
import com.music.player.system.vo.SysUserVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName : AuthCtrl<br>
 * Description : AuthCtrl<br>
 *
 * @author : sj
 * @date : 10/14/25
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthCtrl {

    @Autowired
    private AuthBiz authBiz;
    @Autowired
    private RedisOps redisOps;

    @SaIgnore
    @LogPrint(operation = "登陆", module = LogOperationConstant.MODULE_SYSTEM)
    @PostMapping("login")
    public R<LoginVo> login(@Valid @RequestBody LoginDto loginDto) {
        return R.ok(authBiz.login(loginDto));
    }

    @LogPrint(operation = "获取个人信息", module = LogOperationConstant.MODULE_SYSTEM)
    @GetMapping("info")
    public R<SysUserVo> info(HttpServletRequest request) {
        return R.ok(redisOps.get(RedisConstants.INFO + StpUtil.getLoginIdAsLong(), false));
    }
}
