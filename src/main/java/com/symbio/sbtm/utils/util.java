package com.symbio.sbtm.utils;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.symbio.sbtm.factory.DAOFactory;
import com.symbio.sbtm.vo.Project;

public class util {
	private final static String[] classlist = { "Area", "Areas", "Bug",
			"Build", "Charter", "Duration", "Issue", "OS", "OSs", "Project",
			"Strategy", "Strategies", "User", "UserGroup" };

	private static boolean checkClassType(String classanem) {
		for (String cn : classlist)
			if (classanem.toLowerCase().endsWith(cn.toLowerCase()))
				return true;
		return false;
	}

	public static String fetchClassName(String classname) {
		int pos = classname.lastIndexOf(".") + 1;
		int endpos = classname.length();
		String name = classname.substring(pos, endpos);
		return name;
	}

	public static Map<String, String> getNonEmptyFields(Class<?> cl, Object obj) {
		Map<String, String> map = new TreeMap<String, String>();
		try {
			java.lang.reflect.Field[] fields = cl.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				Object prop = fields[i].get(obj);
				if (null == prop)
					continue;
				Class<?> fieldclasstype = fields[i].getType();
				if (fieldclasstype.isPrimitive()
						|| fieldclasstype.isAssignableFrom(String.class)) {
					String propertValue = prop.toString();
					if (propertValue.equals("0")
							|| propertValue.equals("false"))
						continue;
					map.put(fields[i].getName(), prop.toString());
					continue;
				}
				if (fieldclasstype.isArray())
					continue;
				if (fieldclasstype.isSynthetic())
					continue;

				if (checkClassType(fieldclasstype.getName())) {
					String name = fetchClassName(fieldclasstype.getName());
					String propertValue = prop.toString();
					if (propertValue.equals("0") || propertValue.equals(""))
						continue;
					map.put(name.toLowerCase() + "Id", prop.toString());
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static String[] getFieldsName(Class<?> cl) {
		try {
			java.lang.reflect.Field[] fields = cl.getDeclaredFields();
			String[] filedNames = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				String name = fields[i].getName();
				if (checkClassType(name)) {
					if (name.equalsIgnoreCase("OS")
							|| name.equalsIgnoreCase("Strategy")
							|| (name.equalsIgnoreCase("Duration")))
						name = name.toLowerCase() + "Name";
					else
						name = name.toLowerCase() + "Id";
				}
				filedNames[i] = name;
			}
			return filedNames;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSqlCmd(Class<?> Exp, Class<?> input, Object obj) {
		if (Exp == null)
			return null;
		// String sqlcmd = "select id,name,description,projectId from project";
		String sqlcmd = util.getBeforeSqlCmd(Exp);
		String className = fetchClassName(input.getName());
		if (input == null || obj == null) {
		} else if (input.getName().equalsIgnoreCase(Exp.getName()))
			sqlcmd += util.getAfterSqlCmd(util.getNonEmptyFields(Exp, obj));
		else if (className.equalsIgnoreCase("Strategy")
				|| className.equalsIgnoreCase("user")) {
			sqlcmd += " where " + "Name=" + obj.toString();
		} else {
			sqlcmd += " where " + className + "Id=" + obj.toString();
		}
		return sqlcmd;
	}

	public static String getBeforeSqlCmd(Class<?> cl) {
		String fields[] = getFieldsName(cl);

		String sqlcmd = "select ";
		for (int i = 0; i < fields.length; i++) {
			sqlcmd += fields[i] + ",";
		}
		sqlcmd = sqlcmd.substring(0, sqlcmd.length() - 1);
		sqlcmd += " from " + fetchClassName(cl.getName()).toLowerCase();
		return sqlcmd;
	}

	public static String getAfterSqlCmd(Map<String, String> map) {
		String sqlcmd = "";
		for (String key : map.keySet()) {
			String value = map.get(key);
			String ss = (value.equalsIgnoreCase("true") || value
					.equalsIgnoreCase("false")) ? value : ("\"" + value + "\"");
			sqlcmd += " and " + key + "=" + ss;
		}
		if (sqlcmd.length() > 0)
			sqlcmd = sqlcmd.replaceFirst("and", "where");
		return sqlcmd;
	}

	public static ArrayList<?> getAllObjects(Class<?> outputCl,
			Class<?> inputCl, Object obj, String condition) throws Exception {
		if (null == obj)
			return null;
		String sqlcmd = util.getBeforeSqlCmd(outputCl) + condition;
		ArrayList<Object> list = DAOFactory.getDataBaseOperator()
				.ExecuteReader(sqlcmd, null);
		return convert2Class(outputCl, list);
	}

	public static ArrayList<?> getAllObjects(Class<?> outputCl,
			Class<?> inputCl, Object obj) throws Exception {
		if (null == obj)
			return null;
		String sqlcmd = getSqlCmd(outputCl, inputCl, obj);

		ArrayList<Object> list = DAOFactory.getDataBaseOperator()
				.ExecuteReader(sqlcmd, null);
		return convert2Class(outputCl, list);
	}

	private static <T> ArrayList<Object> convert2Class(Class<T> cl,
			ArrayList<Object> list) throws InstantiationException,
			IllegalAccessException, Exception, SecurityException,
			NoSuchFieldException {
		if (null == list)
			return null;
		ArrayList<Object> objects = new ArrayList<Object>();
		java.lang.reflect.Field[] fields = cl.getDeclaredFields();
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			if (!(obj instanceof Object[]))
				continue;
			Object[] ob = (Object[]) obj;
			Object newcl = cl.newInstance();
			for (int j = 0; j < fields.length; j++) {
				fields[j].setAccessible(true);
				Class<?> clstyp = fields[j].getType();
				if (checkClassType(clstyp.getName())) {
					Object subObj = clstyp.newInstance();
					String fieldName = fields[j].getName();
					java.lang.reflect.Field fd = null;
					Object val = null;
					java.lang.reflect.Field[] fileds_ = clstyp
							.getDeclaredFields();
					for (int index = 0; index < fileds_.length; index++) {
						try {
							fd = fileds_[index];
							String fdName_ = fd.getName();
							if (fdName_.equals("id")) {
								fd.setAccessible(true);
								val = Integer.valueOf(ob[j].toString())
										.intValue();
								fd.set(subObj, val);
								break;
							} else if (fdName_.equals("name")) {
								fd.setAccessible(true);
								val = ob[j].toString();
								fd.set(subObj, val);
								break;
							}

						} catch (Exception e) {
						}
						continue;
					}
					fields[j].set(newcl, subObj);
				} else {
					fields[j].set(newcl, ob[j]);
				}
			}
			objects.add(cl.cast(newcl));
		}
		return objects;
	}

	public void setField(java.lang.reflect.Field fd, Object obj,
			java.lang.reflect.Field subfd, Object value)
			throws IllegalArgumentException, IllegalAccessException {

	}
}
