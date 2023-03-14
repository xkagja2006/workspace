// register.html 의 form 에 있는 버튼을 눌렀을때 실행되는 함수
function regist() {
  // 각 form 의 input 에 입력된 값들을 css 선택자를 이용하여 가져오기
  let id = document.querySelector('#id');
  let password = document.querySelector('#password');
  let name = document.querySelector('#name');
  let email = document.querySelector('#email');
  let age = document.querySelector('#age');

  // user 생성
  const user = {
    id: id.value,
    password: password.value,
    name: name.value,
    email: email.value,
    age: age.value,
  };

  // user 정보 출력
  console.log(user);
}
