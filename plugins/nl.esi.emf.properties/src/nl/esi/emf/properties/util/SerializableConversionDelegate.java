/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.emf.properties.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EDataType.Internal.ConversionDelegate;

/**
 * Candidate to be moved to a more general package or plugin.
 */
public class SerializableConversionDelegate implements ConversionDelegate {
	private static final SerializableConversionDelegate INSTANCE = new SerializableConversionDelegate();

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

		try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			new ObjectOutputStream(out).writeObject(value);
			return Base64.getEncoder().encodeToString(out.toByteArray());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Object createFromString(String literal) {
		if (null == literal || literal.isEmpty()) {
			return null;
		}

		byte[] data = Base64.getDecoder().decode(literal);
		try (ByteArrayInputStream in = new ByteArrayInputStream(data)) {
			return (Serializable) new ObjectInputStream(in).readObject();
		} catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}
