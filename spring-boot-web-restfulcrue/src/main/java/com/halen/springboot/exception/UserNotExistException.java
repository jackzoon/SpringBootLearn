package com.halen.springboot.exception;

/**
 * Created By Halen 2020/5/8 17:17
 */
public class UserNotExistException extends RuntimeException {

    public UserNotExistException() {
        super("用户不存在");
    }
}
