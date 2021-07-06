package com.antzuhl.sharks.security;

/**
 * @author AntzUhl
 * @date 2021/7/6 2:25 下午
 * @description 用户上下文
 **/
public class AuthContext {

    private static final ThreadLocal<UserInfo> context = new ThreadLocal<UserInfo>();
}
