package com.API.API.controller;
import com.API.API.model.Store;
import com.API.API.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    User user = new User();
    Store store = new Store();
    //CRUD
    //create
    @PostMapping("/createUser")
    public String createUser(@RequestParam String username,@RequestParam String password){
        String result  = user.create(username,password);
        store.store_password(user.getPassworld());
        store.store_username(user.getUsername());
        return result;
    }

    //delete
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam String username){
        String result  = user.delete(username);
        store.store_password(user.getPassworld());
        store.store_username(user.getUsername());
        return result;
    }

    //print
    @GetMapping("/print")
    public String printUsers(){
        user.setPassworld(store.load_password());
        user.setUsername(store.load_username());
        String result = user.display_lists();

        return result;
    }

    //read
    @PostMapping("/getUser")
    public String getUser(@RequestParam String username){
        user.setPassworld(store.load_password());
        user.setUsername(store.load_username());
        String result = user.read(username);
        return result;
    }

    //exists
    @PostMapping("/exists")
    public String exists(@RequestParam String username){
        user.setPassworld(store.load_password());
        user.setUsername(store.load_username());
        String result = user.exists(username);
        return result;
    }

    //update
    @PostMapping("/updateUser")
    public String updateUser(@RequestParam String username,@RequestParam String new_username,@RequestParam String new_password){
        String result = user.update(username,new_username,new_password);
        store.store_password(user.getPassworld());
        store.store_username(user.getUsername());
        return result;
    }

    //clear data
    @PostMapping("/clear")
    public String clearData(){
        String result = user.clearLists();
        store.store_password(user.getPassworld());
        store.store_username(user.getUsername());
        return result;
    }

    //size
    @GetMapping("/count")
    public int count(){
        return user.count();
    }
}
