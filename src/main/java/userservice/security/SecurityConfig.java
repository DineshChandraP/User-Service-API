package userservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception {
		hs.csrf(csrf -> csrf.disable())
				/* .cors(cors -> cors.configure(hs))//Enable Cors */
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/user/*", "/user/*/*", "/user/*/*/*", "/user/*/*/*/*").permitAll()
//						.requestMatchers("/user/*/*/*/*").hasRole("ADMIN").requestMatchers("/user/*/*/*")
//						.hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*/*")
//						.hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*").hasAnyRole("INDIVIDUAL", "ADMIN")
//						.requestMatchers("/user").hasRole("ADMIN").requestMatchers("/user/*/*/*/*").hasRole("ADMIN")
//						.requestMatchers("/user/*/*/*").hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*/*")
//						.hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*").hasAnyRole("INDIVIDUAL", "ADMIN")
//						.requestMatchers("/user").hasRole("ADMIN").requestMatchers("/user/*/*/*/*").hasRole("ADMIN")
//						.requestMatchers("/user/*/*/*").hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*/*")
//						.hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*").hasAnyRole("INDIVIDUAL", "ADMIN")
//						.requestMatchers("/user").hasRole("ADMIN").requestMatchers("/user/*/*/*/*").hasRole("ADMIN")
//						.requestMatchers("/user/*/*/*").hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*/*")
//						.hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*").hasAnyRole("INDIVIDUAL", "ADMIN")
//						.requestMatchers("/user").hasRole("ADMIN").requestMatchers("/user/*/*/*/*").hasRole("ADMIN")
//						.requestMatchers("/user/*/*/*").hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*/*")
//						.hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*").hasAnyRole("INDIVIDUAL", "ADMIN")
//						.requestMatchers("/user").hasRole("ADMIN").requestMatchers("/user/*/*/*/*").hasRole("ADMIN")
//						.requestMatchers("/user/*/*/*").hasAnyRole("INDIVIDUAL", "ADMIN").requestMatchers("/user/*/*")
//				.permitAll()
						/*
						 * .requestMatchers("/registerUser", "/getUserById/{id}",
						 * "/updateUser/{id}","/updatePassword/{id}", "/getAllUsers/{adminId}",
						 * "/updateUserAccountDetails/{adminId}", "/assignRoles/{id}",
						 * "/getUserByName/{uname}", "/create", "/getAllUsers", "/test") .permitAll()
						 */
						/* .requestMatchers("/getAllUsers/{adminId}").hasRole("ADMIN") */
						/* .requestMatchers("/getUserById/{id}").hasAnyRole("INDIVIDUAL", "ADMIN") */
						.anyRequest().authenticated());
		return hs.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
