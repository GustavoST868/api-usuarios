package com.API.API.model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Store {
    //save username data
    public void store_username(List<String> username){
        String file_name = "username";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file_name))){
            for(int i=0;i<username.size();i++){
               writer.write(username.get(i));
               writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //save password data
    public void store_password(List<String> password){
        String file_name = "password";
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file_name))){
            for(int i=0;i<password.size();i++){
                writer.write(password.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //get data
    public List<String> load_username(){
        String file_name = "username";
        List<String> usernames = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file_name))){
            String line;
            while ((line = reader.readLine())!=null){
                usernames.add(line);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return usernames;
    }


    //get password
    public List<String> load_password(){
        String file_name = "password";
        List<String> passwords = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file_name))){
            String line;
            while((line = reader.readLine())!=null){
                passwords.add(line);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return passwords;
    }
}
