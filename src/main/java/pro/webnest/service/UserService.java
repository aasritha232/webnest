package pro.webnest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pro.webnest.entity.User;
import pro.webnest.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
    
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

}
