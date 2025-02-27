package userservice.dto;


import java.util.HashSet;
import java.util.Set;

public class AssignRolesDto {
        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public Set<String> getRoles() {
                return roles;
        }

        public void setRoles(Set<String> roles) {
                this.roles = roles;
        }

        private Long userId;
        private Set<String> roles= new HashSet<>();




}
