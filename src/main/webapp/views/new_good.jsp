<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container" id="new-good-container">
    <div><span class="warn_message">${message}</span></div>
    <div class="title">
        <h2>新建宝贝</h2>
        <span class="required_notification">* 表示必填项</span>
    </div>
    <form class="contact_form" action="/good/new" method="post">
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
                <label for="name">属区</label>
                <input type="text" name="zone" id="zone" placeholder="输入宝贝说明" value="${zone}" required />
            </li>
            <li>
                <label for="name">有效期</label>
                <input type="text" name="ttl" id="ttl" placeholder="输入有效期" value="${ttl}" required />
            </li>
            <li>
                <label for="name">定价</label>
                <input type="number" name="price" id="price" placeholder="输入价格" value="${price}" required />
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
