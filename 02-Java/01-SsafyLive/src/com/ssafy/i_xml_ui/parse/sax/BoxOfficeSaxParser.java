package com.ssafy.i_xml_ui.parse.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.events.EndDocument;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.ssafy.i_xml_ui.parse.BoxOffice;

public class BoxOfficeSaxParser extends DefaultHandler {
    private final File xml = new File("./src/com/ssafy/i_xml_ui/parse/boxoffice.xml");
    // 파싱된 내용을 저장할 List
    private List<BoxOffice> list = new ArrayList<>();
    // 현재 파싱하고 있는 대상 객체
    private BoxOffice current;
    // 방금 읽은 텍스트 내용
    private String content;

    public List<BoxOffice> getBoxOffice() {
        // TODO: SAXParser를 구성하고 boxoffice.xml을 파싱하시오.
        
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(xml, this);
		} catch (IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	// END:
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
    	if(qName.equals("dailyBoxOffice")) {
    		current = new BoxOffice();
    	}
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	if(qName.equals("rank")) {
    		this.current.setRank(Integer.parseInt(content));
    	}else if (qName.equals("movieNm")) {
    		this.current.setMovieNm(this.content);
    	}else if (qName.equals("openDt")) {
    		this.current.setOpenDt(current.toDate(this.content));
    	}else if (qName.equals("audiAcc")) {
    		this.current.setAudiAcc((Integer.parseInt(content)));
    	}else if (qName.equals("dailyBoxOffice")) {
    		this.list.add(this.current);
    		this.current = null;
    	}
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
    	this.content = new String(ch, start, length);
    }
    
    // END:
}
