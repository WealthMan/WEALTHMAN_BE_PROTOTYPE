<%
final String title = "WM1 home page";
%>
<html>
<head>
    <title><%= title %></title>
</head>
<body>
    <h2><%= title %></h2>

    <p>Links (REST):</p>

    <ul>
        <li><a href='api/user?login=Admin'> Admin user </a></li>
        <li><a href='api/user?id=10661ee8-327f-11e8-97ff-7427ea10c3d8'> Manager B user </a></li>
        <li><a href='api/user/all'> Users List </a></li>
        <li><a href='api/curr/all'> Currencies List </a></li>
    </ul>


    <p>User operations:</p>

    <ul>
        <li><a href='api/user/check-login/Admin'> Check login 'Admin' </a></li>
        <li><a href='api/user/login/Admin'> Admin user </a></li>
        <li><a href='api/user/id/10661ee8-327f-11e8-97ff-7427ea10c3d8'> Manager B user </a></li>
        <li><a href='api/user/all'> Users List </a></li>
    </ul>

    <p> app-mode: <%= application.getInitParameter("app-mode") %> </p>

</body>
</html>


