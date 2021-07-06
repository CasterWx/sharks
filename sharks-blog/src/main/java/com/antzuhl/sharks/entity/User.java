package com.antzuhl.sharks.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author AntzUhl
 * Blog    http://antzuhl.cn
 * Github  https://github.com/CasterWx
 * Date 2020/7/14 16:34
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", length = 127)
    private String email;

    @Column(name = "avatar", length = 1023)
    private String avatar;

    @Column(name = "description", length = 1023)
    private String description;

    @Column(name = "expire_time")
    private String expireTime;

}
