/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.common.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.function.Function;

public class FunctionFormat<T> extends Format {
	private static final long serialVersionUID = -7009242128690091236L;

	private final Function<? super T, String> formatter;
	private final Function<String, ? extends T> parser;

	public FunctionFormat(Function<? super T, String> formatter) {
		this(formatter, null);
	}

	public FunctionFormat(Function<? super T, String> formatter, Function<String, ? extends T> parser) {
		this.formatter = formatter;
		this.parser = parser;
	}

	@Override
	@SuppressWarnings("unchecked")
	public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
		return toAppendTo.append(formatter.apply((T) obj));
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		if (parser == null) {
			throw new UnsupportedOperationException();
		}
		return parser.apply(source);
	}
}
