<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div><span class="warn_message">${message}</span></div>
    <div class="title">
        <h2>登录</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="/login" method="post">
        <ul>
            <li>
                <label for="name">账号</label>
                <input type="text"  name="user" id="user" placeholder="输入您的账号或id" value="${user}" required />
            </li>
            <li>
                <label for="name">密码</label>
                <input type="text"  name="password" id="password" placeholder="输入您的密码" required />
            </li>
            <li>
                <button class="btn" type="submit">走起！</button>
				<a href="/lost">忘密码了</a>
				<span>|</span>
				<a href="/reg">注册新号</a>
            </li>
        </ul>
    </form>
</div>

<%@ include file="tail.jsp"%>
