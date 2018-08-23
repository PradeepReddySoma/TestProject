 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
 <!DOCTYPE html>
 <html>
 <head>
 <title>Student Confirmation</title>
 </head>
 <body>
 The student is confirmed:${Student1.firstName} ${Student1.lastName}

<br><br>
   Country: ${ Student1.country }
   <br><br>
   Favorite Language:${Student1.favoriteLanguage }
  <br><br>
  Operating Systems
  <ul>
  <c:forEach var="temp" items="${Student1.operatingSystems}">
    <li>${temp}</li>
    </c:forEach>
  </ul>
 </body>
  </html> 