<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Form</title>
    </head>
    <body>
        <form method="post" action="Login">
            USERNAME : <input type="text" name="username"
                              required="required"
                              pattern="[a-zA-Z]+"
                              value="${cookie.user.value}"/> <br/>
            PASSWORD : <input type="password" name="password"/><br/>
            <input type="checkbox" name="remember" value="yes"
                   ${not empty cookie.user.value 
                        ? "checked = 'checked'" : ""  }/>
            Remember Me<br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
