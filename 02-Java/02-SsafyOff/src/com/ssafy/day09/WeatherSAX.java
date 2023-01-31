package com.ssafy.day09;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAX extends DefaultHandler {
	private final File xml = new File("./weather.xml");
	// 파싱된 내용을 저장할 List
	private List<Weather> list = new ArrayList<>();
	// 현재 파싱하고 있는 대상 객체
	private Weather current;
	// 방금 읽은 텍스트 내용
	private String content;

	public List<Weather> getWeatherBySAX() throws Exception, Throwable {
		// TODO: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		parser.parse(xml, this);

		return list;
	}
	

    // TODO: 필요한 매서드를 재정의 하여 boxOffice.xml을 파싱하시오.
    @Override
    public void startDocument() throws SAXException {
    	System.out.println("문서 파싱 시작");
    	super.startDocument();
    }
    
    @Override
    public void endDocument() throws SAXException {
    	System.out.println("파싱종료");
    	super.endDocument();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	if(qName.equals("data")) {
    		current = new Weather();
    	}
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	if(qName.equals("hour")) {
    		this.current.setHour(Integer.parseInt(content));
    	}else if (qName.equals("temp")) {
    		this.current.setTemp(Double.parseDouble(content));
    	}else if (qName.equals("wfKor")) {
    		this.current.setWfKor(content);
    	}else if (qName.equals("wdKor")) {
    		this.current.setWdKor(content);
    	}else if (qName.equals("data")) {
    		this.list.add(this.current);
    		this.current = null;
    	}
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    	this.content = new String(ch, start, length);
    }
}
