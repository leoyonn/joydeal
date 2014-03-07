<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <div class="title">
        <h2>人物：${name}</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <h3>TA的档案</h3>
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
            <label for="name">性别</label><span>${gender}</span>
        </li>
    </ul>
    <h3>TA的声望</h3>
    <ul>
        <li class='entry'>
            <label for="name">宝主声望</label><span class="desc">10000</span>
        </li>
        <li class='entry'>
            <label for="name">金主声望</label><span class="desc">9999</span>
        </li>
        <li class='entry'>
            <label for="name">区主声望</label><span class="desc">9999</span>
        </li>
        <li class='entry'>
            <label for="name">领主声望</label><span class="desc">9999</span>
        </li>
        <li class='entry'>
            <label for="name">人气声望</label><span class="desc">9999</span>
        </li>
    </ul>
    <h3>TA是宝主</h3>
    <ul>
        <li class='entry'>
            <label for="name">宝贝1</label><span class="desc">宝贝1的说明</span>
        </li>
        <li class='entry'>
            <label for="name">宝贝2</label><span class="desc">宝贝2的说明</span>
        </li>
    </ul>
    <h3>TA是金主</h3>
    <ul>
        <li class='entry'>
            <label for="name">需求1</label><span class="desc">需求1的说明</span>
        </li>
        <li class='entry'>
            <label for="name">需求2</label><span class="desc">需求2的说明</span>
        </li>
    <ul/>
    <h3>TA是区主</h3>
    <ul>
        <li class='entry'>
            <label for="name">区域1</label><span class="desc">区域1的说明</span>
        </li>
        <li class='entry'>
            <label for="name">区域2</label><span class="desc">区域2的说明</span>
        </li>
    <ul/>
    <h3>TA是领主</h3>
    <ul>
        <li class='entry'>
            <label for="name">区域1</label><span class="desc">区域1的说明</span>
        </li>
        <li class='entry'>
            <label for="name">区域2</label><span class="desc">区域2的说明</span>
        </li>
    <ul/>
    <h3>TA的粉丝</h3>
    <ul>
        <li class='entry'>
            <label for="name">人物1</label><span class="desc">人物1的说明</span>
        </li>
        <li class='entry'>
            <label for="name">人物2</label><span class="desc">人物2的说明</span>
        </li>
    <ul/>

</div>
<%@ include file="tail.jsp"%>
