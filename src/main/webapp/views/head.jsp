<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <title>交易地，最省心的个人交易平台</title>
	<link rel="stylesheet" media="screen" href="/ui/styles.css" >
</head>

<body>
    <div class="headbar"><a href="/">交易地，最省心的个人交易平台</a>
        <span class="barbtn">
        <c:choose>
           <c:when test="${userInfo != null}"><a href="/logout">退出</a></c:when>
           <c:otherwise><a href="/reg">注册</a></c:otherwise>
        </c:choose>
        </span>
        <span>|</span>
        <span class="barbtn">
        <c:choose>
           <c:when test="${userInfo != null}"><a href="/u">${userInfo.name}</a></c:when>
           <c:otherwise><a href="/login">登录</a></c:otherwise>
        </c:choose>
        </span>
    </div>
