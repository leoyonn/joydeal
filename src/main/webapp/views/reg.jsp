<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div class="title">
        <h2>注册</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="/reg" method="post" name=>
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
                <img src="/avatar/u.1.jpg" alt="介似您的靓照" style="margin-left:60px"></img>
                <label for="name">头像</label>
                <input type="file"  name="avatar" id="avatar" />
            </li>
            <li>
                <label for="name">大名</label>
                <input type="text"  name="name" id="name" value="${name}" required />
            </li>
            <li>
                <label for="name">手机号</label>
                <input type="text"  name="phone" id="phone" value="${phone}" required />
            </li>
            <li>
                <label for="name">Email</label>
                <input type="text"  name="email" id="email" value="${email}" required />
            </li>
            <li>
                <label for="name">性别</label>
                <select name="gender" id="gender" required >
                    <option value ="female">女</option>
                    <option value ="male">男</option>
                </select>
            </li>
            <li>
                <button class="btn" type="submit">走起！</button>
				<a  href="/login">已有账号登录</a>
            </li>
        </ul>
    </form>
</div>
<%@ include file="tail.jsp"%>
