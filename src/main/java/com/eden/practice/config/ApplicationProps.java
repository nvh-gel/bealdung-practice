package com.eden.practice.config;

import com.eden.practice.model.UserConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProps {

    private List<Object> profiles;
    private List<Map<String, Object>> props;
    private List<UserConfig> users;


    public List<Object> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Object> profiles) {
        this.profiles = profiles;
    }

    public List<Map<String, Object>> getProps() {
        return props;
    }

    public void setProps(List<Map<String, Object>> props) {
        this.props = props;
    }

    public List<UserConfig> getUsers() {
        return users;
    }

    public void setUsers(List<UserConfig> users) {
        this.users = users;
    }
}
