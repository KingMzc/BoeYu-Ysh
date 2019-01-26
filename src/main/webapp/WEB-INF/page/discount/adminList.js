layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage','table','laytpl','laydate'],function(){
	var form = layui.form,table = layui.table;
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;
    var laydate = layui.laydate;
    active = {
        search : function() {
            var fullname = $('#fullname'), sex = $('#sex option:selected'), flag = $('#flag option:selected') ,phone = $('#phone');
            //执行重载
            table
                .reload(
                    'adminList',
                    {
                        page : {
                            curr : 1
                            //重新从第 1 页开始
                        },
                        where : {
                            //key: {
                            fullname : fullname
                                .val(),
                            phone : phone
                                .val(),
                            sex : sex
                                .val(),
                            flag : flag
                                .val()
                        }
                    });
        }
    };
    laydate.render({
        elem: '#endtime'
    });
		//数据表格
		table.render({
			id:'discountczkList',
		    elem: '#adminList'
		    ,url: ctx+'/sys/getdiscountList' //数据接口
		    ,cellMinWidth: 80
		    ,toolbar : true
		    ,limit:10//每页默认数
		    ,limits:[10,20,30,40,50,100,200]
		    ,cols: [[ //表头
              {field:'id', title: 'ID', sort: true}
              ,{field:'orderr', title: '卡号'}
              ,{field:'type', title: '类型',templet: '#typeTpl'}
              ,{field:'distype', title: '充值卡',templet: '#distypeTpl'}
              ,{field:'orderid', title: '密码'}
              ,{field:'endtime', title: '有效期'}
              ,{field:'createtime', title: '生成时间',templet: '<div>{{ formatTime(d.createtime,"yyyy-MM-dd")}}</div>'}
              ,{field:'export', title: '导出',templet: '#exportTpl'}
		    ]]
				,page: true //开启分页
				,where: {timestamp: (new Date()).valueOf()}
		  });
		function jiazai() {
            table.render({
                id:'discountczkList',
                elem: '#adminList'
                ,url: ctx+'/sys/getdiscountList' //数据接口
                ,cellMinWidth: 80
                ,toolbar : true
                ,limit:10//每页默认数
                ,limits:[10,20,30,40,50,100,200]
                ,cols: [[ //表头
                    {field:'id', title: 'ID', sort: true}
                    ,{field:'orderr', title: '卡号'}
                    ,{field:'type', title: '类型',templet: '#typeTpl'}
                    ,{field:'distype', title: '充值卡',templet: '#distypeTpl'}
                    ,{field:'orderid', title: '密码'}
                    ,{field:'endtime', title: '有效期'}
                    ,{field:'createtime', title: '生成时间',templet: '<div>{{ formatTime(d.createtime,"yyyy-MM-dd")}}</div>'}
                    ,{field:'export', title: '导出',templet: '#exportTpl'}
                ]]
                ,page: true //开启分页
                ,where: {timestamp: (new Date()).valueOf()}
            });
        }
    //查询
    $("#cx").click(function() {
    	var csize = $("#csize").val();
    	var distype = $('#distype').val();
        var endtime = $('#endtime').val();
        if(csize.length<0){
        	alert("请输入生成条数！")
			return false;
		}
        if(csize>100){
            alert("一次最多生成100条")
            return false;
        }
        if(distype=="-1"){
            alert("选择充值卡！")
            return false;
        }
        if(endtime.length<0){
            alert("请选择到期时间")
            return false;
        }
        var dadis={
            csize:csize,
            distype:distype,
            endtime:endtime
		}
        $.ajax({
            url:ctx+'/sys/addDiscount',
            type : "get",
			data : dadis,
            dataType:'text',
            success : function(data){
                var json = eval("("+data+")");
                if(json.code==0){
                    alert(json.msg)
                }else{
                    alert(json.msg)
                    //layer.msg("权限不足，联系超管！",{icon: 5});
                }
                jiazai();
            }
        })
    })
    //重置
    $("#cz").click(function() {
        $('#fullname').val("");
        $("#sex").val("-1");
        $('#flag').val("-1");
        $('#phone').val("");
        var form = layui.form;
        form.render('select');
    })

		//监听工具条
		  table.on('tool(test)', function(obj){
		    var data = obj.data,adminId=$("#adminId").val();
		    if(obj.event === 'del'){
		    	if(data.id==adminId){
		    		layer.msg("不允许删除自己！",{icon: 5});
		    		return;
		    	}
		      layer.confirm('真的删除行么', function(index){
		    	  $.ajax({
		    		  url:ctx+'/sys/delAdminById/'+data.id,
		    		  type : "get",
		    		  success : function(d){
		    			  if(d.code==0){
		    				  //obj.del();
		    				  table.reload('adminList', {})
		    			  }else{
		    				  layer.msg("权限不足，联系超管！",{icon: 5});
		    			  }
		    		  }
		    	  })
		        layer.close(index);
		      });
		    } else if(obj.event === 'edit'){
		    	if(data.id=='1'){
		    		layer.msg("不允许编辑此用户！",{icon: 5});
		    		return;
		    	}
		    	if(data.id==adminId){
		    		layer.msg("不允许编辑自己！",{icon: 5});
		    		return;
		    	}
		      layer.open({
		    	  type: 2,
		    	  title:"编辑角色",
		    	  area: ['360px', '250px'],
		    	  content:ctx+"/partner/editAdmin/"+data.id //这里content是一个普通的String
		      })
		    }
		  });


	//添加角色
	$(".adminAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "添加管理员",
			type : 2,
			content : ctx+"/sys/addAdmin",
			success : function(layero, index){
				layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
					tips: 3
				});
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})
	
	//批量删除角色
	$(".batchDel").click(function(){
		var checkStatus = table.checkStatus('adminList')
	      ,data = checkStatus.data,adminStr='',flag=false,adminId=$("#adminId").val();
//	      layer.alert(JSON.stringify(data));
		if(data.length>0){
			$.each(data, function (n, value) {
				  //避免选择不允许操作角色
	              if(value.roleName=='超级管理员'){
	            	  flag=true;
	            	  layer.msg('"超级管理员"不允许被删除！',{icon: 5});
	            	  return;
	              }
	              if(value.id+""==adminId){
	            	  flag=true;
	            	  layer.msg('不允许删除自己！',{icon: 5});
	            	  return;
	              }
	              adminStr+=value.id+',';
	          });
			//包含不允许操作角色，结束方法
			  if(flag){
				  return;
			  }
			  adminStr=adminStr.substring(0,adminStr.length-1);
			  layer.confirm('真的要删除<strong>'+data.length+'</strong>条数据吗？', function(index){
				//调用删除接口
				  $.ajax({
			    		  url:ctx+'/sys/delAdmins/'+adminStr,//接口地址
			    		  type : "get",
			    		  success : function(d){
			    			  if(d.code==0){
			    				  //删除成功，刷新父页面
			    				  parent.location.reload();
			    			  }else{
			    				  layer.msg("删除错误，稍后再试！",{icon: 5});
			    			  }
			    		  }
			    	  })
			  });
		}else{
			layer.msg("请选择要操作的数据！");
		}
		
	})
	
})

//格式化时间
function formatTime(datetime,fmt){
	if (parseInt(datetime)==datetime) {
	    if (datetime.length==10) {
	      datetime=parseInt(datetime)*1000;
	    } else if(datetime.length==13) {
	      datetime=parseInt(datetime);
	    }
	  }
	  datetime=new Date(datetime);
	  var o = {
	  "M+" : datetime.getMonth()+1,                 //月份   
	  "d+" : datetime.getDate(),                    //日   
	  "h+" : datetime.getHours(),                   //小时   
	  "m+" : datetime.getMinutes(),                 //分   
	  "s+" : datetime.getSeconds(),                 //秒   
	  "q+" : Math.floor((datetime.getMonth()+3)/3), //季度   
	  "S"  : datetime.getMilliseconds()             //毫秒   
	  };   
	  if(/(y+)/.test(fmt))   
	  fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));   
	  for(var k in o)   
	  if(new RegExp("("+ k +")").test(fmt))   
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
	  return fmt;
}
