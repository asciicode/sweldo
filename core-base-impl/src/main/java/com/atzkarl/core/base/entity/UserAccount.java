package com.atzkarl.core.base.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.atzkarl.framework.base.entity.BaseEntity;

@Entity
@Table(name = "user_account")
public class UserAccount extends BaseEntity implements UserDetails {

    static final long serialVersionUID = 1L;

    public UserAccount() {
    }

    public UserAccount(String username) {
        this.username = username;
    }

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    private Set<UserAccountRole> userAccountRoles = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccount", orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<UserAccountRole> getUserAccountRoles() {
        return userAccountRoles;
    }

    public void setUserAccountRoles(Set<UserAccountRole> roles) {
        this.userAccountRoles = roles;
    }

    @Transient
    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<>();
        for (UserAccountRole role : userAccountRoles) {
            roles.add(role.getRole());
        }
        return roles;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.addAll(getRoles());
        return authorities;
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = proper(username);
    }

    @Transient
    public static String proper(String u) {
        return StringUtils.trim(StringUtils.lowerCase(StringUtils.defaultString(u)));
    }
}
