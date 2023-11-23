/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.conversion

import java.math.BigDecimal
import org.eclipse.xtext.conversion.IValueConverter
import org.eclipse.xtext.conversion.ValueConverterException
import org.eclipse.xtext.nodemodel.INode

class PosEBigDecimalConverter implements IValueConverter<BigDecimal> {
    override toString(BigDecimal value) throws ValueConverterException {
        if (value.signum < 0) {
            throw new ValueConverterException('''Expected a positive number: «value»''', null, null)
        }
        return '''+«value»'''
    }

    override toValue(String string, INode node) throws ValueConverterException {
        try {
            return new BigDecimal(string)
        } catch (NumberFormatException nfe) {
            throw new ValueConverterException(nfe.message, node, nfe)
        }
    }
}
