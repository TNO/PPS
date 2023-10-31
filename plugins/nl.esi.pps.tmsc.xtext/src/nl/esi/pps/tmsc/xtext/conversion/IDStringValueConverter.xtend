/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.conversion

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode

@FinalFieldsConstructor
class IDStringValueConverter implements IValueConverter<String> {
    val IValueConverter<String> idValueConverter
    val IValueConverter<String> stringValueConverter

    /** Prefer ID with fallback to STRING */
    override toString(String value) throws ValueConverterException {
        try {
            return idValueConverter.toString(value)
        } catch (ValueConverterException e) {
            return stringValueConverter.toString(value)
        }
    }

    /** Try STRING with fallback to ID */
    override toValue(String string, INode node) throws ValueConverterException {
        return if (string !== null && (string.startsWith('"') || string.startsWith("'"))) {
            stringValueConverter.toValue(string, node)
        } else {
            idValueConverter.toValue(string, node)
        } 
    }
}
