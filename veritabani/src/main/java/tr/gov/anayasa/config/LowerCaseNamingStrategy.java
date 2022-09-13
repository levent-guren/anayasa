package tr.gov.anayasa.config;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class LowerCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {
	private static final long serialVersionUID = -2990119491852762376L;

	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return context.getIdentifierHelper().toIdentifier(snakeCaseFormat(name.getText()));
	}

	@Override
	public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
		return context.getIdentifierHelper().toIdentifier(snakeCaseFormat(name.getText()));
	}

	private static String snakeCaseFormat(String name) {
		final StringBuilder result = new StringBuilder();

		boolean lastUppercase = false;

		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			char lastEntry = i == 0 ? 'X' : result.charAt(result.length() - 1);
			if (ch == ' ' || ch == '_' || ch == '-' || ch == '.') {
				lastUppercase = false;

				if (lastEntry == '_') {
					continue;
				} else {
					ch = '_';
				}
			} else if (Character.isUpperCase(ch)) {
				ch = StringUtils.lowerCase(String.valueOf(ch), Locale.ENGLISH).charAt(0);
				// is start?
				if (i > 0) {
					if (lastUppercase) {
						// test if end of acronym
						if (i + 1 < name.length()) {
							char next = name.charAt(i + 1);
							if (!Character.isUpperCase(next) && Character.isAlphabetic(next)) {
								// end of acronym
								if (lastEntry != '_') {
									result.append('_');
								}
							}
						}
					} else {
						// last was lowercase, insert _
						if (lastEntry != '_') {
							result.append('_');
						}
					}
				}
				lastUppercase = true;
			} else {
				lastUppercase = false;
			}

			result.append(ch);
		}
		return result.toString();
	}

}