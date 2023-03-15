window.onload = function () {
  let checkboxList = document.querySelectorAll('input');
  console.log(checkboxList);
  for (c of checkboxList) {
    c.addEventListener('click', function (e) {
      let flag = e.target.checked;
      let id = e.target.getAttribute('id');
      let value = e.target.getAttribute('value');

      console.log(flag);
      if (flag == false) {
        doDelete(id);
      } else {
        doMake(id, value);
      }
    });
  }
};

function doDelete(id) {
  let target = document.querySelector('[data-id="' + id + '"]');
  console.log(document.querySelector('[id="' + id + '"]'));
  document.querySelector('[id="' + id + '"]').checked = false;
  target.remove();
}
function doMake(id, value) {
  let box = document.createElement('div');
  let button = document.createElement('button');
  button.innerText = 'X';
  button.setAttribute('onclick', 'doDelete(' + id + ')');

  box.innerText = value;
  box.setAttribute('data-id', id);

  box.appendChild(button);
  document.getElementById('result').appendChild(box);
}
