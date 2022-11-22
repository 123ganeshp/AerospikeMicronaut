//package com.restapi.auth;
//
//import io.micronaut.context.annotation.ConfigurationProperties;
//import io.micronaut.core.convert.format.MapFormat;
//
//import java.util.Map;
//
//@ConfigurationProperties("credentials")
//public class UserStore {
//
//    @MapFormat
//    private Map<String, String> users;
//
//    @MapFormat
//    private Map<String, String> roles;
//
//    public String getUserPassword(String userName) {
//        return users.get(userName);
//    }
//
//    public String getUserRole(String userName) {
//        return roles.get(userName);
//    }
//
//    public void setUsers(Map<String, String> users) {
//        this.users = users;
//    }
//
//    public void setRoles(Map<String, String> roles) {
//        this.roles = roles;
//    }
//}
//
//
