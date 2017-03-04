<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>

<head>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8">
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

    <nav class="navbar-inverse">
        <div class="container-fluid">
            <ul class="nav navbar-nav navbar-right">
                <div class="collapse navbar-collapse">

                    <form action="/login" method="POST" class="navbar-form navbar-right">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <input type="text" name="nick" class="form-control" placeholder="Nick...">
                        </div>

                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="text" name="login" class="form-control" placeholder="Login...">
                        </div>
                        <button type="submit" class="btn btn-primary">Login</button>
                    </form>

                </div>
            </ul>
        </div>
    </nav>

</body>
</html>
