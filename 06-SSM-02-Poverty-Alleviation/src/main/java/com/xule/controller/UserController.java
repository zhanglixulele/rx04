package com.xule.controller;

import com.xule.entity.User;
import com.xule.service.UserService;
import com.xule.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("getlist")
    public ResultVO getlist(@RequestParam(value = "pageNum") Integer pageNum,
                            @RequestParam(value = "pageSize") Integer pageSize,
                            @RequestParam(value = "id") Long id){
        return userService.getList(pageNum,pageSize,id);
    }
    @PostMapping("add")
    public ResultVO add(@RequestBody User user){
        return userService.add(user);
    }
    @PostMapping("update")
    public ResultVO update(@RequestBody User user){
        return userService.update(user);
    }
    @GetMapping("delete")
    public ResultVO delete(@RequestParam Long id){
        return userService.delete(id);
    }
}
