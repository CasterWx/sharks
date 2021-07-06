package com.antzuhl.sharks.controller.admin;

import com.antzuhl.sharks.constant.CommonConstant;
import com.antzuhl.sharks.entity.User;
import com.antzuhl.sharks.repository.UserRepository;
import com.antzuhl.sharks.utils.CookieUtil;
import com.antzuhl.sharks.utils.SecretUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * @author AntzUhl
 * @date 2021/7/6 4:18 下午
 * @description 后台首页
 **/
@Controller
@RequestMapping(value = "/sharks/admin/home")
public class AdminHomeController {

    @Resource
    private UserRepository userRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView mv = new ModelAndView("/admin/home");
        // build home info
        Cookie cookie = CookieUtil.get(request, CommonConstant.AUTH_CHECK_COOKIE_FIELD);
        if (cookie == null) {
            response.sendRedirect("/sharks/admin/login/home");
            return mv;
        }
        String token = cookie.getValue();
        Integer userId = SecretUtil.verify(token);
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            mv.addObject("user", user);
        }
        return mv;
    }
}
