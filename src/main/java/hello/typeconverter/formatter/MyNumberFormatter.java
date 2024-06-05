package hello.typeconverter.formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
	
	@Override
	public Number parse(String text, Locale locale) throws ParseException {
		log.info("text={}, locale={}", text, locale);
		// "1,000" 문자를 -> 1000 숫자로 변경하려는 경우
		NumberFormat format = NumberFormat.getInstance(locale);
		Number result = format.parse(text);
		return result;
	}
	
	@Override
	public String print(Number object, Locale locale) {
		log.info("object={}, locale={}", object, locale);
		NumberFormat instance = NumberFormat.getInstance(locale);
		String result = instance.format(object);
		return result;
	}

}
