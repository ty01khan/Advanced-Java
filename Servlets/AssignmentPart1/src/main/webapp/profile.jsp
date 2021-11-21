<%@ page import="java.sql.*" import="java.io.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <style>
        .profile-image {
            max-width: 150px;
            margin: 0 auto;
        }

        body {
            font-family: 'Lato', sans-serif;
            background-color:  #d4f2f7 ;
        }

        .icon {
            max-width: 25px;
            max-height: 25px;
        }

        .back {
            float: left;
        }
        
        .vl {
            border-left: 8px solid green;
        }
    </style>
</head>

<body>
    <nav class="bg-dark navbar navbar-dark navbar-expand container-fluid">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">PatternFly</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">About</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact</a>
                    </li>
                </ul>
            </div>

            <form action="loginpage.html">
	            <button type="submit" class="btn btn-default btn-sm float-right" style="color: white;">
	                <span class="fa fa-sign-out fa"></span> <b>Logout</b>
	            </button>
            </form>
        </div>
    </nav>

    <div class="col-sm-7 col-md-6 col-lg-4 col-xl-3 container float-left intro my-2 border p-3 bg-white rounded">
        <div>
        	<%
        	Connection con = null;
        	String username="", imagename="";
        	try {
        		Class.forName("com.mysql.cj.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Servlet", "root", "");
            	PreparedStatement ps = con.prepareStatement("SELECT Username, ImageFileName FROM Users");
            	ResultSet rs = ps.executeQuery();
    			while(rs.next()) {
    				username = rs.getString(1);
    				imagename = rs.getString(2);
    				if(username.equals(request.getParameter("Username"))) {
    					break;
    				}
    			}
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        	
            String path = "/home/talha/BeeHyv/Advanced-Java/Servlets/AssignmentPart1/src/main/webapp/image/" + imagename; 
            File f = new File(path);
            if(f.exists()){%> <img src="<%out.println("image/"+imagename);%>" class="d-block mx-auto profile-image rounded-circle"><%}
            else {%> <img src="<%out.println("icon/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png");%>" class="d-block mx-auto profile-image rounded-circle"><%}
            %>
            <h2 class="text-center">
            	<%
            	String name = "", add = "", phone = "", email = "", lang = "", link = "";
            	PreparedStatement ps = con.prepareStatement("SELECT Username, Name, Address, Phone, EmailID, Language FROM Users");
            	ResultSet rs = ps.executeQuery();
    			
    			while(rs.next()) {   
    				username = rs.getString(1);
    				name = rs.getString(2);
    				add = rs.getString(3);
    				phone = rs.getString(4);
    				email = rs.getString(5);
    				link = "https://" + username + ".github.io/";
    				lang = rs.getString(6);
    				if(username.equals(request.getParameter("Username"))) {
    					out.println(name);
    					break;
    				}
    			}
            	 %>
            </h2>
            <p class="text-center">Programmer</p>
            <hr>
        </div>
        <div>
            <ul class="list-unstyled details">
                <!--<input type="button" id="edit" data-toggle="tooltip" data-placement="left" title="Edit details" class="float-right btn btn-primary btn-sm"><span class="far fa-edit"></span>-->
                <!-- <input type="submit" id="save" class="float-right btn btn-primary btn-sm" value="Save"/> -->
                <li><img src="icon/place_black_24dp.svg" class="mr-2" alt="location"><span><% out.println(add); %></span></li>
                <li><img src="icon/call_black_24dp.svg" class="mr-2" alt="phone number"><span><% out.println(phone); %></span></li>
                <li><img src="icon/mail_outline_black_24dp.svg" class="mr-2" alt="mail_icon"><a href="<% out.println(email); %>"><span id="result-email"><% out.println(email); %></span></a></li>
                <li><img src="icon/link_black_24dp.svg" class="mr-2" alt="alma-mater"><a href="<% out.println(link); %>"><span id="result-link"><% out.println(link); %></span></a></li>
                <li><img src="icon/translate_black_24dp.svg" class="mr-2" alt="language_icon"><span><% out.println(lang); %></span></li>
            </ul>
            <hr>
            <div class="d-flex jus justify-content-center mx-4">
                <a id="linkedin" target="blank" href="https://www.linkedin.com/in/<% out.println(username); %>/"><img src="icon/linkedin.png"
                        alt="linkedInIcon" class="icon"></a>
                &nbsp &nbsp
                <a class="mx-2" href="https://wa.me/qr/KBZIJUA6OPHZB1" target="blank"><img src="icon/whatsapp.webp" alt="whatsapp_icon"
                        class="icon"></a>
            </div>
        </div>
    </div>
    <div class="container col-sm-5 col-md-6 col-lg-8 col-xl-9 float-left border-left bg-white rounded my-2">
        <div class="my-3">
            <h2>BACKGROUND</h2>
        </div>
        <hr>
        <ul class="list-unstyled">
            <li>
                <img src="icon/social-mediaa.png" class="icon float-left ml-2 mt-1" alt="logo" />
                <div class="border-bottom mt-4 mb-2 d-flex ml-5">
                    <h4>ABOUT</h4>
                </div>
                <p class="ml-5">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Sint animi saepe suscipit at tenetur neque
                    ipsa accusantium nihil fugiat quaerat quis alias doloribus esse facilis quas obcaecati, ipsam
                    assumenda quibusdam provident laborum!</p>
            </li>
            <li>
                <img src="icon/exp.png" class="icon float-left ml-2 mt-1" alt="logo" />
                <div class="border-bottom my-2 d-flex ml-5">
                    <h4>WORK EXPERIENCE</h4>
                </div>
                <p class="ml-5"><b>Project 1</b>, Java, Angular <br>
                    Dec, 2013-Dec, 2014 <img src="" alt="">1 year <br>
                    Lorem ipsum, dolor sit amet consectetur adipisicing elit. Consectetur, optio corrupti impedit animi
                    minima ad unde eius delectus? Eum, dolore fugiat! <br>
                <ul class="ml-5">
                    <li>Random point 1</li>
                    <li>Random point 2</li>
                    <li>Random point 3</li>
                </ul>
                </p>
            </li>
            <li>
                <img src="icon/skills.png" class="icon float-left ml-2 mt-1" alt="logo" />
                <div class="border-bottom my-2 d-flex ml-5">
                    <h4>SKILLS</h4>
                </div>
                <div class="ml-5 mt-1 mb-4 vl">
                    <div class="ml-2"><b>Web Development</b></div>
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3 ml-2">HTML
                    </button>&nbsp
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">CSS
                    </button>&nbsp
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">Javascript
                    </button>
                </div>
                <div class="ml-5"><hr></div>
                <div class="ml-5 mt-1 mb-4 vl">
                    <div class="ml-2"><b>Compression</b></div>
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3 ml-2">Mpeg
                    </button>&nbsp
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">MP4
                    </button>&nbsp
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">GIF
                    </button>
                </div>
            </li>
            <li>
                <img src="icon/education.png" class="icon float-left ml-2 mt-1" alt="logo" />
                <div class="border-bottom my-2 d-flex ml-5">
                    <h4>EDUCATION</h4>
                </div>
                <p class="ml-5"><b>Bachelor of Technology, &nbsp </b>IIT Palakkad <br>
                    July 2017-April 2021 <br>
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">DB1101-BasicSQL
                    </button>&nbsp
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">CS2011-Java Introduction
                    </button>
                </p>
            </li>
            <li>
                <img src="icon/interest.png" class="icon float-left ml-2 mt-1" alt="logo" />
                <div class="border-bottom my-2 d-flex ml-5">
                    <h4>INTERESTS</h4>
                </div>
                <p class="ml-5"><b>Wildlife</b><br>
                    <button type="button" 
                        class="btn btn-primary btn-sm mt-3">Ferrets
                    </button>&nbsp
                    <button type="button"
                        class="btn btn-primary btn-sm mt-3">Unicorns
                    </button>
                </p>
            </li>
        </ul>
    </div>

</body>
</html>