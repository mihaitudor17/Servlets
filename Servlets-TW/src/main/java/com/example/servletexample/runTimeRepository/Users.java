package com.example.servletexample.runTimeRepository;
import com.example.servletexample.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Users {
    INSTANCE;

    private List<User> users;
    {
        try {
            File f=new File("C:\\src\\users.json");
            if(f.exists())
            {
                Reader reader;
            reader = Files.newBufferedReader(Paths.get("C:\\src\\users.json"));
            users = new Gson().fromJson(reader, new TypeToken<List<User>>() {}.getType());
            }
            else
            {
                users=new ArrayList<>();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> presents= Arrays.asList(new String[]{"TV", "Laptop", "Computer", "Car", "Wash Machine"});


    public void addUser(User user) {
        this.users.add(user);
        saveUsers();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User findUserByEmailAndToken(String email,String token) throws IOException {
        File f=new File("C:\\src\\users.json");
        if(f.exists()) {
            Reader reader = Files.newBufferedReader(Paths.get("C:\\src\\users.json"));
            List<User> users = new Gson().fromJson(reader, new TypeToken<List<User>>() {
            }.getType());
            this.users = users;
            for (User u : users) {
                if (u.getEmail().equals(email) && u.getToken().equals(token))
                    return u;
            }
        }
       return null;
    }

    public String getNextId() {
        return String.valueOf(users.size()+1);
    }

    public void addUserPoints(String token)
    {
        for(User u:users)
        {
            if(u.getToken().equals(token)){
                u.addPoints();
                int level=u.getLevel();
                if((u.getPoints()/100>=level+1)&&u.getEmployed()!=true)
                {
                    u.addPresent(presents.get(givePresent()));
                    u.setLevel(u.getLevel()+1);
                }
            }
        }
        saveUsers();
    }
    public int givePresent()
    {
        int max=presents.size()-1;
        int random_int = (int)Math.floor(Math.random()*(max-0)+0);
        return random_int;
    }
    public void saveUsers()
    {
        try(Writer writer = new FileWriter("C:\\src\\users.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(this.users, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
