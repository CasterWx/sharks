package com.antzuhl.sharks.entity;

import com.antzuhl.sharks.constant.PostStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

/**
 * @author AntzUhl
 * Blog    http://antzuhl.cn
 * Github  https://github.com/CasterWx
 * Date 2020/7/14 17:00
 */
@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "t_post")
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "short_path")
    private String shortPath;

    @Column(name = "status")
    private PostStatus status;

    @Column(name = "password")
    private String password;

    @Column(name = "edit_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editTime;

    @Column(name = "format_content")
    private String formatContent;

    @Column(name = "original_content")
    private String originalContent;

    @Column(name = "disallow_cotent")
    private Boolean disAllowComment;

    @Column(name = "visits")
    private Long visits;

    @Column(name = "top_priority")
    @ColumnDefault("0")
    private Integer topPriority;

    @Deprecated
    @Column(name = "url")
    private String url;

    @Column(name = "thumbnail", length = 1023)
    private String thumbnail;

}
