package com.antzuhl.sharks.controller.admin.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author AntzUhl
 * @date 2021/7/6 3:58 下午
 * @description 描述该文件做了什么
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginUser {

    private String username;

    private String password;
}
