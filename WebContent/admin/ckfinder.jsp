<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ckeditor" uri="http://ckeditor.com" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务器文件管理</title>
<link type="text/css" rel="stylesheet" href="js/ckfinder/skins/kama/app.css" />
<script type="text/javascript" src="js/ckfinder/ckfinder.js"></script>
</head>
<body>
<p style="padding-left: 30px; padding-right: 30px;">
		<script type="text/javascript">
			// This is a sample function which is called when a file is selected in CKFinder.
			function showFileInfo( fileUrl, data )
			{
				var msg = 'The selected URL is: <a href="' + fileUrl + '">' + fileUrl + '</a><br /><br />';
				// Display additional information available in the "data" object.
				// For example, the size of a file (in KB) is available in the data["fileSize"] variable.
				if ( fileUrl != data['fileUrl'] )
					msg += '<b>File url:</b> ' + data['fileUrl'] + '<br />';
				msg += '<b>File size:</b> ' + data['fileSize'] + 'KB<br />';
				msg += '<b>Last modifed:</b> ' + data['fileDate'];

				// this = CKFinderAPI object
				this.openMsgDialog( "Selected file", msg );
			}

			var finder = new CKFinder();
			// The path for the installation of CKFinder (default = "/ckfinder/").
			finder.basePath = 'js/ckfinder/';
			// This is a sample function which is called when a file is selected in CKFinder.
			finder.selectActionFunction = showFileInfo;
			finder.create();
		</script>
	</p>
</body>
</html>