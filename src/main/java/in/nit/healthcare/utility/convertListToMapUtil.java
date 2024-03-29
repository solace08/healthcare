package in.nit.healthcare.utility;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public interface convertListToMapUtil {

	public static  Map<Long,String> convert(List<Object[]> list){
		Map<Long, String> map=list
				.stream()
				.collect(Collectors.toMap(
						ob->Long.valueOf(ob[0].toString()),
						ob->ob[1].toString()));
		return map;

	}
}
