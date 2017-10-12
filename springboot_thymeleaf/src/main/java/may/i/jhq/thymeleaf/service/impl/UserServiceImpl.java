package may.i.jhq.thymeleaf.service.impl;

import may.i.jhq.thymeleaf.dao.UserDAO;
import may.i.jhq.thymeleaf.entity.User;
import may.i.jhq.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author jinhuaquan
 * @create 2017-09-26 下午5:33
 * @desc userService的接口实现
 **/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void saveUser(User user) {
        user.setCreateTime(new Date());

        userDAO.save(user);
    }

    @Override
    public List<User> listUser() {

        List<User> list = userDAO.findAll();

        return list;
    }
}
