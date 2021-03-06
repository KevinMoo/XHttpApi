package com.xuexiang.xhttpapi.controller;

import com.xuexiang.xhttpapi.api.request.PageQuery;
import com.xuexiang.xhttpapi.api.response.ApiResult;
import com.xuexiang.xhttpapi.model.User;
import com.xuexiang.xhttpapi.api.request.ApiRequest;
import com.xuexiang.xhttpapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 控制器
 *
 * @author xuexiang
 * @since 2018/7/15 下午11:23
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ApiResult addUser(@RequestBody ApiRequest<User> request) {
        return new ApiResult<Boolean>().setData(userService.addUser(request.request));
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ApiResult registerUser(@RequestBody User user) {
        return new ApiResult<Boolean>().setData(userService.addUser(user));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUser/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public ApiResult findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return new ApiResult<List<User>>().setData(userService.findAllUser(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/findUsers", method = RequestMethod.POST)
    public ApiResult getUsers(@RequestBody PageQuery pageQuery) {
        return new ApiResult<List<User>>().setData(userService.findAllUser(pageQuery.pageNum, pageQuery.pageSize));
    }

    @ResponseBody
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public ApiResult findAllUser() {
        return new ApiResult<List<User>>().setData(userService.findAllUser());
    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ApiResult deleteUser(int userId) {
        return new ApiResult<Boolean>().setData(userService.deleteUser(userId));
    }


    @ResponseBody
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ApiResult updateUser(@RequestBody User user) {
        return new ApiResult<Boolean>().setData(userService.updateUser(user));
    }
}
