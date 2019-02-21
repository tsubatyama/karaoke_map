<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ミーティング登録画面</title>
<!--Bootstrap４に必要なCSSとJavaScriptを読み込み-->
<!--Bootstrap４に必要なCSSとJavaScriptを読み込み-->


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>	
<!-- Google Maps APIを読み込む -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCKLA9l0Ej-MkVGgV8SMLk-KfIr-gWNfgI">
</script>
<script type="text/javascript">
   var mapOptions;
   var map;
   var marke
   
function initialize() {
	// 地図を表示する際のオプションを設定
	mapOptions = {
		center: new google.maps.LatLng(35.6915291, 139.69687239999996),
		zoom: 8,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	// Mapオブジェクトに地図表示要素情報とオプション情報を渡し、インスタンス生成
	map = new google.maps.Map(document.getElementById("map_canvas"),mapOptions);
}

function codeAddress(address) {
	// google.maps.Geocoder()コンストラクタのインスタンスを生成
	var geocoder = new google.maps.Geocoder();
	// geocoder.geocode()メソッドを実行 
	geocoder.geocode( { 'address': address}, function(results, status) {
		// ジオコーディングが成功した場合
		if (status == google.maps.GeocoderStatus.OK) {
			// google.maps.Map()コンストラクタに定義されているsetCenter()メソッドで
			// 変換した緯度・経度情報を地図の中心に表示
			map.setCenter(results[0].geometry.location);
			map.setZoom(16);

			var latlng = results[0].geometry.location;
   				//hiddenに緯度経度をvalueにセット
				document.getElementById("lat").value = latlng.lat();
				document.getElementById("lng").value = latlng.lng();
      
			marker = new google.maps.InfoWindow({
				content: address
			}).open(map, new google.maps.Marker({
				position: latlng,
				map: map
      			}));
    		// ジオコーディングが成功しなかった場合
    		} else {
			console.log('Geocode was not successful for the following reason: ' + status);
		} 
	});
	
}

 </script>


<script>
$(document).on('change', ':file', function() {
    var input = $(this),
    numFiles = input.get(0).files ? input.get(0).files.length : 1,
    label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    input.parent().parent().next(':text').val(label);
});
</script>
<style>
input[type="text"] {
	height: 31px;
	font-size: 11.5px;
}

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
	width:1000px;
     margin-left:auto;    /* 左側マージンを自動的に空ける */
     margin-right:auto;   /* 右側マージンを自動的に空ける */
     padding:10px;
}

</style>
</head>
<body onload="initialize()">
  <header>
    <p style="display: inline;font-family: 'arial black';font-size:33px;padding:12px;margin-top:20px">BIJIKARA</p>
    <span style="margin-left:20px">-ビジネス✖カラオケ-️</span>

			<input style="float: right;margin-top:10px ;margin-right:25px"
				class="btn btn-outline-secondary btn-sm" type="button"
				value="自動入力" id="autovalue">
			<input style="float: right;margin-top:10px ;margin-right:25px"
				class="btn btn-outline-secondary btn-sm" type="button"
				value="DB調整" id="deletehal">
		
  </header>
  <div id="center">
		<div class="container">
			<form class="class=form-inline" method="POST"
				enctype="multipart/form-data" action="./UploadServlet">
				<h1 class="h3" style="padding: 10px; margin-bottom: 20px; padding-top: 20px">ミーティング店舗登録</h1>
	
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="store">店舗名</label> <input name="store" type="text"
							class="form-control" id="store">
					</div>
					
					
				<script>
				// ボタンに指定したid要素を取得
				var button = document.getElementById("autovalue");
				
				// ボタンが押された時の処理
				button.onclick = function() {
				  // フォームに入力された住所情報を取得
				  document.getElementById("store").value = "HAL東京";
				  document.getElementById("tel").value = "0333441010";
				  document.getElementById("roomnum").value = "50";
				  document.getElementById("address").value = "東京都新宿区西新宿１丁目７−３";
				  document.getElementById("access").value = "新宿（西口）駅前・徒歩3分";
				  document.getElementById("business").value = "月〜土　09:00〜21:00";
				  document.getElementById("holiday").value = "日曜日";
				  document.getElementById("reurl").value = "https://www.hal.ac.jp/tokyo/access";
				  document.getElementById("mourl").value = "https://www.hal.ac.jp/tokyo/access";
				  // 取得した住所を引数に指定してcodeAddress()関数を実行
				}
				
				// ボタンに指定したid要素を取得
				var aiu = document.getElementById("deletehal");
				// ボタンが押された時の処理
				aiu.onclick = function() {	
					var request = {
						name : "HAL東京"
					  };
					$.ajax({
						type : 'post',
						url : 'DeleteServlet',//servltファイル
						data : request,
						datatype:'json'
					}).
					done(
					).
					fail(
						function(xhr){//失敗時のエラー処理
							console.log(xhr.status);
					});
					  alert("DE調整しました。");
				}
				
			</script>
				</div>
				
	
				<div class="form-row">
					<div class="form-group col-md-7">
						<label for="upfile">店舗紹介画像</label>
						<div class="form-group">
							<div class="input-group-append">
								<label class="input-group-btn"> <span
									class="btn btn-outline-secondary btn-sm"> &nbsp;📁<input
										name="upfile" type="file" style="display: none">
								</span>
								</label> <input type="text" class="form-control" readonly>
							</div>
						</div>
					</div>
	
					<div class="form-group col-md-5">
						<label for="tel">電話番号</label> <input name="tel" type="text"
							class="form-control" id="tel" placeholder="00012345678">
					</div>
				</div>
	
	
				<div class="form-row">
					<div class="form-group  col-md-4">
						<label for="roomnum">部屋数</label> <input name="roomnum" type="text"
							class="form-control" id="roomnum" placeholder="">
					</div>
	
					<div class="form-group col-md-6">
						<label for="chen">チェーン店舗</label> <select name="chen"
							style="height: 31px; font-size: 10.5px;" class="form-control"
							id="chen">
							<option>該当なし</option>
							<option>ビッグエコー</option>
							<option>まねきねこ</option>
							<option>カラオケBanBan</option>
							<option>シダックス</option>
							<option>コート・ダジュール</option>
							<option>ジャンボカラオケ広場</option>
							<option>カラオケ館</option>
							<option>カラオケの鉄人</option>
							<option>カラオケマック</option>
						</select>
					</div>
	
					<div class="form-group col-md-2">
						<label for="ate">飲食物持込</label><br> <label
							style="font-size: 11.5px;" class="form-check form-check-inline"
							for="radio_at1"> <input class="form-check-input"
							type="radio" name="ate" id="radio_at1" value="0" checked>
							可能
						</label> <label style="font-size: 11.5px;"
							class="form-check form-check-inline" for="radio_at2"> <input
							class="form-check-input" type="radio" name="ate" id="radio_at2"
							value="1"> 不可
						</label>
					</div>
				</div>
	
				<div class="form-row">
					<div class="form-group col-md-11">
						<label for="address">住所</label> <input name="address" type="text"
							class="form-control" id="address" placeholder="東京都新宿区西新宿１丁目７−３">
					</div>
					<div class="form-group col-md-1">
						<input style="margin-top: 32px"
							class="btn btn-outline-secondary btn-sm" type="button"
							value="地図検索" id="button">
					</div>
				</div>
	
				<input type="hidden" name="lat" id="lat" value="lat"> <input
					type="hidden" name="lng" id="lng" value="lng">
	
				<!-- マップ部分 -->
				<div class="form-row">
					<div class="form-group col-md-12">
						<div id="map_canvas" style="height: 300px"></div>
					</div>
				</div>
				<script>
				// ボタンに指定したid要素を取得
				var button = document.getElementById("button");
				
				// ボタンが押された時の処理
				button.onclick = function() {
				  // フォームに入力された住所情報を取得
				  var address = document.getElementById("address").value;
				  // 取得した住所を引数に指定してcodeAddress()関数を実行
				  console.log("1" , address);
				  codeAddress(address);
				}
			</script>
	
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="access">アクセス</label> <input name="access" type="text"
							class="form-control" id="access" placeholder="東京駅から徒歩5分">
					</div>
				</div>
	
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="business">営業時間</label> <input name="business"
							type="text" class="form-control" id="business"
							placeholder="月〜木日祝…11:00〜5:00 金土祝前…11:00〜6:00">
					</div>
				</div>
	
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="holiday">定休日</label> <input name="holiday" type="text"
							class="form-control" id="holiday" placeholder="なし">
					</div>
				</div>
	
				<div class="form-row">
					<div class="form-group col-md-10">
						<label for="reurl">予約用サイトURL</label> <input name="reurl"
							type="text" class="form-control" id="reurl"
							placeholder="https://aiueo">
					</div>
					<div class="form-group col-md-2">
						<label for="reservation">予約</label><br> <label
							style="font-size: 11.5px;" class="form-check form-check-inline"
							for="radio_re1"> <input class="form-check-input"
							type="radio" name="reservation" id="radio_re1" value="1" checked>
							必要
						</label> <label style="font-size: 11.5px;"
							class="form-check form-check-inline" for="radio_re2"> <input
							class="form-check-input" type="radio" name="reservation"
							id="radio_re2" value="0"> 不要
						</label>
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-md-10">
						<label for="mourl">価格閲覧サイトURL</label> <input name="mourl"
							type="text" class="form-control" id="mourl"
							placeholder="https://aiueo">
					</div>
					<div class="form-group col-md-2">
						<label for="half">左記より割引額</label><br> <select name="half"
							style="height: 31px; font-size: 10.5px;" class="form-control"
							id="half">
							<option>変動なし</option>
							<option>１割引</option>
							<option>２割引</option>
							<option>３割引</option>
							<option>４割引</option>
							<option>半額</option>
							<option>６割引</option>
							<option>７割引</option>
							<option>８割引</option>
							<option>９割引</option>
						</select>
					</div>
				</div>
				<button type="submit" class="btn btn-outline-secondary btn-sm" id="insert">
					登録</button>
				<script>// ボタンに指定したid要素を取得
				var button = document.getElementById("insert");
				
				// ボタンが押された時の処理
				button.onclick = function() {
				  alert("登録が完了しました。");
				}
				</script>
			</form>
		</div>
	</div>
</body>
</html>
