// 모바일 메뉴 토글
document.querySelector('#btn-menu-open').addEventListener('click', () => {
	document.querySelector('#header-nav').classList.toggle('active');
});

document.querySelector('#btn-menu-close').addEventListener('click', () => {
	document.querySelector('#header-nav').classList.toggle('active');
});

// 뷰포트에 따라 텍스트 줄바꿈 및 공백 조절
function adjustTextSpacing() {
	const topH2 = document.querySelector('.section-top h2');
	const topSpan = document.querySelector('.section-top span');
	const dialogSpan = document.querySelector('#dialog-subscribe span');

	const viewWidth = window.innerWidth;

	if (viewWidth < 768) {
		topH2.textContent = "Lorem Ipsum is simply\ndummy text\nof the printing and";
		topSpan.textContent = "Lorem Ipsum is simply dummy text\nof the printing and typesetting industry.\nLorem Ipsum has been the industry's\nstandard dummy text ever since the 1500s,\nwhen an unknown.";
		dialogSpan.textContent = "Lorem Ipsum is simply dummy\ntext of the printing industry.";
	} else {
		topH2.textContent = "Lorem Ipsum is simply\ndummy text of the printing and";
		topSpan.textContent = "Lorem Ipsum is simply dummy text of the printing and\ntypesetting industry.\nLorem Ipsum has been the industry's standard dummy text\never since the 1500s, when an unknown.";
		dialogSpan.textContent = "Lorem Ipsum is simply dummy text of the printing industry.";
	}
}

window.addEventListener('resize', adjustTextSpacing);
window.addEventListener('DOMContentLoaded', adjustTextSpacing);

// 일정 부분 스크롤 시 헤더 고정
const header = document.querySelector('header');
window.addEventListener('scroll', _.throttle(() => {
	if (window.scrollY > 300) {
		header.style.position = 'sticky';
	} else {
		header.style.position = 'static';
	}
}, 300));

// 상단에서 이동 버튼 숨기기
const scrollTop = document.querySelector('#btn-scroll-top');
window.addEventListener('scroll', _.throttle(() => {
	if (window.scrollY < 1) {
		scrollTop.classList.remove('active');
	} else {
		scrollTop.classList.add('active');
	}
}, 300));	//.3s 안에 이벤트 발생 시 1번만 실행

// 최상단으로 스크롤
scrollTop.addEventListener('click', () => {
	window.scrollTo({top: 0, behavior: 'smooth'});
});

// 구독 버튼을 눌렀을 때
const dialog = document.querySelector('#dialog-subscribe');
const openDialogButton = document.querySelector('#btn-subscribe');
const closeDialogButton = document.querySelector('#btn-submit-dialog');
const emailInput = document.querySelector('#input-email');
const dialogForm = document.querySelector('#form-subscribe');
const input = document.querySelector('#input-email');
// email 유효성 검사
const regex = /^(?:(?!\.\.|.*\.\.$)(?!^\.)[!#$%&'*+/=?^_`{|}~\w.-]+(?:\.[!#$%&'*+/=?^_`{|}~\w.-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x7f]|\\[\x01-\x08\x0b\x0c\x0e-\x7f]|[\s.,:;<>@[\]"])*")@((?:[a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+|\[(?:[0-9]{1,3}\.){3}[0-9]{1,3}]|\[IPv6:[0-9a-fA-F:]+])$/;
// 모달 열기
openDialogButton.addEventListener('click', () => {
	if (!regex.test(emailInput.value)) {
		event.preventDefault();
		alert('이메일 주소를 확인해주세요.');
	} else {
		event.preventDefault();
		dialog.showModal();
	}
});
// 모달 닫기
closeDialogButton.addEventListener('click', () => {
	dialog.close();
});
// 버튼 submit 방지
openDialogButton.addEventListener('submit', () => {
	event.preventDefault();
});
// input enter submit 방지
input.addEventListener('keypress', (e) => {
	if (e.key === 'Enter') {
		e.preventDefault();
		openDialogButton.click();
	}
});