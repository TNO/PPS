/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.xtext.formatting;

import com.google.inject.Inject;
import java.util.List;
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class TmscXtextFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private TmscXtextGrammarAccess tmscXtextGrammarAccess;
  
  @Override
  protected void configureFormatting(final FormattingConfig it) {
    it.setAutoLinewrap(120);
    it.setLinewrap(0, 1, 2).before(this.tmscXtextGrammarAccess.getSL_COMMENTRule());
    it.setLinewrap(0, 1, 2).before(this.tmscXtextGrammarAccess.getML_COMMENTRule());
    it.setLinewrap(0, 1, 1).after(this.tmscXtextGrammarAccess.getML_COMMENTRule());
    List<Pair<Keyword, Keyword>> _findKeywordPairs = this.tmscXtextGrammarAccess.findKeywordPairs("{", "}");
    for (final Pair<Keyword, Keyword> pair : _findKeywordPairs) {
      {
        it.setLinewrap(1, 1, 2).after(pair.getFirst());
        it.setLinewrap(1, 1, 2).before(pair.getSecond());
        it.setLinewrap(1, 1, 2).after(pair.getSecond());
        it.setIndentation(pair.getFirst(), pair.getSecond());
        it.setNoSpace().between(pair.getFirst(), pair.getSecond());
      }
    }
    List<Pair<Keyword, Keyword>> _findKeywordPairs_1 = this.tmscXtextGrammarAccess.findKeywordPairs("(", ")");
    for (final Pair<Keyword, Keyword> pair_1 : _findKeywordPairs_1) {
      {
        it.setNoSpace().before(pair_1.getFirst());
        it.setNoSpace().after(pair_1.getFirst());
        it.setNoSpace().before(pair_1.getSecond());
      }
    }
    List<Keyword> _findKeywords = this.tmscXtextGrammarAccess.findKeywords(",", ":");
    for (final Keyword keyword : _findKeywords) {
      it.setNoSpace().before(keyword);
    }
    List<Keyword> _findKeywords_1 = this.tmscXtextGrammarAccess.findKeywords("!", "?");
    for (final Keyword keyword_1 : _findKeywords_1) {
      it.setNoSpace().after(keyword_1);
    }
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXInterfaceRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXOperationRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXComponentRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXComponentAccess().getTimeBoundAssignment_5_1_0_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXComponentAccess().getScheduledAssignment_5_1_1_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXFunctionRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXFunctionAccess().getTimeBoundAssignment_6_1_0_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXFunctionAccess().getScheduledAssignment_6_1_1_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXExecutorRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXExecutorAccess().getTimeBoundAssignment_4_1_0_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXExecutorAccess().getScheduledAssignment_4_1_1_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXEventRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXEventAccess().getTimeBoundAssignment_8_1_0_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXEventAccess().getScheduledAssignment_8_1_1_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXDependencySettingsRule());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXDependencySettingsAccess().getTimeBoundAssignment_3_0_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXDependencySettingsAccess().getScheduledAssignment_3_1_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXDependencySettingsAccess().getPrefixAssignment_3_2_2());
    it.setLinewrap(1, 1, 2).after(this.tmscXtextGrammarAccess.getXPropertyRule());
  }
}
