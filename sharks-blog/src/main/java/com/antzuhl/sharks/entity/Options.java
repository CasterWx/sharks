package com.antzuhl.sharks.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author AntzUhl
 * Blog    http://antzuhl.cn
 * Github  https://github.com/CasterWx
 * Date 2020/7/14 17:22
 */
@Data
@Entity
@Table(name = "t_option")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Options extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "option_key")
    private String optionKey;

    @Column(name = "option_value")
    private String optionValue;
}
