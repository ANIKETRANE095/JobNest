package com.JobNest.Controller;
import com.JobNest.dto.UserDto;
import com.JobNest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // ✅ Register Candidate
    @PostMapping("/register/candidate")
    public ResponseEntity<UserDto> registerCandidate(@RequestBody UserDto userDTO) {
        userDTO.setRole(com.JobNest.Entity.Role.CANDIDATE);
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    // ✅ Register Recruiter
    @PostMapping("/register/recruiter")
    public ResponseEntity<UserDto> registerRecruiter(@RequestBody UserDto userDTO) {
        userDTO.setRole(com.JobNest.Entity.Role.RECRUITER);
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    // ✅ Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // ✅ Get All Users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    // ✅ Update User
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDTO) {
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    // ✅ Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
