/**
 * vanilla js로 ajax 구현
 * author : JM
 * date :  23/03/28
 * 주고받는 DATA는 JSON
 */

function vanillaAjax(method, url, data, callback){
	let httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = () => {
		//readystate가 DONE일 때
		if(httpRequest.readyState === XMLHttpRequest.DONE){
			if(httpRequest.status === 200){
				//수신 성공했을 때 콜백함수 실행;
				callback(httpRequest.response);
			}
		}
	}
	
	httpRequest.responseType = "json";
	
	if(method === "post" || method === "POST"){ //POST방식으로 요청한 경우
		httpRequest.open(method, url, true);
		httpRequest.setRequestHeader('Content-Type', 'application/json');
		
		httpRequest.send(data);
	} else {
		let getData = "?";
		let jsonList = JSON.object(data);
		for(let key in jsonList) getData += key + "=" + jsonList[key];
		
		httpRequest.send();
	}
	
}