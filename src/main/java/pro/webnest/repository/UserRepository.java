package pro.webnest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.webnest.entity.User;
//for connection entity and database
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailAndPassword(String email, String password);

}
