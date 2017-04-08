
<?xml version="1.0" encoding="UTF-8"?>
<matchList>
	<matchInfo>
		<Img></Img>
		<name>炉石杯</name>
		<matchId>10023</matchId>
		<deadline>2017/4/11</deadline>
		<teamNum>36</teamNum>
		<personNum>1</personNum>
		<ruleId>1</ruleId>
		<award>20000</award>
		<organizerID>102</organizerID>
		<area>国服</area>
		<startTime>dawd</startTime>
		<type>炉石</type>
	</matchInfo> 
	<matchInfo>
		<Img></Img>
		<name>LOL杯</name>
		<matchId>10023</matchId>
		<deadline>2017/4/11</deadline>
		<teamNum>36</teamNum>
		<personNum>1</personNum>
		<ruleId>1</ruleId>
		<award>20000</award>
		<organizerID>102</organizerID>
		<area>国服</area>
		<startTime>dawd</startTime>
		<type>英雄联盟</type>
	</matchInfo> 
	<matchInfo>  
		<Img></Img>
		<name>Dota</name>
		<matchId>10023</matchId>
		<deadline>2017/4/11</deadline>
<<<<<<< HEAD
		<Location>900m</Location> 
	</matchInfo> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
 import="java.util.ArrayList,java.util.List,com.gp.bean.*"
	pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="UTF-8"?>
<matchList>
			<%
			List<gamematchBean> list =  (List<gamematchBean>) request.getAttribute("list");
			
				for (int i = 0; i < list.size(); i++) {
					gamematchBean gamematch = list.get(i);
			%>
	<matchInfo>
		<Img></Img>
		<name><%=gamematch.getMatchName() %></name>
		<matchId><%=gamematch.getMatchID() %></matchId>
		<deadline><%=gamematch.getDeadline() %></deadline>
		<Location>900m</Location>
=======
		<teamNum>36</teamNum>
		<personNum>1</personNum>
		<ruleId>1</ruleId>
		<award>20000</award>
		<organizerID>102</organizerID>
		<area>国服</area>
		<startTime>dawd</startTime>
		<type>dota</type>
>>>>>>> refs/remotes/origin/master
	</matchInfo> 
	<%
		}
	%>

<matchList>