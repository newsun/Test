<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>
<
<decorator:usePage id="main"></decorator:usePage>
<html>
<head>
<link href="../style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/cookie.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/navigator.js"></script>
<script type="text/javascript" src="js/images.js"></script>
<script type="text/javascript" src="js/jquery.scrollLoading.js"></script>
<script type="text/javascript">
	document.onreadystatechange = function() {
		if (document.readyState == "complete") {
			onload();
		}
	}
</script>
</head>
<body>

	<content tag="menu_nav">
	<div class="menu_nav">
		<ul>
			<li><a href="../index.html">Home</a></li>
			<li class="active"><a href="#">Project</a></li>
			<li><a href="../configure.html">Configuration</a></li>
			<li><a href="../support.html">Support</a></li>
			<li><a href="../about.html">About Us</a></li>
			<li><a href="../blog.html">Blog</a></li>
			<li><a href="../contact.html">Contact Us</a></li>
		</ul>
	</div>
	</content>
	<div class="mainbar">
		<div class="article">
			<h2>Projects status</h2>
			<div class="clr"></div>
			<p>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. <strong>Suspendisse
					nulla ligula, blandit ultricies aliquet ac, lobortis in massa. Nunc
					dolor sem, tincidunt vitae viverra in, egestas sed lacus.</strong> Etiam in
				ullamcorper felis. Nulla cursus feugiat leo, ut dictum metus semper
				a. Vivamus euismod, arcu gravida sollicitudin vestibulum, quam sem
				tempus quam, quis ullamcorper erat nunc in massa. Donec aliquet ante
				non diam sollicitudin quis auctor velit sodales. Morbi neque est,
				posuere at fringilla non, mollis nec nibh. Sed commodo tortor nec
				sem tincidunt mattis. Nam convallis aliquam nibh eu luctus. Nunc vel
				tincidunt lacus. Suspendisse sit amet pulvinar ante.
			</p>
			<p>Phasellus diam justo, laoreet vel vulputate eu, congue vel
				est. Maecenas eros libero, sollicitudin a vulputate fermentum,
				ultrices vel lacus. Nam in metus non augue fermentum consequat
				ultrices ac enim. Integer aliquam urna non diam aliquam eget
				hendrerit sem molestie.</p>
			<p>
				<strong>Lorem ipsum dolor sit amet</strong>
			</p>
			<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
				Vestibulum eget bibendum tellus. Nunc vel imperdiet tellus. Mauris
				ornare aliquam urna, accumsan bibendum eros auctor ac.</p>
			<ul class="sb_menu">
				<li><a href="#"><strong>Project A</strong> </a></li>
				<li><a href="#"><strong>Project B</strong> </a></li>
				<li><a href="#"><strong>Project C</strong> </a></li>
				<li><a href="#"><strong>Project D</strong> </a></li>
			</ul>
		</div>
	</div>
</body>
</html>