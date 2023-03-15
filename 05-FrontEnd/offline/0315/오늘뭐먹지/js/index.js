selectFood(makeRand());
// 랜덤선택되게 하기
function makeRand() {
  return Math.floor(Math.random() * 3 + 1);
}

let btn = document.getElementById('randomBtn');
btn.addEventListener('click', function () {
  let randImg = document.querySelector('.img-view>img');
  selectFood(makeRand());
});

function selectFood(id) {
  let prev = document.querySelector('.active');
  if (prev != null) {
    prev.classList.remove('active');
  }
  let selectedFood = document.querySelector('[id="' + id + '"]');
  document.querySelector('.img-view>img').setAttribute('src', selectedFood.getAttribute('src'));
  document.querySelector('#foodName').innerHTML = selectedFood.getAttribute('alt');
  selectedFood.classList.add('active');
}

let foodList = document.querySelectorAll('.img-thumb>img');
for (f of foodList) {
  f.addEventListener('click', (e) => {
    selectFood(e.target.getAttribute('id'));
  });
  // f.addEventListener('click', function (e) {
  //   selectFood(e.target.getAttribute('id'));
  // });
}
