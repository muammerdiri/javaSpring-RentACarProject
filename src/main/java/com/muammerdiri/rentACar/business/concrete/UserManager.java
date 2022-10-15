package com.muammerdiri.rentACar.business.concrete;

import com.muammerdiri.rentACar.business.abstracts.UserService;
import com.muammerdiri.rentACar.core.adapters.mernis.HPVKPSPublicSoap;
import com.muammerdiri.rentACar.core.dataAccess.abstracts.UserDao;
import com.muammerdiri.rentACar.core.entities.concrete.User;
import com.muammerdiri.rentACar.core.utilities.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager implements UserService {

    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    public Result add(User user) throws Exception {
        HPVKPSPublicSoap userRegister = new HPVKPSPublicSoap();
        boolean  success = userRegister.TCKimlikNoDogrula(Long.parseLong(user.getIdentityNumber()),user.getFirstName(),user.getLastName(),user.getDate());

        if(success){
            userDao.save(user);
            return new SuccessResult("User is successfully added.");
        }
        return new ErrorResult("The user could not be added.");


    }

    @Override
    public Result delete(User user) {
        return new SuccessResult("Add user is failed!");
    }

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<>(userDao.getUserById(id));
    }
}
