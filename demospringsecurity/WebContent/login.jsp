<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD><TITLE> Authentification Objis formations </TITLE>

    <style type="text/css">
        @import "objis.css";
    </style>
    
</HEAD>

<body>

<div class="conTenu">

<div class="logoObjisAuthentification">
<a href='http://www.objis.com' target=_blank><img src="logo_objis.png" border=0 alt="Objis : www.objis.com" border="0">
</a></div>

<div class="authenTification">
<form method="POST" action="j_spring_security_check">
<table>
<tr>
<td>Login :</td>
<td><input type="text" name="j_username"></td>
</tr>
<tr>
<td>Mot de passe :</td>
<td><input type="password" name="j_password"></td>
</tr>
<tr>
<td colspan="2"><input type="submit" value="Valider"> <input type="reset" value="Annuler"></td>
</tr>
</table>
</form>
</div>
</div>

</body>
</HTML> 