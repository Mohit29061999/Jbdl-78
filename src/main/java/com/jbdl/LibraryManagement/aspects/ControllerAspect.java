package com.jbdl.LibraryManagement.aspects;

import com.jbdl.LibraryManagement.dto.request.BookDto;
import com.jbdl.LibraryManagement.exception.BookException;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//log all controller request
@Aspect
@Component
public class ControllerAspect {

    private final static Logger log = LoggerFactory.getLogger(ControllerAspect.class);

    //it tells you when to run a advice
    @Pointcut("execution(* com.jbdl.LibraryManagement.controller..*(..))")
    public void controllerMethods(){}

    //this basically specifies the condition when the code inside the method should run
   // @Before("execution(* com.jbdl.LibraryManagement.controller..*(..))")
//    @Before(value="controllerMethods()")
//    public void logRequestBefore(){
//
//        //this is called advice
//        //basically what to do is advice
//        log.info("loggingRequest before for all controller");
//
//
//
//    }
//
//   // @After("execution(* com.jbdl.LibraryManagement.controller..*(..))")
//   @After(value="controllerMethods()")
//    public void logRequestAfter(){
//        log.info("loggingRequest after for all controller");
//
//    }




    //target object is args here
    @Before(value="controllerMethods() && args(createBookRequest)")
    public void createBookAdviceWithArgument(BookDto createBookRequest){
        log.info(createBookRequest.toString());

    }



//    @Around(value="controllerMethods()")
//    public Object aroundAdvice(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("Before executing the method: " + joinPoint.getSignature().getName());
//
//        // Proceed with the actual method execution
//      Object result = joinPoint.proceed();
//
//        // After method execution
//        log.info("After executing the method: " + joinPoint.getSignature().getName());
//        return null;
//    }











}
