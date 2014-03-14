<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div class="title">
        <h2>宝贝：${name}</h2>
    </div>
    <ul>
        <li><label for="name">分类</label><span>${category}</span></li>
        <li><label for="name">说明</label><span>${desc}</span></li>
        <li><label for="name">属区</label><span>${zone}</span></li>
        <li><label for="name">宝主</label><span>${owner}</span></li>
        <li><label for="name">有效期</label><span>${ttl}</span></li>
        <li><label for="name">参考价</label><span>${price}</span></li>
        <li><label for="name">状态</label><span>${status}</span></li>
        <li>
            <label for="name">图片</label><img src="/avatar/u.1.jpg" alt="宝贝图片" style="margin-left:60px"></img>
        </li>
    </ul>
    <h3>评论</h3>
    <ul>
        <li class='entry'>
            <label for="name">用户1</label><span class="desc">评论内容1</span>
        </li>
        <li class='entry'>
            <label for="name">用户2</label><span class="desc">评论内容2</span>
        </li>
    <ul/>
</div>

<%@ include file="tail.jsp"%>
