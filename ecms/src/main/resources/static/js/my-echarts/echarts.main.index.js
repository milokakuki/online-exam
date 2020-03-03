 // 基于准备好的dom，初始化echarts实例
        var myCharts = echarts.init(document.getElementById('chart-today'));
		option = {
		    title: {
		        text: ''
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['PV']
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: ["0:00","1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00","11:00"
                ,"12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00"]
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		        {
		            name:'PV',
		            type:'line',
		            stack: '总量',
		            data:[0,5, 20, 36, 10, 10, 20,50,11,30,12,60,7,0,55,10,0,0,0,0,0,0,0,0]
		        }
		    ]
		};
        // 使用刚指定的配置项和数据显示图表。
        myCharts.setOption(option);
        window.onresize = myCharts.resize;