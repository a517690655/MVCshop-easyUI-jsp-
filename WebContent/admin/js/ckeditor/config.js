CKEDITOR.editorConfig = function( config )
{
 config.filebrowserBrowseUrl = 'js/ckfinder/ckfinder.html';  
 config.filebrowserImageBrowseUrl = 'js/ckfinder/ckfinder.html?type=Images';  
 config.filebrowserFlashBrowseUrl = 'js/ckfinder/ckfinder.html?type=Flash';  
 config.filebrowserUploadUrl = 'js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files'; 
 config.filebrowserImageUploadUrl = 'js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images'; 
 config.filebrowserFlashUploadUrl = 'js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash' ;
 config.filebrowserWindowHeight='50%';//CKFinder浏览窗口高度,默认值70%
 config.filebrowserWindowWidth='70%';//CKFinder浏览窗口宽度,默认值80%
 config.language = "zh-cn";
 config.image_previewText=' '; //预览区域显示内容
// config.skin = 'kama';//默认皮肤
 config.skin = 'v2';
 //config.skin = 'office2003';
 config.toolbar_A =
     [
            ['Source'],
            ['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
            ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
            '/',
            ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
            ['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
            ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
            ['Link','Unlink','Anchor'],
            ['Image','Table','HorizontalRule','Smiley','SpecialChar','PageBreak'],
            '/',
            ['Styles','Format','Font','FontSize'],
            ['TextColor','BGColor'],
            ['Maximize', 'ShowBlocks']
     ];

 config.toolbar_Basic =
 [
     ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About']
 ];
 
};