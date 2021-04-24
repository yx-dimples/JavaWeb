<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="./style.css">
    <style>
        .logo-box {
            width:404px;
            margin: 40px auto;
            border:1px solid #e5e5e5;
            border-radius:4px;
            box-shadow:0 4px 18px rgba(0,0,0,0.2);
            position:relative;
            overflow:hidden;
            height: 420px;
        }
    </style>
</head>
<body>
<h2 style="text-align: center">用户注册</h2>
<div class="logo-box">
    <div class="login">
        <div class="bxs-row" style="text-align: center">
            <img id="logo" src="logo.jpg" alt="" width="72px">
            <span class="tips" style="color: red">忍住不哭来段口技</span>
        </div>
        <form method="post" action="/RegisterServlet">
            <div class="bxs-row">
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" class="username">
            </div>
            <div class="bxs-row">
                <label for="password">密码</label>
                <input type="password" id="password" name="password" class="password">
            </div>
            <div class="bxs-row">
                <button type="submit" class="submit btn">注册</button>
            </div>
        </form>
        <div class="bxs-row">
            <button type="submit" class="btn" onclick="window.open('login.jsp')">登录</button>
            <p style="color: red">${inf}</p>
        </div>
    </div>
</div>

</body>
</html>