package com.antzuhl.sharks.controller.admin;

import com.antzuhl.sharks.common.Response;
import com.antzuhl.sharks.controller.admin.request.LoginUser;
import com.antzuhl.sharks.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author AntzUhl
 * @date 2021/7/6 2:10 下午
 * @description 登录相关接口
 **/
@Slf4j
@Controller
@RequestMapping(value = "/sharks/admin/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    /**
     * login page
     * */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response) {
        // TODO not user info, register user
        return new ModelAndView("/admin/login");
    }

    /**
     * login request
     * */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Response loginRequest(HttpServletResponse response, @RequestBody LoginUser user) {
        if (user == null) {
            log.error(">>>> request login user is null");
            return Response.error("Request login user is null");
        }
        return loginService.login(response, user.getUsername(), user.getPassword());
    }
}
