package com.antzuhl.sharks.service;

import com.antzuhl.sharks.common.Response;

import javax.servlet.http.HttpServletResponse;

/**
 * @author AntzUhl
 * @date 2021/7/6 4:03 下午
 * @description 描述该文件做了什么
 **/
public interface LoginService {

    Response login(HttpServletResponse response, String username, String password);

}
