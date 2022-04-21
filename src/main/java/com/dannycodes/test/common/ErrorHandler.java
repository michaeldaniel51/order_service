package com.dannycodes.test.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.jni.Time;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.net.ssl.HttpsURLConnection;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {


   private Log log = LogFactory.getLog(this.getClass());

//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<?> catchError(NullPointerException nul){
//
//        Adviser adviser = new Adviser();
//        adviser.setError(nul.getLocalizedMessage());
//        adviser.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        adviser.setTimestamp(LocalDateTime.now().toString());
//        adviser.setTitle("error");
//        adviser.setDetails(nul.getMessage());
//        adviser.setPath("/order");
//        log.fatal("fix NullPointer Exception immidiately");
//        return new ResponseEntity<>(adviser,HttpStatus.INTERNAL_SERVER_ERROR);
//
//    }






}
