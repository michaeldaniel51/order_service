package com.dannycodes.test.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adviser {



    private String timestamp;
    private int status;
    private String error;
    private String title;
    private String Details;
    private String path;
//   "timestamp": "2022-03-22T14:41:43.766+00:00",
//           "status": 500,
//           "error": "Internal Server Error",
//           "path": "/order/"


}
