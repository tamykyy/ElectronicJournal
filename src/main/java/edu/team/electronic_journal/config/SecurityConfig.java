package edu.team.electronic_journal.config;

import edu.team.electronic_journal.service.StudentDetailService;
import edu.team.electronic_journal.service.TeacherDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StudentDetailService studentDetailService;

    @Autowired
    protected TeacherDetailService teacherDetailService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/me/school/teacher/add").hasRole("TEACHER")
                .antMatchers("/me/school/teacher/save").hasRole("TEACHER")
                .antMatchers("/me/school/teacher/edit/**").hasRole("TEACHER")
                .antMatchers("/me/school/teacher/delete/**").hasRole("TEACHER")
                .antMatchers("/me/school/class/add").hasRole("TEACHER")
                .antMatchers("/me/school/class/**/add-student").hasRole("TEACHER")
                .antMatchers("/me/school/class/save").hasRole("TEACHER")
                .antMatchers("/me/school/class/edit/**").hasRole("TEACHER")
                .antMatchers("/me/school/classes/delete/**").hasRole("TEACHER")
                .antMatchers("/me/school/student/add").hasRole("TEACHER")
                .antMatchers("/me/school/student/save").hasRole("TEACHER")
                .antMatchers("/me/school/student/edit/**").hasRole("TEACHER")
                .antMatchers("/me/school/student/delete/**").hasRole("TEACHER")
                .antMatchers("/me/school/subject/add").hasRole("TEACHER")
                .antMatchers("/me/school/subject/save").hasRole("TEACHER")
                .antMatchers("/me/school/subject/edit/**").hasRole("TEACHER")
                .antMatchers("/me/school/subject/**/add-teacher").hasRole("TEACHER")
                .antMatchers("/me/school/subject/**/save").hasRole("TEACHER")
                .antMatchers("/me/school/subject/**/add-class").hasRole("TEACHER")
                .antMatchers("/me/school/subject/**/add-class/save").hasRole("TEACHER")
                .antMatchers("/me/school/subject/delete/**").hasRole("TEACHER")
                .antMatchers("/me/**").hasAnyRole("STUDENT", "TEACHER")
                .and().formLogin().permitAll();
    }

    //

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(studentDetailService).passwordEncoder(getPasswordEncoder());
        auth.userDetailsService(teacherDetailService).passwordEncoder(getPasswordEncoder());
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
