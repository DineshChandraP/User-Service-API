package userservice.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import userservice.model.Role;
import userservice.model.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Role, Long> {
	Set<Role> findByRoleNameIn(Set<Roles> names);

	Optional<Role> findByRoleName(Roles roleName);

}
