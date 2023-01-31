package com.ssafy.i_xml_ui.parse.json;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.ssafy.i_xml_ui.parse.BoxOffice;

public class UseJson {
	private final File json = new File("./src/com/ssafy/i_xml_ui/parse/boxoffice.json");
	private List<BoxOffice> list = new ArrayList<>();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BoxOffice> getBoxOffice() throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		// 날짜 변경과 관련된 룰 지정
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

//		JsonNode node = mapper.readTree(json);
		list = mapper.convertValue((ArrayNode) mapper.readTree(json).get("boxOfficeResult").get("dailyBoxOfficeList") // get()은
																														// json노드를
																														// 반환한다.
				, new TypeReference<List<BoxOffice>>() {
				});

		/*
		 * // TODO: json을 파싱해서 list를 구성하시오. Map<String, Map<String, Object>> result =
		 * mapper.readValue(json, Map.class); List<Map<String, Object>> list = (List)
		 * (result.get("boxOfficeResult").get("dailyBoxOfficeList")); for (Map<String,
		 * Object> item : list) { this.list.add(mapper.convertValue(item,
		 * BoxOffice.class)); }
		 */
		// END:
		return list;
	}

}
