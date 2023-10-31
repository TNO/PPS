/*
 * Generated by Xtext, all rights reserved ESI (TNO)
 */
package nl.esi.pps.tmsc.xtext.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import nl.esi.pps.tmsc.xtext.ide.contentassist.antlr.internal.InternalTmscXtextParser;
import nl.esi.pps.tmsc.xtext.services.TmscXtextGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class TmscXtextParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(TmscXtextGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, TmscXtextGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getTmscXtextModelAccess().getAlternatives_1(), "rule__TmscXtextModel__Alternatives_1");
			builder.put(grammarAccess.getTmscXtextModelAccess().getAlternatives_1_0_3(), "rule__TmscXtextModel__Alternatives_1_0_3");
			builder.put(grammarAccess.getXNamedArchitectureElementAccess().getAlternatives(), "rule__XNamedArchitectureElement__Alternatives");
			builder.put(grammarAccess.getXInterfaceAccess().getAlternatives_3_1(), "rule__XInterface__Alternatives_3_1");
			builder.put(grammarAccess.getXComponentAccess().getAlternatives_5_1(), "rule__XComponent__Alternatives_5_1");
			builder.put(grammarAccess.getXFunctionAccess().getAlternatives_0(), "rule__XFunction__Alternatives_0");
			builder.put(grammarAccess.getXFunctionAccess().getAlternatives_6_1(), "rule__XFunction__Alternatives_6_1");
			builder.put(grammarAccess.getXExecutorAccess().getAlternatives_4_1(), "rule__XExecutor__Alternatives_4_1");
			builder.put(grammarAccess.getXEventAccess().getTimestampAlternatives_0_0(), "rule__XEvent__TimestampAlternatives_0_0");
			builder.put(grammarAccess.getXEventAccess().getAlternatives_7(), "rule__XEvent__Alternatives_7");
			builder.put(grammarAccess.getXEventAccess().getAlternatives_8_1(), "rule__XEvent__Alternatives_8_1");
			builder.put(grammarAccess.getXDependencyAccess().getAlternatives_2(), "rule__XDependency__Alternatives_2");
			builder.put(grammarAccess.getXDependencyAccess().getAlternatives_2_1_1(), "rule__XDependency__Alternatives_2_1_1");
			builder.put(grammarAccess.getXDependencyAccess().getAlternatives_2_1_2_1(), "rule__XDependency__Alternatives_2_1_2_1");
			builder.put(grammarAccess.getXDependencySettingsAccess().getAlternatives_3(), "rule__XDependencySettings__Alternatives_3");
			builder.put(grammarAccess.getXPropertyValueAccess().getAlternatives(), "rule__XPropertyValue__Alternatives");
			builder.put(grammarAccess.getIDStringAccess().getAlternatives(), "rule__IDString__Alternatives");
			builder.put(grammarAccess.getEBOOLEAN_OBJECTAccess().getAlternatives(), "rule__EBOOLEAN_OBJECT__Alternatives");
			builder.put(grammarAccess.getEBIGDECIMALAccess().getAlternatives(), "rule__EBIGDECIMAL__Alternatives");
			builder.put(grammarAccess.getXArchitectureKindAccess().getAlternatives(), "rule__XArchitectureKind__Alternatives");
			builder.put(grammarAccess.getXFunctionParameterKindAccess().getAlternatives(), "rule__XFunctionParameterKind__Alternatives");
			builder.put(grammarAccess.getXEventTypeAccess().getAlternatives(), "rule__XEventType__Alternatives");
			builder.put(grammarAccess.getXDependencyTypeAccess().getAlternatives(), "rule__XDependencyType__Alternatives");
			builder.put(grammarAccess.getTmscXtextModelAccess().getGroup(), "rule__TmscXtextModel__Group__0");
			builder.put(grammarAccess.getTmscXtextModelAccess().getGroup_1_0(), "rule__TmscXtextModel__Group_1_0__0");
			builder.put(grammarAccess.getTmscXtextModelAccess().getGroup_1_0_3_0(), "rule__TmscXtextModel__Group_1_0_3_0__0");
			builder.put(grammarAccess.getTmscXtextModelAccess().getGroup_1_0_3_1(), "rule__TmscXtextModel__Group_1_0_3_1__0");
			builder.put(grammarAccess.getTmscXtextModelAccess().getGroup_1_0_3_2(), "rule__TmscXtextModel__Group_1_0_3_2__0");
			builder.put(grammarAccess.getXInterfaceAccess().getGroup(), "rule__XInterface__Group__0");
			builder.put(grammarAccess.getXInterfaceAccess().getGroup_1(), "rule__XInterface__Group_1__0");
			builder.put(grammarAccess.getXInterfaceAccess().getGroup_3(), "rule__XInterface__Group_3__0");
			builder.put(grammarAccess.getXOperationAccess().getGroup(), "rule__XOperation__Group__0");
			builder.put(grammarAccess.getXOperationAccess().getGroup_1(), "rule__XOperation__Group_1__0");
			builder.put(grammarAccess.getXOperationAccess().getGroup_3(), "rule__XOperation__Group_3__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup(), "rule__XComponent__Group__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_1(), "rule__XComponent__Group_1__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_3(), "rule__XComponent__Group_3__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_3_2(), "rule__XComponent__Group_3_2__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_4(), "rule__XComponent__Group_4__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_4_2(), "rule__XComponent__Group_4_2__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_5(), "rule__XComponent__Group_5__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_5_1_0(), "rule__XComponent__Group_5_1_0__0");
			builder.put(grammarAccess.getXComponentAccess().getGroup_5_1_1(), "rule__XComponent__Group_5_1_1__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup(), "rule__XFunction__Group__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_2(), "rule__XFunction__Group_2__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_4(), "rule__XFunction__Group_4__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_4_2(), "rule__XFunction__Group_4_2__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_5(), "rule__XFunction__Group_5__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_6(), "rule__XFunction__Group_6__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_6_1_0(), "rule__XFunction__Group_6_1_0__0");
			builder.put(grammarAccess.getXFunctionAccess().getGroup_6_1_1(), "rule__XFunction__Group_6_1_1__0");
			builder.put(grammarAccess.getXFunctionParameterAccess().getGroup(), "rule__XFunctionParameter__Group__0");
			builder.put(grammarAccess.getXFunctionParameterAccess().getGroup_2(), "rule__XFunctionParameter__Group_2__0");
			builder.put(grammarAccess.getXFunctionParameterAccess().getGroup_2_2(), "rule__XFunctionParameter__Group_2_2__0");
			builder.put(grammarAccess.getXExecutorAccess().getGroup(), "rule__XExecutor__Group__0");
			builder.put(grammarAccess.getXExecutorAccess().getGroup_2(), "rule__XExecutor__Group_2__0");
			builder.put(grammarAccess.getXExecutorAccess().getGroup_4(), "rule__XExecutor__Group_4__0");
			builder.put(grammarAccess.getXExecutorAccess().getGroup_4_1_0(), "rule__XExecutor__Group_4_1_0__0");
			builder.put(grammarAccess.getXExecutorAccess().getGroup_4_1_1(), "rule__XExecutor__Group_4_1_1__0");
			builder.put(grammarAccess.getXEventAccess().getGroup(), "rule__XEvent__Group__0");
			builder.put(grammarAccess.getXEventAccess().getGroup_6(), "rule__XEvent__Group_6__0");
			builder.put(grammarAccess.getXEventAccess().getGroup_6_2(), "rule__XEvent__Group_6_2__0");
			builder.put(grammarAccess.getXEventAccess().getGroup_7_0(), "rule__XEvent__Group_7_0__0");
			builder.put(grammarAccess.getXEventAccess().getGroup_7_1(), "rule__XEvent__Group_7_1__0");
			builder.put(grammarAccess.getXEventAccess().getGroup_8(), "rule__XEvent__Group_8__0");
			builder.put(grammarAccess.getXEventAccess().getGroup_8_1_0(), "rule__XEvent__Group_8_1_0__0");
			builder.put(grammarAccess.getXEventArgumentAccess().getGroup(), "rule__XEventArgument__Group__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup(), "rule__XDependency__Group__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_0(), "rule__XDependency__Group_2_0__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1(), "rule__XDependency__Group_2_1__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_1_0(), "rule__XDependency__Group_2_1_1_0__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_1_1(), "rule__XDependency__Group_2_1_1_1__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_1_2(), "rule__XDependency__Group_2_1_1_2__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_1_3(), "rule__XDependency__Group_2_1_1_3__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_2(), "rule__XDependency__Group_2_1_2__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_2_1_0(), "rule__XDependency__Group_2_1_2_1_0__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_2_1_1(), "rule__XDependency__Group_2_1_2_1_1__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_2_1_2(), "rule__XDependency__Group_2_1_2_1_2__0");
			builder.put(grammarAccess.getXDependencyAccess().getGroup_2_1_2_1_3(), "rule__XDependency__Group_2_1_2_1_3__0");
			builder.put(grammarAccess.getXDependencySettingsAccess().getGroup(), "rule__XDependencySettings__Group__0");
			builder.put(grammarAccess.getXDependencySettingsAccess().getGroup_3_0(), "rule__XDependencySettings__Group_3_0__0");
			builder.put(grammarAccess.getXDependencySettingsAccess().getGroup_3_1(), "rule__XDependencySettings__Group_3_1__0");
			builder.put(grammarAccess.getXDependencySettingsAccess().getGroup_3_2(), "rule__XDependencySettings__Group_3_2__0");
			builder.put(grammarAccess.getXPropertyAccess().getGroup(), "rule__XProperty__Group__0");
			builder.put(grammarAccess.getXPropertyValueAccess().getGroup_0(), "rule__XPropertyValue__Group_0__0");
			builder.put(grammarAccess.getXPropertyValueAccess().getGroup_1(), "rule__XPropertyValue__Group_1__0");
			builder.put(grammarAccess.getXPropertyValueAccess().getGroup_2(), "rule__XPropertyValue__Group_2__0");
			builder.put(grammarAccess.getXPropertyValueAccess().getGroup_3(), "rule__XPropertyValue__Group_3__0");
			builder.put(grammarAccess.getXPropertyValueAccess().getGroup_3_3(), "rule__XPropertyValue__Group_3_3__0");
			builder.put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
			builder.put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
			builder.put(grammarAccess.getTmscXtextModelAccess().getArchitectureKindAssignment_1_0_3_0_2(), "rule__TmscXtextModel__ArchitectureKindAssignment_1_0_3_0_2");
			builder.put(grammarAccess.getTmscXtextModelAccess().getTimeBoundAssignment_1_0_3_1_2(), "rule__TmscXtextModel__TimeBoundAssignment_1_0_3_1_2");
			builder.put(grammarAccess.getTmscXtextModelAccess().getScheduledAssignment_1_0_3_2_2(), "rule__TmscXtextModel__ScheduledAssignment_1_0_3_2_2");
			builder.put(grammarAccess.getTmscXtextModelAccess().getPropertiesAssignment_1_0_3_3(), "rule__TmscXtextModel__PropertiesAssignment_1_0_3_3");
			builder.put(grammarAccess.getTmscXtextModelAccess().getDependencySettingsAssignment_1_1(), "rule__TmscXtextModel__DependencySettingsAssignment_1_1");
			builder.put(grammarAccess.getTmscXtextModelAccess().getInterfacesAssignment_1_2(), "rule__TmscXtextModel__InterfacesAssignment_1_2");
			builder.put(grammarAccess.getTmscXtextModelAccess().getComponentsAssignment_1_3(), "rule__TmscXtextModel__ComponentsAssignment_1_3");
			builder.put(grammarAccess.getTmscXtextModelAccess().getFunctionsAssignment_1_4(), "rule__TmscXtextModel__FunctionsAssignment_1_4");
			builder.put(grammarAccess.getTmscXtextModelAccess().getExecutorsAssignment_1_5(), "rule__TmscXtextModel__ExecutorsAssignment_1_5");
			builder.put(grammarAccess.getTmscXtextModelAccess().getEventsAssignment_1_6(), "rule__TmscXtextModel__EventsAssignment_1_6");
			builder.put(grammarAccess.getXInterfaceAccess().getDescriptionAssignment_1_0(), "rule__XInterface__DescriptionAssignment_1_0");
			builder.put(grammarAccess.getXInterfaceAccess().getNameAssignment_2(), "rule__XInterface__NameAssignment_2");
			builder.put(grammarAccess.getXInterfaceAccess().getPropertiesAssignment_3_1_0(), "rule__XInterface__PropertiesAssignment_3_1_0");
			builder.put(grammarAccess.getXInterfaceAccess().getOperationsAssignment_3_1_1(), "rule__XInterface__OperationsAssignment_3_1_1");
			builder.put(grammarAccess.getXOperationAccess().getDescriptionAssignment_1_0(), "rule__XOperation__DescriptionAssignment_1_0");
			builder.put(grammarAccess.getXOperationAccess().getNameAssignment_2(), "rule__XOperation__NameAssignment_2");
			builder.put(grammarAccess.getXOperationAccess().getPropertiesAssignment_3_1(), "rule__XOperation__PropertiesAssignment_3_1");
			builder.put(grammarAccess.getXComponentAccess().getDescriptionAssignment_1_0(), "rule__XComponent__DescriptionAssignment_1_0");
			builder.put(grammarAccess.getXComponentAccess().getNameAssignment_2(), "rule__XComponent__NameAssignment_2");
			builder.put(grammarAccess.getXComponentAccess().getProvidesAssignment_3_1(), "rule__XComponent__ProvidesAssignment_3_1");
			builder.put(grammarAccess.getXComponentAccess().getProvidesAssignment_3_2_1(), "rule__XComponent__ProvidesAssignment_3_2_1");
			builder.put(grammarAccess.getXComponentAccess().getRequiresAssignment_4_1(), "rule__XComponent__RequiresAssignment_4_1");
			builder.put(grammarAccess.getXComponentAccess().getRequiresAssignment_4_2_1(), "rule__XComponent__RequiresAssignment_4_2_1");
			builder.put(grammarAccess.getXComponentAccess().getTimeBoundAssignment_5_1_0_2(), "rule__XComponent__TimeBoundAssignment_5_1_0_2");
			builder.put(grammarAccess.getXComponentAccess().getScheduledAssignment_5_1_1_2(), "rule__XComponent__ScheduledAssignment_5_1_1_2");
			builder.put(grammarAccess.getXComponentAccess().getPropertiesAssignment_5_1_2(), "rule__XComponent__PropertiesAssignment_5_1_2");
			builder.put(grammarAccess.getXFunctionAccess().getIpcClientAssignment_0_0(), "rule__XFunction__IpcClientAssignment_0_0");
			builder.put(grammarAccess.getXFunctionAccess().getIpcServerAssignment_0_1(), "rule__XFunction__IpcServerAssignment_0_1");
			builder.put(grammarAccess.getXFunctionAccess().getDescriptionAssignment_2_0(), "rule__XFunction__DescriptionAssignment_2_0");
			builder.put(grammarAccess.getXFunctionAccess().getNameAssignment_3(), "rule__XFunction__NameAssignment_3");
			builder.put(grammarAccess.getXFunctionAccess().getParametersAssignment_4_1(), "rule__XFunction__ParametersAssignment_4_1");
			builder.put(grammarAccess.getXFunctionAccess().getParametersAssignment_4_2_1(), "rule__XFunction__ParametersAssignment_4_2_1");
			builder.put(grammarAccess.getXFunctionAccess().getOperationAssignment_5_1(), "rule__XFunction__OperationAssignment_5_1");
			builder.put(grammarAccess.getXFunctionAccess().getTimeBoundAssignment_6_1_0_2(), "rule__XFunction__TimeBoundAssignment_6_1_0_2");
			builder.put(grammarAccess.getXFunctionAccess().getScheduledAssignment_6_1_1_2(), "rule__XFunction__ScheduledAssignment_6_1_1_2");
			builder.put(grammarAccess.getXFunctionAccess().getPropertiesAssignment_6_1_2(), "rule__XFunction__PropertiesAssignment_6_1_2");
			builder.put(grammarAccess.getXFunctionParameterAccess().getKindAssignment_0(), "rule__XFunctionParameter__KindAssignment_0");
			builder.put(grammarAccess.getXFunctionParameterAccess().getNameAssignment_1(), "rule__XFunctionParameter__NameAssignment_1");
			builder.put(grammarAccess.getXFunctionParameterAccess().getPropertiesAssignment_2_1(), "rule__XFunctionParameter__PropertiesAssignment_2_1");
			builder.put(grammarAccess.getXFunctionParameterAccess().getPropertiesAssignment_2_2_1(), "rule__XFunctionParameter__PropertiesAssignment_2_2_1");
			builder.put(grammarAccess.getXExecutorAccess().getUntracedAssignment_0(), "rule__XExecutor__UntracedAssignment_0");
			builder.put(grammarAccess.getXExecutorAccess().getDescriptionAssignment_2_0(), "rule__XExecutor__DescriptionAssignment_2_0");
			builder.put(grammarAccess.getXExecutorAccess().getNameAssignment_3(), "rule__XExecutor__NameAssignment_3");
			builder.put(grammarAccess.getXExecutorAccess().getTimeBoundAssignment_4_1_0_2(), "rule__XExecutor__TimeBoundAssignment_4_1_0_2");
			builder.put(grammarAccess.getXExecutorAccess().getScheduledAssignment_4_1_1_2(), "rule__XExecutor__ScheduledAssignment_4_1_1_2");
			builder.put(grammarAccess.getXExecutorAccess().getPropertiesAssignment_4_1_2(), "rule__XExecutor__PropertiesAssignment_4_1_2");
			builder.put(grammarAccess.getXEventAccess().getTimestampAssignment_0(), "rule__XEvent__TimestampAssignment_0");
			builder.put(grammarAccess.getXEventAccess().getTimeBoundAssignment_1(), "rule__XEvent__TimeBoundAssignment_1");
			builder.put(grammarAccess.getXEventAccess().getExecutorAssignment_2(), "rule__XEvent__ExecutorAssignment_2");
			builder.put(grammarAccess.getXEventAccess().getComponentAssignment_3(), "rule__XEvent__ComponentAssignment_3");
			builder.put(grammarAccess.getXEventAccess().getTypeAssignment_4(), "rule__XEvent__TypeAssignment_4");
			builder.put(grammarAccess.getXEventAccess().getFunctionAssignment_5(), "rule__XEvent__FunctionAssignment_5");
			builder.put(grammarAccess.getXEventAccess().getArgumentsAssignment_6_1(), "rule__XEvent__ArgumentsAssignment_6_1");
			builder.put(grammarAccess.getXEventAccess().getArgumentsAssignment_6_2_1(), "rule__XEvent__ArgumentsAssignment_6_2_1");
			builder.put(grammarAccess.getXEventAccess().getOutgoingDependenciesAssignment_7_0_1(), "rule__XEvent__OutgoingDependenciesAssignment_7_0_1");
			builder.put(grammarAccess.getXEventAccess().getIncomingDependenciesAssignment_7_1_1(), "rule__XEvent__IncomingDependenciesAssignment_7_1_1");
			builder.put(grammarAccess.getXEventAccess().getScheduledAssignment_8_1_0_2(), "rule__XEvent__ScheduledAssignment_8_1_0_2");
			builder.put(grammarAccess.getXEventAccess().getPropertiesAssignment_8_1_1(), "rule__XEvent__PropertiesAssignment_8_1_1");
			builder.put(grammarAccess.getXEventArgumentAccess().getParameterAssignment_0(), "rule__XEventArgument__ParameterAssignment_0");
			builder.put(grammarAccess.getXEventArgumentAccess().getValueAssignment_2(), "rule__XEventArgument__ValueAssignment_2");
			builder.put(grammarAccess.getXDependencyAccess().getTypeObjectAssignment_0(), "rule__XDependency__TypeObjectAssignment_0");
			builder.put(grammarAccess.getXDependencyAccess().getNameAssignment_1(), "rule__XDependency__NameAssignment_1");
			builder.put(grammarAccess.getXDependencyAccess().getTimeBoundAssignment_2_0_1(), "rule__XDependency__TimeBoundAssignment_2_0_1");
			builder.put(grammarAccess.getXDependencyAccess().getTimeBoundAssignment_2_1_1_0_2(), "rule__XDependency__TimeBoundAssignment_2_1_1_0_2");
			builder.put(grammarAccess.getXDependencyAccess().getScheduledAssignment_2_1_1_1_2(), "rule__XDependency__ScheduledAssignment_2_1_1_1_2");
			builder.put(grammarAccess.getXDependencyAccess().getRequestAssignment_2_1_1_2_2(), "rule__XDependency__RequestAssignment_2_1_1_2_2");
			builder.put(grammarAccess.getXDependencyAccess().getMessageAssignment_2_1_1_3_2(), "rule__XDependency__MessageAssignment_2_1_1_3_2");
			builder.put(grammarAccess.getXDependencyAccess().getPropertiesAssignment_2_1_1_4(), "rule__XDependency__PropertiesAssignment_2_1_1_4");
			builder.put(grammarAccess.getXDependencyAccess().getTimeBoundAssignment_2_1_2_1_0_2(), "rule__XDependency__TimeBoundAssignment_2_1_2_1_0_2");
			builder.put(grammarAccess.getXDependencyAccess().getScheduledAssignment_2_1_2_1_1_2(), "rule__XDependency__ScheduledAssignment_2_1_2_1_1_2");
			builder.put(grammarAccess.getXDependencyAccess().getRequestAssignment_2_1_2_1_2_2(), "rule__XDependency__RequestAssignment_2_1_2_1_2_2");
			builder.put(grammarAccess.getXDependencyAccess().getMessageAssignment_2_1_2_1_3_2(), "rule__XDependency__MessageAssignment_2_1_2_1_3_2");
			builder.put(grammarAccess.getXDependencyAccess().getPropertiesAssignment_2_1_2_1_4(), "rule__XDependency__PropertiesAssignment_2_1_2_1_4");
			builder.put(grammarAccess.getXDependencyTypeObjectAccess().getValueAssignment(), "rule__XDependencyTypeObject__ValueAssignment");
			builder.put(grammarAccess.getXDependencySettingsAccess().getTypeAssignment_0(), "rule__XDependencySettings__TypeAssignment_0");
			builder.put(grammarAccess.getXDependencySettingsAccess().getTimeBoundAssignment_3_0_2(), "rule__XDependencySettings__TimeBoundAssignment_3_0_2");
			builder.put(grammarAccess.getXDependencySettingsAccess().getScheduledAssignment_3_1_2(), "rule__XDependencySettings__ScheduledAssignment_3_1_2");
			builder.put(grammarAccess.getXDependencySettingsAccess().getPrefixAssignment_3_2_2(), "rule__XDependencySettings__PrefixAssignment_3_2_2");
			builder.put(grammarAccess.getXDependencySettingsAccess().getPropertiesAssignment_3_3(), "rule__XDependencySettings__PropertiesAssignment_3_3");
			builder.put(grammarAccess.getXPropertyAccess().getNameAssignment_0(), "rule__XProperty__NameAssignment_0");
			builder.put(grammarAccess.getXPropertyAccess().getValueAssignment_2(), "rule__XProperty__ValueAssignment_2");
			builder.put(grammarAccess.getXPropertyValueAccess().getValueAssignment_0_1(), "rule__XPropertyValue__ValueAssignment_0_1");
			builder.put(grammarAccess.getXPropertyValueAccess().getValueAssignment_1_1(), "rule__XPropertyValue__ValueAssignment_1_1");
			builder.put(grammarAccess.getXPropertyValueAccess().getValueAssignment_2_1(), "rule__XPropertyValue__ValueAssignment_2_1");
			builder.put(grammarAccess.getXPropertyValueAccess().getValuesAssignment_3_2(), "rule__XPropertyValue__ValuesAssignment_3_2");
			builder.put(grammarAccess.getXPropertyValueAccess().getValuesAssignment_3_3_1(), "rule__XPropertyValue__ValuesAssignment_3_3_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private TmscXtextGrammarAccess grammarAccess;

	@Override
	protected InternalTmscXtextParser createParser() {
		InternalTmscXtextParser result = new InternalTmscXtextParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public TmscXtextGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(TmscXtextGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
