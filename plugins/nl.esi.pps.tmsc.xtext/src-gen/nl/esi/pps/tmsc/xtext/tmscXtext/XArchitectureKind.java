/**
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.tmscXtext;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>XArchitecture Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.tmsc.xtext.tmscXtext.TmscXtextPackage#getXArchitectureKind()
 * @model
 * @generated
 */
public enum XArchitectureKind implements Enumerator
{
  /**
   * The '<em><b>INTERNAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTERNAL_VALUE
   * @generated
   * @ordered
   */
  INTERNAL(0, "INTERNAL", "internal"),

  /**
   * The '<em><b>EXTERNAL</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXTERNAL_VALUE
   * @generated
   * @ordered
   */
  EXTERNAL(1, "EXTERNAL", "external");

  /**
   * The '<em><b>INTERNAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INTERNAL
   * @model literal="internal"
   * @generated
   * @ordered
   */
  public static final int INTERNAL_VALUE = 0;

  /**
   * The '<em><b>EXTERNAL</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #EXTERNAL
   * @model literal="external"
   * @generated
   * @ordered
   */
  public static final int EXTERNAL_VALUE = 1;

  /**
   * An array of all the '<em><b>XArchitecture Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final XArchitectureKind[] VALUES_ARRAY =
    new XArchitectureKind[]
    {
      INTERNAL,
      EXTERNAL,
    };

  /**
   * A public read-only list of all the '<em><b>XArchitecture Kind</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<XArchitectureKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>XArchitecture Kind</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static XArchitectureKind get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      XArchitectureKind result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>XArchitecture Kind</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static XArchitectureKind getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      XArchitectureKind result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>XArchitecture Kind</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static XArchitectureKind get(int value)
  {
    switch (value)
    {
      case INTERNAL_VALUE: return INTERNAL;
      case EXTERNAL_VALUE: return EXTERNAL;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private XArchitectureKind(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //XArchitectureKind
