<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div><span class="warn_message">${message}</span></div>
    <div class="title">
        <h2>信息修改</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="u/info" method="post" enctype="MULTIPART/FORM-DATA" name="contact_form">
        <ul>
            <li>
                <label for="name">账号</label>
                <input type="text"  name="account" id="account" value="${account}" disabled required />
            </li>
            <li>
                <img src="/avatar/u.1.jpg" alt="介似您的靓照" style="margin-left:60px"></img>
                <label for="name">头像</label>
                <input type="file"  name="avatar" id="avatar" />
            </li>
            <li>
                <label for="name">大名</label>
                <input type="text"  name="name" id="name" value="${name}" />
            </li>
            <li>
                <label for="name">手机号</label>
                <input type="text"  name="phone" id="phone" value="${phone}"  />
            </li>
            <li>
                <label for="name">Email</label>
                <input type="text"  name="email" id="email" value="${email}"  />
            </li>
            <li>
                <label for="name">性别</label>
                <select name="gender" id="gender">
                    <option value ="female">女</option>
                    <option value ="male">男</option>
                </select>
            </li>
            <li>
                <button class="btn" type="submit">更新！</button>
            </li>
        </ul>
    </form>
</div>
<%@ include file="tail.jsp"%>
