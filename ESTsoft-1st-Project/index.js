// 모바일 메뉴 토글
document.querySelector('.menu-open').addEventListener('click', () => {
	document.querySelector('#header-nav').classList.toggle('active');
});

document.querySelector('.menu-close').addEventListener('click', () => {
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

// 상단에서 버튼 숨기기
window.addEventListener('scroll', _.throttle(() => {
	if (window.scrollY > 1) {
		gsap.to('#scroll-top', .2, {
			x: 0
		});
	} else {
		gsap.to('#scroll-top', .2, {
			x: 100
		});
	}
}, 300));

// 최상단으로 스크롤
const scrollTop = document.querySelector('#scroll-top');
scrollTop.addEventListener('click', () => {
	gsap.to(window, .7, {
		scrollTo: 0
	});
});

// 구독 버튼을 눌렀을 때
const dialog = document.querySelector('#dialog-subscribe');
const openDialogButton = document.querySelector('#btn-submit-subscribe');
const closeDialogButton = document.querySelector('#btn-close-dialog');
// 모달 열기
openDialogButton.addEventListener('click', () => {
	event.preventDefault();
	dialog.showModal();
});
// 모달 닫기
closeDialogButton.addEventListener('click', () => {
	dialog.close();
});
// backdrop 클릭 시 모달 닫기
dialog.addEventListener('click', () => {
	dialog.close();
});