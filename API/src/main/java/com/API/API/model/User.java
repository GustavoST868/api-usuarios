package com.API.API.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    public User(){

    }
    //lists to store the data
    List<String> username = new ArrayList<>();
    List<String> passworld  = new ArrayList<>();

    //getter
    public List<String> getUsername() {
        return username;
    }

    public List<String> getPassworld() {
        return passworld;
    }

    //seter
    public void setUsername(List<String> username) {
        this.username = username;
    }

    public void setPassworld(List<String> passworld) {
        this.passworld = passworld;
    }

    //CRUDS
    //create
    public String create(String username_,String password_){
        username.add(username_);
        passworld.add(password_);
        return "operation successful";
    }

    //read
    public String read(String username_){
        if(username.contains(username_)){
            int index = username_.indexOf(username_);
            String data = "username:"+username.get(index)+", password:"+passworld.get(index);
            return data;
        }else{
            return "operation failed,data not present in list";
        }
    }

    //update
    public String update(String username_,String new_name,String nex_password){
        if(username.contains(username_)){
            int index = username_.indexOf(username_);
            username.set(index,new_name);
            passworld.set(index,nex_password);
            return "operation successful";
        }else{
            return "operation failed,data not present in list";
        }
    }

    //delete
    public String delete(String username_){
        if(username.contains(username_)){
            int index = username.indexOf(username_);
            username.remove(index);
            passworld.remove(index);
            return "operation successful";
        }else{
            return "operation failed,data not present in list";
        }
    }

    //data print
    public String display_lists(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Users:\n");
        for(int i=0;i<passworld.size();i++){
            stringBuilder.append("username:"+username.get(i)+",password:"+passworld.get(i)+"\n");
        }
        return stringBuilder.toString();
    }

    //exists
    public String exists(String username_){
        if(username.contains(username_)){
            return "exist";
        }else{
            return "not exists";
        }
    }

    //clear list
    public String clearLists(){
        username.clear();
        passworld.clear();
        return "operation successful";
    }

    //Count
    public int count(){
        return username.size();
    }



}
