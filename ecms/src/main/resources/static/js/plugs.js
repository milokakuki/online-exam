;(function($){
	$.fixWidth = function(str,options){
		var setting = $.extend({length:12,suffix:".",fillLength:3} , options || {});
		var pos = setting.length - str.length;
		if(pos > 0){
			return str;
		}else{
			if (setting.suffix) {//带后缀
				var fs = "";
				for (var i=0;i<setting.fillLength;i++) {
					fs += setting.suffix;
				}
				return str.substr(0,setting.length-3) + " " + fs;
			} else{//不带后缀
				return str.substr(0,setting.length);
			}
		}
	}
})(jQuery);
