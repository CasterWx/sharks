package com.antzuhl.sharks.config;

import com.antzuhl.sharks.constant.CommonConstant;
import com.antzuhl.sharks.entity.User;
import com.antzuhl.sharks.repository.UserRepository;
import com.antzuhl.sharks.utils.CookieUtil;
import com.antzuhl.sharks.utils.SecretUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * @author AntzUhl
 * @date 2021/7/6 2:11 下午
 * @description 登录拦截
 **/
@Slf4j
public class AuthCheckInterceptor extends HandlerInterceptorAdapter {

    // ignore request mapping
    private static final List<String> IGNORE_MAPPING = Lists.newArrayList("/favicon.ico", "/error");

    @Resource
    private UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info(">>> preHandle, request uri: {}", requestURI);
        if (StringUtils.isNotBlank(requestURI) && requestURI.contains("/login")) {
            return true;
        }
        if (IGNORE_MAPPING.contains(requestURI)) {
            return true;
        }

        Cookie cookie = CookieUtil.get(request, CommonConstant.AUTH_CHECK_COOKIE_FIELD);
        if (cookie == null) {
            response.sendRedirect("/sharks/admin/login/home");
            return false;
        }

        String token = cookie.getValue();
        Integer verifyId = SecretUtil.verify(token);
        if (verifyId == null || verifyId < 0) {
            response.sendRedirect("/sharks/admin/login/home");
            return false;
        }

        Optional<User> userOpt = userRepository.findById(verifyId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            log.info(">>>> user: {} is login.", user);
        } else {
            log.error(">>>> ignore user");
            response.sendRedirect("/sharks/admin/login/home");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
}
