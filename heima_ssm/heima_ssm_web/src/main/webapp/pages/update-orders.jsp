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
		<form id="form" method="post" action="${pageContext.request.contextPath}/orders/updateOrders">
		<section class="content-header">
			<h1>
				订单管理 <small>全部订单</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="all-admin-index.html"><i
						class="fa fa-dashboard"></i> 首页</a></li>
				<li><a href="all-order-manage-list.html">订单管理</a></li>
				<li class="active">订单详情</li>
			</ol>
		</section>
		<!-- 内容头部 /-->

		<!-- 正文区域 -->
		<section class="content"> <!--订单信息-->

			<div class="panel panel-default">
				<div class="panel-heading">订单信息</div>
				<div class="row data-type">

					<div class="col-md-2 title">订单编号</div>
					<div class="col-md-4 data">
						<input type="text" class="form-control" placeholder="订单编号"
							   value="${orders.orderNum }" readonly="readonly" name="orderNum">
					</div>

					<div class="col-md-2 title">下单时间</div>
					<div class="col-md-4 data">
						<div class="input-group date">
							<div class="input-group-addon">
								<i class="fa fa-calendar"></i>
							</div>
							<input type="text" class="form-control pull-right"
								   id="datepicker-a3"
								   value="${orders.orderTimeStr}" name="orderTime">
						</div>
					</div>
					<div class="col-md-2 title">路线名称</div>
					<div class="col-md-4 data">
						<select id="productName" class="form-control select2" style="width: 100%;" name="product.id">
							<c:forEach items="${products}" var="product" >
								<c:if test="${product.productName==orders.product.productName}">
									<option value="${product.id}" selected="selected">${product.productName}</option>
								</c:if>
								<c:if test="${product.productName!=orders.product.productName}">
									<option value="${product.id}">${product.productName}</option>
								</c:if>

							</c:forEach>
						</select>
					</div>


					<div class="col-md-2 title">出游人数</div>
					<div class="col-md-4 data">
						<input type="text" class="form-control" placeholder="出游人数"
							   value="${orders.peopleCount}" name="peopleCount">
					</div>

					<div class="col-md-2 title rowHeight2x">其他信息</div>
					<div class="col-md-10 data rowHeight2x">
						<textarea class="form-control" rows="3" placeholder="其他信息" name="orderDesc">
							${orders.orderDesc }
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
					<tbody>
					<c:forEach var="traveller" items="${orders.travellers}" varStatus="var">

						<tr>
							<td><select class="form-control" style="height:28px" name="travellers[${var.index}].travellerType">
								<c:if test="${traveller.travellerType==1}">
									<option value="1" selected>儿童</option>
									<option value="0">成人</option>
								</c:if>
								<c:if test="${traveller.travellerType==0}">
									<option value="1" >儿童</option>
									<option value="0" selected>成人</option>
								</c:if>

							</select>
							</td>
							<td><input type="text" size="10" value="${traveller.name }"
									   name="travellers[${var.index}].name">
							</td>
							<td>
								<select class="form-control" style="height:28px" name="travellers[${var.index}].sex">
									<c:if test="${traveller.sex=='男'}">
									<option value="男" selected>男</option>
									<option value="女">女</option>
									</c:if>
									<c:if test="${traveller.sex=='女'}">
										<option value="男" >男</option>
										<option value="女" selected>女</option>
									</c:if>
								</select>
							</td>
							<td><input type="text" size="20"
									   value="${traveller.phoneNum }" name="travellers[${var.index}].phoneNum">
							</td>
							<td><select class="form-control" style="height:28px" name="travellers[${var.index}].credentialsType">
								<c:if test="${traveller.credentialsType==0}">
								<option value="0" selected>身份证</option>
								<option value="1">护照</option>
								<option value="2">军官证</option>
								</c:if>
								<c:if test="${traveller.credentialsType==1}">
									<option value="0" >身份证</option>
									<option value="1" selected>护照</option>
									<option value="2">军官证</option>
								</c:if>
								<c:if test="${traveller.credentialsType==2}">
									<option value="0" >身份证</option>
									<option value="1">护照</option>
									<option value="2" selected>军官证</option>
								</c:if>
							</select>
							</td>
							<td><input type="text" size="28"
									   value="${traveller.credentialsNum }" name="travellers[${var.index}].credentialsNum" ></td>
						</tr>
					</c:forEach>


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
								name="member.nickname" value="${orders.member.nickname}">
					</div>

					<div class="col-md-2 title">联系人</div>
					<div class="col-md-4 data text">
						<input  type="text" class="form-control"
								name="member.name" value="${orders.member.name}">
					</div>

					<div class="col-md-2 title">手机号</div>
					<div class="col-md-4 data text">
						<input  type="text" class="form-control"
								name="member.phoneNum" value="${orders.member.phoneNum}">
					</div>

					<div class="col-md-2 title">邮箱</div>
					<div class="col-md-4 data text">
						<input  type="text" class="form-control"
								name="member.email" value="${orders.member.email}">
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
							<c:if test="${orders.orderStatus==0}">
							<option value="0" selected>未支付</option>
							<option value="1">已支付</option>
							</c:if>
							<c:if test="${orders.orderStatus==1}">
								<option value="0" >未支付</option>
								<option value="1" selected>已支付</option>
							</c:if>
						</select>
					</div>
					<div class="col-md-2 title">支付方式</div>
					<div class="col-md-4 data text">
						<select class="form-control" style="height:28px" name="payType">
							<c:if test="${orders.payType==0}">
							<option value="0" selected>支付宝</option>
							<option value="1">微信</option>
							<option value="2">其他</option>
							</c:if>
							<c:if test="${orders.payType==1}">
								<option value="0" >支付宝</option>
								<option value="1" selected>微信</option>
								<option value="2">其他</option>
							</c:if>
							<c:if test="${orders.payType==2}">
								<option value="0" >支付宝</option>
								<option value="1">微信</option>
								<option value="2" selected>其他</option>
							</c:if>
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
		<!-- 正文区域 /-->


	</div>
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
        $('#datepicker-a3').datetimepicker({
            format : "yyyy-mm-dd hh:ii",
            autoclose : true,
            todayBtn : true,
            language : "zh-CN"
        });
    });

    $(document).ready(function() {
        // 激活导航位置
        setSidebarActive("product");
        $("#datepicker-a3").datetimepicker({
            format : "yyyy-mm-dd hh:ii",

        });

    });

    $(function () {
        //当表单提交时,调用所有的校准方法
        $("#registerForm").submit(function () {
            //1.发送数据到服务器
            return checkTime()&&checkPrice();
        });

        $("#datepicker-a3").blur(checkTime);
        $("#price").blur(checkPrice);

    });



    function checkTime() {
        //1.获取用户名的值
        var time=$("#datepicker-a3").val();
        var flag=false;
        if (time) {
            $("#datepicker-a3").css("border","");
            flag= true;
        } else {
            $("#datepicker-a3").css("border","1px solid red");
        }
        return flag;
    }

    function checkPrice() {
        //1.获取用户名的值
        var time=$("#price").val();
        var flag=false;
        if (time) {
            $("#price").css("border","");
            flag= true;
        } else {
            $("#price").css("border","1px solid red");
        }
        return flag;
    }


</script>
</body>


</html>