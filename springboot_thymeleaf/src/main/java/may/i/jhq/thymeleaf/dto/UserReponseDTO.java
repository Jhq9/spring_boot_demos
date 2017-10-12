package may.i.jhq.thymeleaf.dto;

import lombok.Data;

/**
 * @author jinhuaquan
 * @create 2017-09-26 下午5:38
 * @desc 返回的用户信息DTO
 **/
@Data
public class UserReponseDTO {

    private String id;

    private String login;

    private String name;

    private String email;

    private String create_time;

}
