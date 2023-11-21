package nl.esi.pps.common.emf.edit.ui.provider;

import java.text.Format;
import java.text.ParsePosition;

import org.eclipse.jface.dialogs.IInputValidator;

public class FormatInputValidator implements IInputValidator {
	private final Format format;
	
	public FormatInputValidator(Format format) {
		this.format = format;
	}
	
	public Format getFormat() {
		return format;
	}
	
	@Override
	public String isValid(String newText) {
		String trimmedText = newText.trim();
		ParsePosition position = new ParsePosition(0);
		format.parseObject(trimmedText, position);
		
		if (position.getErrorIndex() >= 0) {
			return "Invalid input: \"" + newText + "\"";
		} else if (position.getIndex() != trimmedText.length()) {
			return "Invalid input near the end: \""
					+ trimmedText.substring(position.getIndex()).trim() + "\"";
		}
		return null;
	}
}
