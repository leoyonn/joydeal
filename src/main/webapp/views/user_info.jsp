<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div class="title">
        <h2>信息</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <h3>私密信息</h3>
    <ul>
        <li>
            <label for="name">账号</label><span>${account}</span>
        </li>
        <li>
            <label for="name">头像</label><img src="/avatar/u.1.jpg" alt="介似您的靓照" style="margin-left:60px"></img>
        </li>
        <li>
            <label for="name">大名</label><span>${name}</span>
        </li>
        <li>
            <label for="name">手机号</label><span>${phone}</span>
        </li>
        <li>
            <label for="name">Email</label><span>${email}</span>
        </li>
        <li>
            <label for="name">性别</label><span>${gender}</span>
        </li>
    </ul>
    <h3>公开信息</h3>

</div>
<%@ include file="tail.jsp"%>
