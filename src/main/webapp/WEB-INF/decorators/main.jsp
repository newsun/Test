<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>

<html>
<head>
<title><decorator:title default="Symbio - SBTM" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
<decorator:head />
<script type="text/javascript">
	$(function() {
		$(".menu_nav li > a").each(function() {
			var pathname=location.pathname;
			var href=$(this).attr("href");
			if(pathname=="/"&&href.indexOf("/index.html")==0){
				$(this).parent().addClass("active");
				return;
			}
			if (pathname.indexOf("/project/") == 0 && href.indexOf("/project/") == 0) {
				$(this).parent().addClass("active");
				return;
			}
			if (pathname.indexOf(href) == 0) {
				$(this).parent().addClass("active");
				return;
			}

		});
	});
	
	
</script>
</head>

<body>
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1>
						<a href="/index.html"><span>Session-Based Test
								Management</span><small>A method for measuring and managing
								exploratory testing</small> </a>
					</h1>
				</div>
				<div class="search">
					<form method="get" id="search" action="">
						<span> <input type="text" value="Search..." name="s" id="s" />
							<input name="searchsubmit" type="image" src="/images/search.gif"
							value="Go" id="searchsubmit" class="btn" />
						</span>
					</form>
					<!--/searchform -->
				</div>
				<div class="clr"></div>
			</div>
			<div class="clr"></div>
			<div class="menu_header">
				<div class="menu_nav">
					<ul>
						<li><a href="/index.html">Home</a></li>
						<li><a href="/project/index.html">Project</a></li>
						<li><a href="/configure.html">Configuration</a></li>
						<li><a href="/support.html">Support</a></li>
						<li><a href="/about.html">About Us</a></li>
						<li><a href="/blog.html">Blog</a></li>
						<li><a href="/contact.html">Contact Us</a></li>
					</ul>
				</div>
			</div>
			<div class="clr"></div>
		</div>
		<div class="content">
			<div class="content_resize">
				<decorator:body />
			</div>
			<div class="clr"></div>
		</div>
		<div class="fbg">
			<div class="fbg_resize">
				<div class="col c1">
					<h2>
						<span>Image Gallery</span>
					</h2>
					<a href="#"><img src="/images/pic_1.jpg" width="58" height="58"
						alt="pix" /> </a> <a href="#"><img src="/images/pic_2.jpg"
						width="58" height="58" alt="pix" /> </a> <a href="#"><img
						src="/images/pic_3.jpg" width="58" height="58" alt="pix" /> </a> <a
						href="#"><img src="/images/pic_4.jpg" width="58" height="58"
						alt="pix" /> </a> <a href="#"><img src="/images/pic_5.jpg"
						width="58" height="58" alt="pix" /> </a> <a href="#"><img
						src="/images/pic_6.jpg" width="58" height="58" alt="pix" /> </a>
				</div>
				<div class="col c2">
					<h2>
						<span>Lorem Ipsum</span>
					</h2>
					<p>
						Lorem ipsum dolor<br /> Lorem ipsum dolor sit amet, consectetuer
						adipiscing elit. Donec libero. Suspendisse bibendum. Cras id urna.
						Morbi tincidunt, orci ac convallis aliquam, lectus turpis varius
						lorem, eu posuere nunc justo tempus leo. Donec mattis, purus nec
						placerat bibendum, dui pede condimentum odio, ac blandit ante orci
						ut diam.
					</p>
				</div>
				<div class="col c3">
					<h2>
						<span>About</span>
					</h2>
					<p>
						Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec
						libero. Suspendisse bibendum. Cras id urna. Morbi tincidunt, orci
						ac convallis aliquam, lectus turpis varius lorem, eu posuere nunc
						justo tempus leo. llorem, eu posuere nunc justo tempus leo. Donec
						mattis, purus nec placerat bibendum. <a href="#">Learn more...</a>
					</p>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<div class="footer">
			<div class="footer_resize">
				<p class="lf">
					© Copyright <a href="#">Symbio - Serious About Software</a>.
				</p>
				<p class="rf">
					<a href="http://www.symbio.com/" title="Symbio Quality Assurance">Symbio
						Quality Assurance</a>
				</p>
				<div class="clr"></div>
			</div>
		</div>
	</div>
</body>
</html>