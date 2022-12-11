package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping ("/api/v1")
public class UserController {

    private final CustomUserDetailsService customUserDetailsService;
    private final UserRepository userRepository;

    //find user by name and password
    @GetMapping("/user")
    public String getUser(){
        return "Welcome, let's have a fun quiz!";
    }

    //get all users list
    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    //get user by User id
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping(value ="/save")//users
    public String saveUser (@RequestBody User user){
    userRepository.save(user);
    return "Saved";
    }

//
//    @PostMapping(value="/registration")
//    public String registerUser (@RequestBody RegistrationRequest request){
//
//        return registrationService.register(request);
//    }
//

//
//    @PostMapping(value="/registration")
//    public ResponseEntity<User> createUser (@RequestBody User user) throws URISyntaxException {
//        User savedUser = userRepository.save (user);
//        return  ResponseEntity.created(new URI("/registration/"+savedUser.getId())).body(savedUser);
//    }

    //update user information
    @PutMapping("/updateUser/{id}") //users/{id}
    public String updateUser(@PathVariable Integer id, @RequestBody User user) {
        User currentUser = userRepository.findById(id).get();
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
        userRepository.save(currentUser);
        return "Information was updated";

    }

//    @PutMapping("/updateUser/{id}")
//    public ResponseEntity<User> update(@RequestBody User user, @PathVariable Integer id) {
//        User updatedUSer = customUserDetailsService.(id, user);
//        if (updatedUSer == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(updatedUSer);
//        }
//    }
}
