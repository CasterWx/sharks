package com.antzuhl.sharks.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author AntzUhl
 * @date 2021/7/6 4:18 下午
 * @description 后台首页
 **/
@Controller
@RequestMapping(value = "/sharks/admin/home")
public class HomeController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView homePage() {
        return new ModelAndView("/admin/home");
    }
}
