<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>

<div class="container">
    <ul>
        <li >
            <button class="btn" type="button" id="new-good" onClick="location.href='/good/new'">+宝贝</button>
            <button class="btn" type="button" id="new-need" onClick="location.href='/need/new'">+需求</button>
            <button class="btn" type="button" id="new-zone" onClick="location.href='/zone/new'">+区</button>
        </li>
    </ul>
    <%@ include file="index_rec.jsp"%>
    <%@ include file="index_hot.jsp"%>
</div>
<%@ include file="tail.jsp"%>
