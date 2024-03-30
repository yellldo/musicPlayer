package com.music.player.auth.filter;

import com.music.player.auth.api.dto.JwtUser;
import com.music.player.auth.config.JwtConfig;
import com.music.player.auth.service.SysUserService;
import com.music.player.auth.service.UserInfoService;
import com.music.player.auth.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName : JwtAuthorizationTokenFilter<br>
 * Description : JwtAuthorizationTokenFilter<br>
 *
 * @author : sj
 * @date : 2024/3/30
 */
@Slf4j
@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = jwtTokenUtil.getToken(request);
        JwtUser jwtUser = null;
        try {
            jwtUser = (JwtUser) redisTemplate.opsForValue().get(jwtConfig.getOnlineKey() + token);
            if ("1".equals(jwtUser.getLoginType())) {
                jwtUser = (JwtUser) userInfoService.loadUserByPhone(jwtUser.getPhone());
            }
            if ("2".equals(jwtUser.getLoginType())) {
                jwtUser = (JwtUser) userInfoService.loadUserByEmail(jwtUser.getEmail());
            }
            if (StringUtils.isBlank(jwtUser.getLoginType())) {
                jwtUser = (JwtUser) sysUserService.loadUserByUserName(jwtUser.getUsername());
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        if (jwtUser != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtTokenUtil.validateToken(token)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        chain.doFilter(request, response);
    }
}
