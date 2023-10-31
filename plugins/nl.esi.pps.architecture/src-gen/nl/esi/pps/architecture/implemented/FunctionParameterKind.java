/**
 */
package nl.esi.pps.architecture.implemented;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Function Parameter Kind</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see nl.esi.pps.architecture.implemented.ImplementedPackage#getFunctionParameterKind()
 * @model
 * @generated
 */
public enum FunctionParameterKind implements Enumerator {
	/**
	 * The '<em><b>IN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_VALUE
	 * @generated
	 * @ordered
	 */
	IN(0, "IN", "in"),

	/**
	 * The '<em><b>OUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT_VALUE
	 * @generated
	 * @ordered
	 */
	OUT(1, "OUT", "out"),

	/**
	 * The '<em><b>IN OUT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_OUT_VALUE
	 * @generated
	 * @ordered
	 */
	IN_OUT(2, "IN_OUT", "inout"),

	/**
	 * The '<em><b>RETURN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN_VALUE
	 * @generated
	 * @ordered
	 */
	RETURN(3, "RETURN", "return");

	/**
	 * The '<em><b>IN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN
	 * @model literal="in"
	 * @generated
	 * @ordered
	 */
	public static final int IN_VALUE = 0;

	/**
	 * The '<em><b>OUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OUT
	 * @model literal="out"
	 * @generated
	 * @ordered
	 */
	public static final int OUT_VALUE = 1;

	/**
	 * The '<em><b>IN OUT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IN_OUT
	 * @model literal="inout"
	 * @generated
	 * @ordered
	 */
	public static final int IN_OUT_VALUE = 2;

	/**
	 * The '<em><b>RETURN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RETURN
	 * @model literal="return"
	 * @generated
	 * @ordered
	 */
	public static final int RETURN_VALUE = 3;

	/**
	 * An array of all the '<em><b>Function Parameter Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final FunctionParameterKind[] VALUES_ARRAY = new FunctionParameterKind[] { IN, OUT, IN_OUT,
			RETURN, };

	/**
	 * A public read-only list of all the '<em><b>Function Parameter Kind</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<FunctionParameterKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Function Parameter Kind</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FunctionParameterKind get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionParameterKind result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function Parameter Kind</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FunctionParameterKind getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			FunctionParameterKind result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Function Parameter Kind</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static FunctionParameterKind get(int value) {
		switch (value) {
		case IN_VALUE:
			return IN;
		case OUT_VALUE:
			return OUT;
		case IN_OUT_VALUE:
			return IN_OUT;
		case RETURN_VALUE:
			return RETURN;
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
	private FunctionParameterKind(int value, String name, String literal) {
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
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} //FunctionParameterKind
