<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib prefix="decorator"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page"%>

<page:applyDecorator name="main">
	<html>
<head>
<title><decorator:title default="Symbio - SBTM" />
</title>
<link href="/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/js/cookie.js"></script>
<script type="text/javascript" src="/js/json2.js"></script>
<script type="text/javascript" src="/js/sbtm.js"></script>
<script type="text/javascript" src="/js/navigator.js"></script>
<script type="text/javascript" src="/js/images.js"></script>
<script type="text/javascript" src="/js/jquery.scrollLoading.js"></script>
<script type="text/javascript">
	document.onreadystatechange = function() {
		if (document.readyState == "complete") {
			onload();
		}
	}
</script>
<decorator:head />
</head>
<body>
	<decorator:body />
	<div class="sidebar">
		<div class="gadget">
			<h2 class="star">
				<span>Project</span> Browser
			</h2>
			<div class="clr"></div>
			<div>
				<table>
					<tbody>
						<tr>
							<td><select id="projectOption"
								onchange="onProjectChanged(this.value);"></select>
							</td>
							<td></td>
						</tr>
						<tr>
							<td><select id="buildOption"
								onchange="onBuildChanged(this.value);"></select>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								<!-- Area list --></td>
						</tr>
						<tr>
							<td>
								<ul id="arealist" class="sb_menu">
								</ul></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="gadget">
			<h2 class="star">
				<span>Latest Activities</span>
			</h2>
			<div class="clr"></div>
			<ul class="ex_menu">
				<li class="active"><a href="#" title="Website Templates">DreamTemplate</a><br />
					Over 6,000+ Premium Web Templates</li>
				<li><a href="#" title="WordPress Themes">TemplateSOLD</a><br />
					Premium WordPress &amp; Joomla Themes</li>
				<li><a href="#" title="Affordable Hosting">ImHosted.com</a><br />
					Affordable Web Hosting Provider</li>
				<li><a href="#" title="Stock Icons">MyVectorStore</a><br />
					Royalty Free Stock Icons</li>
				<li><a href="#" title="Website Builder">Evrsoft</a><br />
					Website Builder Software &amp; Tools</li>
				<li><a href="#" title="CSS Templates">CSS Hub</a><br />
					Premium CSS Templates</li>
			</ul>
		</div>
	</div>

</body>
	</html>
</page:applyDecorator>