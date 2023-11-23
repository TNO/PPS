/**
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 * 
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 * 
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.compare;

import java.util.Objects;
import java.util.function.BiPredicate;
import nl.esi.pps.tmsc.Dependency;
import nl.esi.pps.tmsc.Event;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class DependencyEquivalence implements BiPredicate<Dependency, Dependency> {
  private final BiPredicate<? super Event, ? super Event> sourceEventEquivalence;
  
  private final BiPredicate<? super Event, ? super Event> targetEventEquivalence;
  
  public DependencyEquivalence(final BiPredicate<? super Event, ? super Event> sourceEventEquivalence, final BiPredicate<? super Event, ? super Event> targetEventEquivalence) {
    this.sourceEventEquivalence = sourceEventEquivalence;
    this.targetEventEquivalence = targetEventEquivalence;
  }
  
  @Override
  public boolean test(final Dependency d1, final Dependency d2) {
    return ((DependencyEquivalence.equalsType(d1, d2) && 
      this.sourceEventEquivalence.test(d1.getSource(), d2.getSource())) && 
      this.targetEventEquivalence.test(d1.getTarget(), d2.getTarget()));
  }
  
  public static boolean equalsType(final Dependency d1, final Dependency d2) {
    return ((d1.isProjection() == d2.isProjection()) && Objects.equals(d1.eClass(), d2.eClass()));
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.sourceEventEquivalence== null) ? 0 : this.sourceEventEquivalence.hashCode());
    return prime * result + ((this.targetEventEquivalence== null) ? 0 : this.targetEventEquivalence.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DependencyEquivalence other = (DependencyEquivalence) obj;
    if (this.sourceEventEquivalence == null) {
      if (other.sourceEventEquivalence != null)
        return false;
    } else if (!this.sourceEventEquivalence.equals(other.sourceEventEquivalence))
      return false;
    if (this.targetEventEquivalence == null) {
      if (other.targetEventEquivalence != null)
        return false;
    } else if (!this.targetEventEquivalence.equals(other.targetEventEquivalence))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("sourceEventEquivalence", this.sourceEventEquivalence);
    b.add("targetEventEquivalence", this.targetEventEquivalence);
    return b.toString();
  }
  
  @Pure
  public BiPredicate<? super Event, ? super Event> getSourceEventEquivalence() {
    return this.sourceEventEquivalence;
  }
  
  @Pure
  public BiPredicate<? super Event, ? super Event> getTargetEventEquivalence() {
    return this.targetEventEquivalence;
  }
}
