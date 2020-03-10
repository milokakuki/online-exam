$(function() {
	question_add.initial();

});
question_add = {
		initial : function initial() {
			
			//this.copyToAnswer();
			this.bindChangeQuestionType();
			
			this.bindAddOpt();
			this.bindRemoveOpt();
			this.rearrange();
			
			this.bindAddAnswer();
			this.bindRemoveAnswer();
			
			
			
			this.bindSubmit();
			this.composeEntity();
			
			
		},
		bindSubmit : function bindSubmit() {
			$("#btn-save").click(function() {
				if ( question_add.verifyInput()== true) {
					document.getElementById("btn-save").disabled="disabled";
					var question_entity = question_add.composeEntity();
					var pid = $(".question-pageid input").val();
					console.log(question_entity);
					$.ajax({
						headers : {
							'Accept' : 'application/json',
							'Content-Type' : 'application/json'
						},
						type : "POST",
						url : "/admin/question/add/"+pid,
						data : JSON.stringify(question_entity),
						success : function(message) {
							console.log(message);
							if (message.result == "success") {
								layer.msg("操作成功！", {icon:6,time:1000});
								document.location.href = "/admin/question/list-0-0-0-"+pid;
							} else {
								layer.msg("操作失败，请联系管理员！", {icon:5,time:1000});
							}

						},
						error : function(message) {
							layer.msg("操作失败，请联系管理员！", {icon:5,time:1000});
						}
					});

			}
				else{
					alert("带星号项目为必填项目，请输入必填项！");
				}
			});
		},
		/**
		 *检查多选题选项选择情况
		 */
		checkAnswerMuti : function checkAnswerMuti() {
			var muti_answer_opts = $(".form-question-answer-muti input[type=checkbox]");
			for (var i = 0; i < muti_answer_opts.length; i++) {
				if (muti_answer_opts[i].checked == true) {
					return true;
				}
			}
			var messagebox = $(".form-question-answer-muti .form-message");
			messagebox.text("请至少选择一个选项");
			messagebox.height(messagebox.height() + 1);
			messagebox.height(messagebox.height() - 1);
			return false;

		},
		
		verifyInput : function verifyInput(){
			var result = true;
			var r_checkName = question_add.checkTitle();
			var r_checkContent = question_add.checkContent();
			 var r_checkChoise = question_add.checkChoise();
			
			result = r_checkName && r_checkContent && r_checkChoise;
			
			return result;
		},
		
		checkTitle : function checkTitle() {
			var title = $(".question-title input").val();
			if (title == "") {
				$(".question-title .form-message").text("请输入题目");
				$("#title").focus();
				$("#title").addClass("has-error");
				return false;
			} else {
				return true;
			}
		},
	 
		checkContent : function checkContent() {
			var content = $(".question-content textarea").val();
			var titleImg = $("#titleImg");

			if (content == "" && titleImg.val()=="") {
				$(".question-content .form-message").text("请输入内容");
				$("#content").focus();
				$("#content").addClass("has-error");

			} else {
				return true;
			}
		},
		

		checkChoise : function checkChoise() {
			var resultc=true;
			if ($(".question-type select").val() ==1){
			var add_opt_items = $(".add-opt-item");

			for (var i = 0; i < add_opt_items.length; i++) {
				var add_opt_item = $(add_opt_items[i]);
				//选项标签
				var opt_img = add_opt_item.find(".display-opt-img");
				//alert(  "opt_img.length:"+ opt_img.length);
				//if (opt_img.length > 0) {
				//	alert(  "URL:"+ opt_img.data("url"));
				//}
				
				if (opt_img.length<=0 && add_opt_item.children("input").val()==""){
					  resultc= false;
					  $(".add-opt-item .form-message").text("请输入选项内容");
				}
			}
			}
			if ($(".question-type select").val() ==2){
				var add_opt_items = $(".add-opt-item");

				for (var i = 0; i < add_opt_items.length; i++) {
					var add_opt_item = $(add_opt_items[i]);
					//选项标签
					var opt_img = add_opt_item.find(".display-opt-img");
					//alert(  "opt_img.length:"+ opt_img.length);
					//if (opt_img.length > 0) {
					//	alert(  "URL:"+ opt_img.data("url"));
					//}
					if (opt_img.length<=0 && add_opt_item.children("input").val()==""){
						  resultc= false;
						  $(".add-opt-item .form-message").text("请输入选项内容");
					}
				}
				}
			return resultc
		},
		
		bindChangeQuestionType : function changeQuestionType() {
			$("#question-type select").change(function() {
				if (1 == $(this).val()) {
					$(".correct-answer").hide();
					$(".form-question-opt").show();
					$(".form-question-answer1").show();
					//copyToAnswer();
				} else if (2 == $(this).val()) {
					$(".correct-answer").hide();
					$(".form-question-opt").show();
					$(".form-question-answer-muti").show();
					//copyToAnswer();
				} else if (3 == $(this).val()) {
					$(".correct-answer").hide();
					$(".form-question-opt").hide();
					$(".form-question-answer-boolean").show();
				} else {
					$(".correct-answer").hide();
					$(".form-question-opt").hide();
					$(".form-question-answer-text").show();
				}

			});
		},
		/**
		 *添加一个选项
		 */

		bindAddOpt : function bindAddOpt() {

			$("#ques-add-opt").click(function() {
				var optlength = $(".form-question-opt .add-opt-item").length;
				if (optlength > 5) {
					$(".form-question-opt .form-message").text("选项不能超过6个");
					return false;
				}
				var text = "<span class=\"add-opt-item\"><label class=\"que-opt-no options"+String.fromCharCode(65 + optlength)+"\">" + String.fromCharCode(65 + optlength) + "</label><input type=\"text\" class=\"df-input-narrow form-question-opt-item\"/> <span class=\"add-img add-opt-img\" onclick=\"uploadThumbnail("+(optlength+1)+")\">添加图片</span> <span><i class=\"small-icon ques-remove-opt fa fa-minus-square\" title=\"删除此选项\"></i></span> </span>";
				$(".add-opt-items").append(text);
				question_add.copyToAnswer();
			});
		},

		/**
		 *删除一个选项
		 */
		bindRemoveOpt : function bindRemoveOpt() {
			$(".form-question-opt").on("click", ".ques-remove-opt", function() {
				$(this).parent().parent().remove();
				question_add.rearrange();
				question_add.copyToAnswer();

			});

		},
		
		/**
		 *选项重新排序
		 */
		rearrange : function rearrange() {
			var opts = $(".form-question-opt .que-opt-no");
			opts.each(function(index) {
				$(this).text(String.fromCharCode(65 + index));
			});
		},
		copyToAnswer : function copyToAnswer() {
			var questionType = $("#question-type select");
			var optlength = $(".form-question-opt-item").length;
			if (1 == questionType.val()) {
				$(".form-question-answer1 select").empty();
				for (var i = 0; i < optlength; i++) {
					$(".form-question-answer1 select").append("<option value=\"" + String.fromCharCode(65 + i) + "\">" + String.fromCharCode(65 + i) + "</option>");
				}

			} else if (2 == questionType.val()) {
				$(".form-question-answer-muti .muti-opt-item").remove();
				for (var i = 0; i < optlength; i++) {
					$(".form-question-answer-muti .form-message").before("<span class=\"muti-opt-item\"><input type=\"checkbox\" value=\"" + String.fromCharCode(65 + i) + "\"/><label class=\"que-opt-no\">" + String.fromCharCode(65 + i) + "</label><br /></span>");
				}
			}
		},
		
		composeEntity : function composeEntity() {
			var question_entity = new Object();
			var questionType = new Object();
			questionType.id = $(".question-type select").val();
//			console.log($(".question-type select").val());
//			console.log(questionType.id);
			question_entity.questionType = questionType;
			
			//var field = new Object();
			//field.id = $(".question-field select").val();
			//question_entity.field = field;
//			console.log($(".question-field select").val());
//			console.log(field.id);
			
			
			//var pointList = new Array();
			//var pointOpts = new Array();
			
			//var pointOpts = $(".question-points select").val();
			//console.log($(".question-points select").val());
			//console.log(pointOpts);
			
			//for (var i = 0; i < pointOpts.length; i++) {
			//	var point = new Object();
			//	point.id = pointOpts[i];
			//	pointList.push(point);
			//}
			
			//question_entity.knowledgePoint = pointList;
			
			//var page = new Object();
			//page.id = $(".question-pageid input").val();

			//question_entity.page = page;
			
			question_entity.title = $(".question-title input").val();
			
			if (1 == question_entity.questionType.id) {
				question_entity.answer = $(".form-question-answer1 select").val();
			} else if (2 == question_entity.questionType.id) {
				var checkboxs = $(".form-question-answer-muti input:checked");
				var tmp_v = "";
				for (var i = 0; i < checkboxs.length; i++) {
					tmp_v = tmp_v + checkboxs[i].value;
				}
				question_entity.answer = tmp_v;

			} else if (3 == question_entity.questionType.id) {
				question_entity.answer = $(".form-question-answer-boolean select").val();
			} else {
				//填空题
				//question_entity.answer = $(".form-question-answer-text textarea").val();
				var answer = "";
				var answerOpts = $(".add-question-fill");

				for (var i = 0; i < answerOpts.length; i++) {
					answer+=$(answerOpts[i]).val()+",";
				}
				question_entity.answer = answer;
			}
			question_entity.content = $(".question-content textarea").val();
			titleImg = $("#titleImg");
			if (titleImg.length > 0) {
				question_entity.titleImg = titleImg.val();
			}
			var choiceMap = {};
			var imageMap = {};
			if (1 == question_entity.questionType.id) {
				var add_opt_items = $(".add-opt-item");

				for (var i = 0; i < add_opt_items.length; i++) {
					var add_opt_item = $(add_opt_items[i]);
					//选项标签
					var opt_img = add_opt_item.find(".display-opt-img");
					if (opt_img.length > 0) {
						imageMap[add_opt_item.children(".que-opt-no").text()] = opt_img.data("url");
					}
					choiceMap[add_opt_item.children(".que-opt-no").text()] = add_opt_item.children("input").val();
				}
				
			} else if (2 == question_entity.questionType.id) {
				var add_opt_items = $(".add-opt-item");

				for (var i = 0; i < add_opt_items.length; i++) {
					var add_opt_item = $(add_opt_items[i]);
					//选项标签
					var opt_img = add_opt_item.find(".display-opt-img");
					if (opt_img.length > 0) {
						imageMap[add_opt_item.children(".que-opt-no").text()] = opt_img.data("url");
					}
					choiceMap[add_opt_item.children(".que-opt-no").text()] = add_opt_item.children("input").val();
				}
			}
			question_entity.choiceList = choiceMap;
			question_entity.choiceImgList = imageMap;
			
			
			question_entity.analysis = $(".form-question-analysis textarea").val();
			question_entity.keyword = $(".form-question-keyword input").val();
			return question_entity;
		},
		
		//添加一个备选答案
		bindAddAnswer : function bindAddAnswer() {
			$("#ques-add-answer").click(function() {
				var text = '<span class="fill-answer-opt"><span class="form-label form-question-answer-more">备选答案：</span><input type="text" class="add-question-fill" size="40">';
				text+='<span><i class="small-icon ques-remove-answer fa fa-minus-square" title="删除此选项"></i></span></span>';
				$(".form-question-answer-text").append(text);
			});
		},
		
		//删除一个备选答案
		bindRemoveAnswer : function bindRemoveAnswer() {
			//$(".ques-remove-answer").click(function() {
			$(".form-question-answer-text").on("click", ".ques-remove-answer", function() {
				$(this).parent().parent().remove();
				
			});

		}
}