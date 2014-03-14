<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div class="title">
        <h2>注册</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="/user/reg" method="post" name=>
        <ul>
            <li>
                <label for="name">账号</label>
                <input type="text"  name="account" id="account" placeholder="try_joydeal007" required />
            </li>
            <li>
                <label for="name">密码</label>
                <input type="text"  name="password" id="password" placeholder="DLdlweruo3#s" required />
            </li>
            <li>
                <button class="btn" type="submit">走起！</button>
				<a  href="/user/login">已有账号登录</a>
            </li>
        </ul>
    </form>
</div>
<%@ include file="tail.jsp"%>
