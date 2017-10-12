package may.i.jhq.thymeleaf.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author jinhuaquan
 * @create 2017-09-26 下午5:21
 * @desc 所有用户角色的父类User
 **/
@Data
@Entity
@Table(name = "m_user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 16, nullable = false, unique = true)
    private String login;

    @Column(length = 16)
    private String name;

    @Column(length = 32)
    private String email;

    @Column(nullable = false)
    private Date createTime;

}
