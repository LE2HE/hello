package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    // 현재 코딩
    @GetMapping(path = "/hello") // http://localhost:9090/api/get/hello
    public String getHello() {
        return "get Hello";
    }

    // 옛날 코딩
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get http://localhost:9090/api/get/hi
    public String hi() {
        return "hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}

    @GetMapping("/path-variable/{id}")
    public String pathVariable(@PathVariable(name = "id") String pathName) {
        System.out.println("PathVariable : " + pathName);
        return pathName;
    }

    // ?key=value&key2=value2

    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30
    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+"="+entry.getValue()+"\n");
        });

        return sb.toString();
    }

    @GetMapping(path = "/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {

        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name + " " + email + " " + age;
    }

    // @RequestParam 을 붙이지 않음
    // 미리 값이 정해져있으면 객체를 만들어 값을 받아오는 것이 편리 (제일 많이 활용)
    @GetMapping(path = "/query-param03")
    public String queryParam03(UserRequest userRequest) {
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
