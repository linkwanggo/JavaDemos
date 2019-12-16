<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>

    <%--请求参数绑定--%>

    <%--把数据封装Account类中，类中存在list和map的集合--%>
    <form action="param/saveUser" method="post">
        姓名：<input type="text" name="username" /><br/>

        朋友姓名: <input type="text" name="friend.username" /><br/>

        list用户姓名：<input type="text" name="list[0].username" /><br/>

        map1用户名：<input type="text" name="map['user1'].username" /><br/>
        map2用户名：<input type="text" name="map['user2'].username" /><br/>
        <input type="submit" value="提交" />
    </form>

</body>
</html>
