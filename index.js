const html = document.querySelector('html');
// 모바일 메뉴 토글
const openMenu = document.getElementById('btn-menu-open');
const closeMenu = document.getElementById('btn-menu-close');
const headerNav = document.getElementById('header-nav');
openMenu.addEventListener('click', () => {
	headerNav.classList.toggle('active');
});
closeMenu.addEventListener('click', () => {
	headerNav.classList.toggle('active');
});

// 일정 부분 스크롤 시 헤더 고정
const header = document.getElementsByTagName('header');
window.addEventListener('scroll', _.throttle(() => {
	if (window.scrollY > 300) {
		header[0].style.position = 'sticky';
	} else {
		header[0].style.position = 'static';
	}
}, 300));

// 상단에서 이동 버튼 숨기기
const scrollTop = document.getElementById('btn-scroll-top');
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
const dialog = document.getElementById('dialog-subscribe');
const openDialogButton = document.getElementById('btn-subscribe');
const closeDialogButton = document.getElementById('btn-submit-dialog');
const emailInput = document.getElementById('input-email');
const dialogForm = document.getElementById('form-subscribe');
// email 유효성 검사식
const regex = /^(?:(?!\.\.|.*\.\.$)(?!^\.)[!#$%&'*+/=?^_`{|}~\w.-]+(?:\.[!#$%&'*+/=?^_`{|}~\w.-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x7f]|\\[\x01-\x08\x0b\x0c\x0e-\x7f]|[\s.,:;<>@[\]"])*")@((?:[a-zA-Z0-9-]+\.)*[a-zA-Z0-9-]+|\[(?:[0-9]{1,3}\.){3}[0-9]{1,3}]|\[IPv6:[0-9a-fA-F:]+])$/;
// 모달 열기
openDialogButton.addEventListener('click', (event) => {
	if (!regex.test(emailInput.value)) {
		event.preventDefault();
		alert('이메일 주소를 확인해주세요.');
	} else {
		event.preventDefault();
		dialog.showModal();
		html.style.overflowY = 'hidden';
	}
});
// 모달 닫기
closeDialogButton.addEventListener('click', () => {
	dialog.close();
	html.style.overflowY = 'unset';
});
// 버튼 submit 방지
openDialogButton.addEventListener('submit', (event) => {
	event.preventDefault();
});
// input enter submit 방지
emailInput.addEventListener('keypress', (event) => {
	if (event.key === 'Enter') {
		event.preventDefault();
		openDialogButton.click();
	}
});
// form submit 시 화면 유지
dialogForm.addEventListener('submit', (event) => {
	event.preventDefault();
});
// backdrop 클릭 시 모달 닫기
dialog.addEventListener('click', (event) => {
	if (event.target === dialog) {
		dialog.close();
		html.style.overflowY = 'unset';
	}
});