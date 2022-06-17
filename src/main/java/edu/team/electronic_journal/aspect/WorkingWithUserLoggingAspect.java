package edu.team.electronic_journal.aspect;

import edu.team.electronic_journal.entity.IsUser;
import edu.team.electronic_journal.security.AuthenticatedUser;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class WorkingWithUserLoggingAspect {

    @Autowired
    AuthenticatedUser authenticatedUser;

    @Pointcut("execution(* edu.team.electronic_journal.controller.TeacherController.addTeacher(..))")
    private void teacherCreateMethod() {
    }

    @Pointcut("execution(* edu.team.electronic_journal.controller.StudentController.addStudent(..))")
    private void studentCreateMethod() {
    }

    @Pointcut("execution(* edu.team.electronic_journal.controller.TeacherController.changeTeacher(..))")
    private void teacherChangeMethod() {
    }

    @Pointcut("execution(* edu.team.electronic_journal.controller.StudentController.changeStudent(..))")
    private void studentChangeMethod() {
    }

    @Pointcut("execution(* edu.team.electronic_journal.controller.TeacherController.deleteTeacher(int))")
    private void teacherDeleteMethod() {
    }

    @Pointcut("execution(* edu.team.electronic_journal.controller.StudentController.deleteStudents(int))")
    private void studentDeleteMethod() {
    }

    @Around("teacherCreateMethod() || studentCreateMethod()")
    public Object aroundAllCreatingNewUserMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        IsUser user = authenticatedUser.getAuthenticatedUser();

        System.out.println(methodName + " start working by " + user.getName() + " " +
                user.getSurname() + " (" + user.getId() + ")");

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println(methodName + " end working");

        return targetMethodResult;
    }

    @Around("teacherChangeMethod() || studentChangeMethod()")
    public Object aroundAllChangingUserMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        IsUser user = authenticatedUser.getAuthenticatedUser();

        System.out.println(methodName + " start working by " + user.getName() + " " +
                user.getSurname() + " (" + user.getId() + ")");

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println(methodName + " end working");

        return targetMethodResult;
    }

    @Around("teacherDeleteMethod() || studentDeleteMethod()")
    public Object aroundAllDeleteUserMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();

        IsUser user = authenticatedUser.getAuthenticatedUser();

        System.out.println(methodName + " start working by " + user.getName() + " " +
                user.getSurname() + " (" + user.getId() + ")");

        Object targetMethodResult = proceedingJoinPoint.proceed();

        System.out.println(methodName + " end working");

        return targetMethodResult;
    }
}
