/*
 * Copyright (c) 2018-2025 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate;

public class EPropertyValueConversionDelegate extends SerializableConversionDelegate {
	private static final EPropertyValueConversionDelegate INSTANCE = new EPropertyValueConversionDelegate();

	/**
	 * Pattern: (<java_class>)<string_value> 
	 * Supports white spaces before and within java_class part.
	 */
	private static final Pattern TYPE_VALUE_EXPR = Pattern.compile("^\\s*\\(\\s*([\\w\\.]+)\\s*\\)(.*)$");

	public static final class Factory implements ConversionDelegate.Factory {
		@Override
		public ConversionDelegate createConversionDelegate(EDataType eDataType) {
			return INSTANCE;
		}
	}

	@Override
	public String convertToString(Object value) {
		if (null == value) {
			return null;
		}

		String typeStr = value.getClass().getSimpleName();
		String valueStr;
		
		switch (typeStr) {
		case "Boolean":
		case "Byte":
		case "Character":
		case "Double":
		case "Float":
		case "Integer":
		case "Long":
		case "Short":
		case "String":
		case "BigDecimal":
		case "BigInteger":
			valueStr = String.valueOf(value);
			break;
		default:
			if (value.getClass().isEnum() && value.getClass().getCanonicalName() != null) {
				typeStr = value.getClass().getCanonicalName();
				valueStr = String.valueOf(value);
			} else {
				typeStr = Serializable.class.getSimpleName();
				valueStr = super.convertToString(value);
			}
			break;
		}

		return "(" + typeStr + ")" + valueStr;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object createFromString(String literal) {
		if (null == literal || literal.isEmpty()) {
			return null;
		}

		Matcher matcher = TYPE_VALUE_EXPR.matcher(literal);
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unsupported value, use pattern: (<java_class>)<string_value>");
		}
		final String typeStr = matcher.group(1);
		final String valueStr = matcher.group(2);

		// IMPORTANT: A String value is not trimmed as it may start with white spaces!
		switch (typeStr.toLowerCase()) {
		case "string":
			return valueStr;
		case "boolean":
			return Boolean.parseBoolean(valueStr.trim());
		case "byte":
			return Byte.parseByte(valueStr.trim());
		case "char":
		case "character":
			return valueStr.trim().isEmpty() ? null : valueStr.trim().charAt(0);
		case "double":
			return Double.parseDouble(valueStr.trim());
		case "float":
			return Float.parseFloat(valueStr.trim());
		case "int":
		case "integer":
			return Integer.parseInt(valueStr.trim());
		case "long":
			return Long.parseLong(valueStr.trim());
		case "short":
			return Short.parseShort(valueStr.trim());
		case "bigdecimal":
			return new BigDecimal(valueStr.trim());
		case "biginteger":
			return new BigInteger(valueStr.trim());
		case "serializable":
			return super.createFromString(valueStr.trim());
		default:
			try {
				Class<?> enumType = Class.forName(typeStr);
				if (enumType.isEnum()) {
					return Enum.valueOf((Class<? extends Enum>) enumType, valueStr.trim());
				}
			} catch (ClassNotFoundException e) {
				// Do nothing
			}
			throw new IllegalArgumentException(
					"Unsupported type, use any Java primitive, String, BigDecimal, BigInteger, Enum or Base64 encoded Serializable");
		}
	}
}
