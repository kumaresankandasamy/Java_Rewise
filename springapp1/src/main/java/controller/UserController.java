package controller;

import exception.ResourceNotFoundException;
import model.User;
import repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserRepository  userRepository;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id")Long userId) throws ResourceNotFoundException{
        User user = userRepository.findById(userId)
                                  .orElseThrow(()-> new ResourceNotFoundException("user not found :"+userId));
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }
    public ResponseEntity<User> updateUser(@PathVariable(value = "id")Long userId,@Valid @RequestBody User userdetails)throws ResourceNotFoundException{
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("user not found"+userId));
        user.setEmail(userdetails.getEmail());
        user.setLastName(userdetails.getLastName());
        user.setFirstName(userdetails.getFirstName());
        user.setUpdatedAt(new Date());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/user/{id}")
    public Map<String,Boolean> deleteUser(@PathVariable(value = "id")Long userId)throws Exception{
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found"+userId));
        userRepository.delete(user);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }

}
