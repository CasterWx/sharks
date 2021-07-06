package com.antzuhl.sharks.entity;

import com.antzuhl.sharks.constant.LogType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author AntzUhl
 * Blog    http://antzuhl.cn
 * Github  https://github.com/CasterWx
 * Date 2020/7/14 18:10
 */
@Data
@Entity
@Table(name = "t_log")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Log extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Log key.
     */
    @Column(name = "log_key", length = 1023)
    private String logKey;

    /**
     * Log type.
     */
    @Column(name = "type", nullable = false)
    private LogType type;

    /**
     * Log content.
     */
    @Column(name = "content", length = 1023, nullable = false)
    private String content;

    /**
     * Operator's ip address.
     */
    @Column(name = "ip_address", length = 127)
    private String ipAddress;
}
