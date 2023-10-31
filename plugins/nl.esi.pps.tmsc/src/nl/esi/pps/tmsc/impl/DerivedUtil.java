/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.impl;

import java.util.function.Function;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.lsat.common.util.IterableUtil;

public class DerivedUtil {
	private DerivedUtil() {
		// Private for utility classes
	}
	
	public static <T> EList<T> derivedEOperation(final Iterable<T> iterable) {
		if (iterable instanceof EList) {
			return (EList<T>) iterable;
		}
		final Object[] array = IterableUtil.toArray(iterable);
		return new BasicEList.UnmodifiableEList<T>(array.length, array);
	}
	
	public static <O extends InternalEObject, T> EList<T> derivedEReference(O owner, int featureID, Function<? super O, Iterable<T>> functor) {
		return derivedEReference(owner, featureID, functor.apply(owner));
	}

	public static <O extends InternalEObject, T> EList<T> derivedEReference(O owner, int featureID, Iterable<T> iterable) {
		final EStructuralFeature eStructuralFeature = owner.eClass().getEStructuralFeature(featureID);
		final Object[] data = IterableUtil.toArray(iterable);
		return new EcoreEList.UnmodifiableEList<T>(owner, eStructuralFeature, data.length, data);
	}
}
