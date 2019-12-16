<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>SpringMVC文件上传</h2>

<form action="upload/fileUpload" method="post" enctype="multipart/form-data">
    <input type="file" name="uploadFile" />
    <input type="submit" value="上传">
</form>
</body>
</html>
