package hello.typeconverter.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import hello.typeconverter.type.IpPort;

public class ConversionServiceTest {

	@Test
	void conversionService() {
		//등록
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new StringToIntegerConverter());
		conversionService.addConverter(new IntegerToStringConverter());
		conversionService.addConverter(new StringToIpPortConverter());
		conversionService.addConverter(new IpPortToStringConverter());
		
		//사용
		Integer result = conversionService.convert("10", Integer.class);
		Assertions.assertThat(result).isEqualTo(10);
		
		String result2 = conversionService.convert(10, String.class);
		Assertions.assertThat(result2).isEqualTo("10");
		
		IpPort ipPort = conversionService.convert("127.0.0.1:9090", IpPort.class);
		Assertions.assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 9090));
		
		String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
		Assertions.assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
		
	}
}

























