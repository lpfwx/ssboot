<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/dpl.css" rel="stylesheet">
    <link href="http://g.alicdn.com/bui/bui/1.1.21/css/bs3/bui.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/index.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/font/iconfont.css">
</head>
<body>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min1.7.js"></script>
<script type="text/javascript">
$(function(){
	$(".sel3").val("${banner.order1}");
	
	 $(":radio[name='start1'][value='${banner.start1}']").attr("checked", "checked");
})

</script>
<div class="box">
    <div class="control-group control-group1">
        <label class="control-label"><s>*</s>图片：</label>
        <img src="<%=request.getContextPath() %>/serverimg/${banner.imgname}" id="yushow" class="sh2"/>
    </div>
    <form action="<%=request.getContextPath() %>/banner/update2"  id="form_2" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${banner.id }">
    <input type="hidden" name="imgname" id="imgName" >
    <input type="text" id="file"  value="上传一个文件">
    <input type="file" class="jtt" name="img" style="background: #880000;">
    <div class="row">
        <div class="control-group">
            <label class="control-label">标题：</label>
            <input type="text"  name="title" class="control-text" value="${banner.title }">
        </div>
    </div>
    <div class="row">
        <div class="control-group span18">
            <label class="control-label">显示顺序：</label>
            <select class="sel3" name="order1" >
                <option>0</option>
                <option>1</option>
                <option>2</option>
            </select>
        </div>
    </div>
    <div class="row">
        <label class="radio">
            是否启用：
            <input type="radio" name="start1" value="1" checked>是
            <input type="radio" name="start1" value="0">否
        </label>
    </div>
    <div class="btn" >
        <input type="submit" value="提交">
    </div>
</form>
</div>
</body>
<script>
$(document).ready(function(){
	/*  $('#submit').eq(0).click(function(){
           $.ajax({
              url:'update',
              type:"POST",
              data:$('#form_2').serialize(),
              dataType:"json",
              success: function(data) {
                  if(data.message=="成功"){
                      $('#pos1').css({'display':'block'});
                      $('#pos2').addClass('dis-none');
                      window.location.href="bannerSelect";
                  }else{
                      $('#pos2').css({'display':'block'});
                      $('#pos1').addClass('dis-none');
                  }
              }
          });
  })  */

        let imgarr = ['jpeg', 'png', 'gif'];
        let size = 10 * 1024 * 1024;
        console.log($('.jt'))
        $('.jtt').get(0).onchange = function (e) {
            var that = this;
            console.dir(this)
            var read = new FileReader();
            read.readAsDataURL(this.files[0]);
            console.log($('.sh2').get(0).src)
            read.onload = function () {
                $('.sh2').get(0).src = this.result;
            }
            var formData = new FormData($("#form_2")[0]);
            $.ajax({
               url : '<%= request.getContextPath()%>/banner/add2',
               type : "POST",
               data : formData,
               dataType : "json",
               processData : false, //必须false才会避开jQuery对 formdata 的默认处理
               contentType : false, //必须false才会自动加上正确的Content-Type
               cache : false, //true的话会读缓存
               success : function(data) {
               	console.log(data);
             	$.each(data,function(i,obj){
             		$("#imgName").val((obj));
             		/* $("#form_2").append('<input type="text" name="imgName" value="'+$(obj)[0].saveFilename+'">'); */
             	})
               }
            });
            
        }
     })
     </script>
     </html>