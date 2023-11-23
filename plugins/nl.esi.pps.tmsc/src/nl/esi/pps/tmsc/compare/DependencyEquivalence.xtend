/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare

import java.util.Objects
import java.util.function.BiPredicate
import nl.esi.pps.tmsc.Dependency
import nl.esi.pps.tmsc.Event
import org.eclipse.xtend.lib.annotations.Data

@Data
class DependencyEquivalence implements BiPredicate<Dependency, Dependency> {
    val BiPredicate<? super Event, ? super Event> sourceEventEquivalence;
    val BiPredicate<? super Event, ? super Event> targetEventEquivalence;

    new(BiPredicate<? super Event, ? super Event> sourceEventEquivalence,
        BiPredicate<? super Event, ? super Event> targetEventEquivalence) {
        this.sourceEventEquivalence = sourceEventEquivalence
        this.targetEventEquivalence = targetEventEquivalence
    }

    override test(Dependency d1, Dependency d2) {
        return equalsType(d1, d2) &&
            sourceEventEquivalence.test(d1.source, d2.source) &&
            targetEventEquivalence.test(d1.target, d2.target)
    }
    
    static def boolean equalsType(Dependency d1, Dependency d2) {
        return d1.projection == d2.projection && Objects.equals(d1.eClass, d2.eClass)
    }
}
