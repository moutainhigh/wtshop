[#escape x as x?html]
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>${setting.siteName}</title>
<meta name="author" content="${setting.siteAuthor}" />
<meta name="copyright" content="${setting.siteCopyright}" />
</head>
<body>
	<p>尊敬移动商城的会员</p>
	<p>您在${setting.siteName}申请了重置密码服务，请点击以下链接并根据页面提示完成密码重置</p>
	<p>
		<a href="${setting.siteUrl}/wap/password/reset_email.jhtml?username=${username}&key=${safeKey.value}" target="_blank">${setting.siteUrl}/wap/password/reset_email.jhtml?username=${username}&key=${safeKey.value}</a>
	</p>
</body>
</html>
[/#escape]