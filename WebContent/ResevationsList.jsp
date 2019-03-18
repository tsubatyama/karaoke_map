<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ミーティング予約確認</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!--Bootstrap４に必要なCSSとJavaScriptを読み込み-->
<!--Bootstrap４に必要なCSSとJavaScriptを読み込み-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>	
	
	
<script>
//ajax
window.onload = function() {
	var optionLoop, day, month, year, today, hour,minute;
	var storeName = "HAL大阪";
	today = new Date();
	var flg = 0;
	year = today.getFullYear();
	month = today.getMonth() + 1;
	day = today.getDate();
	hour = today.getHours();
	minute = today.getMinutes();
	var send = year + ('0' + month).slice(-2) + ('0' + day).slice(-2);
	var setime = hour + ('0' + minute).slice(-2);
	var request = {
			id : storeName,
			flg : 0,
			date : send,
			time : setime
		  };
	$.ajax({
		type : 'post',
		url : 'ReservationsServlet',//servltファイル
		data : request,
		datatype:'json'
	}).
	done(
		function(data){//成功時連想配列が入る
			data=JSON.parse(data);
			$("#store").text(data.storename)
			var len = data['contents'].length;//title配列内の要素数を習得してlenに格納
			for(var i = 0 ; i < len ; i++){
				$(".con").append("<tr><td id = arrivaltime>"+data['contents'][i]['arrivaltime']+"</td><td>"+data['contents'][i]['usetime']+"</td><td>"+data['contents'][i]['numberpeople']+"</td><td id = name>"+data['contents'][i]['name']+"</td><td>"+data['contents'][i]['tel']+"</td><td id=\"mail\">"+data['contents'][i]['mail']+"</td><td>"+data['contents'][i]['remarks']+"</td> <td id=\"id\"><a href=\"#\" id=\"delete\";return false;>キャンセル</a></td> </tr>");
			}
		     $('#delete').on("click",function(){
		    	 	console.log($('#mail').text());
		    	 	if( confirm($('#arrivaltime').text() + "からの" + $('#name').text() + " 様の予約を削除してよろしいですか？") ) {
		    	        window.location.href = "./DeleteReservation?mail="+$('#mail').text()+"";
		    	        
		    	    }
		    	    else {
		    	        alert("キャンセルしませんでした。");
		    	    }
		     })
		}
	).
	fail(
		function(xhr){//失敗時のエラー処理
			console.log(xhr.status);
	});
	/*
		日付オプションメニュー処理
	*/
	optionLoop = function(id) {
	  	var i, opt;
	 	opt = null;
	 	today.setDate(today.getDate() -1);
	  	for (i = 0; i <= 10 ; i++) {
	    		today.setDate(today.getDate() + 1);
	    		year = today.getFullYear();
	    		month = today.getMonth() + 1;
	    		day = today.getDate();
	    		var comp,val;
	    		comp = year + "年" + month + "月" + day + "日";
	    		val = year + ('0' + month).slice(-2) + ('0' + day).slice(-2);
	    		if (i == 0) {
	    			opt += "<option value='" + val + "' selected>" + comp + "</option>";
	    		} else {
	    			opt += "<option value='" + val + "'>" + comp + "</option>";
	    		}
	 	}
	 	return document.getElementById(id).innerHTML = opt;
	};
	optionLoop('date');
	
	//セレクトボックスが切り替わったら発動
	$('select').change(function() {
		send = $(this).val();
		today = new Date();
		year = today.getFullYear();
		month = today.getMonth() + 1;
		day = today.getDate();
		var ha = year + ('0' + month).slice(-2) + ('0' + day).slice(-2);
		if(ha == send){
			flg = 0;
			hour = today.getHours();
			minute = today.getMinutes();
			setime = hour + ('0' + minute).slice(-2);
		}else{
			flg = 1;
		}
		var request = {
				id : storeName,
				flg : flg,
				date : send,
				time : setime
			  };
		$.ajax({
			type : 'post',
			url : 'ReservationsServlet',//servltファイル
			data : request,
			datatype:'json'
		}).
		done(
			function(data){//成功時連想配列が入る
				data=JSON.parse(data);
				var len = data['contents'].length;//title配列内の要素数を習得してlenに格納
				$(".con").empty();
				for(var i = 0 ; i < len ; i++){
					$(".con").append("<tr id = \"aiueo\"><td id = arrivaltime>"+data['contents'][i]['arrivaltime']+"</td><td>"+data['contents'][i]['usetime']+"</td><td>"+data['contents'][i]['numberpeople']+"</td><td id = name>"+data['contents'][i]['name']+"</td><td>"+data['contents'][i]['tel']+"</td><td id=\"mail\">"+data['contents'][i]['mail']+"</td><td>"+data['contents'][i]['remarks']+"</td> <td id=\"id\"><a href=\"#\" id=\"delete1\";return false;>キャンセル</a></td> </tr>");
				}
			     $('#delete1').on("click",function(){
			    	 	if( confirm($('#arrivaltime').text() + "からの" + $('#name').text() + " 様の予約を削除してよろしいですか？") ) {
							var reqdel = {
								mail : $('#mail').text()
							  };
							$.ajax({
								type : 'post',
								url : 'DeleteReservation',//servltファイル
								data : reqdel,
								datatype:'json'
							}).
							done(
							).
							fail(
								function(xhr){//失敗時のエラー処理
									console.log(xhr.status);
							});
							 $('#aiueo').remove();
							
			    	    }
			    	    else {
			    	        alert("キャンセルしませんでした。");
			    	    }
			     })
			}
		).
		fail(
			function(xhr){//失敗時のエラー処理
				console.log(xhr.status);
		});
	});
	
	$("#store").click(function(){
		var namejudge = $("#store").text();
		console.log(namejudge);
		if("ビックエコー 西梅田店" == namejudge){
			storeName = "HAL大阪";
		} else{
			storeName = "ビックエコー 西梅田店";
		}
		var request = {
				id : storeName,
				flg : flg,
				date : send,
				time : setime
			  };
		$.ajax({
			type : 'post',
			url : 'ReservationsServlet',//servltファイル
			data : request,
			datatype:'json'
		}).
		done(
			function(data){//成功時連想配列が入る
				data=JSON.parse(data);
				$("#store").text(data.storename)
				var len = data['contents'].length;//title配列内の要素数を習得してlenに格納
				$(".con").empty();
				for(var i = 0 ; i < len ; i++){
					$(".con").append("<tr><td id = arrivaltime>"+data['contents'][i]['arrivaltime']+"</td><td>"+data['contents'][i]['usetime']+"</td><td>"+data['contents'][i]['numberpeople']+"</td><td id = name>"+data['contents'][i]['name']+"</td><td>"+data['contents'][i]['tel']+"</td><td id=\"mail\">"+data['contents'][i]['mail']+"</td><td>"+data['contents'][i]['remarks']+"</td> <td id=\"id\"><a href=\"#\" id=\"delete2\";return false;>キャンセル</a></td> </tr>");
				}
			     $('#delete2').on("click",function(){
			    	 	console.log($('#mail').text());
			    	 	if( confirm($('#arrivaltime').text() + "からの" + $('#name').text() + " 様の予約を削除してよろしいですか？") ) {
			    	        window.location.href = "./DeleteReservation?mail="+$('#mail').text()+"";
			    	    }
			    	    else {
			    	        alert("キャンセルしませんでした。");
			    	    }
			     })
			}
		).
		fail(
			function(xhr){//失敗時のエラー処理
				console.log(xhr.status);
		});
	})
	
	
}
</script>

<style>

@media ( min-width : 768px) {
	.container {
		max-width: none;
	}
}

@media ( min-width : 992px) {
	.container {
		max-width: none;
	}
}

@media ( min-width : 1200px) {
	.container {
		max-width: none;
	}
}
header {
    background-color: B3E2B4;
    height: 50px;
    width: 100%;
}

body{
	background-image:url("img/startup-593327_1280.jpg");
	background-color:white;
}
#center{
	background-color:white;
	width:1100px;
     margin-left:auto;    /* 左側マージンを自動的に空ける */
     margin-right:auto;   /* 右側マージンを自動的に空ける */
     padding:10px;
     height:100%;
}
</style>
</head>
<body>
  <header>
    <p style="display: inline;font-family: 'arial black';font-size:33px;padding:12px;margin-top:20px">BIJIKARA</p>
    <span style="margin-left:20px">-ビジネス✖カラオケ-️</span>
  
	<a id="store" style="float: right;margin-top:13px;padding-right:25px"></a>
			
  </header>
  
  <div id="center">
	<div class="container">
		<h1 class="h3" style="margin: 10px; margin-bottom: 20px; margin-top: 20px">ミーティング予約確認</h1>
		<div class="form-group col-md-5">
			<select style="height: 31px; name="year" id="date" class="form-control">
			</select>
		</div>
		
		<table style="font-size: 12px;"class="table table-striped table-bordered">
			<thead>
				<tr>
					<th style="width: 8%">来店時刻</th>
					<th style="width: 9%">利用時間</th>
					<th style="width: 8%">利用人数</th>
					<th style="width: 9%">代表者名</th>
					<th style="width: 13%">電話番号</th>
					<th style="width: 18%">メール</th>
					<th style="width: 26%">備考</th>
					<th style="width: 9%">キャンセル</th>
				</tr>
			</thead>
			
			<tbody class="con">
			</tbody>
		</table>
		
	</div>
	</div>
</body>

</html>