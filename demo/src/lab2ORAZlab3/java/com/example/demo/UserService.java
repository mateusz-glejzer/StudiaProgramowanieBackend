package com.example.demo;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static final String filePath = "listOfUsers.obf";
    private List<UserEntity2> users = new ArrayList<>();
    private int nextIdOfUsers = 0;

    @PostConstruct
    private void onCreate() {
        boolean endOfFile = false;
        UserEntity2 temp;
        try {

            FileInputStream employeesFile = new FileInputStream(filePath);
            ObjectInputStream employeesStream = new ObjectInputStream(employeesFile);
            temp = (UserEntity2) employeesStream.readObject();

            while (endOfFile != true) {
                try {
                    users.add(temp);
                    temp = (UserEntity2) employeesStream.readObject();
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
            employeesStream.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("File was not found");
        } catch (IOException e) {
            System.out.println("File could not be read");
        } catch (ClassNotFoundException e) {
            System.out.println("Class was not found");
        }

        if(users.size() == 0){
            initializeUsersList();
        }
    }
    @PreDestroy
    private void onDestroy() {
        try {
            FileOutputStream EmployeesFile = new FileOutputStream(filePath);
            ObjectOutputStream EmployeesStream = new ObjectOutputStream(EmployeesFile);

            for (UserEntity2 entity : users) {
                EmployeesStream.writeObject(entity);
            }
            EmployeesStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public UserEntity2 updateUser(int userId, UserEntity2 newUser) {

        UserEntity2 user = null;

        for (UserEntity2 entity : this.users){
            if(entity.getId() == userId)
                user = entity;
        }

        if(user == null)
            return null;

        updateUser(user, newUser);

        return user;
    }

    public Object getUsers(int pageNumber, int pageSize)
    {
        List<UserEntity2> result = new ArrayList<>();

        int start = (pageNumber - 1) * pageSize;
        int stop = start + pageSize;
        int index = 0;

        for (UserEntity2 entity : this.users){
            if(start <= index && index < stop){
                result.add(entity);
            }
            index++;
        }
        return result;
    }

    public Object getUser(int userId)
    {
        for (UserEntity2 entity : this.users){
            if(entity.getId() == userId)
                return entity;
        }
        return null;
    }

    public UserEntity2 createUser(UserEntity2 user) {
        user.setId(nextIdOfUsers);
        nextIdOfUsers++;

        users.add(user);

        return user;
    }



    public Object removeUser(int userId) {
        UserEntity2 user = null;

        for (UserEntity2 entity : this.users){
            if(entity.getId() == userId)
                user = entity;
        }

        this.users.remove(user);

        return new Object(  );
    }

    private void updateUser(UserEntity2 entity, UserEntity2 update){
        entity.setName(update.getEmail());
        entity.setEmail(update.getEmail());
    }
    private void initializeUsersList(){
        for (int i = 0; i < 30; i++){
            createUser(new UserEntity2(i, "user " + i, "email " + i));
        }
    }
}
