package may.i.jhq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jinhuaquan
 * @create 2017-09-17 下午6:04
 * @desc 用户实体类
 **/
@Data
public class User implements Serializable{

    public static final Long serializableID = -13142356454L;

    private Long id;

    private String name;

    private String phone;

    private Integer age;

}
