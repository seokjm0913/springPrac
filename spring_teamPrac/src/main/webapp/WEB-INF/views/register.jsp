<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Faq글 등록</title>
</head>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script src="//cdn.ckeditor.com/4.16.2/full/ckeditor.js"></script>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>

<body>


<form action="/register" method="post">
    <div class="content" style="width: 70%">
    
        <div class="row justify-content-md-center">
            <div class="col-sm-9">
            	<div class="input-group mb-3">                
                    <label class="input-group-text">제목</label>                    
                  	<input type="text" name="faq_title" class="form-control" size="100%">              
                </div>
            </div>           
      </div>
      <br>
      
      <div class="row justify-content-md-center">
          <div class="col_c" style="margin-bottom: 30px">
                <div class="input-group">                 
                  <textarea class="form-control" id="faq_content" name="faq_content" rows = "6" cols = "80"></textarea>
                  <script type="text/javascript">
                  CKEDITOR.editorConfig = function( config ) {
              	    config.enterMode = CKEDITOR.ENTER_BR

              		};
                                    
                  CKEDITOR.replace('faq_content',{width:'50%', height:'30rem'});
                       
                  </script>
                </div>
            </div> 
      </div>
      

      
      <div class="row justify-content-md-center">
        <button type="submit" class="btn btn-outline-secondary" style="width: 20%; font-weight: bold">
             등   록          
        </button>
      </div>
  </div>
</form>  
  



</body>
</html>
