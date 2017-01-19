package krasa.grepconsole.grep.gui;

import com.google.common.base.Splitter;
import krasa.grepconsole.grep.CopyListenerModel;

import java.util.List;

public class GrepOptionsItem {
	int version = 0;
	boolean wholeLine;
	boolean regex;
	boolean caseSensitive;
	String expression;

	public GrepOptionsItem setVersion(final int version) {
		this.version = version;
		return this;
	}

	public GrepOptionsItem setWholeLine(final boolean wholeLine) {
		this.wholeLine = wholeLine;
		return this;
	}

	public GrepOptionsItem setRegex(final boolean regex) {
		this.regex = regex;
		return this;
	}

	public GrepOptionsItem setCaseSensitive(final boolean caseSensitive) {
		this.caseSensitive = caseSensitive;
		return this;
	}

	public GrepOptionsItem setExpression(final String expression) {
		this.expression = expression;
		return this;
	}

	public int getVersion() {
		return version;
	}

	public boolean isWholeLine() {
		return wholeLine;
	}

	public boolean isRegex() {
		return regex;
	}

	public boolean isCaseSensitive() {
		return caseSensitive;
	}

	public String getExpression() {
		return expression;
	}

	public String asString() {
		return new StringBuilder()
				.append(version).append("|")
				.append(wholeLine).append("|")
				.append(regex).append("|")
				.append(caseSensitive).append("|")
				.append(expression)
				.toString();
	}

	public static GrepOptionsItem fromString(String s) {
		List<String> strings = Splitter.on("|").limit(5).splitToList(s);
		GrepOptionsItem grepOptionsItem = new GrepOptionsItem();
		if (strings.size() == 5) {
			grepOptionsItem.version = Integer.parseInt(strings.get(0));
			grepOptionsItem.wholeLine = Boolean.parseBoolean(strings.get(1));
			grepOptionsItem.regex = Boolean.parseBoolean(strings.get(2));
			grepOptionsItem.caseSensitive = Boolean.parseBoolean(strings.get(3));
			grepOptionsItem.expression = strings.get(4);
		} else {
			grepOptionsItem.expression = s;
		}
		return grepOptionsItem;
	}

	public static GrepOptionsItem from(CopyListenerModel copyListenerModel) {
		GrepOptionsItem grepOptionsItem = new GrepOptionsItem();
		grepOptionsItem.wholeLine = copyListenerModel.isWholeLine();
		grepOptionsItem.regex = copyListenerModel.isRegex();
		grepOptionsItem.caseSensitive = copyListenerModel.isCaseSensitive();
		grepOptionsItem.expression = copyListenerModel.getExpression();
		return grepOptionsItem;


	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		GrepOptionsItem that = (GrepOptionsItem) o;

		if (version != that.version) return false;
		if (wholeLine != that.wholeLine) return false;
		if (regex != that.regex) return false;
		if (caseSensitive != that.caseSensitive) return false;
		return expression != null ? expression.equals(that.expression) : that.expression == null;
	}

	@Override
	public int hashCode() {
		int result = version;
		result = 31 * result + (wholeLine ? 1 : 0);
		result = 31 * result + (regex ? 1 : 0);
		result = 31 * result + (caseSensitive ? 1 : 0);
		result = 31 * result + (expression != null ? expression.hashCode() : 0);
		return result;
	}


	@Override
	public String toString() {
		return expression;
	}
}