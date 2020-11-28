<%@ taglib prefix='security' uri='http://www.springframework.org/security/tags' %>
<%@ page import="org.springframework.security.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.userdetails.UserDetails" %>
<%@ page import="org.springframework.security.GrantedAuthority" %>

<%

Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

if (obj instanceof UserDetails) {
	GrantedAuthority[] granted = ((UserDetails)obj).getAuthorities();
	String authority = granted[0].getAuthority() ;
  String username = ((UserDetails)obj).getUsername();
  System.out.println("UserName : " + obj.toString());
  System.out.println("Authority : " +   authority);
  String role = authority.substring(5);
  session.setAttribute("role",role);
} else {
  String username = obj.toString();
  System.out.println("UserName : " + username);
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Démonstration sécurité Spring </title>
    <style type="text/css">
        @import "objis.css";
    </style>
</head>
<body>

<div class="conTenu">

<div class="logoObjis">
<a href='http://www.objis.com' target=_blank><img src="logo_objis.png" border=0 alt="Objis : spécialiste formation JAVA" border="0"></a>
</div>
<div class="userIdentite">
login : <security:authentication property="principal.username"/>
</div>

<div class="userRole">
Role :  <%=session.getAttribute("role") %>
</div>

<div class="mnuLogout">
<a href="j_spring_security_logout">Déconnexion</a>
</div>

<security:authorize ifAnyGranted="ROLE_PARTICIPANT">
<div class="mnuLien1">
<a href="#">Vos formations Objis</a>
</div>
<div class="mnuLien2">
<a href="#">Vos travaux pratiques</a>
</div>
<div class="mnuLien3">
<a href="#">Vos outils</a>
</div>
<div class="mnuLien4">
<a href="#">Votre clé USB</a>
</div>
</security:authorize>

<security:authorize ifAnyGranted="ROLE_FORMATEUR">
<div class="mnuLien1">
<a href="#">Supports de cours</a>
</div>
<div class="mnuLien2">
<a href="#">Supports de Travaux pratiques</a>
</div>
<div class="mnuLien3">
<a href="#">Bilans pédagogiques</a>
</div>
<div class="mnuLien4">
<a href="#">Prochaines formations à assurer</a>
</div>
</security:authorize>


<security:authorize ifAnyGranted="ROLE_MAINTENANCE">
<div class="mnuLien1">
<a href="#">Ordinateurs et OS</a>
</div>
<div class="mnuLien2">
<a href="#">Fournisseurs</a>
</div>
<div class="mnuLien3">
<a href="#">Logiciels Maintenance</a>
</div>


</security:authorize>

</div>

<div class="mnuLien5">
<a href="#">Votre Profil</a>
</div>

<div class="copyRight">
Copyright <a href='http://www.objis.com'>Objis formations : www.objis.com</a>
</div>
</body>
</html>