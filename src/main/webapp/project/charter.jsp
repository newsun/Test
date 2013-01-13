<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Charter: <s:property value="charter.name" /></title>
</head>
<body>
	<div class="mainbar">
		<div class="chartContent">
			<h2>
				Charter
				<s:label name="charter.id" />:
				<s:property value="charter.name"></s:property>
			</h2>
			<div class="module">
				<div class="mod-header">
					<h3>Summary</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<li>
							<dl>
								<dt>Description</dt>
								<dd>
									<s:textarea name="charter.description" class="desciption"></s:textarea>
								</dd>
							</dl></li>
						<li>
							<dl>
								<dt>Start Time</dt>
								<dd>
									<s:label name="charter.starttime"></s:label>
								</dd>
							</dl></li>
						<li>
							<dl>
								<dt>Tester</dt>
								<dd>
									<s:label name="charter.tester.name"></s:label>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div>
			<div class="module">
				<div class="mod-header">
					<h3>Areas</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<li>
							<dl>
								<dt>
									<s:iterator value="charter.areas" id="area" status="st">
										<s:select list="areaList" headerValue="--Select Area--"
											headerKey="--" listKey="id" listValue="name" value="id"></s:select>
										<s:textfield name="name" onchange="modify('%{#st.index}')"
											id="nmArea_%{#st.index}" />

									</s:iterator>
								</dt>
								<dd>
									<s:select list="areaList" headerValue="--Select Area--"
										headerKey="--" listKey="id" listValue="name"
										onchange="areaChanged()"></s:select>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div>

			<div class="module">
				<div class="mod-header">
					<h3>Break Down</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<li>
							<dl>
								<dt>DURATION</dt>
								<dd>
									<s:select list="durationList" headerValue="--Select Duration--"
										headerKey="" listKey="name" listValue="name"
										name="charter.duration.name"></s:select>
									</td>
								</dd>
							</dl></li>
						<li>
							<dl>
								<dt>DESING AND EXECUTION</dt>
								<dd>
									<s:textfield name="charter.designAndExectution"></s:textfield>
								</dd>
							</dl>
							<dl>
								<dt>BUG INVESTIGATION AND REPORTING</dt>
								<dd>
									<s:textfield name="charter.bugIvestigationAndReporting"></s:textfield>
								</dd>
							</dl>
						</li>
						<li>
							<dl>
								<dt>SET UP</dt>
								<dd>
									<s:textfield name="charter.sesstionSetup"></s:textfield>
								</dd>
							</dl>

							<dl>
								<dt>CHARTER VS. OPP</dt>
								<dd>
									<s:textfield name="charter.chartervsopp"></s:textfield>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div>
			<div class="module">
				<div class="mod-header">
					<h3>Data Files</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<li><dl>
								<s:iterator value="charter.datafiles">
									<td><s:property></s:property>
									<td><s:textfield name=""></s:textfield>
								</s:iterator>
							</dl></li>
					</ul>
				</div>
			</div>
			<div class="module">
				<div class="mod-header">
					<h3>Notes</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<li><dl>
								<dt></dt>
								<dd>
									<s:textarea name="charter.note"></s:textarea>
								</dd>
							</dl>
						</li>
					</ul>
				</div>
			</div>
			<div class="module">
				<div class="mod-header">
					<h3>Bugs</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<s:iterator value="charter.bugs" id="bug" status="st">
							<li id="bug<s:property value='#st.index' />">
								<dl>
									<dt>Summary</dt>
									<dd>
										<s:textfield name="summary"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>Description</dt>
									<dd>
										<s:textarea name="description"></s:textarea>
									</dd>
								</dl>
							</li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<div class="module">
				<div class="mod-header">
					<h3>Issues</h3>
				</div>
				<div class="mod-content">
					<ul class="item-details">
						<s:iterator value="charter.issues">
							<li>
								<dl>
									<dt>Summary</dt>
									<dd>
										<s:textfield name="summary"></s:textfield>
									</dd>
								</dl>
								<dl>
									<dt>Description</dt>
									<dd>
										<s:textarea name="charter.issues"></s:textarea>
									</dd>
								</dl></li>
						</s:iterator>
					</ul>
				</div>
			</div>
			<hr>
			<div>
				<s:submit id="submit" value="Update"></s:submit>
			</div>
		</div>
	</div>
</body>
</html>