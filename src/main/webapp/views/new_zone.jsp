<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container" id="new-good-container">
    <div><span class="warn_message">${message}</span></div>
    <div class="title">
        <h2>新建宝贝</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="/zone/new" method="post">
        <ul>
            <li>
            <li>
                <label for="name">分类</label>
                <input type="text" name="category" id="category" placeholder="输入分类信息" value="${category}" required />
            </li>
            <li>
                <label for="name">说明</label>
                <input type="text" name="desc" id="desc" placeholder="输入宝贝说明" value="${desc}" required />
            </li>
            <li>
                <label for="name">地标</label>
                <input type="text" name="landmark" id="landmark" placeholder="输入地标名称" value="${landmark}" required />
            </li>
            <li>
                <label for="name">地址</label>
                <input type="text" name="address" id="address" placeholder="输入地址" value="${address}" />
            </li>
            <li>
                <img src="/avatar/u.1.jpg" alt="上传照片" style="margin-left:60px"></img>
                <label for="name">宝贝图片</label>
                <input type="file"  name="icon" id="icon" />
            </li>
            <li>
                <button class="btn" type="submit">走起！</button>
            </li>
            <li>
                <button class="btn" type="button" onclick="history.go(-1);">取消</button>
            </li>
        </ul>
    </form>
</div>
