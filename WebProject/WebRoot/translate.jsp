<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script src="/WebProject/js/jquery-3.5.0.min.js"></script>
		<script src="/WebProject/js/main.js" type="text/javascript"></script>
		<link rel="stylesheet" type="text/css" href="/WebProject/css/main.css" />	
		
	</head>
	<body>
		
		<div id="head">
			<div id="in">
				<select name="incode" id="incode" style="width:120px; height: 25px;">
					<option value="">请选择原语种</option> 
				</select>
				<span>==></span>
			</div>
			
			<div id="out">
				<select name="outcode" id="outcode" style="width:120px; height: 25px;">
					<option value ="">请选择目的语种</option>
				</select>
			</div>
			
			<div id="bt">
				<input type="button" value="点击翻译"  id="clickbutton">
			</div>	
		</div>
		
		<div id="content">
				<div id="from">
					<textarea name="text" id="textarea" maxlength="30" cols="47" rows="10"  oninput="font_size()" ></textarea>
					<div class="son">
						<input type="button" id="delete"  >
					</div>
					<div class="son2">
						<p><span class="title2 hide">0/30</span></p>
					</div>
				</div>
				<div id="to">
					<textarea name="text" id="textareaprint"  style="resize: none;" cols="47" rows="10" readonly oninput="font_size()"></textarea>
				</div>
		</div>
	</body>
	
</html>
