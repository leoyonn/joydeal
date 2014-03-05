<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

    <form class="contact_form" action="user/login" method="post" name="contact_form">
        <ul>
            <li>
                 <h2>用户登录</h2>
                 <span class="required_notification">* 表示必填项</span>
            </li>
            <li>
                <label for="name">账号</label>
                <input type="text"  name="account" id="account" placeholder="try_joydeal007" required />
            </li>
            <li>
                <label for="name">密码</label>
                <input type="text"  name="password" id="password" placeholder="DLdlweruo3#s" required />
            </li>
            <li>
                <button class="submit" type="submit">走起！</button>
            </li>
        </ul>
    </form>

<%@ include file="tail.jsp"%>
