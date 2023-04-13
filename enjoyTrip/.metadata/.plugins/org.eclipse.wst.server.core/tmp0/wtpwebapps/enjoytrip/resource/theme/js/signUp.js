/*
 * Author : JM
 * Date : 23/03/30
 * Content : 회원가입 js 구현 
 */
let signUp = {
	signUpSubmitBtn : null
	,nameInput : null
	,idInput : null
	,pwInput : null
	,emailInput : null
	
	,init : function(){
		this.signUpSubmitBtn = document.getElementById('signUpSubmitBtn');
		this.nameInput = document.querySelector('#signUpPopup #signUpName');
		this.idInput = document.querySelector('#signUpPopup #signUpId');
		this.pwInput = document.querySelector('#signUpPopup #signUpPassword');
		this.emailInput = document.querySelector('#signUpPopup #signUpEmail');
		
		this.registEvent();
	}
	
	,registEvent : function(){
		let _this = this;
		
		_this.signUpSubmitBtn.addEventListener('click', () => {
			_this.signUpSubmit();
		});
		
	}
	
	,openSignUpPopup : function(){
		let _this = this;
		PopupManager.add('#signUpPopup');
		
		//값 초기화
		_this.nameInput.value = '';
		_this.idInput.value = '';
		_this.pwInput.value = '';
		_this.emailInput.value = '';
	}
	
	,signUpSubmit : function() {
		let _this = this;
		if(_this.nameInput.value == ''){
			alert('이름을 입력해주세요');
			return;
		}
		
		if(_this.idInput.value == ''){
			alert('아이디를 입력해주세요');
			return;
		}
		
		if(_this.pwInput.value == ''){
			alert('비밀번호를 입력해주세요');
			return;
		}
		
		if(_this.emailInput.value == ''){
			alert('이메일을 입력해주세요');
			return;
		}
		
		let param = JSON.stringify({action : "signUp", userName : _this.nameInput.value, userId : _this.idInput.value, userPassword : _this.pwInput.value, userEmail : _this.emailInput.value});
		
		vanillaAjax("POST", getUrl() + "enjoyTrip/user", param, signUp.signUpAction);
		
	}
	
	,signUpAction : function(result){
		if(result.result){
			window.location.reload();
		} else {
			alert('회원가입에 실패했습니다. 확인 후 다시 시도해주세요');
		}
	}
}

windowOnload(function(){
	signUp.init();
})
