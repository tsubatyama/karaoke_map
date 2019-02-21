<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entities.Stores"%>
<%@ page import="java.util.*"%>
<%
ArrayList<Stores> postsList = (ArrayList<Stores>)request.getAttribute("result");
%>
{ "postsList":[
<% for(int i=0; i<postsList.size(); i++){ %>
{ "postId":"<%= postsList.get(i).getId() %>", "postName":"<%= postsList.get(i).getName() %>",
"postLatitude":"<%= postsList.get(i).getLatitude() %>",
"postLongitude":"<%= postsList.get(i).getLongitude() %>", "postIcon":"<%= postsList.get(i).getIcon() %>",
"postRoomNum":"<%= postsList.get(i).getRoomNum() %>",
"postIsImmediately":"<%= postsList.get(i).getIsImmediately() %>",
"postIsAte":"<%= postsList.get(i).getIsAte() %>", "postIsHalf":"<%= postsList.get(i).getIsHalf() %>",
"postMoneyUrl":"<%= postsList.get(i).getMoneyUrl() %>",
"postReservationUrl":"<%= postsList.get(i).getReservationUrl() %>",
"postTel":"<%= postsList.get(i).getTel() %>", "postAddress":"<%= postsList.get(i).getAddress() %>",
"postHoliday":"<%= postsList.get(i).getHoliday() %>", "postAccess":"<%= postsList.get(i).getAccess() %>",
"postBusiness":"<%= postsList.get(i).getBusiness() %>", "postPhoto":"<%= postsList.get(i).getPhoto() %>"
}<% if(i != (postsList.size()-1)){ %>,<%}%>
<%}%>
] }
