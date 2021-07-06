package com.antzuhl.sharks.entity;

import com.antzuhl.sharks.constant.CommentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * @author AntzUhl
 * @date 2021/7/6 11:32 上午
 * @description 留言评论
 **/
@Data
@Entity
@Table(name = "t_comment")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "author", length = 50, nullable = false)
    private String author;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "author_url", length = 256)
    private String authorUrl;

    @Column(name = "comment", length = 1024, nullable = false)
    private String comment;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "comment_status", nullable = false)
    private CommentStatus commentStatus;

    @Column(name = "is_admin")
    @ColumnDefault(value = "0")
    private Boolean isAdmin;

    @Column(name = "top_priority")
    @ColumnDefault(value = "0")
    private Integer topPriority;

    @Column(name = "post_id", nullable = false)
    @ColumnDefault(value = "0")
    private Integer postId;

    @Column(name = "parent_id")
    private Long parentId;
}
