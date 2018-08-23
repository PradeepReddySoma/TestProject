<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head></head>
<body>
  <form:form action="processStudent" modelAttribute="Student1">
  First Name:<form:input path="firstName" />
  <br><br>
   Last Name:<form:input path="lastName" />
   <br><br>
   Country:
    <form:select path="country">
 <!--  <form:option value="Brazil" label="Brazil" />
      <form:option value="France" label="France" />
      <form:option value="Germany" label="Germany" />
      <form:option value="India" label="India" />
      <form:option value="United States" label="United States" />-->
      <form:options items="${Student1.countryOptions}" />
   </form:select>
   
   <br><br>
    Favorite Language:
      java<form:radiobutton path="favoriteLanguage" value="java"/>&nbsp&nbsp
      C#<form:radiobutton path="favoriteLanguage" value="C#"/>&nbsp&nbsp
     PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>&nbsp&nbsp
     RUBY <form:radiobutton path="favoriteLanguage" value="RUBY"/>&nbsp&nbsp
   <br><br> 
   Operating Systems:
   Linux<form:checkbox path="operatingSystems" value="Linux" />
   Mac OS<form:checkbox path="operatingSystems" value="Mac OS" />
   MS Windows<form:checkbox path="operatingSystems" value="MS Windows" />
   Solaris<form:checkbox path="operatingSystems" value="Solaris" />
   
   <br><br> 
   
   <input type="submit" value="submit" />
   </form:form>
</body>
</html> 