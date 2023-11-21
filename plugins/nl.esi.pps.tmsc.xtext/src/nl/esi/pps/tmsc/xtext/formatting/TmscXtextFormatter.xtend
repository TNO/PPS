/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.tmsc.xtext.formatting

import com.google.inject.Inject
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig

class TmscXtextFormatter extends AbstractDeclarativeFormatter {
    @Inject
    @Extension
    var TmscXtextGrammarAccess tmscXtextGrammarAccess;

    override protected configureFormatting(FormattingConfig it) {
        autoLinewrap = 120
        
        // Comments
        setLinewrap(0, 1, 2).before(SL_COMMENTRule)
        setLinewrap(0, 1, 2).before(ML_COMMENTRule)
        setLinewrap(0, 1, 1).after(ML_COMMENTRule)
        
        // Parenthesis
        for (pair : findKeywordPairs("{", "}")) {
            setLinewrap(1,1,2).after(pair.first)
            setLinewrap(1,1,2).before(pair.second)
            setLinewrap(1,1,2).after(pair.second)
            setIndentation(pair.first, pair.second)
            setNoSpace().between(pair.first, pair.second)
        }
        // General keywords
        for (pair : findKeywordPairs("(", ")")) {
            setNoSpace().before(pair.first);
            setNoSpace().after(pair.first);
            setNoSpace().before(pair.second);
        }
        for (keyword : findKeywords(",",":")) {
            setNoSpace().before(keyword);
        }
        for (keyword : findKeywords("!","?")) {
            setNoSpace().after(keyword);
        }
        
        // Grammar
        setLinewrap(1,1,2).after(XInterfaceRule)
        
        setLinewrap(1,1,2).after(XOperationRule)

        setLinewrap(1,1,2).after(XComponentRule)
        setLinewrap(1,1,2).after(XComponentAccess.timeBoundAssignment_5_1_0_2)
        setLinewrap(1,1,2).after(XComponentAccess.scheduledAssignment_5_1_1_2)

        setLinewrap(1,1,2).after(XFunctionRule)
        setLinewrap(1,1,2).after(XFunctionAccess.timeBoundAssignment_6_1_0_2)
        setLinewrap(1,1,2).after(XFunctionAccess.scheduledAssignment_6_1_1_2)

        setLinewrap(1,1,2).after(XExecutorRule)
        setLinewrap(1,1,2).after(XExecutorAccess.timeBoundAssignment_4_1_0_2)
        setLinewrap(1,1,2).after(XExecutorAccess.scheduledAssignment_4_1_1_2)
        
        setLinewrap(1,1,2).after(XEventRule)
        setLinewrap(1,1,2).after(XEventAccess.timeBoundAssignment_8_1_0_2)
        setLinewrap(1,1,2).after(XEventAccess.scheduledAssignment_8_1_1_2)

        setLinewrap(1,1,2).after(XDependencySettingsRule)
        setLinewrap(1,1,2).after(XDependencySettingsAccess.timeBoundAssignment_3_0_2)
        setLinewrap(1,1,2).after(XDependencySettingsAccess.scheduledAssignment_3_1_2)
        setLinewrap(1,1,2).after(XDependencySettingsAccess.prefixAssignment_3_2_2)

        setLinewrap(1,1,2).after(XPropertyRule)
    }
}
