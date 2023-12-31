/*
 * Copyright (c) 2018-2023 TNO and Contributors to the GitHub community
 *
 * This program and the accompanying materials are made available
 * under the terms of the MIT License which is available at
 * https://opensource.org/licenses/MIT
 *
 * SPDX-License-Identifier: MIT
 */
package nl.esi.pps.tmsc.viewers.dataanalysis;

import static org.eclipse.swt.events.FocusListener.focusGainedAdapter;

import java.text.NumberFormat;
import java.text.ParseException;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.typed.BeanProperties;
import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.SelectObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.fieldassist.ControlDecorationSupport;
import org.eclipse.jface.databinding.swt.typed.WidgetProperties;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import nl.esi.pps.tmsc.presentation.TmscEditorPlugin;
import nl.esi.pps.tmsc.text.EDurationFormat;
import nl.esi.pps.tmsc.viewers.dataanalysis.DurationFilter.Technique;

/**
 * The contents of this class is mainly generated by <a href="https://www.eclipse.org/windowbuilder/">WindowBuilder</a>.
 * Please use context menu Open With -> WindowBuilder Editor.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class DurationFilterDialog extends Dialog {
	static final NumberFormat DOUBLE_FORMAT = NumberFormat.getNumberInstance();

	static {
		DOUBLE_FORMAT.setMaximumFractionDigits(9);
	}

	private final DurationFilter durationFilter;
	
	private DataBindingContext m_bindingContext;
	private Text txtSigma;
	private Text txtIQR;
	private Text txtMin;
	private Text txtMax;
	private Button btnRemoveOutliers;
	private Button btnInterquartileRange;
	private Button btnSigma;
	private Button btnRange;
	private Button btnNegate;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public DurationFilterDialog(Shell parentShell, DurationFilter durationFilter) {
		super(parentShell);
		this.durationFilter = durationFilter;
	}

	@Override
	protected void setShellStyle(int newShellStyle) {           
	    super.setShellStyle(SWT.CLOSE | SWT.MODELESS| SWT.BORDER | SWT.TITLE);
	    setBlockOnOpen(false);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Filter Outliers");
	}
	
	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		GridLayout gl_container = new GridLayout(5, false);
		gl_container.horizontalSpacing = 8;
		container.setLayout(gl_container);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		btnRemoveOutliers = new Button(container, SWT.CHECK);
		btnRemoveOutliers.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnRemoveOutliers.setText("Remove outliers");
		
		btnNegate = new Button(container, SWT.CHECK);
		btnNegate.setText("negate");
		btnNegate.setVisible(Boolean.getBoolean("T-iPPS.SHOW_DEBUG_TOOLS"));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 5, 1));
		
		btnInterquartileRange = new Button(container, SWT.RADIO);
		btnInterquartileRange.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnInterquartileRange.setText("Interquartile range");
		
		txtIQR = new Text(container, SWT.BORDER);
		txtIQR.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		txtIQR.addFocusListener(focusGainedAdapter(e -> durationFilter.setTechnique(Technique.INTERQUARTILE_RANGE)));
		
		btnSigma = new Button(container, SWT.RADIO);
		btnSigma.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		btnSigma.setText("Sigma test");
		
		txtSigma = new Text(container, SWT.BORDER);
		txtSigma.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		txtSigma.addFocusListener(focusGainedAdapter(e -> durationFilter.setTechnique(Technique.SIGMA)));
		
		btnRange = new Button(container, SWT.RADIO);
		btnRange.setText("Range");
		
		Label lblMin = new Label(container, SWT.NONE);
		lblMin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMin.setText("min:");
		
		txtMin = new Text(container, SWT.BORDER);
		txtMin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtMin.addFocusListener(focusGainedAdapter(e -> durationFilter.setTechnique(Technique.RANGE)));
		
		Label lblMax = new Label(container, SWT.NONE);
		lblMax.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMax.setText("max:");
		
		txtMax = new Text(container, SWT.BORDER);
		txtMax.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtMax.addFocusListener(focusGainedAdapter(e -> durationFilter.setTechnique(Technique.RANGE)));

		return area;
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.CLOSE_ID, IDialogConstants.CLOSE_LABEL, true);
		m_bindingContext = initDataBindings();
		initDataBindingsManual(m_bindingContext);
		parent.addDisposeListener(e -> m_bindingContext.dispose());
	}
	
	@Override
	protected void buttonPressed(int buttonId) {
		super.buttonPressed(buttonId);
		if (IDialogConstants.CLOSE_ID == buttonId) {
			close();
		}
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
	protected void initDataBindingsManual(DataBindingContext bindingContext) {
		bindingContext.getBindings().forEach(b -> ControlDecorationSupport.create(b, SWT.TOP | SWT.LEFT));

		IObservableValue observeSelectionBtnInterquartileRangeObserveWidget = WidgetProperties.widgetSelection().observe(btnInterquartileRange);
		IObservableValue observeSelectionBtnSigmaObserveWidget = WidgetProperties.widgetSelection().observe(btnSigma);
		IObservableValue observeSelectionBtnRangeObserveWidget = WidgetProperties.widgetSelection().observe(btnRange);
		SelectObservableValue<Technique> observeSelectionRadioBtnFilter = new SelectObservableValue(Technique.class);
		observeSelectionRadioBtnFilter.addOption(Technique.INTERQUARTILE_RANGE, observeSelectionBtnInterquartileRangeObserveWidget);
		observeSelectionRadioBtnFilter.addOption(Technique.SIGMA, observeSelectionBtnSigmaObserveWidget);
		observeSelectionRadioBtnFilter.addOption(Technique.RANGE, observeSelectionBtnRangeObserveWidget);
		IObservableValue techniqueDurationFilterObserveValue = BeanProperties.value("technique").observe(durationFilter);
		bindingContext.bindValue(observeSelectionRadioBtnFilter, techniqueDurationFilterObserveValue, null, null);
	}
	
	public static class PositiveDoubleValidator implements IValidator<String> {
		@Override
		public IStatus validate(String value) {
			if (value.isEmpty()) {
				return new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getBundle().getSymbolicName(),
							"Value cannot be empty");
			} else {
				try {
					Number n = DOUBLE_FORMAT.parse(value);
					if (n.doubleValue() < 0) {
						return new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getBundle().getSymbolicName(),
								"Value should be positive");
					}
				} catch (ParseException e) {
					return new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getBundle().getSymbolicName(),
							e.getLocalizedMessage(), e);
				}
			}
			return Status.OK_STATUS;
		}
	}
	
	public static class PositiveDoubleConverter extends Converter<Double, String> {
		public PositiveDoubleConverter() {
			super(Double.class, String.class);
		}
		
		@Override
		public String convert(Double number) {
			return DOUBLE_FORMAT.format(number);
		}
	}

	public static class EDurationValidator implements IValidator<String> {
		@Override
		public IStatus validate(String value) {
			if (value.isEmpty()) {
				return new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getBundle().getSymbolicName(),
							"Value cannot be empty");
			} else {
				try {
					Number n = EDurationFormat.eINSTANCE.parse(value);
					if (n.doubleValue() < 0) {
						return new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getBundle().getSymbolicName(),
								"Value should be positive");
					}
				} catch (ParseException e) {
					return new Status(IStatus.ERROR, TmscEditorPlugin.getPlugin().getBundle().getSymbolicName(),
							e.getLocalizedMessage(), e);
				}
			}
			return Status.OK_STATUS;
		}
	}
	
	public static class EDurationT2MConverter extends Converter<String, Long> {
		public EDurationT2MConverter() {
			super(String.class, Long.class);
		}
		
		@Override
		public Long convert(String number) {
			try {
				return EDurationFormat.eINSTANCE.parse(number).longValue();
			} catch (ParseException e) {
				return null;
			}
		}
	}

	public static class EDurationM2TConverter extends Converter<Long, String> {
		public EDurationM2TConverter() {
			super(Long.class, String.class);
		}
		
		@Override
		public String convert(Long number) {
			return EDurationFormat.eINSTANCE.format(number);
		}
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeSelectionBtnRemoveOutliersObserveWidget = WidgetProperties.widgetSelection().observe(btnRemoveOutliers);
		IObservableValue filterDurationFilterObserveValue = BeanProperties.value("filter").observe(durationFilter);
		bindingContext.bindValue(observeSelectionBtnRemoveOutliersObserveWidget, filterDurationFilterObserveValue, null, null);
		//
		IObservableValue observeSelectionBtnNegateObserveWidget = WidgetProperties.widgetSelection().observe(btnNegate);
		IObservableValue negateDurationFilterObserveValue = BeanProperties.value("negate").observe(durationFilter);
		bindingContext.bindValue(observeSelectionBtnNegateObserveWidget, negateDurationFilterObserveValue, null, null);
		//
		IObservableValue observeTextTxtIQRObserveWidget = WidgetProperties.text(SWT.Modify).observeDelayed(500, txtIQR);
		IObservableValue iqrFactorDurationFilterObserveValue = BeanProperties.value("iqrFactor").observe(durationFilter);
		UpdateValueStrategy strategy_6 = new UpdateValueStrategy();
		strategy_6.setAfterGetValidator(new PositiveDoubleValidator());
		UpdateValueStrategy strategy_7 = new UpdateValueStrategy();
		strategy_7.setConverter(new PositiveDoubleConverter());
		bindingContext.bindValue(observeTextTxtIQRObserveWidget, iqrFactorDurationFilterObserveValue, strategy_6, strategy_7);
		//
		IObservableValue observeTextTxtSigmaObserveWidget = WidgetProperties.text(SWT.Modify).observeDelayed(500, txtSigma);
		IObservableValue sigmaDurationFilterObserveValue = BeanProperties.value("sigma").observe(durationFilter);
		UpdateValueStrategy strategy_4 = new UpdateValueStrategy();
		strategy_4.setAfterGetValidator(new PositiveDoubleValidator());
		UpdateValueStrategy strategy_5 = new UpdateValueStrategy();
		strategy_5.setConverter(new PositiveDoubleConverter());
		bindingContext.bindValue(observeTextTxtSigmaObserveWidget, sigmaDurationFilterObserveValue, strategy_4, strategy_5);
		//
		IObservableValue observeTextTxtMinObserveWidget = WidgetProperties.text(SWT.Modify).observeDelayed(500, txtMin);
		IObservableValue minDurationFilterObserveValue = BeanProperties.value("min").observe(durationFilter);
		UpdateValueStrategy strategy_2 = new UpdateValueStrategy();
		strategy_2.setAfterGetValidator(new EDurationValidator());
		strategy_2.setConverter(new EDurationT2MConverter());
		UpdateValueStrategy strategy_3 = new UpdateValueStrategy();
		strategy_3.setConverter(new EDurationM2TConverter());
		bindingContext.bindValue(observeTextTxtMinObserveWidget, minDurationFilterObserveValue, strategy_2, strategy_3);
		//
		IObservableValue observeTextTxtMaxObserveWidget = WidgetProperties.text(SWT.Modify).observeDelayed(500, txtMax);
		IObservableValue maxDurationFilterObserveValue = BeanProperties.value("max").observe(durationFilter);
		UpdateValueStrategy strategy = new UpdateValueStrategy();
		strategy.setAfterGetValidator(new EDurationValidator());
		strategy.setConverter(new EDurationT2MConverter());
		UpdateValueStrategy strategy_1 = new UpdateValueStrategy();
		strategy_1.setConverter(new EDurationM2TConverter());
		bindingContext.bindValue(observeTextTxtMaxObserveWidget, maxDurationFilterObserveValue, strategy, strategy_1);
		//
		return bindingContext;
	}
}
