<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>



<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1);
%>
<calendar:resources lang="en" theme="aqua"/>
<link rel="stylesheet" type="text/css" href="${createLinkTo(dir:'css',file:'calendar.css')}" />

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>New Registration</title>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'main.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'anylinkmenu.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'tabcontent.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'stylesheet.css')}" />
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'style.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'menucontents.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'anylinkmenu.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabcontent.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'gen_validatorv31.js')}"></script>
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'md5.js')}"></script>
<link rel="stylesheet" type="text/css"
	href="${createLinkTo(dir:'css',file:'design.css')}" />
<script type="text/javascript"
	src="${createLinkTo(dir:'js',file:'tabs.js')}"></script>



<script type="text/javascript" src="js/tabcontent.js"></script>
<script type="text/javascript">
anylinkmenu.init("menuanchorclass")
</script>

</head>

<body>
<table width="1003" border="0" align="center" cellpadding="0"
	cellspacing="0">
	<tr>
		<td align="left" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="91" align="left" valign="top" class="bgtop"><!-- code for spcbHeader  -->
				<g:include controller="userMaster" action="showSpcbHeader" /></td>
			</tr>
			<tr>
				<td height="32" align="left" valign="top"
					background="${createLinkTo(dir:'images2/gif',file:'button_BG.gif')}">
		<table width="100%" border="0" >
						 <tr height="10px" width="100%">
	<a href="home"><span id="span10" style="font: normal px verdana; color: white;align="left"><u><b>
HOME</u></b></span> </td>					 
						 
		
						 	<td></td>
						 	<td class="top-lnks" align="right">  </td>
						 </tr>
					 </table>
						
			</tr>
			<tr>
							<td align="left" valign="top">
				<table width="1003" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="224" align="left" valign="top" bgcolor="#DEEED0">
							 <g:include
							controller="userMaster" action="showIndexMenu" />
						</td>
						<td width="1" align="left" valign="top" bgcolor="#ADBFCB"></td>
						<td width="778" align="left" valign="top">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="1" valign="top"></td>
							</tr>
							<tr>
								<td><img
									src="${createLinkTo(dir:'images2',file:'img.jpg')}" width="778"
									height="134" /></td>
							</tr>
									<tr>
										<td height="0" align="left" valign="top">
										
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr><!-- Div area for errors-->
                      <td align="center" valign="top"><div style="width:400px;  vertical-align:middle"><span class="error">


										
                      </span></div></td>
                    </tr>
                    <!--<tr>        
                      <td align="center" valign="top">Row for Page Heading</td>
                    </tr>-->
                    <tr>
                      <td height="0" align="left" valign="top"><table width="778" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="82" align="left" valign="top">&nbsp;</td>
                            <td align="left" valign="top"><div style="padding:0px 0px 0px 0px;" >
	  
        
				 
    <br/>
     
         <div style="border":1px solid gray; width:720px; margin-bottom: 1em; padding: 10px" >
										
										<table width="778" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="82" align="left" valign="top">&nbsp;</td>
												<td align="left" valign="top">
												
												<div style="padding: 0px 0px 0px 0px;"><br />
												<div style="" :1px solidgray; width:720px; margin-bottom: 1em; padding: 10px" >
																	<table width="105%" border="0" align="center" cellpadding="0"
													cellspacing="1" bgcolor="#A5CAF4">

													<tr>
 	 <td valign="top" bgcolor="#FFFFFF">
 	 <table width="100%" border="0" align="left"
 	 cellpadding="2" cellspacing="1" class="tblbdr">
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" >Doctor's Name:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docName}</td>
  					</tr>
 
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" >Doctor's Age:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docAge}</td>
  					</tr>
 
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Doctor's Department:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docDept}</td>
  					</tr>
	
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Docotor's Sex:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docSex}</td>
  					</tr>						
  					
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Doctor's Timing:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docTime}</td>
  					</tr>
  					
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Doctor Email:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docEmail}</td>
  					</tr>
						
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Doctor's Qualification:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docQual}</td>
  					</tr>								
  					
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Doctor's Contact No.:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docNo}</td>
  					</tr>
			<tr class="headngblue txt4"  >
              <td width="40%" align="left" class="headngblue" bgcolor="#A8DAF3" > Doctor's Address.:</td>
           <td width="60%" align="left" class="headngblue1" bgcolor="#E8F6F9">${DoctorRegInstance.docAdd}</td>
  					</tr>

  								</td>
															</tr>
	
						 <tr height="10px" width="100%"><td bgcolor="#A8DAF3"></td><td bgcolor="#A8DAF3">
	<a href="/hospital/userMaster/doctorsearch.gsp"><span id="span10" style="font: normal px verdana; color: white;align="center"><u><b>
Search Another Doctor</u></b></span> </td>					 
						 
		
						 	
						 	<td class="top-lnks" align="right">  </td>
																															
															
														</table>
														
														</td>
													</tr>




												</table>









											</div>
												</td>
												<td width="132" align="left" valign="top">&nbsp;</td>
										</td>
									</tr>

								</table>
								</td>
							</tr>

						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			</table>
		</td>
	</tr>
</table>


	
  			 			
 	
 	




</body>
<HEAD>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<META HTTP-EQUIV="Expires" CONTENT="-1">
</HEAD>
</html>


