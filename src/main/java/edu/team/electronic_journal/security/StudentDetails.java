package edu.team.electronic_journal.security;

import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class StudentDetails implements UserDetails, IsUserDetails {
    private final Student student;

    @Autowired
    public StudentDetails(Student student) {
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(student.getRole()));
    }

    @Override
    public String getPassword() {
        return this.student.getPassword();
    }

    @Override
    public String getUsername() {
        return this.student.getEmail();
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

    public Student getStudent() {
        return this.student;
    }

    @Override
    public IsUser getUser() {
        return this.student;
    }
}
