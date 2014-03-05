<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

    <form class="contact_form" action="user/info" method="post" enctype="MULTIPART/FORM-DATA" name="contact_form">
        <ul>
            <li>
                 <h2>用户信息修改</h2>
                 <span class="required_notification">* 表示必填项</span>
            </li>
            <li>
                <label for="name">账号</label>
                <input type="text"  name="account" id="account" value="1111${account}" disabled required />
            </li>
            <li>
                <img src="../avatar/u.1.jpg" alt="介似您的靓照" style="margin-left:60px"></img>
                <label for="name">头像</label>
                <input type="file"  name="avatar" id="avatar" />
            </li>
            <li>
                <label for="name">大名</label>
                <input type="text"  name="name" id="name" placeholder="张三三" />
            </li>
            <li>
                <label for="name">手机号</label>
                <input type="text"  name="phone" id="phone" placeholder="13811820888" />
            </li>
            <li>
                <label for="name">Email</label>
                <input type="text"  name="email" id="email" placeholder="try@joydeal.com" />
            </li>
            <li>
                <label for="name">性别</label>
                <select name="gender" id="gender">
                  <option value ="female">女</option>
                  <option value ="male">男</option>
                </select>
            </li>
            <li>
                <button class="submit" type="submit">更新！</button>
            </li>
        </ul>
    </form>

<%@ include file="tail.jsp"%>
