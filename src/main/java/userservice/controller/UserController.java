package userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userservice.dto.AssignRolesDto;
import userservice.dto.ManageUserAccountDto;
import userservice.dto.UpdatePasswordDto;
import userservice.dto.UpdateUserDto;
import userservice.dto.UserAdminDto;
import userservice.dto.UserDto;
import userservice.dto.UserRegisterDto;
import userservice.model.Role;
import userservice.repository.RolesRepo;
import userservice.repository.UserRepo;
import userservice.service.UserServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	UserRepo userRepo;

	@Autowired
	RolesRepo rolesRepo;

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Test Endpoint", HttpStatus.OK);
	}

	@GetMapping("/testv1")
	public ResponseEntity<String> testv1() {

		return new ResponseEntity<>("Test Endpointv1", HttpStatus.OK);
	}

	@PostMapping("/registerUser")
	public UserDto registerUser(@RequestBody UserRegisterDto user) {
		return userServiceImpl.registerUser(user);
	}

	@GetMapping("/getUserByName/{uname}")
	public UserAdminDto getUser(@PathVariable String uname) {
		UserAdminDto userAdminDto = userServiceImpl.getUserByName(uname);
		return userAdminDto;
	}

	@GetMapping("/getUserById/{id}")
	public UserAdminDto getUserById(@PathVariable Long id) {
		UserAdminDto userDto = userServiceImpl.getUserById(id);
		return userDto;
	}

	@PutMapping("/updateUser/{id}")
	public UserDto updateUserById(@RequestBody UpdateUserDto user, @PathVariable Long id) {
		UserDto userDto = userServiceImpl.updateUser(user, id);
		return userDto;

	}

	@PutMapping("/updatePassword/{id}")
	public ResponseEntity<String> updateUserPassword(@RequestBody UpdatePasswordDto updatePasswordDto,
			@PathVariable Long id) {
		userServiceImpl.updateUserPassword(id, updatePasswordDto);
		return new ResponseEntity<>("Password updated Successfully", HttpStatus.OK);
	}

	@GetMapping("/getAllUsers/{adminId}")
	public List<UserAdminDto> fetchAllUsersByAdminId(@PathVariable Long adminId) {
		return userServiceImpl.fetchAllUsersByAdminId(adminId);
	}

	@GetMapping("/getAllUsers")
	public List<UserDto> fetchAllUsers() {
		return userServiceImpl.fetchAllUsers();
	}

	@PutMapping("/updateUserAccountDetails/{adminId}")
	public UserAdminDto updateUserAccountDetails(@PathVariable Long adminId,
			@RequestBody ManageUserAccountDto manageUserAccountDto) {
		return userServiceImpl.updateUserAccountDetails(adminId, manageUserAccountDto);
	}

	@PutMapping("/assignRoles/{id}")
	public ResponseEntity<String> assignRoles(@RequestBody AssignRolesDto assignRolesDto, @PathVariable Long id) {
		try {
			userServiceImpl.assignRolesToUser(assignRolesDto.getUserId(), assignRolesDto.getRoles(), id);
			return ResponseEntity.ok("Roles updated successfully");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}
	}

	@PostMapping("/createRole")
	public ResponseEntity<String> createRole(@RequestBody Role role) {
		if (role.getRoleName() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role name cannot be null.");
		}
		if (rolesRepo.findByRoleName(role.getRoleName()).isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Role already exists.");
		}
		rolesRepo.save(role);
		return ResponseEntity.ok("Role created successfully.");
	}
}
