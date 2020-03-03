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
			<section class="content">
			<div id="question-filter">
				<div class="box box-solid">
					<div class="box-body table-responsive no-padding">
						<!-- content-header -->
						<section class="content-header">
							<dl id="question-filter-field">
								<dt>题库：</dt>
								<dd>
									<#if fieldId = 0>
										<span data-id="0" class="label label-info">全部</span>
									<#else>
										<span data-id="0" class="btn btn-normal" onclick="list(0,${knowledge},${questionType})">全部</span>
									</#if>
									<#list fields as field>
										<#if fieldId = field.id>
											<span class="label label-info" data-id="${field.id}">${field.name}</span>
										<#else>
											<span data-id="${field.id}" class="btn btn-normal" onclick="list(${field.id},${knowledge},${questionType})">${field.name}</span>
										</#if>
									</#list>
								</dd>
							</dl>
							<dl id="question-filter-knowledge">
								<dt>知识分类：</dt>
								<dd>
									<#if knowledge = 0>
										<span data-id="0" class="label label-info" >全部</span>
									<#else>
										<span data-id="0" class="btn btn-normal" onclick="list(${fieldId},0,${questionType})">全部</span>
									</#if>
									<#list knowledgePoints as point>
										<#if point.id = knowledge>
											<span data-id="${point.id}" class="label label-info">${point.name}</span>
										<#else>
											<span data-id="${point.id}" class="btn btn-normal" onclick="list(${fieldId},${point.id},${questionType})">${point.name}</span>
										</#if>
									</#list>
								</dd>
							</dl>
			
							<dl id="question-filter-qt">
								<dt>试题类型：</dt>
								<dd>
									<#if questionType = 0>
										<span data-id="0" class="label label-info">全部</span>
									<#else>
										<span data-id="0" class="btn btn-normal" onclick="list(${fieldId},${knowledge},0)">全部</span>
									</#if>
									<#list questionTypes as type>
										<#if questionType = type.id >
											<span data-id="${type.id}" class="label label-info">${type.name}</span>
										<#else>
											<span data-id="${type.id}" class="btn btn-normal" onclick="list(${fieldId},${knowledge},${type.id})">${type.name}</span>
										</#if>
									</#list>
								</dd>
							</dl>
							<hr>
						</section>
						<!-- /.content-header -->
						<div class="col-md-12">
							<table class="table table-hover text-center">
								<thead>
									<tr>
										<td width="20"><input id="check-all" type="checkbox"/></td>
										<td>ID</td>
										<td class="question-name-td">试题名称</td>
										<td>试题类型</td>
										<td>专业</td>
										<td>知识类</td>
										<td>关键字</td>
									</tr>
								</thead>
									<tbody>
										<#if page.getContent()??>
											<#list page.getContent() as items>
												<tr>
													<#if ids?seq_contains(items.id)>
														<td><input type="checkbox" class="disabled" disabled="disabled"></td>
													<#else>	
														<td><input type="checkbox" value="${items.id }" class="checkbox"></td>
													</#if>
													<td>${items.id }</td>
													<td><a href="/admin/question/view.html/${items.id }" target="_blank" title="预览">${(items.title)! }</a></td>
													<td>${(items.questionType.name)! }</td>
													<td>${(items.field.name)! }</td>
													<td>
														<#if items.knowledgePoint??>
															<#list items.knowledgePoint as point>
														 		${point.name};
															</#list>
														</#if>
													</td>
													<td>${(items.keyword)!}</td>
												</tr>
											</#list>
										</#if>
									</tbody>
									<tfoot></tfoot>
							</table>
						</div>
					</div>
					<div class="box-footer">
						<div class="row">
							<#assign url="/admin/question/list-${fieldId}-${knowledge}-${questionType}.html">
							<#include "/admin/include/page_inc.html"/>
						</div>
					</div>
					<hr>
					<button type="button" class="btn btn-info btn-sm pull-right" onclick="deleteBatch()"><i class="fa fa-trash"></i>&nbsp; 批量添加</button>
				</div>
		    </div>
		    </section>
	<script type="text/javascript" src="${path}/common/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript" src="${path}/common/jquery-ui/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script type="text/javascript" src="${path}/js/plugs.js"></script>
	<script type="text/javascript" src="${path}/common/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${path}/dist/js/adminlte.min.js"></script>
	<script type="text/javascript" src="${path}/plugins/layer-v3.0.3/layer/layer.js"></script>
	<script type="text/javascript">
		var pid = ${pid}
		function list(fieldId,knowledge,questionType){
			document.location.href = "${path}/admin/page/addQuestion-"+fieldId+"-"+knowledge+"-"+questionType+"-"+${pid};
		}
		/* 全选按钮 */
		$("#check-all").on("click",function(){
			if(this.checked){
				$(".checkbox").prop("checked",true);
			}else{
				$(".checkbox").prop("checked",false);
			}
		});
		
		
		function deleteBatch(){
			var ids = new Array();
			var doms = $("tbody input[type=checkbox]:checked");
			for(var i=0;i<doms.length;i++){
				if(doms[i].checked){
					ids.push(doms[i].value);
				}
			}
			if(ids.length<=0){
				top.layer.open({
					title:false,
					icon:5,
					content:'请选择需要增加的数据',
					offset:'15px'
				});
			}else{
				$.ajax({
					contentType:'application/x-www-form-urlencoded',
					encoding:'utf-8',
					url:"${path}/admin/page/addQuestion",
					type:'POST',
					data:{pid:pid,ids:ids.toString()},
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
			}
		}
	</script>
</body>

</html>