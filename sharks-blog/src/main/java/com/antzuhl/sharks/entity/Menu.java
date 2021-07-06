package com.antzuhl.sharks.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * @author AntzUhl
 * Blog    http://antzuhl.cn
 * Github  https://github.com/CasterWx
 * Date 2020/7/14 18:06
 */
@Data
@Entity
@Table(name = "t_menu")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Menu name.
     */
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    /**
     * Menu access url.
     */
    @Column(name = "url", length = 1023, nullable = false)
    private String url;

    /**
     * Sort.
     */
    @Column(name = "priority")
    @ColumnDefault("0")
    private Integer priority;

    /**
     * Page opening method
     */
    @Column(name = "target", length = 20)
    @ColumnDefault("'_self'")
    private String target;

    /**
     * Menu icon,Template support required.
     */
    @Column(name = "icon", length = 50)
    private String icon;

    /**
     * Parent menu.
     */
    @Column(name = "parent_id")
    @ColumnDefault("0")
    private Integer parentId;

}
