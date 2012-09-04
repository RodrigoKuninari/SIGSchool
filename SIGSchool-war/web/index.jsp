<%-- 
    Document   : index
    Created on : 10/11/2011, 13:26:06
    Author     : systematica
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=us-ascii" />
        <title>SIGSchool | Sistema Online de Agenda Escolar</title>
        <link type="text/css" href="./style.css" rel="stylesheet" />
        <link type="text/css" href="./css/login.css" rel="stylesheet" />
        <script type='text/javascript' src='./js/jquery-1.4.2.min.js'></script>	<!-- jquery library -->
        <script type='text/javascript' src='./js/iphone-style-checkboxes.js'></script> <!-- iphone like checkboxes -->
        <script type='text/javascript'>
            jQuery(document).ready(function() {
                jQuery('.iphone').iphoneStyle();
            });
        </script>
    <body>
        <div id="line"><!-- --></div>
        <div id="background">
            <div id="container">
                <div id="logo">
                    <img src="./assets/logologin.png" alt="Logo" />
                </div>
                <div id="box"> 
                    <form action="${pageContext.request.contextPath}/professor_Presentation" method="POST"> 
                        <div class="one_half">
                            <p>
                                <input name="username" value="username" class="field" onblur="if (jQuery(this).val() == &quot;&quot;) { jQuery(this).val(&quot;username&quot;); }" onclick="jQuery(this).val(&quot;&quot;);" />
                            </p>
                            <p><input type="checkbox" class="iphone" /><label class="fix">Remember me</label></p> 
                        </div>
                        <div class="one_half last">
                            <p><input type="password" name="password" value="asdf1234" class="field" onblur="if (jQuery(this).val() == &quot;&quot;) { jQuery(this).val(&quot;asdf1234&quot;); }" onclick="jQuery(this).val(&quot;&quot;);">	</p>
                            <p><input type="submit" value="Entrar" class="login" /></p>
                        </div>
                    </form> 
                </div> 
            </div>
        </div>
    </body>
</html>
