/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClasses;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 *
 * @author MANALI
 */
public class smu_Registration {
    
    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();
    private String username;
    private String password;
    private String email;

    @PostConstruct
    public void init() {
    }
    
    public Map<String, Map<String, String>> getData() {
        return data;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}
