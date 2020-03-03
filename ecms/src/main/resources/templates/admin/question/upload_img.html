<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<#include "/admin/include/title.html"/>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
		<!--Bootstrap 3.3.7-->
		<link rel="stylesheet" href="${path}/common/bootstrap/dist/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${path}/common/bootstrap/dist/css/bootstrap-switch.min.css" />
		<!--Font Awesome-->
		<link rel="stylesheet" href="${path}/common/font-awesome/css/font-awesome.min.css" />
		<!--Ionicons-->
		<link rel="stylesheet" href="${path}/common/Ionicons/css/ionicons.min.css" />
		<!--Theme style-->
		<link rel="stylesheet" type="text/css" href="${path}/dist/css/AdminLTE.min.css" />
		<link rel="stylesheet" type="text/css" href="${path}/plugins/editormd/css/editormd.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/common/select2/dist/css/select2.min.css" />
		<link rel="stylesheet" type="text/css" href="${path}/plugins/zTree_v3-3.5.28/css/metroStyle/metroStyle.css"/>
		<!--AdminLTE Skins-->
		<link rel="stylesheet" type="text/css" href="${path}/dist/css/skins/skin-blue.min.css" />
		<link rel="icon" href="${path}/img/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="${path}/img/favicon.ico" type="image/x-icon"/>

		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
			<script type="text/javascript" src="${path}/js/html5shiv/3.7.3/html5shiv.min.js" ></script>
			<script type="text/javascript" src="${path}/js/respond/1.4.2/respond.min.js" ></script>	
		<![endif]-->
		<!--Google Font-->
		<link rel="stylesheet" href="${path}/css/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="${path}/plugins/layer-v3.0.3/layer/skin/default/layer.css" />
		<link rel="stylesheet" href="${path}/plugins/zTree_v3-3.5.28/css/metroStyle/metroStyle.css" />
		<link rel="stylesheet" href="${path}/plugins/h5fileupload/css/fileinput.css" />
	</head>

	<body class="hold-transition skin-blue sidebar-mini">
		<div class="row">
			<input type="hidden" id="num" name="num" value="${num}"/>
			<div class="col-md-12 margin">
                <form action="#" method="post" class="form-horizontal" style="padding: 0 15px 0 15px;" id="article-form">
                    <div class="form-group">
                        <input type="file" id="file" name="file" multiple="multiple"/>
                        <input type="hidden" id="img-url" value=""/>
                    </div>
                </form>
				<button type="button" class="btn btn-primary btn-sm upload-ok" disabled="true" style="width: 100px; float: right;" onclick="doConfirm()">
					<i class="fa fa-check-square-o"></i>确认
				</button>
			</div>
		</div>

		<script type="text/javascript" src="${path}/common/jquery/dist/jquery.min.js"></script>
		<script type="text/javascript" src="${path}/common/jquery-ui/jquery-ui.min.js"></script>
		<script type="text/javascript" src="${path}/common/select2/dist/js/select2.full.js"></script>
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script type="text/javascript" src="${path}/dist/js/adminlte.min.js"></script>
		<script type="text/javascript" src="${path}/plugins/editormd/editormd.min.js" ></script>
		<script type="text/javascript" src="${path}/plugins/layer-v3.0.3/layer/layer.js" ></script>
		<script type="text/javascript" src="${path}/common/bootstrap/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${path}/plugins/h5fileupload/js/fileinput.min.js" ></script>
		<script type="text/javascript" src="${path}/plugins/zTree_v3-3.5.28/js/jquery.ztree.all.js" ></script>
		<script type="text/javascript" src="${path}/common/bootstrap/dist/js/bootstrap-switch.min.js"></script>
		<script type="text/javascript">
			/*文件上传*/
			$("#file").fileinput({
				language:'en',
				uploadUrl:'${path}/admin/question/upload',
				allowedFileExtensions:['jpg','png','bmp','gif'],
				minFileCount:1,
				maxFileCount:1
			}).on("fileuploaded",function(even,data){
				var url = data.response.url;
				//TODO 获取服务器返回的图片地址，进行替换
				$("#img-url").val(url);
				$(".upload-ok").attr("disabled",false);
			});
			
			/*确定图片*/
			function doConfirm(){
				var num = $("#num").val();
				//console.log(num);
				if(num == 0){
					var img_url = $("#img-url").val();
					var displayImg = parent.$(".question-content").find(".diaplay-img");
					if(displayImg.length == 0){
						//console.log("0"+num);
						parent.$("#titleImg").val(img_url);
						parent.$("#titleImg").after("<a href=\"" + img_url + "\" class=\"diaplay-img display-opt-img\" target=\"_blank\" data-url=\"" + img_url + "\">预览图片</a>");
					}else{
						displayImg.attr("href", img_url);
					}
					$("#img-url").val("");
					var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}else{
					//console.log("ca"+num);
					var fileurl = $("#img-url").val();
					var thisopt = $(parent.$(".add-opt-item")[num-1]);
					console.log("caca"+thisopt)
					var displayImg = thisopt.find(".diaplay-img");
	        		
	        		if(displayImg.length == 0){
	        			thisopt.find("input.form-question-opt-item").after("<a href=\"" + fileurl + "\" class=\"diaplay-img display-opt-img\" target=\"_blank\" data-url=\"" + fileurl + "\">预览图片</a>");
	        		}else{
	        			displayImg.attr("href", fileurl);
	        		}
	        		var index = parent.layer.getFrameIndex(window.name);
					parent.layer.close(index);
				}
			}
		</script>
	</body>
</html>