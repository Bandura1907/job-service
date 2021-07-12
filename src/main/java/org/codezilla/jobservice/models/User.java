package org.codezilla.jobservice.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.codezilla.jobservice.models.order.Job;
import org.codezilla.jobservice.models.order.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String sureName;
    private String username;

    private String email;
    private String password;

    @Transient
    private String passwordConfirm;

    private Long phone;

    private String address;
    private Double balance;

    private String photo;
    
    @Column(length = 1200)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "senderUser", cascade = CascadeType.ALL)
    private List<Messages> senderUserList;

    @OneToMany(mappedBy = "receiverUser", cascade = CascadeType.ALL)
    private List<Messages> receiverUserList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Job> userJobList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Service> userServiceList;

    @OneToMany(mappedBy = "senderUser", cascade = CascadeType.ALL)
    private List<Proposals> proposalsList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
