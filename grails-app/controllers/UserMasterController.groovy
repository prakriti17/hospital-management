import org.springframework.stereotype.Controllerimport sun.misc.Requestimport java.lang.Systemimport javax.servlet.http.Cookieimport org.postgresql.util.MD5Digestimport javax.servlet.http.HttpServletRequestimport javax.servlet.http.HttpServletResponseimport org.postgresql.core.Encodingimport java.lang.Mathimport java.io.*;import java.text.DateFormat;import java.text.SimpleDateFormat;import java.text.ParseException;import java.util.Date;import DateCustom;import java.util.ArrayList;import java.util.HashSet;import java.util.List;import java.util.Set;import java.util.Random;import java.security.MessageDigest;class UserMasterController {    			   String GenerateRandomCode()	    {		   Random rand=new Random();	        String s ="";	        for (int i = 0; i < 6; i++)	         s=s+rand.nextInt(10).toString();	          	        return s;	    }	   def addUser={			 				if(session.newReg)				{	println"gfgtegg"					def userList = NewReg.list( sort:"id", order:"asc")				  				   render(view:'addUser', model:[userList:userList])			   }				   else				   {						flash.message="unauthorized access"														redirect(uri:"/index.gsp")					}	   }	   def saveUser={			   def app=params.id			   println"dw"+app			   def ins=NewReg.findById(app)			   def userIns=new UserLogin()			   userIns.userName=ins.userName			   userIns.password=ins.password			   userIns.empId=ins.empId			   userIns.securityQues=ins.securityQues			   userIns.securityAns=ins.securityAns			   if(userIns.save())			   {				   println"saved"				   flash.message="user successfully added."				   ins.delete()				   redirect(action:addUser)			       			   }			   			   	   }	   def addAdmin={			 				if(session.newReg)				{	println"gfgtegg"					def userList = AdminReg.list( sort:"id", order:"asc")				  				   render(view:'addAdmin', model:[userList:userList])			   }				   else				   {						flash.message="unauthorized access"														redirect(uri:"/index.gsp")					}	   }	   def saveAdmin={			   def app=params.id			   println"dw"+app			   def ins=AdminReg.findById(app)			   def userIns=new AdminLogin()			   userIns.userName=ins.userName			   userIns.password=ins.password			   userIns.empId=ins.empId			   userIns.securityQues=ins.securityQues			   userIns.securityAns=ins.securityAns			   if(userIns.save())			   {				   println"saved"				   flash.message="Admin successfully added."				   ins.delete()				   redirect(action:addAdmin)			       			   }			   			   	   }	   def savep={			   if(session.newReg)			   {   println"helfcbb"			   def ConsultingPatInstance = new ConsultingPat(params)			   if(ConsultingPatInstance.save()) {				   println"consulbdnd"+ConsultingPatInstance.id				   redirect(action:show,id:ConsultingPatInstance.id)       }	   else {           flash.message = "Consulting Patient not created"		   				render(view:'consultingpat')      	   }			   }			   else			   {					flash.message="unauthorized access"												redirect(uri:"/index.gsp")				}			   }	   	   def show ={if(session.newReg){			   def ConsultingPatInstance = ConsultingPat.get( params.id )		        if(!ConsultingPatInstance) {		            flash.message = "Consulting Patient not found"		            	render(view:'consultingpat')								        }		        else {   flash.message = "Consulting Patient ${ConsultingPatInstance.id} created"		              		        	render(view:'showcon' , model:[ ConsultingPatInstance : ConsultingPatInstance] ) }	   }	   else	   {			flash.message="unauthorized access"								redirect(uri:"/index.gsp")		}	  }	   def savedoc={if(session.newReg){			   println"helfcbb"+params					   def DoctorRegInstance = new DoctorReg(params)			   if(DoctorRegInstance.save()) {		println"consulbdnd"+DoctorRegInstance.id				   flash.message = "Doctor with ${DoctorRegInstance.id} registered"		           redirect(action:showdoc,id:DoctorRegInstance.id)		       }			   else {           flash.message = "Doctor not registered"				   render(view:'doctorreg')		      			   }	   }	   else	   {			flash.message="unauthorized access"								redirect(uri:"/index.gsp")		}		   	   }	   def showdoc={if(session.newReg){			   def DoctorRegInstance = DoctorReg.get( params.id )		        if(!DoctorRegInstance) {		            flash.message = "Doctor not found "		            	render(view:'doctorreg')								        }		        else {  render(view:'showreg' , model:[ DoctorRegInstance : DoctorRegInstance] ) }	   }	   else	   {			flash.message="unauthorized access"								redirect(uri:"/index.gsp")		}		    	   			   	   }	   	   def editPat={			   render(view:'search')			   	   }	   def edit1={			   def par=params.id			   def pat=PatReg.findById(par)			   println"dbgh"+par			   pat.patName=params.patName			   pat.patMob=params.patMob			   pat.patAdd=params.patAdd			   pat.patRoom=params.patRoom			   pat.patRoomT=params.patRoomT			   pat.patDoc=params.patDoc			   pat.patDate=params.patDate			   pat.patAge=params.patAge			   pat.patSex=params.patSex			   pat.save()			   render(view:'disppat' , model:[ PatRegInstance : pat] )	   }	   def edit={			   def x=params.patName			   def pat=PatReg.findById(params.patName)			   if(pat){		    	   			       			       render(view:'editPat' , model:[ PatRegInstance : pat] )			       }			       else			       {			    	   flash.message="patient does not exist"						render(view:'search')			       			       }	   	   }		def doLogin={				println "df"+params.radioButton				def uType=params.radioButton				println "parmas.userId"+params.userId				println "parmas.pass"+params.password				println"cap"+params.capCode1				def userName=params.userId			def user				println "usern"+userName		if(uType=='user'){			user = UserLogin.findByUserNameAndPassword(params.userId,params.password)					if(user && params.capCode1==params.captchaCode)				{					println "created"+user					session.newReg = user					println "id"+user.empId								render(view:'emppage',model:[userName:userName])				}				else if(user && params.capCode!=params.captchaCode)				{					println "not created"+user					flash.message="enter Code correctly"											redirect(uri:"/index.gsp")				}				else				{					println "not created"+user					flash.message="enter username and password correctly"											redirect(uri:"/index.gsp")				}				}				else if(uType=='admin')				{					user = AdminLogin.findByUserNameAndPassword(params.userId,params.password)						if(user && params.capCode1==params.captchaCode)					{						println "created"+user						session.newReg = user						println "id"+user.empId										render(view:'adminpage',model:[userName:userName])					}							else if(user && params.capCode!=params.captchaCode)					{						println "not created"+user						flash.message="enter Code correctly"													redirect(uri:"/index.gsp")					}					else					{						println "not created"+user						flash.message="enter username and password correctly"													redirect(uri:"/index.gsp")					}									}		}	   def billcreate={			   if(session.newReg){			  println("111111111billcreate"+params.id)			  def app = PatReg.get((params.id).toInteger())		      println("22222222222222222"+app)		      def billList = Bill.findAllByPat(app)		      render(view:'billcal', model:[app:app,billList:billList])	   }	   else	   {			flash.message="unauthorized access"								redirect(uri:"/index.gsp")		} 	   }	   def addToBill = {		      	if(session.newReg)		      	{			   println"addtobill"+params.testN		  		def app = PatReg.get((params.appId))		  		println("333333++"+app)		  	def billInstance = new Bill(params)		  	def par = Fee.get(params.testN)		  	   println("444444djeije"+par.testName+par.testFee)		  		flash.message = "Bill Details regarding ${par.toString()} test is saved"		  			billInstance.pat = app		  			billInstance.fee = par		  			println"billIns"+billInstance.pat		  			println"billIns"+billInstance.fee		  			billInstance.total=0		  			if(billInstance.save())		  			{ println"ho gya siiiiiiiiii"		      	redirect(action:billcreate,id:app.id)		  			}		 	   }		 	   else		 	   {		 			flash.message="unauthorized access"		 						 				redirect(uri:"/index.gsp")		 		}		      	}		 	def billTotal={				if(session.newReg)				{			   println("bt111111111billcreate"+params.appId)				  def app = PatReg.get((params.appId).toInteger())			      println("bt22222222222222222"+app)			      def billList = Bill.findAllByPat(app)			      def total=0			      def i=0			      for(i=0;i<billList.size();i++)			      {			    	  total=total+(billList[i].fee.testFee)			      }				  println"total"+total				//  totalBillIns =new TBill()				  				   render(view:'final', model:[app:app,billList:billList,total:total])				   }				   else				   {						flash.message="unauthorized access"														redirect(uri:"/index.gsp")					}				}	   def docSearch={			   if(session.newReg){	   println("huhdhrje"+params)	   def doc=DoctorReg.findByDocName(params.docName)       println "fojfj"+doc              render(view:'showreg1' , model:[ DoctorRegInstance : doc] )			   }			   else			   {					flash.message="unauthorized access"												redirect(uri:"/index.gsp")				}			   }	   		def logout={			   				println "dfg"+session.newReg			   session.newReg=null				flash.message="you have successfully logged out."			   redirect(uri:"/index.gsp")		}	   def home={					   if(session.newReg)	   			   { def a=session.newReg				   println a.id+"hjdh"				   if(AdminLogin.findById(a.id))			   render(view:'adminpage')				else					render(view:'emppage')			   }				   else			   {					flash.message="unauthorized access"												redirect(uri:"/index.gsp")				}	   }	   	   def savepat={			   if(session.newReg){			   println"helfcbb"+params			   def i			   def PatRegInstance = new PatReg(params)			   def ocpRoomInst=new OcpRoom()			   def flag=0				def roomList = OcpRoom.list( sort:"roomNo", order:"asc")				for(i=0;i<roomList.size();i++)				{if(roomList[i].roomNo==params.patRoom)				{					println"room already occupied"					flag=1				}				}			   if(flag==0) {				   println"flag 0"				   if(PatRegInstance.save())				   { 					   println"ins save"					   ocpRoomInst.roomNo=params.patRoom					 if(  ocpRoomInst.save())						 println"buffalo"				   println"consulbdnd"+PatRegInstance.id		   flash.message = " Patient Admitted with ${PatRegInstance.id} "          redirect(action:showpat,id:PatRegInstance.id)       }else{           flash.message = "Patient not Admitted"		   render(view:'admissionpat')      	   }						   }	   else {           flash.message = "Room already occupied"		   render(view:'admissionpat')      	        }			   }			   else			   {					flash.message="unauthorized access"												redirect(uri:"/index.gsp")				}			   }			   def showpat ={if(session.newReg){			   def PatRegInstance = PatReg.get( params.id )				        if(!PatRegInstance) {				            flash.message = "Patient not found"				            	render(view:'admissionpat')												        }				        else {  flash.message = " Patient Admitted with ${PatRegInstance.id} "				            	render(view:'showpat' , model:[ PatRegInstance : PatRegInstance] ) }}else{		flash.message="unauthorized access"						redirect(uri:"/index.gsp")	}  	   }	   			   def searchpat={			   if(session.newReg){			   println("huhdhrje"+params)			   def pat=PatReg.findByPatName(params.patName)		       println "fojfj"+pat		       if(pat){		    	   		       		       render(view:'showpat1' , model:[ PatRegInstance : pat] )		       }		       else		       {		    	   flash.message="patient does not exist"					redirect(uri:"/userMaster/patientsearch.gsp")		       		       }			   }			   else			   {					flash.message="unauthorized access"												redirect(uri:"/index.gsp")				}	   }	   def discharge={if(session.newReg){				   def pat=PatReg.findById(params.patName)		       println "fojfj"+pat		       if(pat)		       {println"ccccccccc"		       render(view:'showpatient' , model:[ PatRegInstance : pat] )		       }		       else		       { flash.message="Patient does not exist.Please try again."				   render(view:'discharge')		       }      }else{		flash.message="unauthorized access"						redirect(uri:"/index.gsp")	}}	   		def dis={if(session.newReg){			   println"paar"+params.patN			   def pat=PatReg.findById(params.patN)			   def patDisInstance= new PatDis()			   def inst=OcpRoom.findByRoomNo(pat.patRoom)			   if(pat) {            try {println"ancn"            	patDisInstance.patName=pat.patName  			  patDisInstance.patAdd=pat.patAdd  			  patDisInstance.patMob=pat.patMob  			  patDisInstance.patAge=pat.patAge  			  patDisInstance.patDate=pat.patDate  			  patDisInstance.patDoc=pat.patDoc  			  patDisInstance.patSex=pat.patSex  			  patDisInstance.patRoom=pat.patRoom  			  patDisInstance.patRoomT=pat.patRoomT  			  println"jkld"+patDisInstance.patName  			  patDisInstance.save()  			  inst.delete()            	pat.delete()                flash.message="${patDisInstance.patName} has been discharged."                render(view:'discharge1' , model:[ PatRegInstance : patDisInstance] )     			    }            catch(org.springframework.dao.DataIntegrityViolationException e) {            render(view:'showpatient' , model:[ PatRegInstance : pat] )        		    }		   }			   else			   {				   flash.message="Please try again"				   render(view:'discharge')			       			   }}else{		flash.message="unauthorized access"						redirect(uri:"/index.gsp")	}	 }			   	   	  def userLogin = {			   println "hello"			//def tunt=Math.randomNumberGenerator			Random rand=new Random();			def tunt=rand.nextInt(100)+99;			def capCode=GenerateRandomCode()						println tunt			render(view:'userLogin',model:[tunt1:tunt,capCode1:capCode])				}		    def showSpcbHeader = {                                                                                                                                                                                                    	render(view:'spcbHeader')    }    def showSpcbFooter = {    	render(view:'spcbFooter')    }    def showAdminMenuHorizontal = {    	render(view:'menuAdminHorizontal')    }    def showSpcbUserMenuHorizontal = {    	render(view:'menuSpcbUserHorizontal')    }    def showIndustryMenuHorizontal = {    	render(view:'menuIndustryHorizontal')    }    def showAdminMenu = {    	render(view:'menuAdmin')        }		 def openIndustryHome = {		    		redirect(uri:"/index.gsp")		 }    def showSpcbUserMenu = {    	render(view:'menuSpcbUser')        }     def showSpcbIndustryMenu = {        render(view:'menuSpcbIndustry')    }    def showIndexMenu = {        render(view:'menuIndex')    }    def showMenu={    	 render(view:'horizontalMenuChattisgarh')    }        def showIndexMenuHorizontal = {    	render(view:'menuIndexHorizontal')    }    def newRegIndustryMenu =     	    {    	 redirect(uri:"/index.gsp")    }        }