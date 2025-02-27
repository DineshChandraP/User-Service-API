package userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import userservice.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String userName);

	boolean existsByEmail(String email);

	boolean existsByEmailAndIdNot(String email, Long id);

}
