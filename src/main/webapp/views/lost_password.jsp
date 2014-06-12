<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div class="title">
        <h2>找回密码</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="/lost" method="post" name=>
        <ul>
            <li>
                <label for="name">账号</label>
                <input type="text"  name="email" id="email" placeholder="邮箱或手机号" required />
            </li>
            <li>
                <button class="btn" type="submit">找回！</button>
				<a href="/login">想起来了</a>
				<span>|</span>
				<a href="/reg">注册新号</a>
            </li>
        </ul>
    </form>
</div>

<%@ include file="tail.jsp"%>
