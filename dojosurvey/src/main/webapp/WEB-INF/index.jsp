<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
    <div class="view">
    <form method="post" action="/result">
    	Your Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="txt" style="width:200px;"><br><br>
        Dojo Location:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="game" name="loc" style="width:200px;">
            			<option value="San Jose">San Jose</option>
            			<option value="New York">New York</option>
            			<option value="Washington">Washington</option>
        			  </select><br><br>
       Favorite language:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select id="game" name="lang" style="width:200px;">
            			<option value="python">python</option>
            			<option value="c">c</option>
            			<option value="java">java</option>
        			  </select><br><br>
      Comment(Optional):&nbsp;&nbsp;&nbsp;<center><input type="textarea" style="width:300px;height:200px;" name="tex"></center><br><br>
        <center><input type="submit" value="Button"></center>

    </form>

    </center>
</body>
</html>