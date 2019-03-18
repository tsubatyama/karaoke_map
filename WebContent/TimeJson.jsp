<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.Time"%>
<%@ page import="java.util.*"%>
<%
ArrayList<Time> postsList = (ArrayList<Time>)request.getAttribute("result");
String roomnum = (String)request.getAttribute("roomnum");
int i_num = Integer.parseInt(roomnum);
%>
{ "postsList":[
<% for(int i=0; i<postsList.size(); i++){ %>
{ 
"postDate":"<%= postsList.get(i).getTime() %>", 
"postDataTime":"<%= postsList.get(i).getDate() %>", 
"postDisplayTime":"<%= postsList.get(i).getDisplayTime() %>", 
"postNine":"<%= postsList.get(i).getRoomNine(i_num) %>", 
"postNineHalf":"<%= postsList.get(i).getRoomNineHalf(i_num) %>", 
"postTen":"<%= postsList.get(i).getRoomTen(i_num) %>", 
"postTenHalf":"<%= postsList.get(i).getRoomTenHalf(i_num) %>", 
"postEleven":"<%= postsList.get(i).getRoomEleven(i_num) %>", 
"postElevenHalf":"<%= postsList.get(i).getRoomElevenHalf(i_num) %>", 
"postTwelve":"<%= postsList.get(i).getRoomTwelve(i_num) %>", 
"postTwelveHalf":"<%= postsList.get(i).getRoomTwelveHalf(i_num) %>", 
"postThirteen":"<%= postsList.get(i).getRoomThirteen(i_num) %>", 
"postThirteenHalf":"<%= postsList.get(i).getRoomThirteenHalf(i_num) %>", 
"postFourteen":"<%= postsList.get(i).getRoomFourteen(i_num) %>", 
"postFourteenHalf":"<%= postsList.get(i).getRoomFourteenHalf(i_num) %>", 
"postFifteen":"<%= postsList.get(i).getRoomFifteen(i_num) %>", 
"postFifteenHalf":"<%= postsList.get(i).getRoomFifteenHalf(i_num) %>", 
"postSixteen":"<%= postsList.get(i).getRoomSixteen(i_num) %>", 
"postSixteenHalf":"<%= postsList.get(i).getRoomSixteenHalf(i_num) %>", 
"postSeventeen":"<%= postsList.get(i).getRoomSeventeen(i_num) %>", 
"postSeventeenHalf":"<%= postsList.get(i).getRoomSeventeenHalf(i_num) %>", 
"postEightteen":"<%= postsList.get(i).getRoomEightteen(i_num) %>", 
"postEightteenHalf":"<%= postsList.get(i).getRoomEightteenHalf(i_num) %>", 
"postNineteen":"<%= postsList.get(i).getRoomNineteen(i_num) %>",
"postNineteenHalf":"<%= postsList.get(i).getRoomNineteenHalf(i_num) %>",
"postTwenty":"<%= postsList.get(i).getRoomTwenty(i_num) %>",
"postTwentyHalf":"<%= postsList.get(i).getRoomTwentyHalf(i_num) %>",
"postTwentyOne":"<%= postsList.get(i).getRoomTwentyOne(i_num) %>",
"postTwentyOneHalf":"<%= postsList.get(i).getRoomTwentyOneHalf(i_num) %>"
}
<% if(i != (postsList.size()-1)){ %>,<%}%>
<%}%>
] }
