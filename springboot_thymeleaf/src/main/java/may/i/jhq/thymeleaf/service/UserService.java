/**
 * @author jinhuaquan
 * @create 2017-09-26 下午5:30
 * @desc User的service层的接口定义
 **/
package may.i.jhq.thymeleaf.service;

import may.i.jhq.thymeleaf.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> listUser();
}
