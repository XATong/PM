package com.xk.yupao.service;

import com.xk.yupao.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 用户服务
 *
 * @author yupi
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @param planetCode 星球编号
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 根据标签查询用户
     * @param tagNameList
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);


    /**
     * 更新用户信息
     * @param user
     * @param loginUser
     * @return
     */
    int updateUser(User user, User loginUser);


    /**
     * 获取当前用户
     * @param request
     * @return
     */
    User getCurrentUser(HttpServletRequest request);


    /**
     * 权限判断
     *   某用户登录成功，则该用户的脱敏用户信息则保存到服务端的session中，此session只匹配当前用户的请求，并返回给前端一个设置 cookie 的 ”命令“
     *   session => cookie
     *   前端接收到后端的命令后，设置 cookie，保存到浏览器内
     *   当该用户调用查询接口时，前端再次请求后端的时候（相同的域名），在请求头中带上cookie去请求
     *   服务器端则通过该用户的请求中cookie携带的JSESSIONID来匹配服务器中的session
     *   若匹配上，则通过session中的 用户登录态USER_LOGIN_STATE 再获取到脱敏用户数据
     *   最终根据脱敏用户对象（用户的登录信息、登录名等）来判断该用户的权限是否为管理员 (safetyUser.getUserRole())
     */
    boolean isAdmin(HttpServletRequest request);


    /**
     * 是否为管理员
     * @param loginUser
     * @return
     */
    boolean isAdmin(User loginUser);
}
