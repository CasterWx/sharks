package com.antzuhl.sharks.service.impl;

import com.antzuhl.sharks.common.Response;
import com.antzuhl.sharks.constant.CommonConstant;
import com.antzuhl.sharks.entity.User;
import com.antzuhl.sharks.repository.UserRepository;
import com.antzuhl.sharks.service.LoginService;
import com.antzuhl.sharks.utils.CookieUtil;
import com.antzuhl.sharks.utils.SecretUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author AntzUhl
 * @date 2021/7/6 4:04 下午
 * @description 描述该文件做了什么
 **/
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Response login(HttpServletResponse response, String username, String password) {
        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
            log.error(">>>> LoginService login request param is null");
            return Response.error("Request Params is Null");
        }
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            log.error(">>>> LoginService know username");
            return Response.error("Not Found this user");
        }
        String dbPwd = user.getPassword();
        String dbMd5Digest = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        if (!StringUtils.equals(dbPwd, dbMd5Digest)) {
            log.error(">>> LoginService login username or password error");
            return Response.error("用户名或密码错误");
        }
        // 认证成功
        String token = SecretUtil.create(user.getId(), username);
        CookieUtil.set(response, CommonConstant.AUTH_CHECK_COOKIE_FIELD, token, true);
        try {
            response.sendRedirect("/sharks/admin/home");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response.success("Login success");
    }
}
