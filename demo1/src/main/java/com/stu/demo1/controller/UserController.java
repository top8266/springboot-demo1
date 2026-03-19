package com.stu.demo1.controller;

import com.stu.demo1.common.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public Result<String> getUser(@PathVariable Long id) {
        return Result.success("查询ID为:" + id + "的用户信息");
    }

    @PostMapping
    public Result<String> createUser() {
        return Result.success("用户新增成功");
    }

    @PostMapping("/login")
    public Result<String> login() {
        return Result.success("登录成功，生成Token");
    }

    @DeleteMapping("/{id}")
    public Result<String> deleteUser(@PathVariable Long id) {
        return Result.success("删除ID为:" + id + "的用户成功");
    }

    @PutMapping("/{id}")
    public Result<String> updateUser(@PathVariable Long id) {
        return Result.success("修改ID为:" + id + "的用户成功");
    }
}