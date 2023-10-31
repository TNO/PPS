/////////////////////////////////////////////////////////////////////////
// Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
//
// This program and the accompanying materials are made available
// under the terms of the MIT License which is available at
// https://opensource.org/licenses/MIT
//
// SPDX-License-Identifier: MIT
/////////////////////////////////////////////////////////////////////////

package nl.esi.emf.properties.xtend;

import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Collection;
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor;
import org.eclipse.xtend.lib.macro.TransformationContext;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class PersistedPropertyCompilationParticipant extends AbstractFieldProcessor {
  @Override
  public void doTransform(final MutableFieldDeclaration field, @Extension final TransformationContext context) {
    final AnnotationReference _annotation = field.findAnnotation(context.findTypeGlobally(PersistedProperty.class));
    final TypeReference[] containerTypes = _annotation.getClassArrayValue("value");
    final boolean unsettable = _annotation.getBooleanValue("unsettable");
    final boolean mutable = _annotation.getBooleanValue("mutable");
    final String category = _annotation.getStringValue("category");
    final TypeReference categoryProvider = _annotation.getClassValue("categoryProvider");
    boolean _isInferred = field.getType().isInferred();
    if (_isInferred) {
      context.addError(field, "Type inference is not supported by @PersistedProperty");
      return;
    } else {
      boolean _isAssignableFrom = context.findTypeGlobally(Serializable.class).isAssignableFrom(field.getType().getType());
      boolean _not = (!_isAssignableFrom);
      if (_not) {
        context.addError(field, "@PersistedProperty should be of type java.io.Serializable");
        return;
      } else {
        if (((field.getInitializer() == null) && field.getType().isPrimitive())) {
          context.addError(field, "Initializer is required for primitive @PersistedProperty");
          return;
        } else {
          if (((field.getInitializer() == null) && mutable)) {
            context.addError(field, "Initializer is required for mutable @PersistedProperty");
            return;
          }
        }
      }
    }
    if ((((field.getInitializer() != null) && (!mutable)) && context.findTypeGlobally(Collection.class).isAssignableFrom(field.getType().getType()))) {
      context.addWarning(field, "Typically, mutable should be set to true for collections");
    }
    TypeReference _xifexpression = null;
    Type _type = categoryProvider.getType();
    Type _findTypeGlobally = context.findTypeGlobally(DefaultCategoryProvider.class);
    boolean _notEquals = (!Objects.equal(_type, _findTypeGlobally));
    if (_notEquals) {
      TypeReference _xblockexpression = null;
      {
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(category);
        boolean _not_1 = (!_isNullOrEmpty);
        if (_not_1) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Either categoryProvider or category can be set, not both.");
          context.addError(field, _builder.toString());
          return;
        }
        final Function1<ResolvedMethod, MethodDeclaration> _function = (ResolvedMethod it) -> {
          return it.getDeclaration();
        };
        final Function1<MethodDeclaration, Boolean> _function_1 = (MethodDeclaration it) -> {
          return Boolean.valueOf((Objects.equal(it.getSimpleName(), "getCategory") && (IterableExtensions.size(it.getParameters()) == 1)));
        };
        final MethodDeclaration categoryMethod = IterableExtensions.<MethodDeclaration>findFirst(IterableExtensions.map(categoryProvider.getAllResolvedMethods(), _function), _function_1);
        if ((categoryMethod == null)) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("The categoryProvider class ");
          String _qualifiedName = categoryProvider.getType().getQualifiedName();
          _builder_1.append(_qualifiedName);
          _builder_1.append(" does not declare method getCategory(T).");
          context.addError(field, _builder_1.toString());
          return;
        }
        _xblockexpression = IterableExtensions.head(categoryMethod.getParameters()).getType();
      }
      _xifexpression = _xblockexpression;
    }
    final TypeReference contextParameterType = _xifexpression;
    final String propertyName = field.getSimpleName();
    final TypeReference propertyType = field.getType();
    MutableMemberDeclaration _switchResult = null;
    boolean _matched = false;
    if (((field.getInitializer() != null) && (!mutable))) {
      _matched=true;
      MutableTypeDeclaration _declaringType = field.getDeclaringType();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("_DEFAULT");
      {
        for(final TypeReference type : containerTypes) {
          _builder.append("_");
          String _upperCase = type.getSimpleName().toUpperCase();
          _builder.append(_upperCase);
        }
      }
      _builder.append("_");
      String _upperCase_1 = propertyName.toUpperCase();
      _builder.append(_upperCase_1);
      final Procedure1<MutableFieldDeclaration> _function = (MutableFieldDeclaration it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Default value for persisted {@code ");
        _builder_1.append(propertyName);
        _builder_1.append("} property on ");
        {
          boolean _hasElements = false;
          for(final TypeReference type_1 : containerTypes) {
            if (!_hasElements) {
              _hasElements = true;
            } else {
              _builder_1.appendImmediate(", ", "");
            }
            String _simpleName = type_1.getSimpleName();
            _builder_1.append(_simpleName);
          }
        }
        it.setDocComment(_builder_1.toString());
        it.setVisibility(Visibility.PRIVATE);
        it.setStatic(true);
        it.setFinal(true);
        it.setType(propertyType);
        it.setInitializer(field.getInitializer());
      };
      _switchResult = _declaringType.addField(_builder.toString(), _function);
    }
    if (!_matched) {
      if (((field.getInitializer() != null) && mutable)) {
        _matched=true;
        MutableTypeDeclaration _declaringType_1 = field.getDeclaringType();
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("_getInitial");
        {
          for(final TypeReference type_1 : containerTypes) {
            _builder_1.append("_");
            String _simpleName = type_1.getSimpleName();
            _builder_1.append(_simpleName);
          }
        }
        _builder_1.append("_");
        String _firstUpper = StringExtensions.toFirstUpper(propertyName);
        _builder_1.append(_firstUpper);
        final Procedure1<MutableMethodDeclaration> _function_1 = (MutableMethodDeclaration it) -> {
          StringConcatenation _builder_2 = new StringConcatenation();
          _builder_2.append("Creates initial value for persisted {@code ");
          _builder_2.append(propertyName);
          _builder_2.append("} property on ");
          {
            boolean _hasElements = false;
            for(final TypeReference type_2 : containerTypes) {
              if (!_hasElements) {
                _hasElements = true;
              } else {
                _builder_2.appendImmediate(", ", "");
              }
              String _simpleName_1 = type_2.getSimpleName();
              _builder_2.append(_simpleName_1);
            }
          }
          it.setDocComment(_builder_2.toString());
          it.setVisibility(Visibility.PRIVATE);
          it.setStatic(true);
          it.setFinal(true);
          it.setReturnType(propertyType);
          it.setBody(field.getInitializer());
        };
        _switchResult = _declaringType_1.addMethod(_builder_1.toString(), _function_1);
      }
    }
    final MutableMemberDeclaration propertyDefault = _switchResult;
    String _switchResult_1 = null;
    boolean _matched_1 = false;
    if ((contextParameterType != null)) {
      _matched_1=true;
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("final String category = new ");
      String _qualifiedName = categoryProvider.getType().getQualifiedName();
      _builder_2.append(_qualifiedName);
      _builder_2.append("().getCategory(context);");
      _builder_2.newLineIfNotEmpty();
      _builder_2.append("final String key = org.eclipse.xtext.xbase.lib.StringExtensions.isNullOrEmpty(category) ? ");
      _builder_2.newLine();
      _builder_2.append("        ");
      _builder_2.append("\"");
      _builder_2.append(propertyName, "        ");
      _builder_2.append("\" : category + \"/");
      _builder_2.append(propertyName, "        ");
      _builder_2.append("\";");
      _builder_2.newLineIfNotEmpty();
      _switchResult_1 = _builder_2.toString();
    }
    if (!_matched_1) {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(category);
      boolean _not_1 = (!_isNullOrEmpty);
      if (_not_1) {
        _matched_1=true;
        StringConcatenation _builder_3 = new StringConcatenation();
        _builder_3.append("final String key = \"");
        _builder_3.append(category);
        _builder_3.append("/");
        _builder_3.append(propertyName);
        _builder_3.append("\";");
        _switchResult_1 = _builder_3.toString();
      }
    }
    if (!_matched_1) {
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("final String key = \"");
      _builder_4.append(propertyName);
      _builder_4.append("\";");
      _switchResult_1 = _builder_4.toString();
    }
    final String propertyKeyInitializer = _switchResult_1;
    String _switchResult_2 = null;
    Type _type_1 = propertyType.getType();
    boolean _matched_2 = false;
    Type _findTypeGlobally_1 = context.findTypeGlobally(Boolean.class);
    if (Objects.equal(_type_1, _findTypeGlobally_1)) {
      _matched_2=true;
    }
    if (!_matched_2) {
      Type _findTypeGlobally_2 = context.findTypeGlobally(boolean.class);
      if (Objects.equal(_type_1, _findTypeGlobally_2)) {
        _matched_2=true;
      }
    }
    if (_matched_2) {
      _switchResult_2 = "is";
    }
    if (!_matched_2) {
      _switchResult_2 = "get";
    }
    final String getterPrefix = _switchResult_2;
    for (final TypeReference containerType : containerTypes) {
      {
        MutableTypeDeclaration _declaringType_2 = field.getDeclaringType();
        String _firstUpper_1 = StringExtensions.toFirstUpper(propertyName);
        String _plus = (getterPrefix + _firstUpper_1);
        final Procedure1<MutableMethodDeclaration> _function_2 = (MutableMethodDeclaration it) -> {
          it.setDocComment(field.getDocComment());
          it.setVisibility(field.getVisibility());
          it.setStatic(field.isStatic());
          it.setReturnType(propertyType);
          it.addParameter("container", containerType);
          if ((contextParameterType != null)) {
            it.addParameter("context", contextParameterType);
          }
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(propertyKeyInitializer);
              _builder.newLineIfNotEmpty();
              {
                if (mutable) {
                  _builder.append("final Object value = container.getProperties().map().computeIfAbsent(key, k -> ");
                  String _simpleName = propertyDefault.getSimpleName();
                  _builder.append(_simpleName);
                  _builder.append("());");
                  _builder.newLineIfNotEmpty();
                } else {
                  _builder.append("final Object value = container.getProperties().get(key);");
                  _builder.newLine();
                  {
                    if ((propertyDefault != null)) {
                      _builder.append("if (value == null) {");
                      _builder.newLine();
                      _builder.append("    ");
                      _builder.append("return ");
                      String _simpleName_1 = propertyDefault.getSimpleName();
                      _builder.append(_simpleName_1, "    ");
                      _builder.append(";");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                    }
                  }
                }
              }
              _builder.append("return (");
              _builder.append(propertyType);
              _builder.append(") value;");
              _builder.newLineIfNotEmpty();
            }
          };
          it.setBody(_client);
        };
        _declaringType_2.addMethod(_plus, _function_2);
        MutableTypeDeclaration _declaringType_3 = field.getDeclaringType();
        String _firstUpper_2 = StringExtensions.toFirstUpper(propertyName);
        String _plus_1 = ("set" + _firstUpper_2);
        final Procedure1<MutableMethodDeclaration> _function_3 = (MutableMethodDeclaration it) -> {
          it.setDocComment(field.getDocComment());
          it.setVisibility(field.getVisibility());
          it.setStatic(field.isStatic());
          it.addParameter("container", containerType);
          it.addParameter("value", propertyType);
          if ((contextParameterType != null)) {
            it.addParameter("context", contextParameterType);
          }
          StringConcatenationClient _client = new StringConcatenationClient() {
            @Override
            protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
              _builder.append(propertyKeyInitializer);
              _builder.newLineIfNotEmpty();
              {
                if ((unsettable || mutable)) {
                  _builder.append("container.getProperties().put(key, value);");
                  _builder.newLine();
                } else {
                  {
                    if ((propertyDefault == null)) {
                      _builder.append("if (value == null) {");
                      _builder.newLine();
                    } else {
                      _builder.append("if (value == ");
                      String _simpleName = propertyDefault.getSimpleName();
                      _builder.append(_simpleName);
                      {
                        boolean _isPrimitive = propertyType.isPrimitive();
                        boolean _not = (!_isPrimitive);
                        if (_not) {
                          _builder.append(" || (value != null && ");
                          String _simpleName_1 = propertyDefault.getSimpleName();
                          _builder.append(_simpleName_1);
                          _builder.append(" != null && value.equals(");
                          String _simpleName_2 = propertyDefault.getSimpleName();
                          _builder.append(_simpleName_2);
                          _builder.append("))");
                        }
                      }
                      _builder.append(") {");
                      _builder.newLineIfNotEmpty();
                    }
                  }
                  _builder.append("container.getProperties().remove(key);");
                  _builder.newLine();
                  _builder.append("} else {");
                  _builder.newLine();
                  _builder.append("    ");
                  _builder.append("container.getProperties().put(key, value);");
                  _builder.newLine();
                  _builder.append("}");
                  _builder.newLine();
                }
              }
            }
          };
          it.setBody(_client);
        };
        _declaringType_3.addMethod(_plus_1, _function_3);
        if (unsettable) {
          MutableTypeDeclaration _declaringType_4 = field.getDeclaringType();
          String _firstUpper_3 = StringExtensions.toFirstUpper(propertyName);
          String _plus_2 = ("isSet" + _firstUpper_3);
          final Procedure1<MutableMethodDeclaration> _function_4 = (MutableMethodDeclaration it) -> {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("Returns whether the value of the \'{@link ");
            String _qualifiedName_1 = field.getDeclaringType().getQualifiedName();
            _builder_5.append(_qualifiedName_1);
            _builder_5.append("#");
            _builder_5.append(getterPrefix);
            String _firstUpper_4 = StringExtensions.toFirstUpper(propertyName);
            _builder_5.append(_firstUpper_4);
            _builder_5.append(" <em>");
            _builder_5.append(propertyName);
            _builder_5.append("</em>}\' property is set on {@code container}.");
            it.setDocComment(_builder_5.toString());
            it.setVisibility(field.getVisibility());
            it.setStatic(field.isStatic());
            it.setReturnType(context.newTypeReference(context.findTypeGlobally(boolean.class)));
            it.addParameter("container", containerType);
            if ((contextParameterType != null)) {
              it.addParameter("context", contextParameterType);
            }
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append(propertyKeyInitializer);
                _builder.newLineIfNotEmpty();
                _builder.append("return container.getProperties().containsKey(key);");
                _builder.newLine();
              }
            };
            it.setBody(_client);
          };
          _declaringType_4.addMethod(_plus_2, _function_4);
          MutableTypeDeclaration _declaringType_5 = field.getDeclaringType();
          String _firstUpper_4 = StringExtensions.toFirstUpper(propertyName);
          String _plus_3 = ("unset" + _firstUpper_4);
          final Procedure1<MutableMethodDeclaration> _function_5 = (MutableMethodDeclaration it) -> {
            StringConcatenation _builder_5 = new StringConcatenation();
            _builder_5.append("Unsets the value of the \'{@link ");
            String _qualifiedName_1 = field.getDeclaringType().getQualifiedName();
            _builder_5.append(_qualifiedName_1);
            _builder_5.append("#");
            _builder_5.append(getterPrefix);
            String _firstUpper_5 = StringExtensions.toFirstUpper(propertyName);
            _builder_5.append(_firstUpper_5);
            _builder_5.append(" <em>");
            _builder_5.append(propertyName);
            _builder_5.append("</em>}\' property on {@code container}.");
            it.setDocComment(_builder_5.toString());
            it.setVisibility(field.getVisibility());
            it.setStatic(field.isStatic());
            it.addParameter("container", containerType);
            if ((contextParameterType != null)) {
              it.addParameter("context", contextParameterType);
            }
            StringConcatenationClient _client = new StringConcatenationClient() {
              @Override
              protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
                _builder.append(propertyKeyInitializer);
                _builder.newLineIfNotEmpty();
                _builder.append("container.getProperties().remove(key);");
                _builder.newLine();
              }
            };
            it.setBody(_client);
          };
          _declaringType_5.addMethod(_plus_3, _function_5);
        }
      }
    }
    field.remove();
  }
}
