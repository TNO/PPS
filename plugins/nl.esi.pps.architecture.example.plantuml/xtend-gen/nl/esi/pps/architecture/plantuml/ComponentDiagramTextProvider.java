/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.pps.architecture.plantuml;

import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import net.sourceforge.plantuml.eclipse.utils.DiagramTextProvider;
import nl.esi.pps.architecture.example.ExampleArchitecture;
import nl.esi.pps.architecture.specified.Component;
import nl.esi.pps.architecture.specified.Interface;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@SuppressWarnings("all")
public class ComponentDiagramTextProvider implements DiagramTextProvider {
  @Data
  public static class ComponentsAndInterfaces {
    private final Set<Component> components = CollectionLiterals.<Component>newLinkedHashSet();
    
    private final Set<Interface> interfaces = CollectionLiterals.<Interface>newLinkedHashSet();
    
    public boolean isEmpty() {
      return (this.components.isEmpty() && this.interfaces.isEmpty());
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.components== null) ? 0 : this.components.hashCode());
      return prime * result + ((this.interfaces== null) ? 0 : this.interfaces.hashCode());
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
      ComponentDiagramTextProvider.ComponentsAndInterfaces other = (ComponentDiagramTextProvider.ComponentsAndInterfaces) obj;
      if (this.components == null) {
        if (other.components != null)
          return false;
      } else if (!this.components.equals(other.components))
        return false;
      if (this.interfaces == null) {
        if (other.interfaces != null)
          return false;
      } else if (!this.interfaces.equals(other.interfaces))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("components", this.components);
      b.add("interfaces", this.interfaces);
      return b.toString();
    }
    
    @Pure
    public Set<Component> getComponents() {
      return this.components;
    }
    
    @Pure
    public Set<Interface> getInterfaces() {
      return this.interfaces;
    }
  }
  
  @Override
  public boolean supportsSelection(final ISelection selection) {
    boolean _isEmpty = this.findComponentsAndInterfaces(selection).isEmpty();
    return (!_isEmpty);
  }
  
  @Override
  public String getDiagramText(final IEditorPart editorPart, final ISelection selection) {
    return this.getDiagramText(selection);
  }
  
  @Override
  public String getDiagramText(final IViewPart viewPart, final ISelection selection) {
    return this.getDiagramText(selection);
  }
  
  private String getDiagramText(final ISelection selection) {
    final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i = this.findComponentsAndInterfaces(selection);
    boolean _isEmpty = c_and_i.isEmpty();
    if (_isEmpty) {
      return null;
    }
    final List selectedItems = ((IStructuredSelection) selection).toList();
    final Function1<Pair<Integer, Interface>, Interface> _function = (Pair<Integer, Interface> it) -> {
      return it.getValue();
    };
    final Function1<Pair<Integer, Interface>, Integer> _function_1 = (Pair<Integer, Interface> it) -> {
      return it.getKey();
    };
    final Map<Interface, Integer> indexedInterfaces = IterableExtensions.<Pair<Integer, Interface>, Interface, Integer>toMap(IterableExtensions.<Interface>indexed(c_and_i.interfaces), _function, _function_1);
    final Function1<Pair<Integer, Component>, Component> _function_2 = (Pair<Integer, Component> it) -> {
      return it.getValue();
    };
    final Function1<Pair<Integer, Component>, Integer> _function_3 = (Pair<Integer, Component> it) -> {
      return it.getKey();
    };
    final Map<Component, Integer> indexedComponents = IterableExtensions.<Pair<Integer, Component>, Component, Integer>toMap(IterableExtensions.<Component>indexed(c_and_i.components), _function_2, _function_3);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("skinparam fixCircleLabelOverlapping true");
    _builder.newLine();
    _builder.newLine();
    _builder.append("skinparam interface {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("fontColor MidnightBlue");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("borderColor SteelBlue");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("backgroundColor White");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("backgroundColor<<selected>> Yellow");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("skinparam component {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("fontColor MidnightBlue");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("arrowColor SteelBlue");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("borderColor SteelBlue");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("backgroundColor White");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("backgroundColor<<selected>> Yellow");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      Set<Map.Entry<Interface, Integer>> _entrySet = indexedInterfaces.entrySet();
      for(final Map.Entry<Interface, Integer> indexedInterface : _entrySet) {
        _builder.append("interface \"");
        String _name = indexedInterface.getKey().getName();
        _builder.append(_name);
        _builder.append("\"");
        {
          boolean _contains = selectedItems.contains(indexedInterface.getKey());
          if (_contains) {
            _builder.append(" <<selected>>");
          }
        }
        _builder.append(" as I");
        Integer _value = indexedInterface.getValue();
        _builder.append(_value);
        _builder.newLineIfNotEmpty();
      }
    }
    {
      Set<Map.Entry<Component, Integer>> _entrySet_1 = indexedComponents.entrySet();
      for(final Map.Entry<Component, Integer> indexedComponent : _entrySet_1) {
        _builder.append("component \"");
        String _name_1 = indexedComponent.getKey().getName();
        _builder.append(_name_1);
        _builder.append("\"");
        {
          boolean _contains_1 = selectedItems.contains(indexedComponent.getKey());
          if (_contains_1) {
            _builder.append(" <<selected>>");
          }
        }
        _builder.append(" as C");
        Integer _value_1 = indexedComponent.getValue();
        _builder.append(_value_1);
        _builder.newLineIfNotEmpty();
        {
          final Function1<Interface, Boolean> _function_4 = (Interface it) -> {
            return Boolean.valueOf(indexedInterfaces.containsKey(it));
          };
          Iterable<Interface> _filter = IterableExtensions.<Interface>filter(indexedComponent.getKey().getProvidedInterfaces(), _function_4);
          for(final Interface provided : _filter) {
            _builder.append("C");
            Integer _value_2 = indexedComponent.getValue();
            _builder.append(_value_2);
            _builder.append(" -up- I");
            Integer _get = indexedInterfaces.get(provided);
            _builder.append(_get);
            _builder.newLineIfNotEmpty();
          }
        }
        {
          final Function1<Interface, Boolean> _function_5 = (Interface it) -> {
            return Boolean.valueOf(indexedInterfaces.containsKey(it));
          };
          Iterable<Interface> _filter_1 = IterableExtensions.<Interface>filter(indexedComponent.getKey().getRequiredInterfaces(), _function_5);
          for(final Interface required : _filter_1) {
            _builder.append("C");
            Integer _value_3 = indexedComponent.getValue();
            _builder.append(_value_3);
            _builder.append(" .down.( I");
            Integer _get_1 = indexedInterfaces.get(required);
            _builder.append(_get_1);
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    return _builder.toString();
  }
  
  private ComponentDiagramTextProvider.ComponentsAndInterfaces findComponentsAndInterfaces(final ISelection selection) {
    final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i = new ComponentDiagramTextProvider.ComponentsAndInterfaces();
    if ((selection instanceof IStructuredSelection)) {
      final Consumer<EObject> _function = (EObject it) -> {
        this.addComponentsAndInterfaces(it, c_and_i);
      };
      Iterables.<EObject>filter(((Iterable<?>)selection), EObject.class).forEach(_function);
    }
    return c_and_i;
  }
  
  private void _addComponentsAndInterfaces(final EObject eObject, final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i) {
  }
  
  private void _addComponentsAndInterfaces(final ExampleArchitecture architecture, final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i) {
    EList<Interface> _interfaces = architecture.getInterfaces();
    Iterables.<Interface>addAll(c_and_i.interfaces, _interfaces);
    EList<Component> _components = architecture.getComponents();
    Iterables.<Component>addAll(c_and_i.components, _components);
  }
  
  private void _addComponentsAndInterfaces(final Component component, final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i) {
    EList<Interface> _providedInterfaces = component.getProvidedInterfaces();
    Iterables.<Interface>addAll(c_and_i.interfaces, _providedInterfaces);
    EList<Interface> _requiredInterfaces = component.getRequiredInterfaces();
    Iterables.<Interface>addAll(c_and_i.interfaces, _requiredInterfaces);
    c_and_i.components.add(component);
    final Function1<Interface, EList<Component>> _function = (Interface it) -> {
      return it.getRequiredBy();
    };
    Iterable<Component> _flatMap = IterableExtensions.<Interface, Component>flatMap(component.getProvidedInterfaces(), _function);
    Iterables.<Component>addAll(c_and_i.components, _flatMap);
    final Function1<Interface, EList<Component>> _function_1 = (Interface it) -> {
      return it.getProvidedBy();
    };
    Iterable<Component> _flatMap_1 = IterableExtensions.<Interface, Component>flatMap(component.getRequiredInterfaces(), _function_1);
    Iterables.<Component>addAll(c_and_i.components, _flatMap_1);
  }
  
  private void _addComponentsAndInterfaces(final Interface _interface, final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i) {
    c_and_i.interfaces.add(_interface);
    EList<Component> _providedBy = _interface.getProvidedBy();
    Iterables.<Component>addAll(c_and_i.components, _providedBy);
    EList<Component> _requiredBy = _interface.getRequiredBy();
    Iterables.<Component>addAll(c_and_i.components, _requiredBy);
  }
  
  private void addComponentsAndInterfaces(final EObject component, final ComponentDiagramTextProvider.ComponentsAndInterfaces c_and_i) {
    if (component instanceof Component) {
      _addComponentsAndInterfaces((Component)component, c_and_i);
      return;
    } else if (component instanceof Interface) {
      _addComponentsAndInterfaces((Interface)component, c_and_i);
      return;
    } else if (component instanceof ExampleArchitecture) {
      _addComponentsAndInterfaces((ExampleArchitecture)component, c_and_i);
      return;
    } else if (component != null) {
      _addComponentsAndInterfaces(component, c_and_i);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(component, c_and_i).toString());
    }
  }
}
