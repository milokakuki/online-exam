<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<#include "/admin/include/title.html"/>
		<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
		<link rel="stylesheet" href="${path}/common/bootstrap/dist/css/bootstrap.min.css" />
		<!--Font Awesome-->
		<link rel="stylesheet" href="${path}/common/font-awesome/css/font-awesome.min.css" />
		<link rel="stylesheet" href="${path}/common/Ionicons/css/ionicons.min.css" />
		<!--Theme style-->
		<link rel="stylesheet" type="text/css" href="${path}/dist/css/AdminLTE.min.css" />
		<!--AdminLTE Skins-->
		<link rel="stylesheet" type="text/css" href="${path}/dist/css/skins/skin-blue.min.css" />
		<!-- <link rel="icon" href="${path}/img/favicon.ico" type="image/x-icon" />
		<link rel="shortcut icon" href="${path}/img/favicon.ico" type="image/x-icon"/> -->
		<!--[if lt IE 9]>
			<script type="text/javascript" src="${path}/js/html5shiv/3.7.3/html5shiv.min.js}" ></script>
			<script type="text/javascript" src="${path}/js/respond/1.4.2/respond.min.js}" ></script>	
		<![endif]-->
		<link rel="stylesheet" href="${path}/css/fonts.googleapis.com.css" />
		<link rel="stylesheet" href="${path}/css/question-add.css" />
		<link rel="stylesheet" href="${path}/plugins/layer-v3.0.3/layer/skin/default/layer.css" />
		<link rel="stylesheet" href="${path}/common/select2/dist/css/select2.min.css" />
	</head>

	<body>
		<section class="content">
			<div class="box box-success box-solid">
	          <div class="box-header with-border">
	            <h3 class="box-title">修改分数</h3>
	          </div>
	          <!-- /.box-header -->
	          <div class="box-body">
	            <form>
					<div class="form-line qt-point-destination">
						<label for="points" class="form-label">分数：</label>
						<input type="text" value="" id="points" name="points" required="required" placeholder="please input points" />
					</div>
					<div class="form-line">
						<button type="submit" class="btn btn-sm btn-success" id="update-point-btn"><i class="fa fa-check"></i>仅修改第本题</button>
						<button type="submit" class="btn btn-sm btn-warning" id="update-point-type-btn"><i class="fa fa-random"></i>批量更新该题型</button>
					</div>
				</form>
	          </div>
	          <!-- /.box-body -->
	        </div>
	    </section>
		<script type="text/javascript" src="${path}/common/jquery/dist/jquery.min.js"></script>
		<script type="text/javascript" src="${path}/common/jquery-ui/jquery-ui.min.js"></script>
		<script type="text/javascript" src="${path}/common/select2/dist/js/select2.full.js"></script>
		<script>
			$.widget.bridge('uibutton', $.ui.button);
		</script>
		<script type="text/javascript" src="${path}/js/plugs.js"></script>
		<script type="text/javascript" src="${path}/js/field_point.js"></script>
		<script type="text/javascript" src="${path}/dist/js/adminlte.min.js"></script>
		<script type="text/javascript" src="${path}/plugins/layer-v3.0.3/layer/layer.js" ></script>
		<script type="text/javascript" src="${path}/common/bootstrap/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript">
			$("#update-point-btn").click(function(){
				var pid = ${page.id};
				var qid = ${question.id};
				var points = $("#points").val();
				var type=-1;
				$.ajax({
					contentType:'application/x-www-form-urlencoded',
					encoding:'utf-8',
					url:"${path}/admin/page/editPoints",
					type:'post',
					data:{
						qid:qid,
						pid:pid,
						points:points,
						type:type
					},
					cache:false,
					async:false,
					success:function(msg){
					   if(msg.code == 0){
						   var index = parent.layer.getFrameIndex(window.name);
						   parent.layer.close(index);
					   }else{
						   layer.msg('添加失败！', {icon:6,time:1000});
					   }
					},
					error:function(msg){
						layer.msg('服务器错误，请稍后再试！', {icon:6,time:1000});
					}
				});
			});
			$("#update-point-type-btn").click(function(){
				
				var pid = ${page.id};
				var qid = ${question.id};
				var points = $("#points").val();
				var type=${question.questionType.id};
				$.ajax({
					contentType:'application/x-www-form-urlencoded',
					encoding:'utf-8',
					url:"${path}/admin/page/editPoints",
					type:'post',
					data:{
						pid:pid,
						qid:qid,
						points:points,
						type:type
					},
					cache:false,
					async:false,
					success:function(msg){
						   if(msg.code == 0){
							   var index = parent.layer.getFrameIndex(window.name);
							   parent.layer.close(index);
						   }else{
							   layer.msg('添加失败！', {icon:6,time:1000});
						   }
					},
					error:function(msg){
							layer.msg('服务器错误，请稍后再试！', {icon:6,time:1000});
					}
				});
			});
		</script>
	</body>

</html>