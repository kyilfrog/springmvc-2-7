package hello.typeconverter.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.Locale;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MyNumberFormatterTest {

	MyNumberFormatter formatter = new MyNumberFormatter();
	
	@Test
	void testParse() throws ParseException {
		Number result = formatter.parse("1,000", Locale.KOREA);
		Assertions.assertThat(result).isEqualTo(1000L);
	}

	@Test
	void testPrint() {
		String result = formatter.print(1000, Locale.KOREA);
		Assertions.assertThat(result).isEqualTo("1,000");
	}

}















