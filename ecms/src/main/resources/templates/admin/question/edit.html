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
			   <div class="form-group">
	                <span class="col-sm-3 control-label" style="top:8px">
	                	<small class="text-red">*</small>  选择题库
	                </span><br><br>
	                <div class="col-sm-9 question-field" id="aq-course1">
		                <select class="form-control select2" name="field" id="field" style="width: 100%;">
			                <#if fields??>
				                <#list fields as type>
				                	<#if type.id = question.field.id>
					                	<option value="${type.id}" selected="selected">${type.name}</option>
				                	<#else>
					                	<option value="${type.id}">${type.name}</option>
				                	</#if>
				                </#list>
			                </#if>
		                </select>
		                <span class="form-message"></span>
	                </div>
                </div>
                <div class="form-group">
	                <span class="col-sm-3 control-label" style="top:8px">
	                	<small class="text-red">*</small>  选择知识点
	                </span><br><br>
                   <div class="col-sm-9 question-points" id="aq-course2">
                       <select class="form-control select2" name="knowledgePoint" id="knowledgePoint" required="required" multiple="multiple" style="width: 100%;">
						   <#if question.knowledgePoint??>
								<#list question.knowledgePoint as type>
									<option value="${type.id}" selected="selected">${type.name}</option>
								</#list>
							</#if>
	                       <#if knowledges??>
		                       <#list knowledges as type>
									<option value="${type.id}">${type.name}</option>
		                       </#list>
	                       </#if>
                       </select>
                       <span class="form-message"></span>
                   </div>
                </div>
                <hr>
                <div class="pull-right">
	                <button type="button" class="btn btn-danger">删除题目</button>
	                <button type="button" onclick="edit('${question.id }')" class="btn btn-info" style="margin-right: 15px">确认修改</button>
                </div>
	<script type="text/javascript" src="${path}/common/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/common/jquery-ui/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${path}/common/select2/dist/js/select2.full.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script type="text/javascript" src="${path}/js/plugs.js"></script>
	<script type="text/javascript" src="${path}/js/field_point.js"></script>
	<script type="text/javascript" src="${path}/js/question-add.js"></script>
	<script type="text/javascript" src="${path}/dist/js/adminlte.min.js"></script>
	<script type="text/javascript" src="${path}/plugins/layer-v3.0.3/layer/layer.js" ></script>
	<script type="text/javascript" src="${path}/common/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$('.select2').select2();
		function edit(id){
			var question = new Object();
			question.id = id;
				
			var field = new Object();
			field.id = $(".question-field select").val();
			question.field = field;
			
			var pointList = new Array();
			var pointOpts = new Array();
			
			var pointOpts = $(".question-points select").val();
			
			for (var i = 0; i < pointOpts.length; i++) {
				var point = new Object();
				point.id = pointOpts[i];
				pointList.push(point);
			}
			question.knowledgePoint = pointList;
			
			layer.confirm('确定修改?',{
				btn: ['确定','取消'],
                shade: false,
                closeBtn: 0
            },
            function(){
	            $.ajax({
	            	headers : {
						'Accept' : 'application/json',
						'Content-Type' : 'application/json'
					},
	                type:"POST",
	                url:'${path}/admin/question/edit',
	                data:JSON.stringify(question),
	                success:function(message){
	                	if(message.result == "success"){
                            layer.msg('修改成功！', {icon:6,time:1000});
	                		var index = parent.layer.getFrameIndex(window.name);
	                        parent.layer.close(index);
	                    }else{
	                         layer.msg('修改失败！', {icon:6,time:1000});
	                    }
	                },
	                error:function(){
	                    layer.msg("服务繁忙，请稍后再试！",{icon:6,time:1000});
	                }
	            });
	        });
		}
	</script>
</body>

</html>