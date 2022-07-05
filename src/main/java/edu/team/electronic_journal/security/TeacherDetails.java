package edu.team.electronic_journal.security;

import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class TeacherDetails implements UserDetails, IsUserDetails {
    private final Teacher teacher;

    @Autowired
    public TeacherDetails(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(teacher.getRole()));
    }

    @Override
    public String getPassword() {
        return this.teacher.getPassword();
    }

    @Override
    public String getUsername() {
        return this.teacher.getEmail();
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

    public Teacher getTeacher() {
        return this.teacher;
    }

    @Override
    public IsUser getUser() {
        return this.teacher;
    }
}
