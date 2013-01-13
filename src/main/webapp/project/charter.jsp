<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Charter: <s:property value="charter.name" />
</title>
<script type="text/javascript">
	function modify(data) {
		alert(data);
	}
	function addbug() {
		var id = document.getElementById("bugs").getElementsByTagName("table").length;
		$("#addbug")
				.before(
						'<table id='+id+'><tbody>'
								+ '<tr><td>Summary</td><td><s:textfield name="summary"></s:textfield></td></tr>'
								+ '<tr><td>Description</td><td><s:textarea name="description"></s:textarea></td></tr>'
								+ '<tr><td></td><td align="right"><button onclick="deleteBug(+'
								+ id + ')">Delete Bug</button></td></tr>'
								+ '</tbody></table>');
	}
	function deleteBug(id) {
		$("table#" + id).remove();
	}
	function areaChanged() {
		var div = $("#addareadiv");
		var div2 = div.clone();
		div.removeAttr("id", "");
		div.after(div2);
	}
</script>
</head>
<body>
	<div class="mainbar">
		<div class="chartContent">
			<s:div id="charter">
				<h3>
					Charter:
					<s:property value="charter.name"></s:property>
				</h3>
				<hr />
				<table>
					<tbody>
						<tr>
							<td>Description</td>
							<td><s:textarea name="charter.description"
									class="desciption"></s:textarea>
							</td>
						</tr>
						<tr>
							<td>Start Time</td>
							<td><s:textfield name="charter.starttime"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>Tester</td>
							<td><s:textfield name="charter.tester.name"></s:textfield>
							</td>
						</tr>
					</tbody>
				</table>
			</s:div>
			<hr />
			<s:div id="areas">
				<h3>Areas</h3>
				<hr></hr>
				<table>
					<tbody>
						<s:iterator value="charter.areas" id="area" status="st">
							<tr>
								<td><s:select list="areaList" headerValue="--Select Area--"
										headerKey="--" listKey="id" listValue="name" value="id"></s:select>
								</td>
								<td><s:textfield name="name"
										onchange="modify('%{#st.index}')" id="nmArea_%{#st.index}" />
								</td>
							</tr>
						</s:iterator>
						<tr id="addareadiv">
							<td><s:select list="areaList" headerValue="--Select Area--"
									headerKey="--" listKey="id" listValue="name"
									onchange="areaChanged()"></s:select>
							</td>
						</tr>
					</tbody>
				</table>
			</s:div>
			<hr />
			<s:div id="breakdown">
				<h3>Break Down</h3>
				<hr>
				<table>
					<tbody>
						<tr>
							<td>DURATION</td>
							<%--<td><s:select list="durationList"
					headerValue="--Select Duration--" headerKey="--" listKey="name"
					listValue="name" name="charter.duration.name"></s:select></td>
					 --%>
						</tr>
						<tr>
							<td>DESING AND EXECUTION</td>
							<td><s:textfield name="charter.designAndExectution"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>BUG INVESTIGATION AND REPORTING</td>
							<td><s:textfield name="charter.bugIvestigationAndReporting"></s:textfield>
							</td>
						</tr>
						<tr>
							<td>SET UP</td>
							<td><s:textfield name="charter.sesstionSetup"></s:textfield>
							</td>
						</tr>

						<tr>
							<td>CHARTER VS. OPP</td>
							<td><s:textfield name="charter.chartervsopp"></s:textfield>
							</td>
						</tr>
					</tbody>
				</table>
			</s:div>
			<hr />
			<s:div id="datafiles">
				<h3>Data Files</h3>
				<hr>
				<table>
					<tbody>
						<s:iterator value="charter.datafiles">
							<tr>
								<td><s:property></s:property>
								</td>
								<td><s:textfield name=""></s:textfield>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:div>
			<s:div id="notes">
				<h3>Notes</h3>
				<s:textarea name="charter.notes"></s:textarea>
			</s:div>
			<hr />
			<s:div id="bugs">
				<h3>Bugs</h3>
				<hr>
				<s:iterator value="charter.bugs" id="bug" status="st">
					<table id="bug<s:property value='#st.index' />">
						<tbody>
							<tr>
								<td>Summary</td>
								<td><s:textfield name="summary"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>Description</td>
								<td><s:textarea name="description"></s:textarea>
								</td>
							</tr>
							<tr>
								<td></td>
								<td align="right">
									<button
										onclick="deleteBug(this.parentNode.parentNode.parentNode.parentNode.id)">Delete
										Bug</button></td>
							</tr>

						</tbody>
					</table>
				</s:iterator>
				<table id="addbug">
					<tbody>
						<tr>
							<td align="right">
								<button onclick="addbug()">Add New Bug</button></td>
						</tr>
					</tbody>
				</table>
			</s:div>

			<s:div id="issues">
				<h3>Issues</h3>
				<hr>
				<table>
					<tbody>
						<s:iterator value="charter.issues">
							<tr>
								<td><s:textfield name="summary"></s:textfield>
								</td>
							</tr>
							<tr>
								<td><s:textarea name="charter.issues"></s:textarea>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:div>
		</div>
	</div>
</body>
</html>