<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>数据 - AdminLTE2定制版</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">

<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">

<link rel=“stylesheet”
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->

		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
				<h1>
					订单管理
					<small>订单表单</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="all-order-manage-list.html">订单管理</a></li>
					<li class="active">订单表单</li>
				</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<form id="form" method="post" action="${pageContext.request.contextPath}/orders/saveOrders">
			<section class="content"> <!--订单信息-->

				<div class="panel panel-default">
					<div class="panel-heading">订单信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">订单编号</div>
						<div class="col-md-4 data">
							<input type="text" class="form-control" placeholder="订单编号"
								   name="orderNum" >
						</div>

						<div class="col-md-2 title">下单时间</div>
						<div class="col-md-4 data">
							<div class="input-group date">
								<div class="input-group-addon">
									<i class="fa fa-calendar"></i>
								</div>
								<input type="text" class="form-control pull-right"
									   id="datepicker-a3"
									   name="orderTime">
							</div>
						</div>
						<div class="col-md-2 title">路线名称</div>
						<div class="col-md-4 data">
							<select id="productName" class="form-control select2" style="width: 100%;" name="product.id">
								<c:forEach items="${products}" var="product" >
									<option value="${product.id}" selected="selected">${product.productName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-2 title">出游人数</div>
						<div class="col-md-4 data">
							<input id="peoplenum" type="text" class="form-control"
								   name="peopleCount">
						</div>

						<div class="col-md-2 title rowHeight2x">其他信息</div>
						<div class="col-md-10 data rowHeight2x">
						<textarea class="form-control" name="orderDesc" rows="3" placeholder="其他信息">

						</textarea>
						</div>

					</div>
				</div>
				<!--订单信息/--> <!--游客信息-->
				<div class="panel panel-default">
					<div class="panel-heading">游客信息</div>
					<!--数据列表-->
					<table id="dataList"
						   class="table table-bordered table-striped table-hover dataTable">
						<thead>
						<tr>
							<th class="">人群</th>
							<th class="">姓名</th>
							<th class="">性别</th>
							<th class="">手机号码</th>
							<th class="">证件类型</th>
							<th class="">证件号码</th>
						</tr>
						</thead>
						<tbody id="tbody">
						<%--<c:forEach begin="0" end="${pageScope.num}" var="i">

							<tr>
								<td>
									<select class="form-control" style="height:28px" name="travellers[${i}].travellerType">
										<option value="1" selected>儿童</option>
										<option value="0">成人</option>
									</select>
								</td>
								<td>
									<input type="text" size="10" name="travellers[${i}].name">
								</td>
								<td>
									<select class="form-control" style="height:28px" name="travellers[${i}].sex">
									<option value="男" selected>男</option>
									<option value="女">女</option>
									</select>
								</td>

								<td><input type="text" size="20"
										   name="travellers[${i}].phoneNum" >
								</td>
								<td><select class="form-control" style="height:28px" name="travellers[${i}].credentialsType}">
									<option value="0" selected>身份证</option>
									<option value="1">护照</option>
									<option value="2">军官证</option>
								</select>
								</td>
								<td>
									<input type="text" size="28" name="travellers[${i}].credentialsNum" >
							    </td>
							</tr>
						</c:forEach>

--%>
						</tbody>
					</table>
					<!--数据列表/-->
				</div>
				<!--游客信息/--> <!--联系人信息-->
				<div class="panel panel-default">
					<div class="panel-heading">联系人信息</div>
					<div class="row data-type">

						<div class="col-md-2 title">会员</div>
						<div class="col-md-4 data text">
							<input  type="text" class="form-control"
								   name="Member.nickname" value="">
						</div>

						<div class="col-md-2 title">联系人</div>
						<div class="col-md-4 data text">
							<input  type="text" class="form-control"
								   name="Member.name" value="">
						</div>

						<div class="col-md-2 title">手机号</div>
						<div class="col-md-4 data text">
							<input  type="text" class="form-control"
									name="Member.phoneNum" value="">
						</div>

						<div class="col-md-2 title">邮箱</div>
						<div class="col-md-4 data text">
							<input  type="text" class="form-control"
									name="Member.email" value="">
						</div>

					</div>
				</div>
				<!--联系人信息/--> <!--费用信息-->
					<div class="panel panel-default">
						<div class="panel-heading">费用信息</div>
						<div class="row data-type">

							<div class="col-md-2 title">订单状态</div>
							<div class="col-md-4 data text">
								<select class="form-control" style="height:28px" name="orderStatus">
									<option value="0" selected>未支付</option>
									<option value="1">已支付</option>
								</select>
								</div>
							<div class="col-md-2 title">支付方式</div>
							<div class="col-md-4 data text">
								<select class="form-control" style="height:28px" name="payType">
									<option value="0" selected>支付宝</option>
									<option value="1">微信</option>
									<option value="2">其他</option>
								</select>
							</div>
						</div>
					</div>
				<!--费用信息/--> <!--工具栏-->
				<div class="box-tools text-center">
					<button type="submit" class="btn bg-maroon">保存</button>
					<button type="button" class="btn bg-default"
							onclick="history.back(-1);">返回</button>
				</div>
				<!--工具栏/-->
			</section>
			</form>
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 1.0.8
		</div>
		<strong>Copyright &copy; 2014-2017 <a
			href="http://www.itcast.cn">研究院研发部</a>.
		</strong> All rights reserved. </footer>
		<!-- 底部导航 /-->
		</div>
	</div>



	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>

	<script>
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});

        })




        $("#peoplenum").blur(function () {
                var num = $("#peoplenum").val();

            $.ajax({
                url:"${pageContext.request.contextPath}/orders/peoplenum",
                contentType:"application/json;charset=utf-8",
                data:JSON.stringify({"peopleCount":num}),
                dataType:"json",
                type:"post",
                success:function (order) {
                    var str='';
                    for(var i=0;i<order.peopleCount-1;i++){
                        var str1='<tr>\n' +
                            '                    <td>\n' +
                            '                    <select class="form-control" style="height:28px" name="travellers['+i+'].travellerType">\n' +
                            '                        <option value="1" selected>儿童</option>\n' +
                            '                    <option value="0">成人</option>\n' +
                            '                        </select>\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                        <input type="text" size="10" name="travellers['+i+'].name">\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                        <select class="form-control" style="height:28px" name="travellers['+i+'].sex">\n' +
                            '                        <option value="男" selected>男</option>\n' +
                            '                    <option value="女">女</option>\n' +
                            '                        </select>\n' +
                            '                        </td>\n' +
                            '\n' +
                            '                        <td><input type="text" size="20"\n' +
                            '                    name="travellers['+i+'].phoneNum" >\n' +
                            '                        </td>\n' +
                            '                        <td><select class="form-control" style="height:28px" name="travellers['+i+'].credentialsType">\n' +
                            '                        <option value="0" selected>身份证</option>\n' +
                            '                       <option value="1">护照</option>\n' +
                            '                        <option value="2">军官证</option>\n' +
                            '                        </select>\n' +
                            '                        </td>\n' +
                            '                        <td>\n' +
                            '                        <input type="text" size="28" name="travellers['+i+'].credentialsNum" >\n' +
                            '                        </td>\n' +
                            '                        </tr>'
                        str+=str1
                    }


                    $("#tbody").html(str);
                }
            })
        })




        $(document).ready(function() {
            $('#datepicker-a3').datetimepicker({
                format : "yyyy-mm-dd hh:ii",
                autoclose : true,
                todayBtn : true,
                language : "zh-CN"
            });
        });

        $(document).ready(function() {
            $('#datepicker-a6').datetimepicker({
                format : "yyyy-mm-dd hh:ii",
                autoclose : true,
                todayBtn : true,
                language : "zh-CN"
            });
        });

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {

			// 激活导航位置
			setSidebarActive("orders");

			// 列表按钮 
			$("#dataList td input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				increaseArea : '20%'
			});
			// 全选操作 
			$("#selall").click(function() {
				var clicks = $(this).is(':checked');
				if (!clicks) {
					$("#dataList td input[type='checkbox']").iCheck("uncheck");
				} else {
					$("#dataList td input[type='checkbox']").iCheck("check");
				}
				$(this).data("clicks", !clicks);
			});
		});
	</script>
</body>


</html>